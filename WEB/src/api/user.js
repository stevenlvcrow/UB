import axios from 'axios';
import url from './base';
import errorCallback from './error'

export const login = params => { return axios.post(`${url}/sys/login`,params).then(res => res).catch(error =>{errorCallback(error)}); };
export const getUserInfo = params => { return axios.post(`${url}/userInfo/getUserInfo`,params).then(res => res).catch(error =>{errorCallback(error)}); };
export const saveUser = params => { return axios.post(`${url}/userInfo/saveUser`,params).then(res => res).catch(error =>{errorCallback(error)}); };
