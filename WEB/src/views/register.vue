<template>
    <el-dialog
            :close-on-click-modal="false"
            title="注册用户"
            :visible.sync="$store.state.userInfo.showRegisterDialog"
            width="30%"
            @open="open"
            :before-close="handleClose">

            <el-form :model="$store.state.userInfo.registerForm" status-icon :rules="rules" ref="ruleForm2" label-width="100px">

            </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="$store.state.userInfo.showRegisterDialog = false">确 定</el-button>
          </span>
    </el-dialog>
</template>
<script>
    import {getUserInfo} from "../api/user";

    export default {
        name: 'registerDialog',
        data() {
            return {
                rules: {
                    name: [
                        {required: true, message: '请输入名称', trigger: 'blur'},
                    ],
                }
            };
        },
        methods: {
            handleClose(done) {
                this.$confirm('确认关闭？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {});
            },
            open(){
                getUserInfo({id:'nothing'}).then(res=>{
                    console.log(res);
                    this.$store.state.userInfo.registerForm = res || {};
                })
            }
        }
    };
</script>