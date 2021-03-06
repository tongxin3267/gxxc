import Main from '@/views/Main.vue';

// 不作为Main组件的子页面展示的页面单独写，如下
export const loginRouter = {
    path: '/login',
    name: 'login',
    meta: {
        title: '吉驾无忧管理平台'
    },
    component: () => import('@/views/login.vue')
};

export const page404 = {
    path: '/*',
    name: 'error-404',
    meta: {
        title: '404-页面不存在'
    },
    component: () => import('@/views/error-page/404.vue')
};

export const page403 = {
    path: '/403',
    meta: {
        title: '403-权限不足'
    },
    name: 'error-403',
    component: () => import('@//views/error-page/403.vue')
};

export const page500 = {
    path: '/500',
    meta: {
        title: '500-服务端错误'
    },
    name: 'error-500',
    component: () => import('@/views/error-page/500.vue')
};
// 作为Main组件的子页面展示但是不在左侧菜单显示的路由写在otherRouter里
export const otherRouter = {
    path: '/',
    name: 'otherRouter',
    redirect: '/home',
    meta: { title: '首页' },
    component: Main,
    children: [
        {
            meta: { title: '首页' },
            path: 'home',
            name: 'home_index',
            component: () => import('@/views/home/home.vue')
        }
    ]
};

