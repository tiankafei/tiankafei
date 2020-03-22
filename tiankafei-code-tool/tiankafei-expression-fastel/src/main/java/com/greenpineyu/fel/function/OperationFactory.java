package com.greenpineyu.fel.function;

import com.greenpineyu.fel.function.api.BaseMoreOperation;
import com.greenpineyu.fel.function.api.BaseOneOperation;
import com.greenpineyu.fel.function.api.BaseTwoOperation;
import com.greenpineyu.fel.function.more.impl.AgeOperation;
import com.greenpineyu.fel.function.more.impl.AndMoreOperation;
import com.greenpineyu.fel.function.more.impl.FindOperation;
import com.greenpineyu.fel.function.more.impl.IfOperation;
import com.greenpineyu.fel.function.more.impl.InListOperation;
import com.greenpineyu.fel.function.more.impl.InRangeOperation;
import com.greenpineyu.fel.function.more.impl.LeftOperation;
import com.greenpineyu.fel.function.more.impl.LookatOperation;
import com.greenpineyu.fel.function.more.impl.MatchOperation;
import com.greenpineyu.fel.function.more.impl.MaxOperation;
import com.greenpineyu.fel.function.more.impl.MidOperation;
import com.greenpineyu.fel.function.more.impl.MinOperation;
import com.greenpineyu.fel.function.more.impl.MonthOperation;
import com.greenpineyu.fel.function.more.impl.OrMoreOperation;
import com.greenpineyu.fel.function.more.impl.ReplaceallOperation;
import com.greenpineyu.fel.function.more.impl.RightOperation;
import com.greenpineyu.fel.function.more.impl.SumOperation;
import com.greenpineyu.fel.function.more.impl.TimeCompareOperation;
import com.greenpineyu.fel.function.more.impl.VerifychOperation;
import com.greenpineyu.fel.function.more.impl.YearOperation;
import com.greenpineyu.fel.function.one.impl.AbsOperation;
import com.greenpineyu.fel.function.one.impl.CeilOperation;
import com.greenpineyu.fel.function.one.impl.CurrentTimeOperation;
import com.greenpineyu.fel.function.one.impl.IsNullOperation;
import com.greenpineyu.fel.function.one.impl.IsNumberOperation;
import com.greenpineyu.fel.function.one.impl.IschOperation;
import com.greenpineyu.fel.function.one.impl.IsenOperation;
import com.greenpineyu.fel.function.one.impl.IslowerOperation;
import com.greenpineyu.fel.function.one.impl.IsupperOperation;
import com.greenpineyu.fel.function.one.impl.LengthOperation;
import com.greenpineyu.fel.function.one.impl.LowerOperation;
import com.greenpineyu.fel.function.one.impl.NotNullOperation;
import com.greenpineyu.fel.function.one.impl.NotOperation;
import com.greenpineyu.fel.function.one.impl.RoundOperation;
import com.greenpineyu.fel.function.one.impl.TrimOperation;
import com.greenpineyu.fel.function.one.impl.TruncOperation;
import com.greenpineyu.fel.function.one.impl.UpperOperation;
import com.greenpineyu.fel.function.one.impl.VerifyCreditCodeOperation;
import com.greenpineyu.fel.function.one.impl.VerifyIdCardOperation;
import com.greenpineyu.fel.function.one.impl.VerifycodeOperation;
import com.greenpineyu.fel.function.operator.impl.AddOperation;
import com.greenpineyu.fel.function.operator.impl.AndOperation;
import com.greenpineyu.fel.function.operator.impl.DivOperation;
import com.greenpineyu.fel.function.operator.impl.EqualsOperation;
import com.greenpineyu.fel.function.operator.impl.GreaterThenEqualsOperation;
import com.greenpineyu.fel.function.operator.impl.GreaterThenOperation;
import com.greenpineyu.fel.function.operator.impl.LessThenEqualsOperation;
import com.greenpineyu.fel.function.operator.impl.LessThenOperation;
import com.greenpineyu.fel.function.operator.impl.ModOperation;
import com.greenpineyu.fel.function.operator.impl.MulOperation;
import com.greenpineyu.fel.function.operator.impl.NoEqualsOperation;
import com.greenpineyu.fel.function.operator.impl.OrOperation;
import com.greenpineyu.fel.function.operator.impl.SubOperation;

