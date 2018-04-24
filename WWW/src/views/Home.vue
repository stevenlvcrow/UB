<template>

    <el-row class="container">
        <el-col :span="24" class="header">
            <el-col :span="10" class="logo" :class="isCollapse?'logo-collapse-width':'logo-width'">
                <img src="../assets/Bitmap.png">
                {{isCollapse ? '' : sysName}}
            </el-col>
            <el-col :span="10">
                <div class="tools">
                    <!--<i class="fa fa-align-justify" @click="collapse"></i>-->
                    <!--<i class="fa fa-home line-tools" @click="gohome"></i>-->
                    <span v-if="merchant">
                         <el-popover
                                 ref="popover1"
                                 placement="top-start"
                                 title="商户切换"
                                 width="490"
                                 trigger="hover">
                        <template>
                            <el-table :data="tableData">
                                <el-table-column prop="name" label="商户名称"></el-table-column>
                                <el-table-column prop="type" label="商户类型" :formatter="fomatType"></el-table-column>
                                <el-table-column label="操作">
                                    <template slot-scope="scope">
                                        <el-button type="default" size="mini"
                                                   @click="switchMerchant(scope.row.id)"
                                        >确认切换</el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </template>
                    </el-popover>
                        <i class="line-text" v-popover:popover1>商户名称：{{merchant.name}}</i>
                    </span>


                    <i class="line-text" v-if="roles!=''">登录角色：{{roles}}</i>
                    <i class="line-text" >所属机构：{{orgName}}</i>
                    <!--<a href="/qmfrural-shop-portal/manage/index.html" style="margin-left: 20px">返回旧版</a>-->

                </div>
            </el-col>
            <el-col :span="4" class="userinfo">
                <i class="fa fa-user-o"></i>
                <i class="userinfo-inner">
                    <el-tooltip class="item" :content="sysUserName" placement="top">
                        <span>sysUserName</span>
                    </el-tooltip>
                </i>
                <i class="fa fa-sign-out icon-padding" aria-hidden="true"></i>
                <i class="userinfo-inner" @click="logout">退出</i>
            </el-col>
        </el-col>
        <el-col :span="24" class="main">
            <el-menu :default-active="$route.path" class="el-menu-vertical-demo"
                     text-color="#fff"
                     unique-opened router
                     :collapse="isCollapse">
                <template v-for="(item,index) in $router.options.routes" v-if="!item.hidden">
                    <el-submenu :index="index+''" v-if="!item.leaf">
                        <template slot="title">
                            <i :class="item.iconCls"></i> <span slot="title">{{item.name}}</span>
                        </template>
                        <el-menu-item class="sub-demo" v-for="child in item.children"
                                      v-if="!child.hidden" :index="child.path" :key="child.path">{{child.name}}
                        </el-menu-item>
                    </el-submenu>
                    <el-menu-item class="sub-demo" v-if="(item.leaf&&item.children.length>0)" :index="item.children[0].path">
                        <i :class="item.iconCls"></i><span slot="title">{{item.children[0].name}}</span></el-menu-item>
                </template>
            </el-menu>
            <section class="content-container">

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
                sysName: '卖家平台',
                isCollapse: false,
                sysUserName: '',
                sysOperator: '',
                sysUserRole: [],
                orgName:'',
                merchant:'',
                roles:[],
                tableData: []
            }
        },
        methods: {
            //退出登录
            logout: function () {
                let _this = this;
                this.$confirm('确认退出吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    loginOut().then(res=>{
                        if(res.success){
                            this.$message.success('注销成功');
                        }
                    });
                    sessionStorage.removeItem('user');
                    sessionStorage.removeItem('token');
                    sessionStorage.removeItem('vuex');
                    _this.$router.push('/login');
                    setTimeout(() => {
                        window.location.reload()
                    }, 500);
                }).catch(() => {

                });
            },

        },
        mounted() {



        }

    }

</script>

<style scoped lang="scss">
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 224px;
        min-height: 400px;
        line-height: 25px;
        background-color: #333333;
        border-radius: 0;
        .sub-demo{
            background-color: #333333;
            //color: #C9C9C9 !important;
        }
        .is-active{
            color: #52BEA6;
        }
    }
    .el-menu{
        border-radius: 0;
        background-color: #333333 ;
    }

    .container {
        position: absolute;
        top: 0;
        bottom: 0;
        width: 100%;
        .header {
            height: 75px;
            line-height: 75px;
            background: url(../assets/bg.png) center !important;
            //background-color: #409EFF;
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
                height: 60px;
                font-size: 18px;
                background: #333333 !important;
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
                    margin: 10px 10px 10px 18px;
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
                // background: #f1f2f7;
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
                    //margin-top: 10px;
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