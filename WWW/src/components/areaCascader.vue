<template>
    <el-cascader
            style="width: 260px"
            size="mini"
            :value="value"
            change-on-select
            :options="options2"
            @change="changeParent"
            :props="props"
    ></el-cascader>

</template>

<script>
    import {getAreaCombo} from '../api/base';
    export default {
        name: 'areaCascader',
        props:['provinceId','cityId','districtId','address'],
        data() {
            return {
                loading2: false,
                options2: [],
                value:[],
                props: {
                    value: 'value',
                    label: 'label',
                    children: 'cites'
                }
            };
        },

        mounted(){
            getAreaCombo('').then(response => {
                if (response.data.length <= 0) {
                    return;
                }
                let provinceArr = response.data;
                this.options2 = this.renderResult(provinceArr)
            });

        },

        watch: {
            // 根据传入的省ID进行回填操作
            provinceId(curVal){
                if(curVal==='') return;
                if(typeof(curVal)==="undefined") return;
                // 查城市列表
                this.getData(curVal, (response) => {
                    // 城市列表
                    let cityArr = response.data;
                    // 找到回填城市的那一条记录
                    let idx = this.utils.getArryidx(this.options2,curVal,'value');
                    // 回填的城市列表装填完毕
                    this.options2[idx].cites= this.renderResult(cityArr);
                });

            },
            cityId(curVal){
                if(typeof(curVal)==="undefined") return;
                if(!curVal)return;
                this.getData(curVal, (response) => {
                    let idx = this.utils.getArryidx(this.options2,this.provinceId,'value');
                    let thiz = this;
                    setTimeout(_ => {
                        let idxx = thiz.utils.getArryidx(thiz.options2[idx].cites,curVal,'value');
                        thiz.options2[idx]['cites'][idxx]['cites'] = response.data ;
                        thiz.value = [this.provinceId,this.cityId,this.districtId];
                    }, 300);
                });
            },
            value(curVal){
                this.changeParent(curVal)
            }
        },

        methods: {
            renderResult(result){
              let arry = [];
                for(let province of result){
                    let obj = {
                        label:province.label,
                        value:province.value,
                        cites:[]
                    };
                    arry.push(obj)
                }
                return arry;
            },

            getData(parentid, fn){
                getAreaCombo(parentid).then(response => {
                    if (response.data.length <= 0) {
                        return;
                    }
                    // success callback
                    fn(response);
                });
            },

            changeParent(val){
                let addr0 = this.utils.getLabelByValue(this.options2,val[0],'cites','label');
                let addr1 = this.utils.getLabelByValue(this.options2,val[1],'cites','label');
                let addr2 = this.utils.getLabelByValue(this.options2,val[2],'cites','label');
                this.$emit('update:address', addr0+addr1+addr2);
                this.$emit('update:provinceId', val[0]);
                this.$emit('update:cityId', val[1]);
                this.$emit('update:districtId', val[2]);
            },



            clear(){
                this.value=[]
            }

        }
    };
</script>