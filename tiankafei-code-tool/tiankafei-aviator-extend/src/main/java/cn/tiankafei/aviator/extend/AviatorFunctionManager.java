package cn.tiankafei.aviator.extend;

import cn.tiankafei.aviator.extend.function.Abs;
import cn.tiankafei.aviator.extend.function.And;
import cn.tiankafei.aviator.extend.function.Ceil;
import cn.tiankafei.aviator.extend.function.CurrentTime;
import cn.tiankafei.aviator.extend.function.IsNull;
import cn.tiankafei.aviator.extend.function.IsNum;
import cn.tiankafei.aviator.extend.function.IsNumber;
import cn.tiankafei.aviator.extend.function.Isch;
import cn.tiankafei.aviator.extend.function.Isen;
import cn.tiankafei.aviator.extend.function.Islower;
import cn.tiankafei.aviator.extend.function.Isupper;
import cn.tiankafei.aviator.extend.function.Len;
import cn.tiankafei.aviator.extend.function.Length;
import cn.tiankafei.aviator.extend.function.Lower;
import cn.tiankafei.aviator.extend.function.Not;
import cn.tiankafei.aviator.extend.function.NotNull;
import cn.tiankafei.aviator.extend.function.NotOper;
import cn.tiankafei.aviator.extend.function.Or;
import cn.tiankafei.aviator.extend.function.Round;
import cn.tiankafei.aviator.extend.function.Trim;
import cn.tiankafei.aviator.extend.function.Trunc;
import cn.tiankafei.aviator.extend.function.Upper;
import cn.tiankafei.aviator.extend.function.VerifyCreditCode;
import cn.tiankafei.aviator.extend.function.VerifyIdCard;
import cn.tiankafei.aviator.extend.function.Verifycode;
import cn.tiankafei.aviator.extend.util.AviatorExtendUtil;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class AviatorFunctionManager {

    public void initFun() {
        //删除框架默认的函数实现
//        AviatorExtendUtil.removeFunction("!");

        //新增自定义的函数
        AviatorExtendUtil.addFunction(new And());
        AviatorExtendUtil.addFunction(new Or());
        AviatorExtendUtil.addFunction(new Abs());
        AviatorExtendUtil.addFunction(new Ceil());
        AviatorExtendUtil.addFunction(new CurrentTime());
        AviatorExtendUtil.addFunction(new Isch());
        AviatorExtendUtil.addFunction(new Isen());
        AviatorExtendUtil.addFunction(new Islower());
        AviatorExtendUtil.addFunction(new IsNull());
        AviatorExtendUtil.addFunction(new IsNum());
        AviatorExtendUtil.addFunction(new IsNumber());
        AviatorExtendUtil.addFunction(new Isupper());
        AviatorExtendUtil.addFunction(new Len());
        AviatorExtendUtil.addFunction(new Length());
        AviatorExtendUtil.addFunction(new Lower());
        AviatorExtendUtil.addFunction(new Not());
        AviatorExtendUtil.addFunction(new NotNull());
//        AviatorExtendUtil.addFunction(new NotOper());
        AviatorExtendUtil.addFunction(new Round());
        AviatorExtendUtil.addFunction(new Trim());
        AviatorExtendUtil.addFunction(new Trunc());
        AviatorExtendUtil.addFunction(new Upper());
        AviatorExtendUtil.addFunction(new Verifycode());
        AviatorExtendUtil.addFunction(new VerifyCreditCode());
        AviatorExtendUtil.addFunction(new VerifyIdCard());
    }

}
