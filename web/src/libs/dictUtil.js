
import session from '@/libs/session.js'
let dictUtil = {
    getValByCode(v,zdlmCode,zdxmCode){
        let dic	= session.getItem('dictMap')
        let zdlm = new Map(dic).get(zdlmCode)
        if (!zdlm)return '';
        for (let r of zdlm){
            if (r.key === zdxmCode){
                return r.val;
            }
        }
        return '';
    },
    getItemByCode(v,zdlmCode,zdxmCode){
        let dic	= session.getItem('dictMap')
        let zdlm = new Map(dic).get(zdlmCode)
        if (!zdlm)return '';
        for (let r of zdlm){
            if (r.key === zdxmCode){
                return r;
            }
        }
        return null;
    },
    getByCode(v,code){
        let dic	= session.getItem('dictMap')
        let val = new Map(dic).get(code)
        if (val){
            return val;
        }else{
            log('字典加载失败，重新登陆',code);
            // v.$router.push({ name: 'login' });
        }
    },
}
export default dictUtil;
