import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
import createPersistedState from 'vuex-persistedstate'

import Farmby from './modules/farmby.js'
import RefundRule from './modules/refundRule.js'

const store = new Vuex.Store({
    plugins: [createPersistedState({ storage: window.sessionStorage })],
    modules: {
        farmby: Farmby,
        refundRule: RefundRule,
    }
});

export default store