// 作为Main组件的子页面展示并且在左侧菜单显示的路由写在appRouter里
export let appRouter = [
	{
		path: '/system',
        icon: 'android-car',
        name: 'system',
        meta: { title: '系统管理' },
        component: Main,
        children: [
			{
				path: 'system-user',
				icon: 'android-clipboard',
				name: 'system-user',
                meta: { title: '用户管理' },
				component: () => import('@/views/whdx/system/system-user')
			},
			{
				path: 'system-role',
				icon: 'android-clipboard',
				name: 'system-role',
                meta: { title: '角色管理' },
				component: () => import('@/views/whdx/system/system-role')
			},
			{
				path: 'system-framework',
				icon: 'android-clipboard',
				name: 'system-framework',
                meta: { title: '组织机构' },
				component: () => import('@/views/whdx/system/system-framework')
			},
			{
				path: 'system-dictionary',
				icon: 'android-clipboard',
				name: 'system-dictionary',
                meta: { title: '字典管理' },
				component: () => import('@/views/whdx/system/system-dictionary')
			},
			{
				path: 'system-ITSM',
				icon: 'android-clipboard',
				name: 'system-ITSM',
                meta: { title: '服务管理' },
				component: () => import('@/views/whdx/system/system-ITSM')
			},
			{
				path: 'system-function',
				icon: 'android-clipboard',
				name: 'system-function',
                meta: { title: '功能管理' },
				component: () => import('@/views/whdx/system/system-function')
			},
			{
				path: 'system-daily',
				icon: 'android-clipboard',
				name: 'system-daily',
                meta: { title: '日志管理' },
				component: () => import('@/views/whdx/system/system-daily')
			}
		]
	},
    {
        path: '/form',
        icon: 'android-checkbox',
        name: 'form',
        title: '表单编辑',
        component: Main,
        children: [
            { path: 'artical-publish', title: '文章发布', name: 'artical-publish', icon: 'compose', component: () => import('@/views/form/article-publish/article-publish.vue') },
            { path: 'workflow', title: '工作流', name: 'workflow', icon: 'arrow-swap', component: () => import('@/views/form/work-flow/work-flow.vue') }
        ]
    },
    {
        path: '/baseInfo',
        icon: 'android-car',
        name: 'baseInfo',
        meta: {title: '基础数据'},
        component: Main,
        children: [
            {
                path: 'school',
                icon: 'android-clipboard',
                name: 'school',
                meta: { title: '驾校管理' },
                component: () => import('@/views/whdx/school')
            },
            {
                path: 'examPlace',
                icon: 'android-clipboard',
                name: 'examPlace',
                meta: { title: '考场管理' },
                component: () => import('@/views/whdx/examPlace')
            },
            {
                path: 'dpdgl',
                icon: 'android-clipboard',
                name: 'dpdgl',
                meta: { title: '代陪点管理' },
                component: () => import('@/views/whdx/dpdgl')
            },
            {
                path: 'trainPlace',
                icon: 'android-clipboard',
                name: 'trainPlace',
                meta: { title: '训练场管理' },
                component: () => import('@/views/whdx/trainPlace')
            },
            {
                path: 'news',
                icon: 'android-clipboard',
                name: 'news',
                meta: { title: '新闻资讯' },
                component: () => import('@/views/whdx/hd/list.vue')
            },
            {
                path: 'create_news',
                icon: 'android-clipboard',
                name: 'create_news',
                meta: { title: '新建资讯' },
                component: () => import('@/views/whdx/hd/create.vue')
            },
		]
    },
    {
        path: '/student',
        icon: 'android-car',
        name: 'student',
        meta: {title: '学员管理'},
        component: Main,
        children: [
            {
                path: 'status-query',
                icon: 'android-clipboard',
                name: 'status-query',
                meta: { title: '综合查询' },
                component: () => import('@/views/whdx/student/status-query')
            },
            {
                path: 'student-list',
                icon: 'android-clipboard',
                name: 'student-list',
                meta: { title: '学员列表' },
                component: () => import('@/views/whdx/student/list')
            },
            {
                path: 'student-verify',
                icon: 'android-clipboard',
                name: 'student-verify',
                meta: { title: '学员认证' },
                component: () => import('@/views/whdx/student/verify')
            },
            {
                path: 'status',
                icon: 'android-clipboard',
                name: 'status',
                meta: { title: '学习进度' },
                component: () => import('@/views/whdx/student/status')
            },
		]
    },
    {
        path: '/member',
        icon: 'android-car',
        name: 'member',
        meta: {title: '会员管理'},
        component: Main,
        children: [
            {
                path: 'member-list',
                icon: 'android-clipboard',
                name: 'member-list',
                meta: { title: '学员列表' },
                component: () => import('@/views/whdx/member')
            },
		]
    },
    {
        path: '/payment',
        icon: 'android-car',
        name: 'payment',
        meta: {title: '缴费管理'},
        component: Main,
        children: [
            {
                path: 'payment-list',
                icon: 'android-clipboard',
                name: 'payment-list',
                meta: { title: '学员列表' },
                component: () => import('@/views/whdx/payment/payment-list.vue')
            },
            {
                path: 'wait-payment1',
                icon: 'android-clipboard',
                name: 'wait-payment1',
                meta: { title: '科一待缴费' },
                component: () => import('@/views/whdx/payment/wait-payment1.vue')
            },
            {
                path: 'wait-payment2',
                icon: 'android-clipboard',
                name: 'wait-payment2',
                meta: { title: '科二待缴费' },
                component: () => import('@/views/whdx/payment/wait-payment2.vue')
            },
            {
                path: 'wait-payment3',
                icon: 'android-clipboard',
                name: 'wait-payment3',
                meta: { title: '科三待缴费' },
                component: () => import('@/views/whdx/payment/wait-payment3.vue')
            },
		]
    },
    {
        path: '/chat',
        icon: 'android-car',
        name: 'chat',
        meta: {title: '聊天管理'},
        component: Main,
        children: [
            {
                path: 'chatMessage',
                icon: 'android-clipboard',
                name: 'chatMessage',
                meta: { title: '聊天内容' },
                component: () => import('@/views/whdx/chat/chatMessage.vue')
            }
        ]
    },
    {
        path: '/commissioner',
        icon: 'android-car',
        name: 'commissioner',
        meta: {title: '教练管理'},
        component: Main,
        children: [
            {
                path: 'commissioner-list',
                icon: 'android-clipboard',
                name: 'commissioner-list',
                meta: { title: '培训专员管理' },
                component: () => import('@/views/whdx/commissioner/list')
            },
            // {
            //     path: '/commissioner-asign',
            //     icon: 'android-car',
            //     name: 'commissioner-asign',
            //     meta: {title: '教练管理'},
            //     component: Main,
            //     children: [
                    {
                        path: 'commissioner-handle',
                        icon: 'android-clipboard',
                        name: 'commissioner-handle',
                        meta: { title: '受理教练' },
                        component: () => import('@/views/whdx/commissioner/handle')
                    },
                    {
                        path: 'commissioner-k1',
                        icon: 'android-clipboard',
                        name: 'commissioner-k1',
                        meta: { title: '科一教练' },
                        component: () => import('@/views/whdx/commissioner/k1')
                    },
                    {
                        path: 'commissioner-k2',
                        icon: 'android-clipboard',
                        name: 'commissioner-k2',
                        meta: { title: '科二教练' },
                        component: () => import('@/views/whdx/commissioner/k2')
                    },
                    {
                        path: 'commissioner-k3',
                        icon: 'android-clipboard',
                        name: 'commissioner-k3',
                        meta: { title: '科三教练' },
                        component: () => import('@/views/whdx/commissioner/k3')
                    },
                    {
                        path: 'commissioner-k4',
                        icon: 'android-clipboard',
                        name: 'commissioner-k4',
                        meta: { title: '四阶段' },
                        component: () => import('@/views/whdx/commissioner/k4')
                    },
                // ]
            // },

		]
    },
    {
        path: '/coach',
        icon: 'android-car',
        name: 'coach',
        meta: {title: '教练管理'},
        component: Main,
        children: [
            {
                path: 'teacher-list',
                icon: 'android-clipboard',
                name: 'teacher-list',
                meta: { title: '培训专员列表' },
                component: () => import('@/views/whdx/teacher/list')
            },
            {
                path: 'teacher-verify',
                icon: 'android-clipboard',
                name: 'teacher-verify',
                meta: { title: '教练审核' },
                component: () => import('@/views/whdx/teacher/verify')
            },
		]
    },
	{
		path: '/platform',
        icon: 'android-car',
        name: 'platform',
        meta: { title: '财务管理' },
        component: Main,
        children: [
            {
                path: 'kaoshifei',
                icon: 'android-clipboard',
                name: 'kaoshifei',
                meta: { title: '待缴考试费' },
                component: () => import('@/views/whdx/kaoshifei')
            },
            {
                path: 'huifang',
                icon: 'android-clipboard',
                name: 'huifang',
                meta: { title: '待确认回访' },
                component: () => import('@/views/whdx/huifang')
            },
            {
                path: 'dfp',
                icon: 'android-clipboard',
                name: 'dfp',
                meta: { title: '待分配专员' },
                component: () => import('@/views/whdx/dfp')
            },
            {
                path: 'dsl',
                icon: 'android-clipboard',
                name: 'dsl',
                meta: { title: '待确认受理' },
                component: () => import('@/views/whdx/dsl')
            },
            {
                path: 'dlr',
                icon: 'android-clipboard',
                name: 'dlr',
                meta: { title: '待录入成绩' },
                component: () => import('@/views/whdx/dlr')
            },
            {
                path: 'peixunfei',
                icon: 'android-clipboard',
                name: 'peixunfei',
                meta: { title: '待付培训费' },
                component: () => import('@/views/whdx/peixunfei')
            },
            {
                path: 'product',
                icon: 'android-clipboard',
                name: 'product',
                meta: { title: '费用管理' },
                component: () => import('@/views/whdx/cp')
            },
			{
				path: 'order-list',
				icon: 'android-clipboard',
				name: 'order-list',
                meta: { title: '订单列表' },
				component: () => import('@/views/whdx/order')
			},
			{
				path: 'tx',
				icon: 'android-clipboard',
				name: 'tx',
                meta: { title: '待确认分佣' },
				component: () => import('@/views/whdx/tx/index.vue')
			},
			{
				path: 'wait-tx',
				icon: 'android-clipboard',
				name: 'wait-tx',
                meta: { title: '待提现' },
				component: () => import('@/views/whdx/tx/wait-tx.vue')
			},
			{
				path: 'wait-confirm',
				icon: 'android-clipboard',
				name: 'wait-confirm',
                meta: { title: '待确认' },
				component: () => import('@/views/whdx/tx/wait-confirm.vue')
			},
			{
				path: 'tk',
				icon: 'android-clipboard',
				name: 'tk',
                meta: { title: '退款管理' },
				component: () => import('@/views/whdx/tk')
			},
		]
	},
    {
    	path: '/',
    	meta: {
    	    title: '500-服务端错误'
    	},
    	name: 'error-page-500',
    	component: Main,
        children: [
            { path: '500', title: '服务器繁忙', name: 'errorpage_500', component: () => import('@/views/error-page/500.vue') }
        ]
    }
];
// 所有上面定义的路由都要写在下面的routers里
export const routers = [
    loginRouter,
    otherRouter,
    ...appRouter,
    page500,
    page403,
    page404
];
