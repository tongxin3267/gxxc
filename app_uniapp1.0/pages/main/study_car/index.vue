<template>
	<!-- <view class="">
		<button type="primary" @click="pay">支付一元</button>
		
		<view class="" v-for="(it,index) in appMess" :key="index">
			{{it}}
		</view>
	</view> -->

	<view style="background:rgba(245,246,249,1)">
		<view class="bg">
			<view class="person">
				<view class="headTip">
					安全教学{{zyMess.jlJxsl==undefined? 0:zyMess.jlJxsl }}次
				</view>
				<!-- phone(zyMess.jlJjlxrdh) -->
				<img v-if="zyMess.yhXm" :src="imgUrl+zyMess.jlImg" style="border-radius: 50%;width: 132upx;height: 132upx;" @click="goMess(zyMess)">
				<img v-else src="/static/img/qq.png" style="border-radius: 50%;width: 132upx;height: 132upx;">
				<view style="color:rgba(255,255,255,1);margin: 18upx 0;">{{zyMess.yhXm | yhXmZY}}</view>
				<uni-rate :value="zyMess.jlPf" @change='pjJl'></uni-rate>
				<view v-if="isPJ" style="border-bottom: 2upx solid #FFFFFF;margin-top: 18upx;font-size:28upx;font-weight:400;color:rgba(255,255,255,1);" @click="upPj">
					提交评价>
				</view>
			</view>
		</view>
		<view style="width:748upx;height:136upx;background:rgba(254,255,255,1);">
			<segmented-control id="tabbar" :height="136" :values="items" :stickyTop="108" :offsetLeftParam="23" :lineWidth="30" :current="current" @clickItem="onClickItem"></segmented-control>
		</view>

		<view class="btnClass">
			<view v-for="(item,index) in btnList" :key='index' style="margin: 38upx 0;text-align: center;width: 30%;" @click="gouTxt(item.url)">
				<img v-if="item.src!=''" :src="item.src" style="width: 116upx;height: 116upx;">
				<view v-else style="width: 116upx;height: 116upx;"></view>
				<view style="font-size:28upx;font-weight:400;color: #333333;">
					{{item.text}}
				</view>
			</view>
		</view>

		<view>
			<view v-if="current == 0  && Sl.lsh" style="padding-top: 1upx;margin-top: 14upx;background:#f8f8f8">
				<view class="card-control" :style="{width: screenWidth+'px'}">
					<view class="card-bg  bg-gradual-green text-white" style="box-shadow: 2px 2px 5px #888888;">
						<view class="card-content">
							<view class="padding text-xxl text-cut">
								受理回执
							</view>
							<view class="padding"> </view>
							<view>
								{{Sl.slSj}}
							</view>
						</view>
						<view v-if="onval" style="text-align: center;padding-top: 20rpx;">
						    <tki-barcode
						    ref="barcode"
							:val="val"
							:onval="true"
						    @result="barresult" />
						</view>
						<view class="card-function flex justify-around">
							<block>
								姓名 : {{Sl.yhXm}}
							</block>
						</view>
						<view class="card-function flex justify-around">
							<block>
								业务类型 : {{Sl.yhYwlx}}
							</block>
						</view>
						<view class="card-function flex justify-around">
							<block>
								准驾车型 : {{Sl.yhCx}}
							</block>
						</view>
						<view class="card-function flex justify-around">
							<block>
								驾校 : {{Sl.name}}
							</block>
						</view>
						<view class="card-function flex justify-around">
							<block>
								有效期至 :  {{Sl.SyhYxqz}}
							</block>
						</view>
					</view>
				</view>
			</view>
			<!-- 受理进度 -->
			<view v-else style="padding-top: 1upx;margin-top: 14upx;background:rgba(254,255,255,1)">
				<view class="lineC"></view>
				<view class="tip">
					<image src="/static/my/no.png" style="border-radius: 50%;left: 12upx;width: 30upx;height: 30upx;"></image>
					<text style="margin-left: 16upx;font-size:28upx;color:rgba(161,174,198,1);">
						{{current==0?'受理成功可考试':'当前科目考试费'}}
					</text>
					<view v-if="current!=0" class="toPayBtn" :style="{backgroundColor:alreayPay[current-1]?'#6CA5FF':'rgba(237,103,103,1)'}">
						{{alreayPay[current-1]?'已缴费':'未缴费'}}
					</view>
				</view>
				<view v-for="(item,index) in itemList" :key='index' style="margin:26upx 0 0 48upx;display: flex;align-items:flex-start" v-if="item.state != ''">
					<image :src="item.state==='已完成'||item.state==='合格'?'/static/img/ok.png':'/static/img/no.png'" style="top: 14upx;width: 36upx;height: 36upx;"></image>
					<view class="item">
						<view style="padding:0 20upx;margin-top: 14upx;display: flex;justify-content: space-between">
							<text class="itemText">{{item.name}}</text>
							<text class="itemFinish" :style="{color:item.state==='已完成'?'':(item.state==='合格'?'#3E8715':'rgba(161,174,198,1)')}">{{item.state}}</text>
						</view>
						<view class="message">
							<text>{{item.tip}}</text>
							<text>{{item.date}}</text>
						</view>
					</view>
				</view>
			</view>
		</view>

	</view>
