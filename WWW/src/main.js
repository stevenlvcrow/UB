import babelpolyfill from 'babel-polyfill'
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import VueRouter from 'vue-router'
import store from './vuex/index'
import utils from './common/js/util'
import gt from './common/js/resource/gt'
import fmt from './common/js/fmt'
import mes from './common/js/mes'
import Vuex from 'vuex'
import routes from './routes'
// import Mock from './mock'
// Mock.bootstrap();
import 'font-awesome/css/font-awesome.min.css'
import { Loading } from 'element-ui';

Vue.use(ElementUI, { size: 'mini' });
Vue.use(VueRouter);
Vue.use(Vuex);

//NProgress.configure({ showSpinner: false });

Vue.prototype.utils = utils;
Vue.prototype.fmt = fmt;
Vue.prototype.mes = mes;
const router = new VueRouter({
    routes
});


router.beforeEach((to, from, next) => {
    next();
});


new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');

