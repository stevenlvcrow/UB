<template>
    <el-row class="container">
        <el-col :span="24" class="header">
            <el-col :span="10" class="logo logo-width">
                <img src="../assets/Bitmap.png">系统名称
            </el-col>

            <el-col :span="4" class="userinfo">
                <i class="fa fa-user-o"></i>
                <i class="userinfo-inner">
                    张三
                </i>
                <i class="fa fa-sign-out icon-padding" aria-hidden="true"></i>
                <i class="userinfo-inner" @click="logout">退出</i>
            </el-col>
        </el-col>
        <el-col :span="24" class="main">
            <el-menu :default-active="$route.path" class="el-menu-vertical-demo"
                     unique-opened router>
                <template v-for="(item,index) in $router.options.routes" v-if="!item.hidden">
                    <el-submenu :index="index+''" v-if="!item.leaf">
                        <template slot="title">
                            <i :class="item.iconCls"></i> <span slot="title">{{item.name}}</span>
                        </template>
                        <el-menu-item class="sub-demo" v-for="child in item.children"
                                      v-show="!child.hidden" :index="child.path" :key="child.path">{{child.name}}
                        </el-menu-item>
                    </el-submenu>
                    <el-menu-item class="sub-demo" v-if="(item.leaf&&item.children.length>0)" :index="item.children[0].path">
                        <i :class="item.iconCls"></i><span slot="title">{{item.children[0].name}}</span></el-menu-item>
                </template>
            </el-menu>
            <section class="content-container">
                <el-row :gutter="24" style="margin-top: 5px">
                    <el-col :span="22">
                        <el-breadcrumb separator-class="el-icon-arrow-right" separator="/">
                            <el-breadcrumb-item v-for="item in $route.matched" :key="item.path">
                                {{ item.name }}
                            </el-breadcrumb-item>
                        </el-breadcrumb>
                    </el-col>
                    <el-col :span="2" >
                        <el-button type="text" style="padding:0px 0px" @click="$router.push('/main')">返回首页</el-button>
                    </el-col>
                </el-row>
                <hr style="height:1px;border:none;border-top:1px solid #555555;">
                <el-col :span="24" class="content-wrapper">
                    <transition name="el-zoom-in-center" mode="out-in">
                        <router-view></router-view>
                    </transition>
                </el-col>
            </section>
        </el-col>
    </el-row>
</template>

<script>
    export default {

        data() {
            return {

            }
        },
        methods: {
            logout(){
                this.$router.push('/login');
            }
        },
        mounted() {
            let user = JSON.parse(sessionStorage.getItem('vuex'));
            if(!user){
                this.$router.push('/login');
            }
        }

    }

</script>

<style scoped lang="scss">

    .container {
        position: absolute;
        top: 0;
        bottom: 0;
        width: 100%;
        .el-menu-vertical-demo:not(.el-menu--collapse) {
            width: 224px;
            min-height: 400px;
            line-height: 25px;
            border-radius: 0;
            .sub-demo{
                //background-color: #333333;
                //color: #C9C9C9 !important;
            }
            .is-active{
                color: #409EFF;
            }
        }
        .el-menu{
            border-radius: 0;
            //background-color: #333333 ;
        }
        .header {
            height: 75px;
            line-height: 60px;
            background-color: #409EFF;
            //background: url(../assets/bg.png) center !important;
            color: #fff;
            .userinfo {
                text-align: right;
                padding-right: 23px;
                height: 60px;
                line-height: 60px;
                font-size: 12px;
                float: right;
                .icon-padding{
                    margin-left: 23px;
                }
                .userinfo-inner {
                    cursor: pointer;
                    font-style:normal;
                    color: #fff;
                    img {
                        width: 40px;
                        height: 40px;
                        border-radius: 20px;
                        float: right;
                    }
                }
            }
            .logo {
                //width:230px;
                font-size: 18px;
                //background: #333333 !important;
                .txt {
                    color: #fff;
                    size: 18px;
                }
            }
            .logo-width {
                width: 224px;
                img {
                    width: 46px;
                    float: left;
                    margin: 5px 10px 10px 18px;
                }
            }
            .logo-collapse-width {
                img {
                    width: 46px;
                    margin: 10px 10px 10px 10px
                }
                width: 64px
            }
            .tools {
                padding: 0 23px;
                // width: 60px;
                height: 60px;
                line-height: 60px;
                font-size: 12px;
            }
            .line-tools {
                margin-left: 23px;
            }
            .line-text{
                margin-left: 23px;
                font-style:normal;
            }
        }
        .main {
            display: flex;
            background: #ffffff;
            position: absolute;
            top: 60px;
            bottom: 0px;
            overflow: hidden;

            .content-container {
                //background: #f1f2f7;
                flex: 1;
                position: absolute;
                right: 0px;
                top: 0px;
                bottom: 0px;
                left: 230px;
                overflow-y: scroll;
                padding: 10px;
                .breadcrumb-container {
                    margin-top: 15px;
                    .title {
                        width: 200px;
                        float: left;
                        color: #475669;
                    }
                    .breadcrumb-inner {
                        float: right;
                    }
                }
                .content-wrapper {
                    box-sizing: border-box;
                    margin-top: 10px;
                }
            }
            .home-foot {
                width: 100%;
                position: fixed;
                bottom: 10px;
                text-align: left;
            }
        }

    }
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 480px;
    }

</style>