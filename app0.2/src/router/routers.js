module.exports = [
  {
    path: '/index',
    name: 'index',
    meta:{
      title:'学车联盟'
    },
    component:()=>import('@/views/index'),
  },
  {
    path: '/Login',
    name: 'Login',
    component:()=>import('@/views/login'),
    meta:{
      title:'登录'
    }
  },
  {
    path: '/reg',
    name: 'reg',
    component:()=>import('@/views/reg'),
    meta:{
      title:'注册'
    }
  },
  {
    path: '/forget',
    name: 'forget',
    component:()=>import('@/views/forgetPassword'),
    meta:{
      title:'密码找回'
    }
  },
  {
    path: '/Home',
    name: 'Home',
    component:()=>import('@/views/home'),
    meta:{
      title:'学车联盟'
    }
  },
  {
    path: '/',
    name:'indexName',
    component:()=>import('@/views/home'),
    meta:{
      title:'学车联盟'
    }
  },
  {
    path: '/coachList',
    name: 'coachList',
    component:()=>import('@/views/main/coach/list.vue'),
    meta:{
      title:'培训专员列表'
    }
  },
  {
    path: '/myCenter-qrcode',
    name: 'myCenterQrcode',
    meta:{
      title:'我的二维码'
    },
    component:()=>import('@/views/main/center/page/qrcode.vue'),
  },
  {
    path: '/myCenter-info',
    name: 'myCenterInfo',
    meta:{
      title:'个人信息'
    },
    component:()=>import('@/views/main/center/page/info.vue'),
  },
  {
    path: '/bill',
    name: 'bill',
    meta:{
      title:'账单'
    },
    component:()=>import('@/views/main/bill')
  },
  {
    path:'/myTeam',name:'myteam',
    meta:{title:'我的团队'},
    component:()=>import('@/views/main/myTeam')
  },
  {
    path:'/smrz',name:'smrz',
    meta:{title:'实名认证'},
    component:()=>import('@/views/main/smrz')
  },{
    path:'/myStudent',name:'myStudent',
    meta:{title:'我的学员'},
    component:()=>import('@/views/main/student')
  },{
    path:'/stuMess',name:'stuMess',
    meta:{title:'学员信息'},
    component:()=>import('@/views/main/stuMess')
  },{
    path:'/coach',name:'coach',
    meta:{title:'教练信息'},
    component:()=>import('@/views/main/mess/coach')
  },{
    path: '/pay/payIndex',
    name: 'pay',
    meta:{
      title:'缴费'
    },
    component:()=>import('@/views/main/pay')
  },{
    path: '/tx',
    name: 'tx',
    meta:{
      title:'提现'
    },
    component:()=>import('@/views/main/TX')
  },{
    path: '/xlc',
    name: 'xlc',
    meta:{
      title:'训练场'
    },
    component:()=>import('@/views/main/homePage/page/xlcMess')
  },{
    path:'/productList',
    name:'productList',
    meta:{
      title:'产品列表'
    },
    component:()=>import('@/views/main/productList')
  },
  {
    path:'/process',
    name:'process',
    meta:{
      title:'学员进程'
    },
    component:()=>import('@/views/main/infor/page/process')
  },
  {
    path:'/payMoneyOk',
    name:'payMoneyOk',
    meta:{
      title:'缴费成功'
    },
    component:()=>import('@/views/main/payMoneyOk')
  }
]
