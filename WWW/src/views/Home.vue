<template>
    <section>
        <el-input v-model="labeles.join(',')"></el-input>
        <el-button type="text" @click="dialogTableVisible = true">打开嵌套表格的 Dialog</el-button>

        <el-dialog title="选择销售区域(省)" :visible.sync="dialogTableVisible" width="50%" :close-on-click-modal="false">
            <hr class="ums-hr"/>
            <el-row :gutter="24">
                <el-col :span="3" v-for="item in provinceList" :key="item.value">
                    <el-button v-if="selectedList.indexOf(item.value)!=-1" class="ums-button" type="primary" size="medium"
                               @click="selected(item.value,item.label)">{{item.label}}</el-button>
                    <el-button v-if="selectedList.indexOf(item.value)==-1" class="ums-button" size="medium"
                               @click="selected(item.value,item.label)">{{item.label}}</el-button>
                </el-col>
            </el-row>
            <hr class="ums-hr"/>
            <span slot="footer">
                <el-button size="medium" @click="dialogTableVisible = false">取 消</el-button>
                <el-button size="medium" type="primary" @click="dialogTableVisible = false">确 定</el-button>
                <el-button size="medium" class="ums-left" @click="selectAll">全选</el-button>
                <el-button size="medium" class="ums-left" @click="clearAll">清空</el-button>
              </span>
        </el-dialog>
    </section>
</template>

<script>


    export default {
        data() {
            return {
                isActive:false,
                provinceList: [
                    {
                        "value": "0a753387c2474e36af5593e1d19cb938",
                        "label": "安徽"
                    },
                    {
                        "value": "92dfbf862846410baf454657b31e4a80",
                        "label": "北京"
                    },
                    {
                        "value": "a20a9b46d7c4450db332cdbcd52a0316",
                        "label": "福建"
                    },
                    {
                        "value": "80c7af3871a345c195b03385f272eea9",
                        "label": "甘肃"
                    },
                    {
                        "value": "88cf724a9c0b401d90975c2c561e0efc",
                        "label": "广东"
                    },
                    {
                        "value": "c817f5dbe28b4cd1a2d111f9ff7fe919",
                        "label": "广西"
                    },
                    {
                        "value": "8db4fdd4a11a49b29d28639d783df498",
                        "label": "贵州"
                    },
                    {
                        "value": "eb609033f82c41a79966d5be85651242",
                        "label": "海南"
                    },
                    {
                        "value": "62e0be78ec3c424c9e7681d0e44ad8ab",
                        "label": "河北"
                    },
                    {
                        "value": "4756aa8101c4406ebf59715ca7484e3b",
                        "label": "河南"
                    },
                    {
                        "value": "c03fa9804c584fa2ac4dd073b616d07e",
                        "label": "黑龙江"
                    },
                    {
                        "value": "0003",
                        "label": "湖北"
                    },
                    {
                        "value": "0ff023eb8fd54ac2914694ea82756323",
                        "label": "湖南"
                    },
                    {
                        "value": "b9f984cbb2c740f1972cab2dcc019969",
                        "label": "吉林"
                    },
                    {
                        "value": "78a0363a16aa4566aee73fd03cbec65c",
                        "label": "江苏"
                    },
                    {
                        "value": "0b02b47031974bc1806d4b4c6729f46b",
                        "label": "江西"
                    },
                    {
                        "value": "8654a2ce9e844f048232abaeb69b8625",
                        "label": "辽宁"
                    },
                    {
                        "value": "5c307899709c4f26b5de5742cd0516cb",
                        "label": "内蒙古"
                    },
                    {
                        "value": "a01ec5fd96f1414dbd67be423b6b31ea",
                        "label": "宁夏"
                    },
                    {
                        "value": "87aab6b3af8547c483e542e74eceebf5",
                        "label": "青海"
                    },
                    {
                        "value": "5946c8dc69764f57ba7a3641768b195d",
                        "label": "山东"
                    },
                    {
                        "value": "bbe28fda03bf4aa4b74a3e3963296cdf",
                        "label": "山西"
                    },
                    {
                        "value": "cf520c61c08a4c7384758bbcbfb8218c",
                        "label": "陕西"
                    },
                    {
                        "value": "0002",
                        "label": "上海"
                    },
                    {
                        "value": "b221f22d8b1047b49270a1a5cdc5d22b",
                        "label": "四川"
                    },
                    {
                        "value": "63dc7fd044e84ccf82a18502ddeff92d",
                        "label": "天津"
                    },
                    {
                        "value": "19fb7574c2d84ce6bff6ef1691b87be1",
                        "label": "西藏"
                    },
                    {
                        "value": "4b5c441a9a10460489bc23f55ec05875",
                        "label": "新疆"
                    },
                    {
                        "value": "ad28ce0ff25e4477b89bff07dc88a932",
                        "label": "云南"
                    },
                    {
                        "value": "8a5094c36d5b4ddc87271ae3f1052841",
                        "label": "浙江"
                    },
                    {
                        "value": "399cc2f08aba48bd9c112581f2e20dbe",
                        "label": "重庆"
                    }
                ],
                selectedList:[],
                labeles:[],
                dialogTableVisible: false,
            };
        },
        methods:{
            selected(id,name){
                let index = this.selectedList.indexOf(id);
                if(index!==-1){
                    this.selectedList.splice(index,1);
                    this.labeles.splice(index,1);
                }else{
                    this.selectedList.push(id);
                    this.labeles.push(name);
                }
            },
            selectAll(){
                if(this.selectedList.length === this.provinceList.length){
                    return;
                }
                for(let item of this.provinceList){
                    this.selectedList.push(item.value);
                    this.labeles.push(item.label);
                }
            },
            clearAll(){
                this.selectedList = [];
                this.labeles = [];
            },
            sub(){
                this.dialogTableVisible = false;
            }
        }
    };
</script>
<style lang="scss">

    .ums-hr {
        height: 1px;
        border: none;
        border-top: 1px solid #D9D9D9;
    }

    .ums-left {
        float: left;
    }

    .ums-button {
        margin-top: 12px;
        width: 80px;
    }

</style>