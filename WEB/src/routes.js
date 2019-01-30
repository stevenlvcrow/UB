
let routes = [
    {
        path: '/index',
        component: (resolve) => require(['./views/index.vue'], resolve),
        name: '',
        hidden: true
    },
    {
        path: '/login',
        component: (resolve) => require(['./views/login.vue'], resolve),
        name: '',
        hidden: true
    },
    {
        path: '/demo',
        component: (resolve) => require(['./views/demo.vue'], resolve),
        name: '',
        hidden: false
    },
    {
        path: '*',
        hidden: true,
        redirect: {path: '/index'}
    }
];

export default routes;