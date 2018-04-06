const refundrule = {
    state: {
        //退换货规则列表
        refundRuleList: [],
    },
    getters: {
        getRefundRuleList: state => state.refundRuleList,
        getRefundRuleCombo:state=>{
            let combo = [];
            combo.push({'label':"",'value':""});
            let list = state.refundRuleList;
            for(let red of list){
                combo.push({'label':red.ruleName,'value':red.id});
            }
            return combo
        }
    },
    mutations: {
        setRefundRuleList(state, obj) {
            state.refundRuleList = obj.data
        }
    },
    actions: {
        set_RefundRuleList({commit}, obj) {
            commit('setRefundRuleList', obj)
        }
    }
};

export default refundrule
