<template>
	<view style="width: 100%;">
		<view class="inputMess">
			<input class="uni-input input" style="font-size: 16px;height: 40px;margin: 10px 0;" v-model="form.yhkXm" focus placeholder="请输入您的真实姓名" />
			<input class="uni-input input" style="font-size: 16px;height: 40px;margin: 10px 0;" v-model="form.yhkSsyh" focus placeholder="银行卡所属银行" />
			<input class="uni-input input" style="font-size: 16px;height: 40px;margin: 10px 0;" v-model="form.dn"  focus placeholder="请输入银行卡绑定的手机号码" />
			<input class="uni-input input" style="font-size: 16px;height: 40px;margin: 10px 0;" v-model="form.yhkKh" focus placeholder="请输入银行卡卡号" />

		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				form: {
					yhkXm: '',
					dn: '',
					yhkKh: '',
					yhkSsyh: ''
				}
			}
		},
		methods: {
			saveBankCard() {
				uni.showLoading({
					title: '绑定中'
				})
				this.$http.post(this.apis.ADDBANK, this.form).then(res => {
					if (res.code == 200) {
						uni.hideLoading()
						
							uni.navigateTo({
								url: '../chooseBank/chooseBank',
							});
						
						
					} else {
						uni.showToast({
							title: '绑定失败',
							duration: 2000,
							icon:"none"
						});
					}
				})
			}
		},
		onNavigationBarButtonTap() { //点击了添加按钮,验证银行卡
			if (this.form.yhkXm == '' || this.form.yhkKh == '' || this.form.dn == '') {
				uni.showToast({
					title: '填写不完整',
					duration: 2000,
					icon: 'none'
				});
				return
			}

			// var v = this
			// this.$http.post(this.apis.YZYHK, this.form).then(res => {
			// 	if (res.code == 200) {
			uni.showToast({
				title: '验证成功',
				duration: 1500
			});
			setTimeout(() => {
				this.saveBankCard()
			}, 2000);
			// } else {
			// uni.showToast({
			// 	title: res.message,
			// 	duration: 2000
			// });
			// 	}
			// })

		}
	}
</script>

<style>
	.inputMess {
		width: 100%;
		height: 276upx;
		background: rgba(255, 255, 255, 1);
	}

	.input {
		height: 136upx;
		width: 678upx;
		border-bottom: 2upx solid #DFE7EE;
		margin: 0 auto;
	}
</style>
