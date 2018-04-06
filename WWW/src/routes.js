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
    // {
    //     path: '/',
    //     component: Home,
    //     name: '银商优选',
    //     iconCls: 'el-icon-plus',//图标样式class
    //     children: [
    //         {path: '/statisnotify', component: (resolve) => require(['./views/qmcs/statisnotify/orderstatis.vue'], resolve), name: '统计与通知'},
    //
    //     ]
    // },

    {
        path: '*',
        hidden: true,
        redirect: {path: '/404'}
    },
    {
        path: '/404',
        component: NotFound,
        name: '',
        hidden: true
    },
];

export default routes;