<style lang="less">
  #bill{
    .billList{
      .tit{
        background-color: #f2f2f2;
        padding: 0.1rem 0.2rem;
        .mon{
          color: #000;font-size: 0.26rem
        }
        .sz{//收支
          font-size: 0.2rem;
          .icon-ico-money{
            font-size: 0.2rem;
          }
        }
      }

    }
  }
</style>
<template>
      <div id="bill" class="box">
        <div>
          <box-head tit="账单" leftToName="home">
            <div slot="left" style="color: #E0DADF">
              <i class="iconfont icon-left1"></i>
            </div>
          </box-head>
        </div>
        <div class="body">
          <div class="billList" v-for="(item,index) in pageList">
            <div class="box-row">
              <div style="width: 1.3rem;padding: 0.2rem">
                <img
                  style="width: 100%"
                  src="static/images/bill.png" alt="">
              </div>
              <div class="body-O" style="border-bottom: #949494 solid 1px;margin-right: 0.2rem">
                  <div class="box-row" style="padding-top: 0.25rem;
                          color: #505050;
                          font-size: 0.3rem;
                          font-weight: 700">
                    <div class="body-O">
                      {{item.mxlx | mxlx}}
                    </div>
                    <div>
                      {{item.zjFs | zjFs}}
                      {{item.zjJe/100}}
                    </div>
                  </div>
                  <div class="box-row"
                    style="padding-top: 0.15rem;font-size: 0.2rem;
                  color: #949494;
                  font-weight: 600">
                    <div class="body-O">
                        {{item.cjsj}}
                    </div>
                    <div style="text-align: right">
                      <div v-show="item.zjZt!=0">
                        <div>{{item.zjZt | zjZt}}</div>
                        <div v-show="item.zjZt==2">{{item.zjBz}}</div>
                      </div>
                      <div v-show="item.zjZt==0">
                        <div>{{item.txShZt | txShZt}}</div>
                        <div v-show="item.txShZt==2">{{item.zjBz}}</div>
                      </div>
                    </div>
                  </div>
              </div>
            </div>
          </div>
          <div v-show="pageList==0" style="font-size: 0.6rem;font-weight: 700;color: #999999;text-align: center;line-height: 2.8rem">
            暂无账单数据
          </div>
        </div>
      </div>
</template>

<script>
  import { Header,Button } from 'mint-ui'
    export default {
        name: "index",
        components:{
          [Header.name]:Header,
            [Button.name]:Button
        },
        filters:{
          zjZt:(val)=>{
            switch (val){
              case '0':
                return '提现冻结'
                break;
              case '1':
                return '处理成功'
                break;
              case '2':
                return '提现失败'
                break;
            }
          },
          txShZt:(val)=>{
            switch (val){
              case '0':
                return '待审核'
                break;
              case '1':
                return '待打款'
                break;
              case '2':
                return '审核失败'
                break;
            }
          },
          mxlx:(val)=>{
            switch (val){
              case '1':
                return '充值'
              break;
              case '2':
                return '分佣'
              break;
              case '3':
                  return '消费'
              break;
              case '4':
                return '提现'
              break;
            }
          },
          zjFs:(val)=>{
            switch (val){
              case '1':
                return ''
                break;
              case '-1':
                return '-'
                break;
            }
          }
        },
        data(){
          return{
            pageList:[]
          }
        },
        created(){
          // this.zdListType()
          this.getList()
        },
        methods:{
          zdListType(){
            this.$http.post(this.apis.ZDLISTTYPE,{'typeCode':''}).then((res)=>{
              console.log(res)

            }).catch((err)=>{

            })
          },
          getList(){
              var v = this
              this.$http.post(this.apis.ZDLIST).then((res)=>{
                console.log(res)
                if(res.code==200){
                   v.pageList = res.page.list
                }
              }).catch((err)=>{})

          }
        }
    }
</script>

<style scoped>

</style>
