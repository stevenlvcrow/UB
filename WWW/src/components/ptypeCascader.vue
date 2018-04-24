<template>
    <el-cascader size="small" :options="$store.state.produceTypeList" :value="proType" @change="getProductType"
                 clearable change-on-select expand-trigger="hover"></el-cascader>
</template>
<script>
    export default{
        name:'ptCascader',
        props:{
            proType:{
                type:Array,
                default:[]
            },
            productType:{
                type:String,
                defalut:''
            },
            proTypeName:{
                type:String,
                defalut:''
            }
        },
        data(){
            return{

            }
        },
        watch:{
            proType(val){
                this.getProductType(val)
            }
        },
        methods:{
            getProductType(val){
                let addr0 = this.utils.getLabelByValue(this.$store.state.produceTypeList,val[0],'children','label');
                let addr1 = this.utils.getLabelByValue(this.$store.state.produceTypeList,val[1],'children','label');

                this.$emit('update:proTypeName', addr0+'/'+addr1);
                this.$emit('update:value', val[val.length-1]);
                this.$emit('update:proType', val);
               // this.getlabel(val);
            }
        }
    }
</script>