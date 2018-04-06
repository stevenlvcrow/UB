import axios from 'axios';
import routes from '../main'


let base  = process.env.NODE_ENV === 'development' ? 'http://localhost:29000/qmfrural-shop-portal/' : '';


//支持跨域
axios.defaults.withCredentials=true;
// 请求时的拦截
axios.interceptors.request.use(config => {
    return config;
}, error=> {
    // 当请求异常时做一些处理
    console.log(error);
});

axios.interceptors.response.use((response) => {
    return response;
});

export const getAreaCombo   = params => { return axios.post(`${base}getAreaCombo`,params).then(res => res); };

export const url = ()=>{return `${base}`};
export default base;