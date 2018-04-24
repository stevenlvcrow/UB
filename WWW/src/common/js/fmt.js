

export default {

    formatProType(emum){
        switch (emum){
            case '1': return '一起来扶贫';
            case '2': return '地方特色';
            default:  return '';
        }
    },

    publishStat(emum){
        switch (emum) {
            case '0':
                return '待审核';
            case '1':
                return '审核通过';
            case '2':
                return '下线';
            case '3':
                return '驳回';
            default: return "";
        }
    },

    produceStat(emum){
        switch (emum){
            case '0': return '新增';
            case '1': return '修改';
            case '2': return '删除';
            default: return "";
        }
    },

    formatCustomLimit(emum){
        switch (emum){
            case 0: return '不限制';
            case 1: return '限制';
            default: return "";
        }
    },

    formatSource(emum){
        switch (emum){
            case '0': return '自产';
            case '1': return '供货商';
            default: return "";
        }
    },

    formatPinkage(emum){
        switch (emum){
            case '0': return '包邮';
            case '1': return '不包邮';
            default: return "";
        }
    },

    formatSupType(emum){
        switch (emum){
            case 'person': return '个人';
            case 'company': return '企业';
            default: return "";
        }
    },

    formatOrderStat(emum){
        switch (emum){
            case '0': return '未支付';
            case '1': return '已支付';
            case '2': return '支付失败';
            case '3': return '支付成功待发货';
            case '4': return '支付成功待收货';
            case '5': return '支付成功确认收货';
            case '9': return '关闭';
            case '10': return '售后未确认';
            case '11': return '售后已确认';
            default: return "";
        }
    },
    // 11：下单成功 12：下单失败 13：接单 14：不接单 15：已揽件 16：揽收失败 17：派件中 18：签收成功 19：签收失败 20：已取消 21：人工处理 22：已支付
    formatDhStat(emum){
        switch (emum){
            case '11': return '下单成功';
            case '12': return '下单失败';
            case '13': return '接单';
            case '14': return '不接单';
            case '15': return '已揽件';
            case '16': return '揽收失败';
            case '17': return '派件中';
            case '18': return '签收成功';
            case '19': return '签收失败';
            case '20': return '已取消';
            case '21': return '人工处理';
            case '22': return '已支付';
            default: return "";
        }
    },

    formatExpressUms(emum){
        switch (emum){
            case '0': return '自选快递';
            case '1': return '大华捷通';
            default: return "";
        }
    },

    formatFeatureType(emum){
        switch (emum){
            case '0': return '普通';
            case '1': return '当日达';
            default: return "";
        }
    },

    formatRefundStat(emum){
        switch (emum){
            case '1': return '待审核';
            case '2': return '审核通过';
            case '3': return '审核不通过';
            default: return "";
        }
    },

    formatRefundType(emum){
        switch (emum){
            case '0': return '退款';
            case '1': return '退货';
            default: return "";
        }
    },

    pageInit(user, path){
        let sysUserAthority = user.authority || [];
        let buttons = [];
        for (let authority of sysUserAthority) {
            if (authority.page === path) {
                buttons = authority.buttons
            }
        }
        return buttons;
    },

    formatDate(date, fmt){
        date = new Date(date);
        if (/(y+)/.test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
        }
        let o = {
            'M+': date.getMonth() + 1,
            'd+': date.getDate(),
            'h+': date.getHours(),
            'm+': date.getMinutes(),
            's+': date.getSeconds()
        };
        for (let k in o) {
            if (new RegExp(`(${k})`).test(fmt)) {
                let str = o[k] + '';
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : this.padLeftZero(str));
            }
        }
        return fmt;
    },
    padLeftZero(str){
        return ('00' + str).substr(str.length);
    }

};
