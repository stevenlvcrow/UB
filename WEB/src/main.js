import Vue from 'vue'
import ElementUI from 'element-ui'
import VueRouter from 'vue-router'
import Vuex from 'vuex'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'

import routes from './routes'
import store from './common/vuex/index'

Vue.use(ElementUI, { size: 'mini' });
Vue.use(VueRouter);
Vue.use(Vuex);


const router = new VueRouter({
    routes
});

router.beforeEach((to, from, next) => {
    next();
});

new Vue({
    store,
    router,
  el: '#app',
  render: h => h(App)
});
