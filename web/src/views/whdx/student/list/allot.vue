<style lang="less">
	@import '../../../../styles/common.less';
	.docImg{
		width: 100%;
		padding: 10px;
	}
</style>
<style type="text/css">

</style>
<template>
	<div>
		<Modal v-model="showModal" width='900' :closable='false'
			:mask-closable="false" :title="operate+''"
			   ok-text="关闭"
			   @on-cancel="close"
			   @on-ok="close"

		>
			<div style="overflow: auto;height: 600px;">
				<Tabs>
					<Tab-pane v-if="state == 0" label="受理教练" icon="ios-download-outline">
						<allot1 :item="item" :parent="v" :row="row"></allot1>
					</Tab-pane>
					<Tab-pane v-if="state == 1" label="科一教练" icon="ios-upload-outline">
						<allot2 :item="item" :parent="v" :row="row"></allot2>
					</Tab-pane>
					<Tab-pane v-if="state == 2" label="科二科三教练" icon="ios-upload-outline">
						<allot5 :item="item" :parent="v " :row="row"></allot5>
					</Tab-pane>
					<div v-if="state==3 ||state==4" style="font-size: 24px;font-weight: 600;text-align: center">
						当前学员已分配,若修改请点击修改教练
					</div>
<!--					<Tab-pane v-if="state == 3" label="" icon="ios-upload-outline">-->
<!--						-->
<!--					</Tab-pane>-->
				</Tabs>
			</div>
		</Modal>
	</div>
</template>

<script>
    import allot1 from './allot1'
    import allot2 from './allot2'
    import allot5 from './allot5'
    import allot4 from './allot4'
	export default {
		name: 'byxxForm',
		components:{allot1,allot2,allot5,allot4},
		data() {
			return {
			    v:this,
                operate:'分配',
				showModal: true,
                apiRoot:this.apis.student,
				readonly: false,
                form: {
					jlTypeLike: '',
					jlZt: 0,
                    total: 0,
                    pageNum: 1,
                    pageSize: 8,
                },
				choosedData:[],
                tableColumns: [
                    {title: "#",  type: 'index'},
                    {title: '姓名',key:'yhXm',searchKey:'yhXmLike'},
                    {title: '电话',key:'yhZh',searchKey:'yhZhLike'},
                    {
                        title: '操作',
                        key: 'action',
                        width: 120,
                        render: (h, params) => {
                            return h('div', [
                                this.util.buildButton(this,h,'success','ribbon-b','分配',()=>{
                                    this.confirm(params.row.id);
                                }),
                            ]);
                        }
                    }
                ],
                pageData: [],
                ruleInline:{
				},
                item:{

                },
				state:0,
				row:{},
				dpdlst:[]
			}
		},
		created(){
			this.dpdlst = this.$parent.dpdlst
            console.log('created');
		    this.choosedData = this.$parent.choosedData
			this.row = this.$parent.row
			console.log(this.row,'1232');
			this.getState();
			this.util.initTable(this)
		},
		mounted(){
            console.log('mounted');
        },
		methods: {
		    getState(){
		        this.state=parseInt( this.$parent.row.yhXyFpzyType);
				console.log(this.state);
				if(this.state == '0'){
					this.form.jlTypeLike = 'slzy'
				}else if(this.state == '1'){
					this.form.jlTypeLike = 'k1'
				}else {
					this.form.jlTypeLike = 'k2'
				}
			},
			close(){
		    	this.$parent.componentName = ''
			}
		}
	}
</script>

<style>

</style>
