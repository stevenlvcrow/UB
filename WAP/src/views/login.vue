<template>
  <div class="login">
    <div class="welcome"><img src="../assets/welcome.png"></div>
    <div>
      <div class="login-inp"><label>登录</label><input type="text" placeholder=""></div>
      <div class="login-inp"><label>密码</label><input type="password" placeholder=""></div>
      <div class="login-inp"><a href="#" >立即登录</a></div>
    </div>
    <div class="login-txt"><a href="#">立即注册</a>|<a href="#">忘记密码？</a></div>
  </div>
</template>


<style lang="scss">
  .login{
    font-family:SimHei,'Helvetica Neue',Arial,'Droid Sans',sans-serif;font-size:14px;color:#333;background:#f2f2f2;
    a, a.link{color:#666;text-decoration:none;font-weight:500;}
    a, a.link:hover{color:#666;}
    h1,h2,h3,h4,h5,h6{font-weight: normal;}
    margin:0;padding:0;border:0;list-style:none;font-style:normal;
    width:100%;height:100%;background:url(../assets/login-bg.png) no-repeat;background-size:cover;position:fixed;z-index:-10;
    .welcome{width:100%;margin:25% 0;}
    .welcome img{width:100%;}
    .login-inp{margin:0 30px 15px 30px;border:1px solid #fff;border-radius:25px;}
    .login-inp label{width:4em;text-align:center;display:inline-block;color:#fff;}
    .login-inp input{line-height:40px;color:#fff;background-color:transparent;border:none;outline: none;}
    .login-inp a{display:block;width:100%;text-align:center;line-height:40px;color:#fff;font-size:16px;letter-spacing:5px;}
    .login-txt{text-align:center;color:#fff;}
    .login-txt a{color:#fff;padding:0 5px;}

  }

</style>