/**
 * @author tiankafei
 */
public class OperationFactory {

    public static BaseOneOperation getBaseOneOperation(String name) {
        BaseOneOperation baseOneOperation = null;
        if (FunctionConstants.ABS.equals(name)) {
            baseOneOperation = AbsOperation.getInstance();
        } else if (FunctionConstants.NOT_NULL.equals(name)) {
            baseOneOperation = NotNullOperation.getInstance();
        } else if (FunctionConstants.IS_NULL.equals(name)) {
            baseOneOperation = IsNullOperation.getInstance();
        } else if (FunctionConstants.IS_NUMBER.equals(name)) {
            baseOneOperation = IsNumberOperation.getInstance();
        } else if (FunctionConstants.IS_NUM.equals(name)) {
            baseOneOperation = IsNumberOperation.getInstance();
        } else if (FunctionConstants.CEIL.equals(name)) {
            baseOneOperation = CeilOperation.getInstance();
        } else if (FunctionConstants.CURRENTTIME.equals(name)) {
            baseOneOperation = CurrentTimeOperation.getInstance();
        } else if (FunctionConstants.NOT.equals(name)) {
            baseOneOperation = NotOperation.getInstance();
        } else if (FunctionConstants.NOT_OPER.equals(name)) {
            baseOneOperation = NotOperation.getInstance();
        } else if (FunctionConstants.ISCH.equals(name)) {
            baseOneOperation = IschOperation.getInstance();
        } else if (FunctionConstants.ISEN.equals(name)) {
            baseOneOperation = IsenOperation.getInstance();
        } else if (FunctionConstants.ISLOWER.equals(name)) {
            baseOneOperation = IslowerOperation.getInstance();
        } else if (FunctionConstants.ISUPPER.equals(name)) {
            baseOneOperation = IsupperOperation.getInstance();
        } else if (FunctionConstants.LEN.equals(name)) {
            baseOneOperation = LengthOperation.getInstance();
        } else if (FunctionConstants.LENGTH.equals(name)) {
            baseOneOperation = LengthOperation.getInstance();
        } else if (FunctionConstants.ROUND.equals(name)) {
            baseOneOperation = RoundOperation.getInstance();
        } else if (FunctionConstants.TRIM.equals(name)) {
            baseOneOperation = TrimOperation.getInstance();
        } else if (FunctionConstants.UPPER.equals(name)) {
            baseOneOperation = UpperOperation.getInstance();
        } else if (FunctionConstants.LOWER.equals(name)) {
            baseOneOperation = LowerOperation.getInstance();
        } else if (FunctionConstants.TRUNC.equals(name)) {
            baseOneOperation = TruncOperation.getInstance();
        } else if (FunctionConstants.VERIFYCODE.equals(name)) {
            baseOneOperation = VerifycodeOperation.getInstance();
        } else if (FunctionConstants.VERIFYIDCARD.equals(name)) {
            baseOneOperation = VerifyIdCardOperation.getInstance();
        } else if (FunctionConstants.VERIFYCREDITCODE.equals(name)) {
            baseOneOperation = VerifyCreditCodeOperation.getInstance();
        }
        return baseOneOperation;
    }

