<style lang="less">
</style>
<template>
	<div class="boxbackborder">
		<Row style="padding-bottom: 16px;">
				<search-items :parent="v" :label-with="100"></search-items>
				<Button type="info" @click="exportData">
					<Icon type="ios-download-outline"></Icon>
				</Button>
		</Row>
		<Row style="position: relative;">
			<Table :height="tableHeight" :columns="tableColumns" :data="pageData" @on-selection-change="selectionChange"></Table>
		</Row>
		<Row class="margin-top-10 pageSty">
			<pager :parent="v"></pager>
		</Row>
		<component :is="componentName"></component>
	</div>
</template>

<script>
    import formData from './formData.vue'
    import sublist from './sublist.vue'

    export default {
        name: 'byxxTable',
        components: {formData,sublist},
        data() {
            return {
                v:this,
                SpinShow: true,
                apiRoot:this.apis.student,
                deleteUrl:this.apis.removeUserInfo,
                tableHeight: 220,
                componentName: '',
                choosedItem: null,
                dateRange:'',
                tableColumns: [
                    {title: "",  type: 'index',width:60},
                    {title: '姓名',key:'yhXm',searchKey:'yhXmLike'},
                    {title: '账号',key:'yhZh',searchKey:'yhZhLike'},
                    {title: '缴费状态',key:'ddSfjx',dict:'jfzt',searchType:'dict'},
                    {title: '认证状态',key:'yhZt',dict:'ZDCLK0043',searchType:'dict'},
                    {title: '锁定',key:'yhSfsd',
                        render:(h,p)=>{
                            return this.util.buildSwitch(h,p.row.yhSfsd && p.row.yhSfsd == '1' ? true:false,(value)=>{
                                let rzt = value ? '1':'0'
                                let v = this;
                                this.$http.post(this.apis.student.updateSfsd,{'id':p.row.id,'yhSfsd':rzt}).then((res) =>{
                                    if(res.code==200){
                                        this.$Message.success(res.message);
                                    }else{
                                        this.$Message.error(res.message);
                                    }
                                    v.util.getPageData(v)
                                })
                            })
                        }
                    },
                    {
                        title: '操作',
                        key: 'action',
                        width: 120,
                        render: (h, params) => {
                            return h('div', [
                                this.util.buildButton(this,h,'success','md-card','详情',()=>{
                                    this.choosedItem = params.row;
                                    this.componentName = 'formData'
                                }),
                                this.util.buildButton(this,h,'info','md-git-network','查看下线',()=>{
                                    this.choosedItem = params.row;
                                    this.componentName = 'sublist'
                                }),
                                this.util.buildButton(this,h,'info','md-close','删除',()=>{
                                    swal({
                                        title: "是否删除数据?",
                                        text: "",
                                        icon: "warning",
                                        buttons:['取消','确认'],
                                    }).then((willDelete) => {
                                        if (willDelete) {
                                            this.deleteUser(params.row.id);
                                        }
                                    });
								}),
                            ]);
                        }
                    }
                ],
                pageData: [],
				choosedData:[],
                form: {
                    yhLx:"3",
                    byBysjInRange:'',
                    total: 0,
                    pageNum: 1,
                    pageSize: 8,
                },
            }
        },
        created() {
            this.util.initTable(this)
        },
        methods: {
            selectionChange(e){
				this.choosedData = e;
			},
			deleteUser(id){
				this.$http.post(this.apis.removeUserInfo,{userId:id}).then((res)=>{
				    if (res.code == 200){
				        this.$Message.success(res.message);
				        this.util.getPageData(this);
					}else{
				        this.$Message.error(res.message);
					}
				})
			},
            allot(){
                console.log('allot');
                if (this.choosedData.length == 0){
                    this.$Message.error("请选择学员")
					return;
				}
				for (let r of this.choosedData){
                    if (r.yhIxySffp == '1'){
                        this.$Message.error("请选择未分配的学员")
                        return;
					}
                    if (r.ddSfjx != '1'){
                        this.$Message.error("请选择已缴费的学员")
                        return;
					}
				}
                console.log('componentName');
				this.componentName = "allot";
			},
            pageChange(event) {
                this.util.pageChange(this, event);
            },
			exportData(){
                let params = {
                    exportType:'ptyh',
                    cols:'姓名,账号,是否有驾驶证,认证状态,教练姓名,教练电话',
					keys:'yhXm,yhZh,yhSfyjz,yhZt,jlxm,jldh'
				}
				window.open(this.apis.exportData+'?ddSfjx=1&exportType='+params.exportType+"&cols="+params.cols+"&keys="+params.keys);
			}
        }
    }
</script>
