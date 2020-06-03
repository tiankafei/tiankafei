package cn.tiankafei.aviator.extend.util;

import cn.tiankafei.aviator.extend.InitFunction;
import cn.tiankafei.aviator.extend.function.Abs;
import cn.tiankafei.aviator.extend.function.Age;
import cn.tiankafei.aviator.extend.function.And;
import cn.tiankafei.aviator.extend.function.Ceil;
import cn.tiankafei.aviator.extend.function.CurrentTime;
import cn.tiankafei.aviator.extend.function.Find;
import cn.tiankafei.aviator.extend.function.If;
import cn.tiankafei.aviator.extend.function.InList;
import cn.tiankafei.aviator.extend.function.InRange;
import cn.tiankafei.aviator.extend.function.IsNull;
import cn.tiankafei.aviator.extend.function.IsNum;
import cn.tiankafei.aviator.extend.function.IsNumber;
import cn.tiankafei.aviator.extend.function.Isch;
import cn.tiankafei.aviator.extend.function.Isen;
import cn.tiankafei.aviator.extend.function.Islower;
import cn.tiankafei.aviator.extend.function.Isupper;
import cn.tiankafei.aviator.extend.function.Left;
import cn.tiankafei.aviator.extend.function.Len;
import cn.tiankafei.aviator.extend.function.Length;
import cn.tiankafei.aviator.extend.function.Lookat;
import cn.tiankafei.aviator.extend.function.Lower;
import cn.tiankafei.aviator.extend.function.Match;
import cn.tiankafei.aviator.extend.function.Mid;
import cn.tiankafei.aviator.extend.function.Month;
import cn.tiankafei.aviator.extend.function.Not;
import cn.tiankafei.aviator.extend.function.NotNull;
import cn.tiankafei.aviator.extend.function.Or;
import cn.tiankafei.aviator.extend.function.Replaceall;
import cn.tiankafei.aviator.extend.function.Right;
import cn.tiankafei.aviator.extend.function.Round;
import cn.tiankafei.aviator.extend.function.Sum;
import cn.tiankafei.aviator.extend.function.TimeCompare;
import cn.tiankafei.aviator.extend.function.Trim;
import cn.tiankafei.aviator.extend.function.Trunc;
import cn.tiankafei.aviator.extend.function.Upper;
import cn.tiankafei.aviator.extend.function.VerifyCreditCode;
import cn.tiankafei.aviator.extend.function.VerifyIdCard;
import cn.tiankafei.aviator.extend.function.Verifych;
import cn.tiankafei.aviator.extend.function.Verifycode;
import cn.tiankafei.aviator.extend.function.Year;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class AviatorCustomFunManager implements InitFunction {

    @Override
    public void initFun() {
        //新增自定义的函数
        AviatorExtendUtil.addFunction();

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
        AviatorExtendUtil.addFunction(new Round());
        AviatorExtendUtil.addFunction(new Trim());
        AviatorExtendUtil.addFunction(new Trunc());
        AviatorExtendUtil.addFunction(new Upper());
        AviatorExtendUtil.addFunction(new Verifycode());
        AviatorExtendUtil.addFunction(new VerifyCreditCode());
        AviatorExtendUtil.addFunction(new VerifyIdCard());

        AviatorExtendUtil.addFunction(new Age());
        AviatorExtendUtil.addFunction(new And());
        AviatorExtendUtil.addFunction(new Find());
        AviatorExtendUtil.addFunction(new If());
        AviatorExtendUtil.addFunction(new InList());
        AviatorExtendUtil.addFunction(new InRange());
        AviatorExtendUtil.addFunction(new Left());
        AviatorExtendUtil.addFunction(new Lookat());
        AviatorExtendUtil.addFunction(new Match());
        AviatorExtendUtil.addFunction(new Mid());
        AviatorExtendUtil.addFunction(new Month());
        AviatorExtendUtil.addFunction(new Or());
        AviatorExtendUtil.addFunction(new Replaceall());
        AviatorExtendUtil.addFunction(new Right());
        AviatorExtendUtil.addFunction(new Sum());
        AviatorExtendUtil.addFunction(new TimeCompare());
        AviatorExtendUtil.addFunction(new Verifych());
        AviatorExtendUtil.addFunction(new Year());
    }

}
