<template>
    <section>
        <el-input v-model="labeles.join(',')" :readonly="true" @focus="dialogTableVisible = true"></el-input>
        <el-dialog title="选择销售区域(省)" :visible.sync="dialogTableVisible" width="50%" :close-on-click-modal="false" append-to-body>
            <hr class="ums-hr"/>
            <br>
            <el-row :gutter="24">
                <el-col :span="3" v-for="item in provinceList" :key="item.value">
                    <el-button v-if="selectedList.indexOf(item.value)!=-1" class="ums-button" type="primary" 
                               @click="selected(item.value,item.label)">{{item.label}}</el-button>
                    <el-button v-if="selectedList.indexOf(item.value)==-1" class="ums-button" 
                               @click="selected(item.value,item.label)">{{item.label}}</el-button>
                </el-col>
            </el-row>
            <br> <br>
            <hr class="ums-hr"/>
            <br>
            <span slot="footer">
                <el-button  @click="dialogTableVisible = false">取 消</el-button>
                <el-button  type="primary" @click="dialogTableVisible = false">确 定</el-button>
                <el-button  class="ums-left" @click="selectAll">全选</el-button>
                <el-button  class="ums-left" @click="clearAll">清空</el-button>
              </span>
        </el-dialog>
    </section>
</template>

<script>

    export default {
        name:'provinceSelect',
        props:{
            provinceList1:{
                type:Array,
                default:[]
            },
        },
        data() {
            return {
                isActive:false,
                provinceList: this.$store.state.provinceList,
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
                    this.labeles.splice(this.labeles.indexOf(this.getNameById(id)),1);
                }else{
                    this.selectedList.push(id);
                    this.labeles.push(name);
                }
                this.update()
            },
            selectAll(){
                if(this.selectedList.length === this.provinceList.length){
                    return;
                }
                for(let item of this.provinceList){
                    this.selectedList.push(item.value);
                    this.labeles.push(item.label);
                }
                this.update()
            },
            clearAll(){
                this.selectedList = [];
                this.labeles = [];
                this.update()
            },
            sub(){
                this.dialogTableVisible = false;
                this.$emit('update:provinceList1', this.selectedList);
            },
            update(){
                this.$emit('update:provinceList1', this.selectedList);
            },
            getName(){
                for(let item of this.provinceList){
                    for(let item1 of this.selectedList){
                        if(item1===item.value){
                            this.labeles.push(item.label)
                        }
                    }
                }
            },
            init(arry){
                this.clearAll();
                for(let item of arry){
                    this.selectedList.push(item);
                }
                this.getName();
            },
            getNameById(id){
                for(let item of this.provinceList){
                    if(id===item.value){
                        return item.label
                    }
                }
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