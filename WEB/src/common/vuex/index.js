import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex);
import createPersistedState from 'vuex-persistedstate'

import userInfo from './modules/userInfo.js'


const store = new Vuex.Store({
    plugins: [createPersistedState({ storage: window.sessionStorage })],
    modules: {
        userInfo:userInfo,
    }
});

export default store
