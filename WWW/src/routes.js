import Login from './views/Login.vue'
import NotFound from './views/404.vue'
import Home from './views/Home.vue'

let routes = [
    {
        path: '/login',
        component: Login,
        name: '',
        hidden: true
    },
    {
        path: '/404',
        component: NotFound,
        name: '',
        hidden: true
    },
    {
        path: '/',
        component: Home,
        name: '商户管理',
        iconCls: 'el-icon-plus',//图标样式class
        children: [
            {
                path: '/main',
                component: (resolve) => require(['./views/test/test.vue'], resolve),
                name: '会员管理'
            },
        ]
    },

    {
        path: '*',
        hidden: true,
        redirect: {path: '/404'}
    }
];

export default routes;