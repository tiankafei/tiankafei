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
package com.googlecode.aviator.runtime.type;

import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.utils.TypeUtils;

import java.util.Map;


/**
 * Aviator root object
 *
 * @author dennis
 */
public abstract class BaseAviatorObject {

    /**
     * compare
     *
     * @param other
     * @param env
     * @return
     */
    public abstract int compare(BaseAviatorObject other, Map<String, Object> env);

    /**
     * getAviatorType
     *
     * @return
     */
    public abstract AviatorType getAviatorType();


    /**
     * Returns true if the aviator object is null.
     *
     * @return
     * @since 3.0.0
     */
    public boolean isNull(Map<String, Object> env) {
        return this.getValue(env) == null;
    }


    public BaseAviatorObject match(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(this.desc(env) + " doesn't support match operation '=~'");
    }


    public BaseAviatorObject neg(Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                this.desc(env) + " doesn't support negative operation '-'");
    }


    public BaseAviatorObject not(Map<String, Object> env) {
        throw new ExpressionRuntimeException(this.desc(env) + " doesn't support not operation '!'");
    }


    public String desc(Map<String, Object> env) {
        return "<" + this.getAviatorType() + ", " + this.getValue(env) + ">";
    }

    /**
     * getValue
     *
     * @param env
     * @return
     */
    public abstract Object getValue(Map<String, Object> env);


    public BaseAviatorObject add(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not add " + this.desc(env) + " with " + other.desc(env));
    }


    public BaseAviatorObject bitAnd(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not bitAnd " + this.desc(env) + " with " + other.desc(env));
    }


    public BaseAviatorObject bitOr(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not bitOr " + this.desc(env) + " with " + other.desc(env));
    }


    public BaseAviatorObject bitXor(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not bitXor " + this.desc(env) + " with " + other.desc(env));
    }


    public BaseAviatorObject shiftRight(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not shiftRight " + this.desc(env) + " with " + other.desc(env));
    }


    public BaseAviatorObject shiftLeft(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not shiftLeft " + this.desc(env) + " with " + other.desc(env));
    }


    public BaseAviatorObject unsignedShiftRight(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not unsignedShiftRight " + this.desc(env) + " with " + other.desc(env));
    }


    public BaseAviatorObject bitNot(Map<String, Object> env) {
        throw new ExpressionRuntimeException(this.desc(env) + " doesn't support not operation '^'");
    }


    public BaseAviatorObject sub(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not sub " + this.desc(env) + " with " + other.desc(env));
    }


    public BaseAviatorObject mod(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not mod " + this.desc(env) + " with " + other.desc(env));
    }


    public BaseAviatorObject div(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not div " + this.desc(env) + " with " + other.desc(env));
    }


    public BaseAviatorObject mult(BaseAviatorObject other, Map<String, Object> env) {
        throw new ExpressionRuntimeException(
                "Could not mult " + this.desc(env) + " with " + other.desc(env));
    }


    public Number numberValue(Map<String, Object> env) {
        if (!(this.getValue(env) instanceof Number)) {
            throw new ExpressionRuntimeException(this.desc(env) + " is not a number value");
        }
        return (Number) this.getValue(env);
    }


    public String stringValue(Map<String, Object> env) {
        Object value = this.getValue(env);
        if (!(TypeUtils.isString(value))) {
            throw new ExpressionRuntimeException(this.desc(env) + " is not a string value");
        }
        return String.valueOf(value);
    }


    public boolean booleanValue(Map<String, Object> env) {
        if (!(this.getValue(env) instanceof Boolean)) {
            throw new ExpressionRuntimeException(this.desc(env) + " is not a boolean value");
        }
        return (Boolean) this.getValue(env);
    }


    /**
     * Access array or list element
     *
     * @param env
     * @param indexObject
     * @return
     */
    public BaseAviatorObject getElement(Map<String, Object> env, BaseAviatorObject indexObject) {
        throw new ExpressionRuntimeException(this.desc(env) + " is not a array");
    }
}
