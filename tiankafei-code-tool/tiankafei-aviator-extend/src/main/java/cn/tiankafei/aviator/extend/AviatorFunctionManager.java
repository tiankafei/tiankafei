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
import com.googlecode.aviator.AviatorEvaluator;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class AviatorFunctionManager {

    public void initFun() {
        AviatorEvaluator.addFunction(new And());
        AviatorEvaluator.addFunction(new Or());
        AviatorEvaluator.addFunction(new Abs());
        AviatorEvaluator.addFunction(new Ceil());
        AviatorEvaluator.addFunction(new CurrentTime());
        AviatorEvaluator.addFunction(new Isch());
        AviatorEvaluator.addFunction(new Isen());
        AviatorEvaluator.addFunction(new Islower());
        AviatorEvaluator.addFunction(new IsNull());
        AviatorEvaluator.addFunction(new IsNum());
        AviatorEvaluator.addFunction(new IsNumber());
        AviatorEvaluator.addFunction(new Isupper());
        AviatorEvaluator.addFunction(new Len());
        AviatorEvaluator.addFunction(new Length());
        AviatorEvaluator.addFunction(new Lower());
        AviatorEvaluator.addFunction(new Not());
        AviatorEvaluator.addFunction(new NotNull());
        AviatorEvaluator.addFunction(new NotOper());
        AviatorEvaluator.addFunction(new Round());
        AviatorEvaluator.addFunction(new Trim());
        AviatorEvaluator.addFunction(new Trunc());
        AviatorEvaluator.addFunction(new Upper());
        AviatorEvaluator.addFunction(new Verifycode());
        AviatorEvaluator.addFunction(new VerifyCreditCode());
        AviatorEvaluator.addFunction(new VerifyIdCard());
    }

}