</template>

<script>
	import uniRate from "@/components/uni-rate/uni-rate.vue"
	import segmentedControl from "@/components/seg/segmented-control.vue";
	import vTab from "@/components/v-tab/v-tab.vue"
	import mixin from '@/common/mixin.js'
	import tkiBarcode from "@/components/tki-barcode/tki-barcode.vue"
	import {
		mapState,
		mapMutations
	} from 'vuex'
	export default {
		name: "study",
		components: {
			uniRate,
			segmentedControl,
			vTab,
			tkiBarcode
		},
		mixins:[mixin],
		data() {
			return {
				Sl:{},
				val:'',
				onval:false,
				screenWidth: this.screenWidth,
				imgUrl:'http://www.520xclm.com:8001/',
				appMess: [],
                usermess:{},
				isPJ:false,	//是否评价，控制显示星星
				star:0,
				data: [{name:'受理进度'}, {name:'科一'},{name: '科二'}, {name:'科三'}, {name:'科四'}],
				items: ['受理', '科一', '科二', '科三', '科四'],
				current: 0,
				btnList: [],
				btnListAll: [
					[{
							text: '报名条件',
							src: '/static/img/studybtn/bmtj.png',
							url:'http://m.jxedt.com/info_1_2/'
						},
						{
							text: '学车费用',
							src: '/static/img/studybtn/xcfy.png',
							url:'http://m.jxedt.com/info_1_4/'
						},
						{
							text: '学车流程',
							src: '/static/img/studybtn/xclc.png',
							url:'http://m.jxedt.com/info_1_8/'
						},
					],
					[{
							text: '顺序练习',
							src: '/static/img/studybtn/sxlx.png',
							url:'http://m.jxedt.com/mnks/ckm1/sxlx/'
						},
						{
							text: '章节练习',
							src: '/static/img/studybtn/zjlx.png',
							url:'http://m.jxedt.com/mnks/ckm1/zjlx/'
						},
						{
							text: '专项练习',
							src: '/static/img/studybtn/zxlx.png',
							url:'http://m.jxedt.com/mnks/ckm1/zxlx/'
						},
					],
					[{
							text: '合格标准',
							src: '/static/img/studybtn/hgbz.png',
							url:'http://m.jxedt.com/km2_82_212'
						},
						{
							text: '侧方停车',
							src: '/static/img/studybtn/cftc.png',
							url:'http://m.jxedt.com/km2_82_603/'
						},
						{
							text: '曲线行驶',
							src: '/static/img/studybtn/qxxs.png',
							url:'http://m.jxedt.com/km2_82_604/'
						},
						{
							text: '直角转弯',
							src: '/static/img/studybtn/zjzw.png',
							url:'http://m.jxedt.com/km2_82_605/'
						},
						{
							text: '上坡起步',
							src: '/static/img/studybtn/spqb.png',
							url:'http://m.jxedt.com/km2_82_602/'
						},
						{
							text: '倒车入库',
							src: '/static/img/studybtn/dcrk.png',
							url:'http://m.jxedt.com/km2_82_606'
						},
					],
					[{
							text: '评判标准',
							src: '/static/img/studybtn/ppbz.png',
							url:'http://m.jxedt.com/km3_607_608/'
						},
						{
							text: '语言指令',
							src: '/static/img/studybtn/yyzl.png',
							url:'http://m.jxedt.com/km3/yyzl/'
						},
						{
							text: '灯光操作',
							src: '/static/img/studybtn/dgcz.png',
							url:'http://m.jxedt.com/km3/dgcz/'
						},
						{
							text: '考试口诀',
							src: '/static/img/studybtn/kskj.png',
							url:'http://m.jxedt.com/km3_607_627/'
						},
						{
							text: '',
							src: ''
						},
						{
							text: '',
							src: ''
						},
					],
					[{
							text: '顺序练习',
							src: '/static/img/studybtn/sxlx.png',
							url:'http://m.jxedt.com/mnks/ckm1/sxlx/'
						},
						{
							text: '章节练习',
							src: '/static/img/studybtn/zjlx.png',
							url:'http://m.jxedt.com/mnks/ckm1/zjlx/'
						},
						{
							text: '专项练习',
							src: '/static/img/studybtn/zxlx.png',
							url:'http://m.jxedt.com/mnks/ckm1/zxlx/'
						}
					]
				],
				alreayPay: [false, false, false, false], //科一~四缴费情况
				itemList: [], //装item的list，以下的list数据在对接接口时可直接写成一个数组
				itemListAll: [
					[{
							name: '医院体检',
							state: '待完成',
							tip: '',
							date: ''
						},
						{
							name: '入网面签',
							state: '待完成',
							tip: '',
							date: ''
						},
						{
							name: '档案采集',
							state: '待完成',
							tip: '',
							date: ''
						},
						{
							name: '受理成功',
							state: '待完成',
							tip: '',
							date: ''
						}
					],
					[{
						name: '',
						state: '',
						tip: '',
						date: '',
					}],
					[{
						name: '',
						state: '',
						tip: '',
						date: '',
					}],
					[{
						name: '',
						state: '',
						tip: '',
						date: '',
					}],
					[{
						name: '',
						state: '',
						tip: '',
						date: '',
					}]
				],
				safeTeach:'340',
				zyMess:{//专员信息
					yhXm:"",
					jlJxsl:0
				  },
				  zyMwssList:[//专员信息列表
					{
					  yhXm:""
					}
				  ],
				showStar:false,
				payInfo:{},//缴费信息
				examInfo:[],//考试信息
				handleStatus:[],
				yhYxqz:'',
				yhYwlx:''
			}
		},
		onLaunch() {
			console.log('onLaunch')
		},
		onShow() {
			this.usermess = uni.getStorageSync('token')
			this.getSL()
			console.log('this.curr',this.current);
			var a = uni.getStorageSync('usermess').yhDqzt
			
			
			this.getHandleStatus()// 获取受理状态信息
			this.getPayInfo()// 缴费信息
			this.getExamInfo()//考试信息
			this.getZYmess()//获取专员信息
			setTimeout(()=>{
				this.onClickItem(parseInt(a))
			},1000)
			this.onval = true
			this.btnList=Object.assign(this.btnListAll[0])
			this.itemList=Object.assign(this.itemListAll[0])
		},
		onLoad() {
			
		},
		methods: {
			...mapMutations(['setZyMess']),
			barresult(){},
			getSL(){
				this.$http.get('/app/kssl/query',{yhId:this.usermess.userId,slType:'4'}).then((res)=>{
					if(res.result){
						this.Sl = res.result[0]
						this.val = this.Sl.lsh
						this.yhYxqz = this.usermess.yhYxqz
						this.yhYwlx = this.usermess.yhYwlx
						this.$nextTick(() => {
							this.onval = true
						})
						console.log(this.val,'valvalval');
					}else{
						
					}
				})
			},
			goMess(mess){
				console.log('123',mess)
				this.setZyMess(mess)
				uni.navigateTo({
					url: '/pages/main/study_car/mess/index',
				});
			},
			phone(id) {
				uni.makePhoneCall({
					phoneNumber: id //仅为示例
				});
			},
			pjJl(val){
				console.log(val,'val');
				this.isPJ = true
				this.star = val.value
			},
			upPj(){
				this.$http.post(this.apis.PF_TEACHER,{slType:this.current,yhFz:this.star,jlid:this.zyMess.yhId}).then((res)=>{
					if(res.code == 200){
						uni.showToast({
							title:'评价成功!'
						})
					}else{
						uni.showToast({
							title:res.message
						})
					}
					this.isPJ = false
				})
			},
			getZYmess(){//获取专员信息
			  var v = this
			  this.$http.post(this.apis.getZYmess,{}).then((res)=>{
				  console.log('zhuanyuan',res);
				  if(res.code==200 && res.result){
					  res.result.forEach((item,index)=>{
						if(item.jlPf){
						  item.jlPf = parseInt(item.jlPf)
						}
					  })
					  v.zyMwssList = res.result
					  v.zyMess = v.zyMwssList[v.current]
					  console.log(v.zyMess,'zyMess');
				  }
			  })
			},
			 getHandleStatus(){// 获取受理状态信息
			  this.$http.post(this.apis.getHandleStatus,{yhId: this.usermess.userId}).then((res)=>{
				  console.log('获取受理状态信息-',res)
				if (res.code == 200 && res.result){
				  this.handleStatus = res.result;
				  let a = this.itemListAll[0]
				  for(var key in res.result){
					  a[key-1].tip = res.result[key].name
					  a[key-1].date = res.result[key].slSj
					  a[key-1].state ='已完成'
					  // name: '医院体检',
					  // state: '已完成',
					  // tip: '湖北省中医院',
					  // date: '2019年7月30日'
				  }
				  // this.thisIndex = parseInt(res.message);
				}
			  })
			}, 
			getPayInfo() {// 缴费信息
			  this.$http.post(this.apis.getPayInfo,{yhId: this.usermess.userId}).then((res)=>{
				if (res.code == 200 && res.result) {
				  console.log('缴费信息',res);
				  this.payInfo = res.result;
				  if(this.payInfo&&this.payInfo!=''){
					  for (var key in res.result) {
						  if(res.result[key] == '已缴')
					  	 this.alreayPay[key-1] = true
					  }
				  }
				}
			  })
			},
			getExamInfo() {// 考试信息
			  let v = this;
			  this.$http.get(this.apis.getExamInfo,{yhId: this.usermess.userId}).then((res)=>{
				  console.log('考试信息',res);
				  if (res.code == 200 && res.result) {
					this.examInfo = res.result;
					let a = this.itemListAll;
					
					for(var key in res.result){
					    let b = {name: '',
					    		 state: '',
					    		 tip: '',
					    		date: '',}
								let k = res.result[key].kmCode
								
						console.log(res.result[key].kmCode+'123')
						a[k][0].name = res.result[key].schoolName
						a[k][0].date = res.result[key].ykSj
						if (res.result[key].cj1 == ""){
							a[k][0].state= "未考试"
						}else{
						if(res.result[key].kmCode!='2'){
							if(res.result[key].cj1>=90){
								a[k][0].state = '合格'
							}else{
								a[k][0].state = '不合格'
								b.name = res.result[key].schoolName
								b.date = res.result[key].ykSj
								b.tip = '第二次考试'
								if(res.result[key].cj2>=90){
									b.state = '合格'
								}else{
									b.state = '不合格'
								}
								a[k][1] = b
							}
							
						}else{
							if(res.result[key].cj1>=80){
								a[k][0].state = '合格'
							}else{
								a[k][0].state = '不合格'
								b.name = res.result[key].schoolName
								b.date = res.result[key].ykSj
								b.tip = '第二次考试'
								if(res.result[key].cj2>=80){
									b.state = '合格'
								}else{
									b.state = '不合格'
								}
								a[k][1] = b
							}
						}
						a[k][0].tip = '第一次考试'
						}
						
						
					}
					this.itemListAll = a 
					console.log(this.itemListAll,'this.itemListAll');
				  }
			  })
			},
			gouTxt(url){
			  uni.navigateTo({
			  	url:'wbweb/wbweb?url='+url
			  })
			},
			pay() {
				// 获取 支付方式
				uni.getProvider({
					service: 'payment',
					success: (res) => {
						this.appMess = res.provider
						res.provider
						this.payMoney(res.provider[1])
						console.log('信息', res.provider)
					}
				});
			},
			payMoney(provider) {
				uni.requestPayment({
					provider: provider
				})
			},


			onClickItem(index) {
				console.log('index',index)
				console.log(this.current,'current')
				this.zyMess = this.zyMwssList[index] //板块切换 专员信息 随之切换
				if(this.zyMess.yhXm == ''){
					this.isPJ = true
				}else{
					this.isPJ = false
				}
				if (this.current !== index) {					
						this.current = index;
						this.btnList = Object.assign(this.btnListAll[index])
						this.itemList = Object.assign(this.itemListAll[index])
				}else{
					this.btnList = Object.assign(this.btnListAll[index])
					this.itemList = Object.assign(this.itemListAll[index])
				}
			},
			
			select(index){
				if (this.current !== index) {					
					this.current = index;
					this.btnList = Object.assign(this.btnListAll[index])
					this.itemList = Object.assign(this.itemListAll[index])
				}
			}
		}
	}
