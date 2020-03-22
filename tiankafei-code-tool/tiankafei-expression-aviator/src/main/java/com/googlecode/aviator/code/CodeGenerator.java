/**
 * Copyright (C) 2010 dennis zhuang (killme2008@gmail.com)
 * <p>
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with this program;
 * if not, write to the Free Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 **/
package com.googlecode.aviator.code;

import com.googlecode.aviator.Expression;
import com.googlecode.aviator.lexer.token.Token;
import com.googlecode.aviator.parser.Parser;
import com.googlecode.aviator.runtime.FunctionArgument;

import java.util.List;


/**
 * Code generator interface
 *
 * @author dennis
 */
public interface CodeGenerator {

    /**
     * onAssignment
     *
     * @param lookhead
     */
    public void onAssignment(Token<?> lookhead);

    /**
     * setParser
     *
     * @param parser
     */
    public void setParser(Parser parser);

    /**
     * onShiftRight
     *
     * @param lookhead
     */
    public void onShiftRight(Token<?> lookhead);

    /**
     * onShiftLeft
     *
     * @param lookhead
     */
    public void onShiftLeft(Token<?> lookhead);

    /**
     * onUnsignedShiftRight
     *
     * @param lookhead
     */
    public void onUnsignedShiftRight(Token<?> lookhead);

    /**
     * onBitOr
     *
     * @param lookhead
     */
    public void onBitOr(Token<?> lookhead);

    /**
     * onBitAnd
     *
     * @param lookhead
     */
    public void onBitAnd(Token<?> lookhead);

    /**
     * onBitXor
     *
     * @param lookhead
     */
    public void onBitXor(Token<?> lookhead);

    /**
     * onBitNot
     *
     * @param lookhead
     */
    public void onBitNot(Token<?> lookhead);

    /**
     * onAdd
     *
     * @param lookhead
     */
    public void onAdd(Token<?> lookhead);

    /**
     * onSub
     *
     * @param lookhead
     */
    public void onSub(Token<?> lookhead);

    /**
     * onMult
     *
     * @param lookhead
     */
    public void onMult(Token<?> lookhead);

    /**
     * onDiv
     *
     * @param lookhead
     */
    public void onDiv(Token<?> lookhead);

    /**
     * onAndLeft
     *
     * @param lookhead
     */
    public void onAndLeft(Token<?> lookhead);

    /**
     * onAndRight
     *
     * @param lookhead
     */
    public void onAndRight(Token<?> lookhead);

    /**
     * onTernaryBoolean
     *
     * @param lookhead
     */
    public void onTernaryBoolean(Token<?> lookhead);

    /**
     * onTernaryLeft
     *
     * @param lookhead
     */
    public void onTernaryLeft(Token<?> lookhead);

    /**
     * onTernaryRight
     *
     * @param lookhead
     */
    public void onTernaryRight(Token<?> lookhead);

    /**
     * onTernaryEnd
     *
     * @param lookhead
     */
    public void onTernaryEnd(Token<?> lookhead);

    /**
     * onJoinLeft
     *
     * @param lookhead
     */
    public void onJoinLeft(Token<?> lookhead);

    /**
     * onJoinRight
     *
     * @param lookhead
     */
    public void onJoinRight(Token<?> lookhead);

    /**
     * onEq
     *
     * @param lookhead
     */
    public void onEq(Token<?> lookhead);

    /**
     * onMatch
     *
     * @param lookhead
     */
    public void onMatch(Token<?> lookhead);

    /**
     * onNeq
     *
     * @param lookhead
     */
    public void onNeq(Token<?> lookhead);

    /**
     * onLt
     *
     * @param lookhead
     */
    public void onLt(Token<?> lookhead);

    /**
     * onLe
     *
     * @param lookhead
     */
    public void onLe(Token<?> lookhead);

    /**
     * onGt
     *
     * @param lookhead
     */
    public void onGt(Token<?> lookhead);

    /**
     * onGe
     *
     * @param lookhead
     */
    public void onGe(Token<?> lookhead);

    /**
     * onMod
     *
     * @param lookhead
     */
    public void onMod(Token<?> lookhead);

    /**
     * onNot
     *
     * @param lookhead
     */
    public void onNot(Token<?> lookhead);

    /**
     * onNeg
     *
     * @param lookhead
     */
    public void onNeg(Token<?> lookhead);

    /**
     * getResult
     *
     * @return
     */
    public Expression getResult();

    /**
     * onConstant
     *
     * @param lookhead
     */
    public void onConstant(Token<?> lookhead);

    /**
     * onMethodName
     *
     * @param lookhead
     */
    public void onMethodName(Token<?> lookhead);

    /**
     * onMethodParameter
     *
     * @param lookhead
     */
    public void onMethodParameter(Token<?> lookhead);

    /**
     * onMethodInvoke
     *
     * @param lookhead
     * @param params
     */
    public void onMethodInvoke(Token<?> lookhead, List<FunctionArgument> params);

    /**
     * onLambdaDefineStart
     *
     * @param lookhead
     */
    public void onLambdaDefineStart(Token<?> lookhead);

    /**
     * onLambdaArgument
     *
     * @param lookhead
     */
    public void onLambdaArgument(Token<?> lookhead);

    /**
     * onLambdaBodyStart
     *
     * @param lookhead
     */
    public void onLambdaBodyStart(Token<?> lookhead);

    /**
     * onLambdaBodyEnd
     *
     * @param lookhead
     */
    public void onLambdaBodyEnd(Token<?> lookhead);

    /**
     * onArray
     *
     * @param lookhead
     */
    public void onArray(Token<?> lookhead);

    /**
     * onArrayIndexStart
     *
     * @param token
     */
    public void onArrayIndexStart(Token<?> token);

    /**
     * onArrayIndexEnd
     *
     * @param lookhead
     */
    public void onArrayIndexEnd(Token<?> lookhead);

}
