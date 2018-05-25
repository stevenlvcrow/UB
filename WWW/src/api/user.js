import axios from 'axios';
import url from './base';
import errorCallback from './error'

export const login = params => { return axios.post(`${url}login`,params).then(res => res.data).catch(error =>{errorCallback(error)}); };