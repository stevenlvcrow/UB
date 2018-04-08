import babelpolyfill from 'babel-polyfill'
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import VueRouter from 'vue-router'
import utils from './common/js/util'
import Vuex from 'vuex'
import routes from './routes'
// import Mock from './mock'
// Mock.bootstrap();
import 'font-awesome/css/font-awesome.min.css'

Vue.use(ElementUI, { size: 'mini' });
Vue.use(VueRouter);
Vue.use(Vuex);

//NProgress.configure({ showSpinner: false });

const router = new VueRouter({
  routes
});


router.beforeEach((to, from, next) => {
    next();
});


new Vue({
  router,
  render: h => h(App)
}).$mount('#app');

export default router;
