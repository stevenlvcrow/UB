<template>
    <div id="win10">
        <div id="aaa"></div>
        <transition name="fade" mode="out-in">
            <router-view></router-view>
        </transition>
    </div>
</template>


<script>
    import WIN10 from '../src/common/resource/win10'
    import layer from '../src/common/components/layer-v3.0.3/layer/layer.js'



    export default {
        name: 'win10',
        mounted:function () {
        }
    }

</script>

<style lang="scss">

    @import "./common/components/font-awesome-4.7.0/css/font-awesome.min.css";
    @import "./common/components/layer-v3.0.3/layer/skin/default/layer.css";
    @import "./common/resource/default.css";
    @import "./common/resource/animate.css";




    #win10 {
        /*磁贴自定义样式*/
        .win10-block-content-text {
            line-height: 44px;
            text-align: center;
            font-size: 16px;
        }
    }
</style>

