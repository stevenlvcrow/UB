const userInfo = {
    namespaced: true,
    state: {
        showRegisterDialog:false,
        menu:[],
        registerForm:{},
    },
    getters: {
        getTableDatas: state => {

        }
    },
    mutations: {
        setMenu(state, obj) {
            state.menu = obj || [];
        },
    },
    actions: {


    }
};

export default userInfo
