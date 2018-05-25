import axios from 'axios';
import url from './base';
let base = url;
export const test = params => { return axios.post(`${base}login`,params).then(res => res.data); };