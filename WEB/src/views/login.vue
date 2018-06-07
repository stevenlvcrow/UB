<template>
    <section class="ub-login">
        <div class="login_box">
            <div class="login_l_img"><img src="../assets/login-img.png"/></div>
            <div class="login">
                <div class="login_logo"><a href="#"><img src="../assets/login_logo.png"/></a></div>
                <div class="login_name">
                    <p>商户平台</p>
                </div>
                <el-form :model="user" :rules="rules" ref="ruleForm" label-width="80px">
                    <el-form-item label="用户名" prop="userName">
                        <el-input v-model="user.userName" ></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="pwd">
                        <el-input type="password" v-model="user.pwd"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                        <el-button @click="resetForm('ruleForm')">重置</el-button>
                        <el-button type="text" @click="$store.state.userInfo.showRegisterDialog=true">注册商户</el-button>
                    </el-form-item>
                </el-form>
            </div>
            <div class="copyright">某某有限公司 版权所有©2016-2018 技术支持电话：000-00000000</div>
        </div>
        <register-dialog></register-dialog>
    </section>
</template>
<script>
    import {login} from "../api/user";
    import ElFormItem from "element-ui/packages/form/src/form-item";
    import RegisterDialog from "./register";

    export default {
        components: {
            RegisterDialog,
            ElFormItem},
        data() {

            return {
                user: {
                    userName: '',
                    pwd: ''
                },
                rules: {
                    userName: [
                        { required: true, message: '请输入用户名', trigger: 'blur' }
                    ],
                    pwd: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        login(this.user).then(res => {
                            if (!res) return;
                            sessionStorage.setItem('vuex', '22222222');
                            this.$router.push('/main');
                        });
                    }
                });
            },
        }
    }
</script>
<style lang="scss">
    .ub-login {
        background: #93defe;
        background-size: cover;
        height: 100%;
        overflow: hidden;

        a {
            color: #27A9E3;
            text-decoration: none;
            cursor: pointer;
        }
        img {
            border: none;
        }

        .login_box {
            width: 1100px;
            margin: 120px auto 0;
        }
        .login_box .login_l_img {
            float: left;
            width: 432px;
            height: 440px;
            margin-left: 50px;
        }
        .login_box .login_l_img img {
            width: 500px;
            height: 440px;
        }
        .login {
            height: 360px;
            width: 400px;
            padding: 50px;
            background-color: #ffffff;
            border-radius: 6px;
            box-sizing: border-box;
            float: right;
            margin-right: 50px;
            position: relative;
            margin-top: 50px;
        }
        .login_logo {
            width: 120px;
            height: 120px;
            border: 5px solid #93defe;
            border-radius: 100px;
            background: #fff;
            text-align: center;
            line-height: 110px;
            position: absolute;
            top: -60px;
            right: 140px;
        }
        .login_name {
            width: 100%;
            float: left;
            text-align: center;
            margin-top: 20px;
        }
        .login_name p {
            width: 100%;
            text-align: center;
            font-size: 18px;
            color: #444;
            padding: 10px 0 20px;
        }
        .login_logo img {
            width: 60px;
            height: 60px;
            display: inline-block;
            vertical-align: middle;
        }

        .copyright {
            font-size: 14px;
            color: #fff;
            display: block;
            width: 100%;
            float: left;
            text-align: center;
            margin-top: 60px;
        }



    }

</style>