const farmby = {
    state: {
        currentAudio: {
            url: ''
        },
        tableData: [],
    },
    getters: {
        getCurrentAudio: state => state.currentAudio,

        getFarmbyList: state => {
            state.tableData = [{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                date: '2016-05-04',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1517 弄'
            }, {
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1519 弄'
            }, {
                date: '2016-05-03',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1516 弄'
            }]
        }
    },
    mutations: {
        setAudioCurrentD(state, obj) {
            state.currentD = obj
        }
    },
    actions: {
        set_AudioCurrentD({commit}, obj) {
            commit('setAudioCurrentD', obj)
        }
    }
};

export default farmby
