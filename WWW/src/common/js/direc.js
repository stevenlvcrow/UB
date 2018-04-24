import Vue from 'vue'

Vue.directive('demoDirective', function (el, binding, vnode) {
    console.log(binding.value.color);
    console.log(binding.value.text);
});

Vue.directive('permission', {
    bind: function (el, binding, vnode) {
        let permiss = {
            getAuthority: function (el) {
                let user = JSON.parse(sessionStorage.getItem('user'));
                if (!user) {
                    return []
                }
                let authority = user.authority;
                if (authority.length === 0) {
                    return []
                }
                return user.authority;
            },
            isShow: function (el, boolen) {
                el.style.display = boolen ? '' : 'none'
            },
            begin:function (el, binding) {
                let authority = permiss.getAuthority(el);
                // 得到所属页面路径
                let pageObj = authority.filter(item=>{
                    return item.page ===binding.value.page
                });
                let buttons = pageObj[0].buttons;
                // index of = -1 没权限 index of >=0 有权限
                permiss.isShow(el,!(buttons.indexOf(binding.value.button)===-1));
            }
        };


        permiss.begin(el, binding);
    }

});


export {Vue}