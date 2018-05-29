import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/home'
import Util from '../libs/apis';

Vue.use(Router)
// 路由配置
const router = new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      meta:{
        title:'学车联盟'
      },
      children:[
      ]
    },
    {
      path: '/login',
      name: 'Login',
      meta:{
        title:'登录'
      },
      component: resolve => { require(['@/views/login.vue'], resolve); }
    },
    {
      path: '/reg',
      name: 'Reg',
      meta:{
        title:'注册'
      },
      component: resolve => { require(['@/views/reg.vue'], resolve); }
    },
    {
      path: '/myCenter-info',
      name: 'myCenterInfo',
      meta:{
        title:'个人信息'
      },
      component: resolve => { require(['@/views/myCenter/info.vue'], resolve); }
    },
    // {
    //   path: '/index',
    //   name: 'index',
    //   component:()=>import('@/views/homepage')
    // },
    {
      path: '/jxlist',
      name: 'jxlist',
      component:()=>import('@/views/jxlist')
    },
    {
      path: '/kcfb',
      name: 'kcfb',
      component:()=>import('@/views/kcfb')
    },
    {
      path: '/mycenter',
      name: 'mycenter',
      component:()=>import('@/views/myCenter')
    },
  ]
});
router.beforeEach((to, from, next) => {
  Util.title(to.meta.title);
  next();
})

router.afterEach((to) => {
  //Util.openNewPage(router.app, to.name, to.params, to.query);
  window.scrollTo(0, 0);
});
export default router;
