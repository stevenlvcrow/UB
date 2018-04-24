<template>
    <section>
        <el-row>
            <el-col :span=8>
                <el-select size="small" v-model="provinceId_" clearable placeholder="省" >
                    <el-option
                            v-for="item in provinceList"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-col>
            <el-col :span=8>
                <el-select size="small" v-model="cityId_" clearable placeholder="市">
                    <el-option
                            v-for="item in cityList"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-col>
            <el-col :span=8>
                <el-select size="small" v-model="districtId_" clearable placeholder="县">
                    <el-option
                            v-for="item in districtList"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-col>
        </el-row>

    </section>
</template>
<script>
    import {getAreaCombo} from '../api/base';
    export default {
        name: 'areaCombo',
        props: {
            provinceId: {
                type: String,
                default: ''
            },
            cityId: {
                type: String,
                default: ''
            },
            districtId: {
                type: String,
                default: ''
            }
        },
        data() {
            return {
                provinceId_: '',
                cityId_: '',
                districtId_: '',
                provinceName:'',
                cityIdName:'',
                districtIdName:'',

                provinceList: [],
                cityList: [],
                districtList: [],
            }
        },
        mounted(){
            this.getData('', (response) => {
                this.provinceList = response.data;
            })
        },
        watch: {
            provinceId(curVal){
                this.provinceId_ = curVal;
            },
            cityId(curVal){
                this.cityId_ = curVal;
            },
            districtId(curVal){
                this.districtId_ = curVal;
            },
            provinceId_(curVal){
                this.$emit('update:provinceId', curVal);
                if (curVal !== '') {
                    this.getData(curVal, (response) => {
                        this.cityList = response.data;
                        this.cityId_ = response.data[0].value;
                        this.provinceName = this.provinceList.find(item => item.value=== this.provinceId_)['label']
                    });
                }
            },
            cityId_(curVal){
                this.$emit('update:cityId', curVal);
                if (curVal !== '') {
                    this.getData(curVal, (response) => {
                        this.districtList = response.data;
                        this.districtId_ = this.districtList[0].value;
                        this.cityIdName = this.cityList.find(item => item.value === this.cityId_)['label']
                    });
                }
            },
            districtId_(curVal){
                this.$emit('update:districtId', curVal);
                this.districtIdName = this.districtList.find(item => item.value === this.districtId_)['label'];
                this.address = this.provinceName+this.cityIdName+this.districtIdName;
                this.$emit('update:address', this.address);
            }
        },
        methods: {
            getData(parentid, fn){
                getAreaCombo(parentid).then(response => {
                    if (response.data.length <= 0) {
                        return;
                    }
                    // success callback
                    fn(response);
                });
            }
        }
    }
</script>