const userInfo = {
    namespaced: true,
    state: {
        showRegisterDialog:false,
        registerForm:{},
    },
    getters: {
        getTableDatas: state => {

        }
    },
    mutations: {

    },
    actions: {
        resetForm({commit}) {
            commit('clearMember');

        },

    }
};

export default userInfo
