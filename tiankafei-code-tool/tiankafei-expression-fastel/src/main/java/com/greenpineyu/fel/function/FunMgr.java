package com.greenpineyu.fel.function;

import com.greenpineyu.fel.function.more.Age;
import com.greenpineyu.fel.function.more.Find;
import com.greenpineyu.fel.function.more.If;
import com.greenpineyu.fel.function.more.InList;
import com.greenpineyu.fel.function.more.InRange;
import com.greenpineyu.fel.function.more.Left;
import com.greenpineyu.fel.function.more.Lookat;
import com.greenpineyu.fel.function.more.Match;
import com.greenpineyu.fel.function.more.Max;
import com.greenpineyu.fel.function.more.Mid;
import com.greenpineyu.fel.function.more.Min;
import com.greenpineyu.fel.function.more.Month;
import com.greenpineyu.fel.function.more.Replaceall;
import com.greenpineyu.fel.function.more.Right;
import com.greenpineyu.fel.function.more.Sum;
import com.greenpineyu.fel.function.more.TimeCompare;
import com.greenpineyu.fel.function.more.Verifych;
import com.greenpineyu.fel.function.more.Year;
import com.greenpineyu.fel.function.one.Abs;
import com.greenpineyu.fel.function.one.Ceil;
import com.greenpineyu.fel.function.one.CurrentTime;
import com.greenpineyu.fel.function.one.IsNull;
import com.greenpineyu.fel.function.one.IsNum;
import com.greenpineyu.fel.function.one.IsNumber;
import com.greenpineyu.fel.function.one.Isch;
import com.greenpineyu.fel.function.one.Isen;
import com.greenpineyu.fel.function.one.Islower;
import com.greenpineyu.fel.function.one.Isupper;
import com.greenpineyu.fel.function.one.Len;
import com.greenpineyu.fel.function.one.Length;
import com.greenpineyu.fel.function.one.Lower;
import com.greenpineyu.fel.function.one.Not;
import com.greenpineyu.fel.function.one.NotNull;
import com.greenpineyu.fel.function.one.NotOper;
import com.greenpineyu.fel.function.one.Round;
import com.greenpineyu.fel.function.one.Trim;
import com.greenpineyu.fel.function.one.Trunc;
import com.greenpineyu.fel.function.one.Upper;
import com.greenpineyu.fel.function.one.VerifyCreditCode;
import com.greenpineyu.fel.function.one.VerifyIdCard;
import com.greenpineyu.fel.function.one.Verifycode;
import com.greenpineyu.fel.function.operator.Add;
import com.greenpineyu.fel.function.operator.And;
import com.greenpineyu.fel.function.operator.Div;
import com.greenpineyu.fel.function.operator.Equal;
import com.greenpineyu.fel.function.operator.GreaterThen;
import com.greenpineyu.fel.function.operator.GreaterThenEqual;
import com.greenpineyu.fel.function.operator.LessThen;
import com.greenpineyu.fel.function.operator.LessThenEqual;
import com.greenpineyu.fel.function.operator.Mod;
import com.greenpineyu.fel.function.operator.Mul;
import com.greenpineyu.fel.function.operator.NotEqual;
import com.greenpineyu.fel.function.operator.Or;
import com.greenpineyu.fel.function.operator.Sub;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author tiankafei
 */
public class FunMgr {

    public FunMgr() {
        userFunMap = new HashMap<String, Function>();
    }

    /**
     * 用户函数
     */
    private Map<String, Function> userFunMap;

    /**
     * 共用函数
     */
    private Map<String, Function> funcMap;

