<template>

    <div class="agreeMess box_col">
      <div style="text-align: center;position: relative">
        <div class="tit">会员缴费协议</div>
      </div>
      <div class="" style="padding: 0.05rem 0.3rem 0.1rem 0.3rem">
        <div class="box-row">
          <div class="box_row_100">
            <div>
              甲方:<span class="decoration">{{usermess.yhXm}}</span>
            </div>
            <div>
              电话:<span class="decoration">{{usermess.yhZh}}</span>
            </div>
            <div>
              证件号码: <span class="decoration">{{usermess.yhZjhm}}</span>
            </div>
          </div>
          <div class="box_row_100">
            <div>
              乙方:<span class="decoration">武汉天弘腾创科技有限公司</span>
            </div>
            <div>
              代表人:<span class="decoration">腾创</span>
            </div>
            <div>
              电话: <span class="decoration">13133446688</span>
            </div>
          </div>
        </div>
      </div>
      <div class="box_col_auto" style="padding: 0.35rem 0.5rem;">
        <div class="fontsty">
          甲乙双方经友好协商，依据中华人民共和国相关法律、法规的规定，本着自愿、平等、互惠互利、诚实信用的原则，乙方为甲方提供创业培训、项目运营咨询、工商税务咨询、创业资源对接等服务，在以下方面达成一致。双方约定共同遵守：
        </div>
        <div>
          <div class="fonttit">第一条：甲方权利与义务</div>
          <div class="fontsty">
            1、本协议有效期内，甲方是乙方创业培训服务的购买方和代理方，可以以自己名义代理乙方签订乙方经营范围内的业务合同，为乙方提供招揽、联系培训业务的专项服务。
          </div>
          <div class="fontsty">
            2、甲方在业务开展前，应得到乙方许可或授权。
          </div>
          <div class="fontsty">
            3、甲方在交纳培训费用后，有权享受乙方每月提供的创业培训课程及相关资源。
          </div>
          <div class="fontsty">
            4、甲方运用自身渠道为乙方进行课程及项目推广，并拥有联系、安排、接洽与乙方有关的培训工作及相关事宜的权利。
          </div>
          <div class="fontsty">
            5、甲方拥有与本协议工作内容相关的乙方的名称、音频、图标、文案及相关资质的使用权。甲方与客户签订的各种与乙方培训工作相关的合约和细则，应提前通知乙方，并与乙方就创业服务的细节问题进行沟通协商
          </div>
        </div>

        <div>
          <div class="fonttit">第二条：乙方权利与义务</div>
          <div class="fontsty">
            1、本协议生效后，乙方应向甲方提供为期一年的创业服务，服务内容主要是提供创业课程、创业政策解读、工商税务咨询、项目运营辅导、团队搭建、资源对接等服务。
          </div>
          <div class="fontsty">
            2、乙方应依据甲方实际情况，每个月不定期举办至少一次线下创业交流会。
          </div>
          <div class="fontsty">
            3、乙方有权在培训前，从甲方处获得课酬 2500 元。
          </div>
          <div class="fontsty">
            4、对甲方招收的学员，乙方应确保提供较为满意的服务，在学员积极配合的前提下，保证学员在接受培训后取得相关证书或凭证。
          </div>
        </div>
        <div>
          <div class="fonttit">第三条：合作期限</div>
          <div class="fontsty">
            双方合作期间为  1  年，<span style="color: red;">{{getdateStr(0)}}</span>起，至<span style="color: red;">{{getdateStr(1)}}</span>止，本协议届满前   1   个月，甲乙双方可就续签事宜进行协商并签订相关协议；协议期满，双方未签订新签约或就本协议签订相关补充协议，则本协议到期终止。
          </div>
        </div>
        <div>
          <div class="fonttit">第四条：乙方酬劳及双方利润分配</div>
          <div class="fontsty">
            1、乙方就驾考招生项目给予甲方的合作报价为  2500  元/人，甲方招收的学员在缴纳驾考培训费用2500元后，乙方平台系统应向甲方支付  800  元/人的酬劳，且甲方招收的学员在招到新学员时，乙方平台系统应支付甲方 400 元/人的酬劳，具体依据学车联盟平台运营管理方案施行。
          </div>
          <div class="fontsty">
            2、甲乙双方在本协议履行期间，应共享收益，同担风险，若发生客户退款、减免部分款项之事，双方应共同协调处理，产生的损失按照收益比例分担。
          </div>
        </div>
        <div>
          <div class="fonttit">第五条：协议的解除或终止</div>
          <div class="fontsty">
            1、甲乙双方协商一致，可以解除本协议。
          </div>
          <div class="fontsty">
            2、有下列情形之一，甲乙任何一方有权单方解除本协议。
          </div>
          <div class="fontsty">
            （1）一方涉入本协议外的法律纠纷而不能履行本协议约定工作。
          </div>
          <div class="fontsty">
            （2）一方人身自由或经营权利受限或不能自由活动、不能履行本协议约定的义务。
          </div>
          <div class="fontsty">
            （3）一方在本协议中虚假承诺，且对另一方签订本协议有重大影响的，受影响方有权解除协议。
          </div>
        </div>
        <div>
          <div class="fonttit">第六条：保密约定</div>
          <div class="fontsty">
            1、甲乙双方保证对在讨论、签订、执行本协议过程中所获悉的属于对方的且无法自公开渠道获得的文件及资料（包括商业秘密、公司计划、运营活动、财务信息、技术信息、经营信息、折扣及其他涉密信息）予以保密。
          </div>
          <div class="fontsty">
            2、未经该资料和文件的原提供方书面同意，另一方不得向任何第三方泄露该商业秘密的全部或部分内容。
          </div>
          <div class="fontsty">
            3、本保密条款在本协议解除或终止后两年内仍然有效，双方亦应遵守。
          </div>
        </div>
        <div>
          <div class="fonttit">第七条：违约责任</div>
          <div class="fontsty">
            本协议履行过程中，甲乙双方因一方行为造成另一方实际损失，行为造成方应予赔偿。若商定的课程、培训项目乙方对课程已经确认后因乙方原因未履约，甲方由此可向乙方追偿。
          </div>
        </div>
        <div>
          <div class="fonttit">第八条：争议解决</div>
          <div class="fontsty">
            1、本协议的订立、解释、履行和争议的解决均适用中华人民共和国法律。
          </div>
          <div class="fontsty">
            2、因本协议引起的或与本协议事项有关的争议，双方应友好协商解决；协商不成，任何一方可向对方所在地人民法院提起诉讼解决。
          </div>
        </div>
        <div>
          <div class="fonttit">第九条：其他事项</div>
          <div class="fontsty">
            1、本协议经双方签字、盖章之日起生效。
          </div>
          <div class="fontsty">
            2、本协议一式   2   份，甲乙双方各执   1   份，具有同等法律效力。
          </div>
          <div class="fontsty">
            3、除非本协议另有规定，甲乙双方协商一致并签署相关协议，可转让本协议约定的全部或部分权利给第三方。
          </div>
        </div>
      </div>
      <div class="box-row" style="padding: 0.15rem 0.3rem">
        <div class="userSign" style="margin-right: 0.2rem">
          <div class="signImg"  v-show="saveResultUrl!=''">
            <img :src="apis.getImgUrl+saveResultUrl" alt="">
          </div>
          <div>
            甲方代表:<span class="decoration">{{usermess.yhXm}}</span>
          </div>
          <div>
            甲方（签章）:
            <el-button v-if="sign" type="primary" icon="el-icon-edit" circle
                       @click="$parent.signShow=!$parent.signShow"
            >请签名</el-button>
            <el-button v-else type="success" icon="el-icon-check" circle>
              已签名
            </el-button>
          </div>
          <div>
            时间：{{getdateStr(0)}}
          </div>
        </div>
        <div class="box_row_100" style="position: relative">
          <img src="static/gz/thtc.png" style="width: 1.6rem;
                  position: absolute;
                  top: -0.5rem;
                  right: 0.5rem;
                  transform: rotate(-60deg);">
          <div>
            乙方代表:<span class="decoration">武汉天弘腾创科技有限公司</span>
          </div>
          <div>
            乙方（签章）:
          </div>
          <div>
            时间：{{getdateStr(0)}}
          </div>
        </div>
      </div>
      <div class="box-row">
        <div class="box_row_100" style="padding: 0.2rem">
          <el-button type="success" round
                     @click="agreeShowOk"
                     style="width: 100%;font-size: 0.4rem"
          >同意</el-button>
        </div>
        <div class="box_row_100" style="padding: 0.2rem">
          <el-button type="info" round
                     @click="$router.push({name:'Home'})"
                     style="width: 100%;font-size: 0.4rem"
          >拒绝</el-button>
        </div>
      </div>
    </div>

</template>

<script>
    export default {
        name: "Member",
        components:{

        },
        props:{
          saveResultUrl:{
            type:String,
            default:''
          },
          sign:{
            type:Boolean,
            default:true
          }
        },
        data(){
          return{
            usermess: this.$store.state.app.userMess,
          }
        },
        created(){

        },
        methods:{
          //获取当前时间
          getdateStr(Y){
            var NowDate = new Date
            let Year = NowDate.getFullYear()+Y
            let Month = NowDate.getMonth()+1
            let Day = NowDate.getDate()
            let Hours = NowDate.getHours()
            let Minutes = NowDate.getMinutes()
            let Seconds = NowDate.getSeconds()
            // +Seconds+'秒'
            let time = Year+'年'+Month+'月'+Day+'日'+Hours+'时'+Minutes+'分'
            return time
          },
          agreeShowOk(){
            // if(this.sign){
            //   Toast.info('请签字')
            // }else {
              this.$emit('agreeShowOk')
              // this.checkboxVal = true
            // }
          },
        }
    }
</script>

<style scoped>

</style>
