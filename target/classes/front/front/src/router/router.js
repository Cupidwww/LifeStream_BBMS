import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import gongzuorenyuanList from '../pages/gongzuorenyuan/list'
import gongzuorenyuanDetail from '../pages/gongzuorenyuan/detail'
import gongzuorenyuanAdd from '../pages/gongzuorenyuan/add'
import xianxuerenyuanList from '../pages/xianxuerenyuan/list'
import xianxuerenyuanDetail from '../pages/xianxuerenyuan/detail'
import xianxuerenyuanAdd from '../pages/xianxuerenyuan/add'
import caixuedengjiList from '../pages/caixuedengji/list'
import caixuedengjiDetail from '../pages/caixuedengji/detail'
import caixuedengjiAdd from '../pages/caixuedengji/add'
import xueyejianceList from '../pages/xueyejiance/list'
import xueyejianceDetail from '../pages/xueyejiance/detail'
import xueyejianceAdd from '../pages/xueyejiance/add'
import tijianxinxiList from '../pages/tijianxinxi/list'
import tijianxinxiDetail from '../pages/tijianxinxi/detail'
import tijianxinxiAdd from '../pages/tijianxinxi/add'
import xuekuxinxiList from '../pages/xuekuxinxi/list'
import xuekuxinxiDetail from '../pages/xuekuxinxi/detail'
import xuekuxinxiAdd from '../pages/xuekuxinxi/add'
import xueyerukuList from '../pages/xueyeruku/list'
import xueyerukuDetail from '../pages/xueyeruku/detail'
import xueyerukuAdd from '../pages/xueyeruku/add'
import xueyechukuList from '../pages/xueyechuku/list'
import xueyechukuDetail from '../pages/xueyechuku/detail'
import xueyechukuAdd from '../pages/xueyechuku/add'
import chengfenluruList from '../pages/chengfenluru/list'
import chengfenluruDetail from '../pages/chengfenluru/detail'
import chengfenluruAdd from '../pages/chengfenluru/add'
import yingyangbutieList from '../pages/yingyangbutie/list'
import yingyangbutieDetail from '../pages/yingyangbutie/detail'
import yingyangbutieAdd from '../pages/yingyangbutie/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'gongzuorenyuan',
					component: gongzuorenyuanList
				},
				{
					path: 'gongzuorenyuanDetail',
					component: gongzuorenyuanDetail
				},
				{
					path: 'gongzuorenyuanAdd',
					component: gongzuorenyuanAdd
				},
				{
					path: 'xianxuerenyuan',
					component: xianxuerenyuanList
				},
				{
					path: 'xianxuerenyuanDetail',
					component: xianxuerenyuanDetail
				},
				{
					path: 'xianxuerenyuanAdd',
					component: xianxuerenyuanAdd
				},
				{
					path: 'caixuedengji',
					component: caixuedengjiList
				},
				{
					path: 'caixuedengjiDetail',
					component: caixuedengjiDetail
				},
				{
					path: 'caixuedengjiAdd',
					component: caixuedengjiAdd
				},
				{
					path: 'xueyejiance',
					component: xueyejianceList
				},
				{
					path: 'xueyejianceDetail',
					component: xueyejianceDetail
				},
				{
					path: 'xueyejianceAdd',
					component: xueyejianceAdd
				},
				{
					path: 'tijianxinxi',
					component: tijianxinxiList
				},
				{
					path: 'tijianxinxiDetail',
					component: tijianxinxiDetail
				},
				{
					path: 'tijianxinxiAdd',
					component: tijianxinxiAdd
				},
				{
					path: 'xuekuxinxi',
					component: xuekuxinxiList
				},
				{
					path: 'xuekuxinxiDetail',
					component: xuekuxinxiDetail
				},
				{
					path: 'xuekuxinxiAdd',
					component: xuekuxinxiAdd
				},
				{
					path: 'xueyeruku',
					component: xueyerukuList
				},
				{
					path: 'xueyerukuDetail',
					component: xueyerukuDetail
				},
				{
					path: 'xueyerukuAdd',
					component: xueyerukuAdd
				},
				{
					path: 'xueyechuku',
					component: xueyechukuList
				},
				{
					path: 'xueyechukuDetail',
					component: xueyechukuDetail
				},
				{
					path: 'xueyechukuAdd',
					component: xueyechukuAdd
				},
				{
					path: 'chengfenluru',
					component: chengfenluruList
				},
				{
					path: 'chengfenluruDetail',
					component: chengfenluruDetail
				},
				{
					path: 'chengfenluruAdd',
					component: chengfenluruAdd
				},
				{
					path: 'yingyangbutie',
					component: yingyangbutieList
				},
				{
					path: 'yingyangbutieDetail',
					component: yingyangbutieDetail
				},
				{
					path: 'yingyangbutieAdd',
					component: yingyangbutieAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