    public static BaseMoreOperation getBaseMoreOperation(String name) {
        BaseMoreOperation baseMoreOperation = null;
        if (FunctionConstants.AND_MORE.equals(name)) {
            baseMoreOperation = AndMoreOperation.getInstance();
        } else if (FunctionConstants.OR_MORE.equals(name)) {
            baseMoreOperation = OrMoreOperation.getInstance();
        } else if (FunctionConstants.LEFT.equals(name)) {
            baseMoreOperation = LeftOperation.getInstance();
        } else if (FunctionConstants.RIGHT.equals(name)) {
            baseMoreOperation = RightOperation.getInstance();
        } else if (FunctionConstants.MID.equals(name)) {
            baseMoreOperation = MidOperation.getInstance();
        } else if (FunctionConstants.SUM.equals(name)) {
            baseMoreOperation = SumOperation.getInstance();
        } else if (FunctionConstants.IF.equals(name)) {
            baseMoreOperation = IfOperation.getInstance();
        } else if (FunctionConstants.INLIST.equals(name)) {
            baseMoreOperation = InListOperation.getInstance();
        } else if (FunctionConstants.AGE.equals(name)) {
            baseMoreOperation = AgeOperation.getInstance();
        } else if (FunctionConstants.FIND.equals(name)) {
            baseMoreOperation = FindOperation.getInstance();
        } else if (FunctionConstants.INRANGE.equals(name)) {
            baseMoreOperation = InRangeOperation.getInstance();
        } else if (FunctionConstants.MAX.equals(name)) {
            baseMoreOperation = MaxOperation.getInstance();
        } else if (FunctionConstants.MIN.equals(name)) {
            baseMoreOperation = MinOperation.getInstance();
        } else if (FunctionConstants.REPLACEALL.equals(name)) {
            baseMoreOperation = ReplaceallOperation.getInstance();
        } else if (FunctionConstants.LOOKAT.equals(name)) {
            baseMoreOperation = LookatOperation.getInstance();
        } else if (FunctionConstants.MATCH.equals(name)) {
            baseMoreOperation = MatchOperation.getInstance();
        } else if (FunctionConstants.VERIFYCH.equals(name)) {
            baseMoreOperation = VerifychOperation.getInstance();
        } else if (FunctionConstants.YEAR.equals(name)) {
            baseMoreOperation = YearOperation.getInstance();
        } else if (FunctionConstants.MONTH.equals(name)) {
            baseMoreOperation = MonthOperation.getInstance();
        } else if (FunctionConstants.TIMECOMPARE.equals(name)) {
            baseMoreOperation = TimeCompareOperation.getInstance();
        }
        return baseMoreOperation;
    }

    public static BaseTwoOperation getBaseOperation(String name) {
        BaseTwoOperation baseTwoOperation = null;
        if (FunctionConstants.ADD.equals(name)) {
            baseTwoOperation = AddOperation.getInstance();
        } else if (FunctionConstants.SUB.equals(name)) {
            baseTwoOperation = SubOperation.getInstance();
        } else if (FunctionConstants.MUL.equals(name)) {
            baseTwoOperation = MulOperation.getInstance();
        } else if (FunctionConstants.DIV.equals(name)) {
            baseTwoOperation = DivOperation.getInstance();
        } else if (FunctionConstants.MOD.equals(name)) {
            baseTwoOperation = ModOperation.getInstance();
        } else if (FunctionConstants.EQUALS.equals(name)) {
            baseTwoOperation = EqualsOperation.getInstance();
        } else if (FunctionConstants.NO_EQUALS.equals(name)) {
            baseTwoOperation = NoEqualsOperation.getInstance();
        } else if (FunctionConstants.LESS_THEN.equals(name)) {
            baseTwoOperation = LessThenOperation.getInstance();
        } else if (FunctionConstants.LESS_THEN_EQUALS.equals(name)) {
            baseTwoOperation = LessThenEqualsOperation.getInstance();
        } else if (FunctionConstants.GREATER_THEN.equals(name)) {
            baseTwoOperation = GreaterThenOperation.getInstance();
        } else if (FunctionConstants.GREATER_THEN_EQUALS.equals(name)) {
            baseTwoOperation = GreaterThenEqualsOperation.getInstance();
        } else if (FunctionConstants.AND.equals(name)) {
            baseTwoOperation = AndOperation.getInstance();
        } else if (FunctionConstants.OR.equals(name)) {
            baseTwoOperation = OrOperation.getInstance();
        }
        return baseTwoOperation;
    }

}
