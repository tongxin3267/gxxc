<style type="text/css">

</style>
<template>
	<div>
		<Modal v-model="showModal" width='900' :closable='false'
        			:mask-closable="false" title="约考">
        	<div style="overflow: auto;height: 500px;">
        		<Form ref="form"
        						:model="formItem"
        						:rules="ruleInline"
        						:label-width="100"
        						:styles="{top: '20px'}">
        			<Row>
        				<form-items :parent="v"></form-items>
        			</Row>
					<Row>
						<Col span="12">
							<label>第一次成绩</label>
							<choose-img :type="'cjd1'" :path="formItem.cjd1" @imgChange="imgChange1"></choose-img>
						</Col>
						<Col span="12">
							<label>第二次成绩</label>
							<choose-img :type="'cjd2'" :path="formItem.cjd2" @imgChange="imgChange2"></choose-img>
						</Col>
					</Row>
					<Row>
						<yk-list :parent="v"></yk-list>
					</Row>
        		</Form>
        	</div>
        	<div slot='footer'>
        		<Button type="default" @click="v.util.closeDialog(v)">取消</Button>
        		<Button type="primary" @click="v.util.save(v)">确定</Button>
        	</div>
        </Modal>
	</div>
</template>

<script>
	import chooseImg from '../../components/chooseImg'
	import ykList from './ykList'
	export default {
		name: 'ksYkForm',
		components:{
            chooseImg,ykList
		},
		data() {
			return {
			    v:this,
                operate:'新建',
                saveUrl:this.apis.ksyk.ADD,
				showModal: true,
				readonly: false,
				formItem: {
				},
                formInputs:[
                    {label:'姓名',prop:'yhId',type:'foreignKey',disabled:true},
                    {label:'科目',prop:'kmCode',dict:'ZDCLK0067'},
                    {label:'考试地点',prop:'examPlaceId',type:'foreignKey'},
                    {label:'约考时间',prop:'ykSj',type:'date'},
                    {label:'第一次成绩',prop:'cj1',type:''},
                    {label:'第二次成绩',prop:'cj2',type:''},
                ],
                ruleInline:{
				},
                km:'',
                foreignList:{
                    examPlaceId:{url:this.apis.examPlace.QUERY,key:'id',val:'name',items:[]},
                    yhId:{url:this.apis.student.QUERY,key:'id',val:'yhXm',items:[]},
                },
			}
		},
		created(){
            let userInfo = sessionStorage.getItem('userInfo');
            let userType = JSON.parse(userInfo).type;
            if (userType === 'k1' || userType === 'k2' || userType === 'k3' || userType === 'k4'){
                this.km = userType.charAt(1);
                this.foreignList.examPlaceId.url += '?kskm='+this.km;
                this.formInputs[1].disabled = true;
            }
            this.util.initFormModal(this)
            if (this.km !== ''){
                this.formItem.kmCode = this.km;
            }
            this.formItem.ykSj = new Date().format('yyyy-MM-dd');
		},
		mounted(){
		},
		methods: {
            imgChange1(o){
                this.formItem.cjd1 = o.path;
            },
            imgChange2(o){
                this.formItem.cjd2 = o.path;
            }
		}
	}
</script>

<style>

</style>