    {
        funcMap = new HashMap<String, Function>();

        // // 操作符函数
//        addFun(new Dot());
//        addFun(new CollectionGet());
//        addFun(new Cond());
//        addFun(new Dollar());
//        addFun(new NotOper());

        //+
        addFun(new Add());
        //-
        addFun(new Sub());
        //==
        addFun(new Equal());
        //!=
        addFun(new NotEqual());
        // *
        addFun(new Mul());
        // /
        addFun(new Div());
        // %
        addFun(new Mod());
        // <
        addFun(new LessThen());
        // <=
        addFun(new LessThenEqual());
        // >
        addFun(new GreaterThen());
        // >=
        addFun(new GreaterThenEqual());
        // &&
        addFun(new And());
        // ||
        addFun(new Or());


        /**********************自定义一个参数的函数*******************/
        addFun(new Abs());
        addFun(new Ceil());
        addFun(new NotNull());
        addFun(new IsNull());
        addFun(new Not());
        addFun(new NotOper());
        addFun(new IsNumber());
        addFun(new IsNum());
        addFun(new CurrentTime());
        addFun(new Isch());
        addFun(new Isen());
        addFun(new Islower());
        addFun(new Isupper());
        addFun(new Len());
        addFun(new Length());
        addFun(new Round());
        addFun(new Trim());
        addFun(new Upper());
        addFun(new Lower());
        addFun(new Trunc());
        addFun(new Verifycode());
        addFun(new VerifyIdCard());
        addFun(new VerifyCreditCode());

        /**********************自定义多个参数(超过两个)的函数*******************/
        addFun(new com.greenpineyu.fel.function.more.And());
        addFun(new com.greenpineyu.fel.function.more.Or());
        addFun(new Left());
        addFun(new Right());
        addFun(new Mid());
        addFun(new Sum());
        addFun(new If());
        addFun(new InList());
        addFun(new Age());
        addFun(new Find());
        addFun(new InRange());
        addFun(new Max());
        addFun(new Min());
        addFun(new Replaceall());
        addFun(new Lookat());
        addFun(new Match());
        addFun(new Verifych());
        addFun(new Year());
        addFun(new Month());
        addFun(new TimeCompare());
    }

    private void addFun(Function fun) {
        funcMap.put(getLowerCaseName(fun.getName()), fun);
    }

    /**
     * 获取函数。先从用户函数中取，如没有获取到，再从共用函数中获取。
     *
     * @param funName
     * @return
     */
    public Function getFun(String funName) {
        if (funName != null) {
            String newFunName = getLowerCaseName(funName);
            Function userFun = userFunMap.get(newFunName);
            if (userFun != null) {
                return userFun;
            }
            return funcMap.get(newFunName);
        }
        return null;
    }

    private String getLowerCaseName(String funName) {
        return funName.toLowerCase();
    }

    /**
     * 添加函数到用户函数库中
     *
     * @param fun
     */
    public void add(Function fun) {
        if (fun != null) {
            String name = fun.getName();
            if (name == null || "".equals(name)) {
                throw new IllegalArgumentException("函数名称不能为空");
            } else {
                userFunMap.put(getLowerCaseName(name), fun);
            }
        }
    }

    /**
     * 判断字符串是否是用户自定义的函数
     *
     * @param name
     * @return
     */
    public boolean hasUserFun(String name) {
        return userFunMap.containsKey(name.toLowerCase());
    }

    /**
     * 判断字符串是否是函数
     *
     * @param name
     * @return
     */
    public boolean exists(String name) {
        boolean flag = userFunMap.containsKey(name.toLowerCase());
        if (!flag) {
            flag = funcMap.containsKey(name.toLowerCase());
        }
        return flag;
    }

    /**
     * 获取规则引擎的函数列表
     *
     * @return
     */
    public List<String> getFunNameList() {
        Set<String> funSet = funcMap.keySet();
        Set<String> userFunSet = userFunMap.keySet();

        List<String> funNameList = new ArrayList<>();
        funNameList.addAll(funSet);
        funNameList.addAll(userFunSet);
        return funNameList;
    }


    /**
     * 移除用户函数
     *
     * @param name
     */
    public void remove(String name) {
        if (name != null) {
            userFunMap.remove(getLowerCaseName(name));
        }
    }

}
