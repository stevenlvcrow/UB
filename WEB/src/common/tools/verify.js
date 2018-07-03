export default {

    verifyMoney(rule, value, callback) {
        let reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
        if (!reg.test(value)) {
            callback(new Error('请输入正确的价格!'));
        } else {
            callback();
        }
    },

    verifyMobile(rule, value, callback) {
        let re = /^0?(13[0-9]|14[5-9]|15[012356789]|166|17[0-8]|18[0-9]|19[8-9])[0-9]{8}$/;
        if (!re.test(value)) {
            callback(new Error('请输入正确的手机号!'));
        } else {
            callback();
        }
    },
    verifyNum(rule, value, callback) {
        let re = /^[0-9]*$/;
        if (!re.test(value)) {
            callback(new Error('只能输入数字!'));
        } else {
            callback();
        }
    },

    verifyEmail(e, value, callback) {
        let re = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!re.test(value)) {
            callback(new Error('请输入正确的邮箱地址!'));
        } else {
            callback();
        }
    },
    verifyPostCode(e, value, callback) {
        let re = /[1-9]\d{5}(?!\d)/;
        if (!re.test(value)) {
            callback(new Error('请输入正确的邮政编码'));
        } else {
            callback();
        }
    },

    verifyPostCode(e, value, callback) {
        let re = /^[1-9][0-9]{5}$/;
        if (!re.test(value)) {
            callback(new Error('请输入正确的邮编地址'));
        } else {
            callback();
        }
    },

    verifyIdCard(e, value, callback) {
        let re18 = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
        let re15 = /^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$/;
        if (value.length === 18) {
            if (!re18.test(value)) {
                callback(new Error('请输入正确的身份证号'));
            } else {
                callback();
            }
        }
        if (value.length === 15) {
            if (!re15.test(value)) {
                callback(new Error('请输入正确的身份证号'));
            } else {
                callback();
            }
        }
        callback(new Error('请输入正确的身份证号'));
    },

    isNull(rule, value, callback) {
        if (value === null || value === '') {
            callback(new Error('不能为空'));
        } else {
            callback();
        }
    },
};
