
let routes = [
    {
        path: '/login',
        component: (resolve) => require(['./views/login.vue'], resolve),
        name: '',
        hidden: true
    },

    {
        path: '/layout',
        component: (resolve) => require(['./views/layout.vue'], resolve),
        name: '系统设置',
        iconCls: 'el-icon-menu',//图标样式class
        children: [
            {path: '/statisindex', component: (resolve) => require(['./views/syset/view.vue'], resolve), name: '设置'},
            {path: '/main', component: (resolve) => require(['./views/main.vue'], resolve), name: '主页',hidden: true},
        ]
    },
    {
        path: '*',
        hidden: true,
        redirect: {path: '/login'}
    }
];

export default routes;