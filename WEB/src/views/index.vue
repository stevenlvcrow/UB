<template>
    <section>
        <div class="desktop">
            <div id="win10-shortcuts" class="shortcuts-hidden">


                <div class="shortcut" onclick="Win10.openUrl('http://win10ui.yuri2.cn','<img class=\'icon\' src=\'static/icon/win10.png\'/>Win10-UI官网')">
                    <img class="icon" src="static/icon/win10.png"/>
                    <div class="title">Win10-UI官网</div>
                </div>
                <div class="shortcut" onclick="window.open(window.location.origin+'#/demo')">
                    <img class="icon" src="static/icon/demo.png"/>
                    <div class="title">查看DEMO</div>
                </div>


            </div>
            <div id="win10-desktop-scene"></div>
        </div>
        <div id="win10-menu" class="hidden">
            <div class="list win10-menu-hidden animated animated-slideOutLeft">
                <div class="item"
                     onclick="Win10.exit()">
                    <i class="black icon fa fa-power-off fa-fw"></i><span class="title">关闭</span>
                </div>
            </div>
            <div class="blocks">
                <div class="menu_group">
                    <div class="title">Welcome</div>
                    <div class="block" loc="1,1" size="6,4">
                        <div class="content">
                            <div style="font-size:100px;line-height: 132px;margin: 0 auto ;display: block"
                                 class="fa fa-fw fa-windows win10-block-content-text"></div>
                            <div class="win10-block-content-text" style="font-size: 22px">欢迎使用 Win10-UI</div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="win10-menu-switcher"></div>
        </div>
        <div id="win10_command_center" class="hidden_right">
            <div class="title">
                <h4 style="float: left">消息中心 </h4>
                <span id="win10_btn_command_center_clean_all">全部清除</span>
            </div>
            <div class="msgs"></div>
        </div>
        <div id="win10_task_bar">
            <div id="win10_btn_group_left" class="btn_group">
                <div id="win10_btn_win" class="btn"><span class="fa fa-windows"></span></div>
                <div class="btn" id="win10-btn-browser"><span class="fa fa-internet-explorer"></span></div>
            </div>
            <div id="win10_btn_group_middle" class="btn_group"></div>
            <div id="win10_btn_group_right" class="btn_group">
                <div class="btn" id="win10_btn_time"></div>
                <div class="btn" id="win10_btn_command"><span id="win10-msg-nof" class="fa fa-comment-o"></span></div>
                <div class="btn" id="win10_btn_show_desktop"></div>
            </div>
        </div>
    </section>
</template>
<script>



    export default {
        mounted:function () {
            Win10._init();

            for(let i in Win10._handleReady){
                let handle=Win10._handleReady[i];
                handle();
            }
            Win10.setBgUrl({
                main:'static/wallpapers/main.jpg',
                mobile:'static/wallpapers/mobile.jpg',
            });

            Win10.setAnimated([
                'animated flip',
                'animated bounceIn'
            ], 0.01);
            setTimeout(()=>{

            },1000)
        },
    }
</script>
<style lang="scss">


</style>