</script>

<style>
	.bg {
		width: 750upx;
		height: 350upx;
		background: linear-gradient(132deg, rgba(59, 147, 253, 1) 0%, rgba(60, 128, 253, 1) 41%, rgba(55, 84, 252, 1) 100%);
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.person {
		text-align: center;
		width: 100%;
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	
	.headTip{
		width:172upx;
		height:40upx;
		background:rgba(220,166,36,1);
		border-radius:20upx;
		border:2upx solid rgba(255,255,255,1);
		position: absolute;
		margin: 98upx auto 0;
		font-size:20upx;
		font-weight:400;
		color:rgba(255,255,255,1);
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.lineC{
		width: 4upx;
		height: 685upx;
		background-color: #E8ECF4;
		margin-left: 64upx;
		position: absolute;
	}
	
	.tip{
		width:484upx;
		height:60upx;
		background:#E8ECF4;
		border-radius:30upx;
		margin: 32upx 0 0 38upx;
		line-height: 60upx;
	}
	
	.item{
		width:362upx;
		height:146upx;
		background:rgba(248,250,252,1);
		box-shadow:0px 4upx 8upx 0upx rgba(211,224,255,0.5);
		border-radius:16upx;
		margin-left: 14upx;
		display: inline-block;
	}
	
	.itemText{
		font-size:28upx;
		font-weight:400;
		color:rgba(51,51,51,1);
	}
	
	.itemFinish{
		font-size:10px;
		font-weight:400;
		color:rgba(108,165,255,1);
	}
	
	.message{
		/* width:362upx; */
		height:84upx;
		background:rgba(255,255,255,1);
		box-shadow:0 4upx 8upx 0 rgba(221,231,255,0.5);
		border-radius:0 0 16upx 16upx;
		margin-top: 8upx;
		flex-direction: column;
		font-size:20upx;
		font-weight:400;
		color:rgba(102,102,102,1);
		display: flex;
		justify-content: center;
		padding:0 20upx;
	}
		
		.btnClass{
			display: flex;
			flex-wrap:wrap;
			align-items: flex-start;
			justify-content: space-around;
			margin-top: 14upx;
			width:750upx;
			background:rgba(254,255,255,1);
		}
		
		.toPayBtn{
			width:136upx;
			height:48upx;
			border-radius:24upx;
			float: right;
			margin: 7upx 8upx 0 0;
			font-size:24upx;
			font-family:PingFangSC-Regular;
			font-weight:400;
			color:rgba(255,255,255,1);
			display: flex;
			justify-content: center;
			align-items: center;
		}
		
		page {
			min-height: 0;
			display: flex;
		}
		
		.uni-view{
			line-height: none;
		}
		.card-function {
		
			padding: 30upx 30upx 0 30upx;
		}
		
		.card-function .item {}
		
		.card-content {
			justify-content: space-between;
			display: flex;
			border-bottom: 1px solid #dbdbdb;
			border-top: 0px;
			border-left: 0px;
			border-right: 0px;
		}
		
		.card-title {
			font-size: 70upx;
			margin-top: 20upx;
			margin-left: 20upx;
		}
		
		.card-control {
			padding: 20upx;
		}
		
		.card-id {
			padding: 10upx;
		}
		
		.card-bg {
		
			padding: 10upx;
			border-radius: 20upx 20upx;
			min-height: 300upx;
			background-color:#FFFFFF;
		}
</style>
