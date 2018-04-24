import axios from 'axios';
 let base  = process.env.NODE_ENV === 'development' ? 'http://172.27.15.152:8081/qmfrural-asso-portal/' : '';
//let base  = process.env.NODE_ENV === 'development' ? 'http://58.247.0.18:29014/qmfrural-asso-portal/' : '';
axios.defaults.withCredentials=true;
// 请求时的拦截
axios.interceptors.request.use(function (config) {
    // 发送请求之前做一些处理
    // 解决在ie上 请求缓存数据的问题
    if(config.url.indexOf("?")>-1){
        config.url=config.url+"&tamp="+new Date().getTime();
    }else{
        config.url=config.url+"?timestamp="+new Date().getTime();
    }
    return config;
}, function (error) {
    // 当请求异常时做一些处理
    return Promise.reject(error);
});
export const getAreaNameById   = params => { return axios.get(`${base}member/getAreaNameById?id=`+params).then(res => res); };
export const getAreaCombo   = params => { return axios.get(`${base}member/getAreaCombo?parentId=`+params).then(res => res); };
export const startCaptcha   = params => { return axios.get(`${base}startCaptcha`,params).then(res => res.data); };
export const url = ()=>{return `${base}`};
export default base;