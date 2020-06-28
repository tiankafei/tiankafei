package org.tiankafei.aviator.extend.util;

import org.tiankafei.aviator.extend.InitFunction;
import org.tiankafei.aviator.extend.function.Abs;
import org.tiankafei.aviator.extend.function.Age;
import org.tiankafei.aviator.extend.function.AndMore;
import org.tiankafei.aviator.extend.function.Ceil;
import org.tiankafei.aviator.extend.function.CurrentTime;
import org.tiankafei.aviator.extend.function.Find;
import org.tiankafei.aviator.extend.function.If;
import org.tiankafei.aviator.extend.function.InList;
import org.tiankafei.aviator.extend.function.InRange;
import org.tiankafei.aviator.extend.function.IsNull;
import org.tiankafei.aviator.extend.function.IsNum;
import org.tiankafei.aviator.extend.function.IsNumber;
import org.tiankafei.aviator.extend.function.Isch;
import org.tiankafei.aviator.extend.function.Isen;
import org.tiankafei.aviator.extend.function.Islower;
import org.tiankafei.aviator.extend.function.Isupper;
import org.tiankafei.aviator.extend.function.Left;
import org.tiankafei.aviator.extend.function.Len;
import org.tiankafei.aviator.extend.function.Length;
import org.tiankafei.aviator.extend.function.Lookat;
import org.tiankafei.aviator.extend.function.Lower;
import org.tiankafei.aviator.extend.function.Match;
import org.tiankafei.aviator.extend.function.Max;
import org.tiankafei.aviator.extend.function.Mid;
import org.tiankafei.aviator.extend.function.Min;
import org.tiankafei.aviator.extend.function.Month;
import org.tiankafei.aviator.extend.function.Not;
import org.tiankafei.aviator.extend.function.NotNull;
import org.tiankafei.aviator.extend.function.OrMore;
import org.tiankafei.aviator.extend.function.Replaceall;
import org.tiankafei.aviator.extend.function.Right;
import org.tiankafei.aviator.extend.function.Round;
import org.tiankafei.aviator.extend.function.Sum;
import org.tiankafei.aviator.extend.function.TimeCompare;
import org.tiankafei.aviator.extend.function.Trim;
import org.tiankafei.aviator.extend.function.Trunc;
import org.tiankafei.aviator.extend.function.Upper;
import org.tiankafei.aviator.extend.function.VerifyCreditCode;
import org.tiankafei.aviator.extend.function.VerifyIdCard;
import org.tiankafei.aviator.extend.function.Verifych;
import org.tiankafei.aviator.extend.function.Verifycode;
import org.tiankafei.aviator.extend.function.Year;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class AviatorCustomFunManager implements InitFunction {

    @Override
    public void initFun() {
        //新增自定义的函数
        AviatorExtendUtil.addOperatorTypeFunction();

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
        AviatorExtendUtil.addFunction(new AndMore());
        AviatorExtendUtil.addFunction(new Find());
        // 小写的if是关键字，不支持自定义函数
        AviatorExtendUtil.addFunction(new If());
        AviatorExtendUtil.addFunction(new InList());
        AviatorExtendUtil.addFunction(new InRange());
        AviatorExtendUtil.addFunction(new Left());
        AviatorExtendUtil.addFunction(new Lookat());
        AviatorExtendUtil.addFunction(new Match());
        AviatorExtendUtil.addFunction(new Mid());
        AviatorExtendUtil.addFunction(new Month());
        AviatorExtendUtil.addFunction(new OrMore());
        AviatorExtendUtil.addFunction(new Replaceall());
        AviatorExtendUtil.addFunction(new Right());
        AviatorExtendUtil.addFunction(new Sum());
        AviatorExtendUtil.addFunction(new TimeCompare());
        AviatorExtendUtil.addFunction(new Verifych());
        AviatorExtendUtil.addFunction(new Year());

        AviatorExtendUtil.delFunction("max");
        AviatorExtendUtil.addFunction(new Max());
        AviatorExtendUtil.delFunction("min");
        AviatorExtendUtil.addFunction(new Min());
    }

}
