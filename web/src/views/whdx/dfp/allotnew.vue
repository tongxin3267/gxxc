<style lang="less">
    @import '../../../styles/common.less';
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
               :mask-closable="false" :title="operate+''">
            <div style="overflow: auto;height: 500px;">
<!--                <Row style="padding-bottom: 16px;">-->
<!--                    <search-items :parent="v" :label-with="100"></search-items>-->
<!--                </Row>-->
<!--                <Tabs type="card" v-model="form.subSchoolName">-->
<!--                    <TabPane v-for="(item,index) in dpdlst" :label="item.subName" @0n-click="getpager(item.subName)"></TabPane>-->
<!--                </Tabs>-->
                <RadioGroup v-model="form.subSchoolId" type="button" @on-change="getpager()">
                    <Radio  v-for="(item,index) in dpdlst" :label="item.id" :key="index">{{item.subName}}</Radio>
                </RadioGroup>
                <Row style="position: relative;">
                    <Table  :columns="tableColumns" :data="pageData"></Table>
                </Row>
                <Row class="margin-top-10 pageSty">
                    <Page :total=form.total :current=form.pageNum :page-size=form.pageSize show-total show-elevator
                          @on-change='pageChange'></Page>
                </Row>
            </div>
            <div slot='footer'>
                <Button type="default" @click="v.util.closeDialog(v)">取消</Button>
                <Button type="primary" @click="confirm">确定</Button>
            </div>
        </Modal>
    </div>
</template>

<script>
    import fromData from '../teacher/list/formData'
    export default {
        name: 'byxxForm',
        components:{fromData},
        props:{
            item:{
                type:Object,
                default:function(){
                    return {};
                }
            },
        },
        data() {
            return {
                v:this,
                operate:'分配',
                showModal: true,
                pagerUrl:this.apis.teacher.QUERY,
                readonly: false,
                form: {
                    subSchoolId:'DXH0001',
                    jlTypeLike:"k2",
                    total: 0,
                    jlZt:'0',
                    pageNum: 1,
                    pageSize: 8,
                },
                tableColumns: [
                    {title: "#",  type: 'index'},
                    {title: '姓名',key:'yhXm',searchKey:'yhXmLike'},
                    {title: '联系电话',key:'yhSjhm',searchKey:'yhSjhmLike'},
                    {title: '培训车型',key:'jlCx',searchKey:'jlCxLike'},
                    {
                        title: '操作',
                        key: 'action',
                        width: 120,
                        fixed:'right',
                        render: (h, params) => {
                            return h('div', [
                                this.util.buildButton(this,h,'success','md-ribbon','分配',()=>{
                                    this.confirm(params.row.yhId);
                                }),
                            ]);
                        }
                    }
                ],
                pageData: [],
                ruleInline:{
                },
                formItem:{

                },
                dpdlst:[]
            }
        },
        created(){
            this.dpdlst = this.$parent.dpdlst
            this.util.initTable(this)

            this.formItem = this.item

        },
        methods: {
            getpager(){
                this.util.initTable(this)
            },
            pageChange(event) {
                this.util.pageChange(this, event);
            },
            confirm(id){
                swal({
                    title: "是否确认分配?",
                    text: "",
                    icon: "warning",
                    buttons:['取消','确认'],
                }).then((willDelete) => {
                    if (willDelete) {
                        this.save(id);
                    } else {
                    }
                });
            },

            save(id){
                let userList = this.$parent.choosedItem;
                let yhIds =userList.id;
                let params = {
                    yhIds:yhIds,
                    jlid:id,
                    jlType:2
                }
                let v = this;
                this.$http.post(this.apis.student.assignStudents,params).then((res)=>{
                    if (res.code === 200){
                        this.$Message.success(res.message);
                        v.util.closeDialog(v);
                        v.util.getPageData(v.$parent)
                    }
                })
            }
        }
    }
</script>

<style>

</style>
