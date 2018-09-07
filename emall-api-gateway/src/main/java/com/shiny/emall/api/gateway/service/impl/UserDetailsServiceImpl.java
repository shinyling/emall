package com.shiny.emall.api.gateway.service.impl;

import com.shiny.emall.api.gateway.service.PermissionService;
import com.shiny.emall.api.gateway.service.RoleService;
import com.shiny.emall.api.gateway.service.UserService;
import com.shiny.emall.common.constants.ResultCode;
import com.shiny.emall.common.ucenter.entity.UcMenu;
import com.shiny.emall.common.ucenter.entity.UcRole;
import com.shiny.emall.common.ucenter.vo.UserVo;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JsonResult userResult=userService.findByUsername(username);
        if(!userResult.getCode().equals(ResultCode.OK.getCode())){
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userResult.getData(),userVo);
        JsonResult<List<UcRole>> roleResult = roleService.getRolesByUserId(userVo.getId());
        if(roleResult.getCode().equals(ResultCode.OK.getCode())){
            List<UcRole> roles=roleResult.getData();
            for (UcRole role:roles){
                //角色必须是ROLE_开头，可以在数据库中设置
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
                grantedAuthorities.add(grantedAuthority);
                //获取权限
                JsonResult<List<UcMenu>> perResult  = permissionService.findPermissionsByRoleId(role.getId());
                if (perResult.getCode().equals(ResultCode.OK.getCode())){
                    List<UcMenu> permissionList = perResult.getData();
                    for (UcMenu menu:permissionList) {
                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
                        grantedAuthorities.add(authority);
                    }
                }
            }
        }
        User user = new User(userVo.getUsername(), userVo.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
