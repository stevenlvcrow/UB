export default {

    isArray(obj) {
        return Object.prototype.toString.call(obj) === '[object Array]';
    },

    removeByValue(arr, val) {
        for (let i = 0; i < arr.length; i++) {
            if (arr[i] === val) {
                arr.splice(i, 1);
                break;
            }
        }
    },

    /**
     * 得到某项=某值的下标
     * @param arry
     * @param val
     * @param prototype
     * @returns {number}
     */
    getArryidx(arry, val, prototype) {
        for (let index = 0, len = arry.length; index < len; index++) {
            let option = arry[index];
            if (option[prototype] === val) {
                return index
            }
        }
    },
    /**
     * 获取子父集合value对应的文本
     * @param arry
     * @param value
     * @param children 子集合键
     * @param name 文本内容键
     * @returns {string}
     */
    getLabelByValue(arry, value, children, name) {
        let adr = '';

        function loop(arry, value, name) {
            for (let cy of arry) {
                if (cy.value === value) {
                    adr = cy[name]
                } else {
                    if (cy[children] && cy[children].length !== 0) {
                        loop(cy[children], value, name)
                    }
                }
            }
        }

        loop(arry, value, name);
        return adr
    },

    uuid() {
        let s = [];
        let hexDigits = "0123456789abcdef";
        for (let i = 0; i < 32; i++) {
            s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
        }
        s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
        s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
        s[8] = s[13] = s[18] = s[23] = "-";

        let uuid = s.join("");
        return uuid;
    },

};
