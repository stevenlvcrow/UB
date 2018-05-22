
let routes = [
    {
        path: '/login',
        component: (resolve) => require(['./views/login.vue'], resolve),
        name: '',
        hidden: true
    },
    {
        path: '/',
        component: (resolve) => require(['./views/main.vue'], resolve),
        name: '经纪人协会',
        iconCls: 'el-icon-message',//图标样式class
        children: [

        ]
    }
];

export default routes;