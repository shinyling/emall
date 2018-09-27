package com.shiny.emall.ucenter.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@Log4j2
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        String body= IOUtils.toString(request.getInputStream(), Charset.forName("utf-8"));
//        log.info("请求body:{}",body);
        Map<String,String[]> paramMap=request.getParameterMap();
        Iterator<String> it=paramMap.keySet().iterator();
        StringBuilder stringBuilder=new StringBuilder();
        while (it.hasNext()){
            String key=it.next();
            String[] value=paramMap.get(key);
            stringBuilder.append("key:"+key);
            stringBuilder.append("value:"+value);
        }
        log.info("请求paramMap:{}",stringBuilder);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
