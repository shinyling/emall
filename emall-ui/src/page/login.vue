<template>
  <div class="bg">
    <div class="login" @keydown.enter="login">
      <div class="login-con">
        <Card :bordered="false">
          <div class="login-title" slot="title">
            <p class="sub-title">SpringCloud & Vue2.x (iview)</p>
          </div>
        </Card>
        <div class="form-con">
          <Form ref="form" :model="form" :rules="rules">
            <FormItem prop="userName">
              <Input size="large" v-model="form.username" placeholder="请输入用户名" icon="person"/>
            </FormItem>
            <FormItem prop="password">
              <Input size="large" type="password" v-model="form.password" placeholder="请输入密码" icon="locked"/>
            </FormItem>
            <FormItem>
              <Button size="large" @click="login" class="form-submit" :loading="loading">
                <span v-if="!loading"><Icon type="checkmark-circled"></Icon> 登入系统</span>
                <span v-else>正在登陆..</span>
              </Button>
            </FormItem>
          </Form>
        </div>
      </div>
    </div>
    <p class="login-tip">Copyright &copy; 2018.Shiny All rights reserved.<a href="www.baidu.com" target="_blank" title="shiny">Shiny</a></p>
  </div>
</template>
<script>
import User from '../api/user'
import {sucessMessage, errorMessage} from '../providers/http-service'
export default {
  data () {
    return {
      form: {
        username: '',
        password: ''
      },
      rules: {
        username: [{required: true, message: '账号不能为空', trigger: 'blur'}],
        password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
      },
      loading: false
    }
  },
  methods: {
    login () {
      this.$refs.form.validate((valid) => {
        if (valid) {
          this.loading = true
          User.login(this.form.username, this.form.password).then((response) => {
            console.log(response)
            this.$store.dispatch("storeToken",response.access_token)
            User.getUserInfo().then((res) => {
              this.$store.dispatch("setUser", res)
              this.$router.push('/home')
            }).catch((error) => {
              errorMessage("用户信息拉取失败!")
            })
          }).catch((err) => {
            errorMessage(err)
            this.loading = false
          })
        }
      })
    }
  }
}
</script>
<style scoped>
  .bg {
    background-size: 100% 100%;
    width: 100%;
    height: 100%;
    background: url('../../static/images/bg1.jpg') bottom center no-repeat #efeff4;
  }
  .login {
    width: 100%;
    height: 100%;
    background-size: cover;
  }
  .login-title {
    text-align: center;
  }
  .sub-title {
    font-size: 20px;
    color: #C0C4CC;
  }
  .form-submit {
    width: 100%;
    color: #fff;
    border-color: #6bc5a4;
    background: #6bc5a4;
  }
  .login:active, .login:hover {
    border-color: #31c555;
    background: #31c555;
  }
  .login-con {
    position: absolute;
    right: 40%;
    top: 40%;
    transform: translateY(-60%);
    width: 20%;
  }
  .form-con {
    padding: 10px 0 0;
  }
  .login-tip {
    position: absolute;
    font-size: 10px;
    text-align: center;
    color: #c3c3c3;
    bottom: 1%;
    left: 40%;
  }
</style>
