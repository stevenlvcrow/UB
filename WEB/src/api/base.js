import axios from 'axios';
import jsencrypt from 'jsencrypt'
import sha256 from 'crypto-js/sha256';
import store from '../common/vuex/index'
import { Message } from 'element-ui';

let base  = process.env.NODE_ENV === 'development' ? 'http://localhost:8769' : '';

// 请求时的拦截
axios.interceptors.request.use(function (config) {
    if(config.url.indexOf("login")!==-1){
        return config;
    }
    let jse =new jsencrypt();
    jse.setPublicKey(store.state.userInfo.publicKey);
    if(!store.state.userInfo.publicKey){
        return config;
    }
    let requestdata = JSON.stringify(config.data);
    requestdata = sha256(requestdata);
    config.headers.token  = jse.encrypt(requestdata+'#asso#');

    return config;
}, function (error) {
    // 当请求异常时做一些处理
    return Promise.reject(error);
});
axios.interceptors.response.use((response) => {
    let data = response.data;
    if(data.errCode!=='0000'){
        throw data.errInfo;
    }

    return data.responseData;
}, error => {
    console.log(error);
    Message.error({
        message: '加载失败'
    });
    return Promise.reject(error)
});

export default base;