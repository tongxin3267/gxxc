<style lang="less">
	@import '../../../../styles/common.less';
</style>
<template>
	<div class="boxbackborder">
		<Row style="padding-bottom: 16px;">
			<search-items :parent="v"  ></search-items>
			<Button type="primary" @click="v.util.getPageData(v)">
				<Icon type="search"></Icon>
			</Button>
		</Row>
		<Row style="position: relative;">
			<Table :height="tableHeight" :columns="tableColumns" :data="pageData"></Table>
		</Row>
		<Row class="margin-top-10 pageSty">
			<Page :total=form.total :current=form.pageNum :page-size=form.pageSize show-total show-elevator
				  @on-change='pageChange'></Page>
		</Row>
		<component :is="componentName"></component>
	</div>
</template>

<script>
    import detail from './detail.vue'

    export default {
        name: 'byxxTable',
        components: {detail},
        data() {
            return {
                v:this,
                SpinShow: true,
                apiRoot:this.apis.user,
                tableHeight: 220,
                componentName: '',
                choosedItem: null,
                dateRange:'',
                tableColumns: [
                    {title: "#",  type: 'index'},
                    {title: '姓名',key:'yhXm',searchKey:'yhXmLike'},
                    {title: '手机号码',key:'yhSjhm',searchKey:'yhSjhmLike' },
                    {title: '类型',key:'yhLx'},
                    {
                        title: '操作',
                        key: 'action',
                        width: 120,
                        render: (h, params) => {
                            return h('div', [
                                this.util.buildButton(this,h,'success','card','详情',()=>{
                                    this.choosedItem = params.row;
                                    this.componentName = 'detail'
                                }),
                            ]);
                        }
                    }
                ],
                pageData: [],
                form: {
                    userId:'',
                    userGrade:'1',
                    total: 0,
                    pageNum: 1,
                    pageSize: 8,
                },
            }
        },
		props:{
          item:{
              type:Object,
			  default:function(){
			      return {};
			  }
		  }
		},
        created() {
            this.form.userId = this.item.yhId;
            this.util.initTable(this)
        },
        methods: {
            pageChange(event) {
                this.util.pageChange(this, event);
            },
        }
    }
</script>
