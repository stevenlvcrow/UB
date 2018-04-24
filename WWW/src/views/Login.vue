<template>
    <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" v-loading="logining" label-position="left" label-width="0px"
             class="demo-ruleForm login-container">
        <h3 class="title">系统登录</h3>
        <el-form-item prop="mobile">
            <el-input type="text" v-model="ruleForm2.mobile" auto-complete="off" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="pwd">
            <el-input type="password" v-model="ruleForm2.pwd" auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item style="width:100%;">
            <el-button type="primary" style="width:100%;" @click="login">登录</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    import {requestLogin} from '../api/user';
    export default {
        data() {
            return {
                logining: false,
                captchaObj:'',
                showCode:true,
                ruleForm2: {
                    mobile: '',
                    pwd: '',
                },
                rules2: {
                    mobile: [
                        {required: true, message: '请输入账号', trigger: 'blur'},
                    ],
                    pwd: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                    ]
                },
                checked: true
            };
        },
        mounted(){

        },
        methods: {
            login(){
                this.$refs.ruleForm2.validate((valid) => {
                    this.logining = true;
                    if(!valid){
                        this.logining = false;

                    }else{
                        this.$router.push({path: '/main'});
                        this.logining = false;
//                        requestLogin(this.ruleForm2).then((res) => {
//                            if(res.success){
//                                this.$router.push({path: '/memberinfo'});
//                                this.logining = false;
//                            }else{
//                                this.$message.error(res.message);
//                                this.logining = false;
//                            }
//                        });
                    }
                });
            }
        }
    }

</script>

<style lang="scss" scoped>
    .login-container {
        /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
        -webkit-border-radius: 5px;
        border-radius: 5px;
        -moz-border-radius: 5px;
        background-clip: padding-box;
        margin: 180px auto;
        width: 350px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
        .title {
            margin: 0px auto 40px auto;
            text-align: center;
            color: #505458;
        }
        .remember {
            margin: 0px 0px 35px 0px;
        }
    }
</style>