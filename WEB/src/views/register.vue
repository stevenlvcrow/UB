<template>
    <el-dialog
            :close-on-click-modal="false"
            title="注册用户"
            :visible.sync="$store.state.userInfo.showRegisterDialog"
            width="30%"
            @open="open">

            <el-form :model="$store.state.userInfo.registerForm" status-icon :rules="rules" ref="registerForm" label-width="100px">
                <el-form-item label="登录用户名" prop="userName">
                    <el-input v-model="$store.state.userInfo.registerForm.userName"></el-input>
                </el-form-item>
                <el-form-item label="登录密码" prop="pwd">
                    <el-input v-model="$store.state.userInfo.registerForm.pwd"></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="checkPass">
                    <el-input v-model="$store.state.userInfo.registerForm.checkPass"></el-input>
                </el-form-item>
                <el-form-item label="真实姓名" prop="relName">
                    <el-input v-model="$store.state.userInfo.registerForm.relName"></el-input>
                </el-form-item>
            </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="$store.state.userInfo.showRegisterDialog = false">取 消</el-button>
            <el-button type="primary" @click="sub">确 定</el-button>
          </span>
    </el-dialog>
</template>
<script>
    import {getUserInfo, saveUser} from "../api/user";

    export default {
        name: 'registerDialog',
        data() {
            const validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.$store.state.userInfo.registerForm.pwd) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                rules: {
                    checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],
                    userName: [
                        {required: true, message: '请输入登录用户名', trigger: 'blur'},
                    ],
                    pwd: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                    ],
                    relName: [
                        {required: true, message: '请输入真实姓名', trigger: 'blur'},
                    ],
                }
            };
        },
        methods: {
            open(){
                getUserInfo({id:'nothing'}).then(res=>{
                    //console.log(res);
                    this.$store.state.userInfo.registerForm = res || {};
                })
            },
            sub(){
                this.$refs['registerForm'].validate((valid) => {
                    if(!valid)return;

                    saveUser({ubUser:this.$store.state.userInfo.registerForm}).then((res)=>{
                        if(!res){
                            return
                        }
                        this.$message.success('注册成功');
                        this.$store.state.userInfo.showRegisterDialog = false
                    })
                })
            }
        }
    };
</script>