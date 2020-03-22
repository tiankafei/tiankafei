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
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.utils.TypeUtils;

import java.util.Map;


/**
 * Aviator long type
 *
 * @author dennis
 */
public class AviatorLong extends BaseAviatorNumber {

    private static class LongCache {
        private LongCache() {
        }

        static final AviatorLong[] CACHE = new AviatorLong[256];

        static {
            for (long i = 0; i < CACHE.length; i++) {
                CACHE[(int) i] = new AviatorLong(i - 128);
            }
        }
    }

    AviatorLong(long i) {
        super(i);
    }


    AviatorLong(Number number) {
        super(number);

    }


    public static AviatorLong valueOf(long l) {
        final int offset = 128;
        int number128 = -128;
        int number127 = 127;
        if (l >= number128 && l <= number127) {
            return LongCache.CACHE[(int) l + offset];
        }
        return new AviatorLong(l);
    }


    public static AviatorLong valueOf(Long l) {
        return valueOf(l.longValue());
    }


    @Override
    public BaseAviatorObject neg(Map<String, Object> env) {
        return AviatorLong.valueOf(-this.longValue);
    }


    @Override
    public int innerCompare(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case BigInt:
                return this.toBigInt().compareTo(other.toBigInt());
            case Decimal:
                return this.toDecimal(env).compareTo(other.toDecimal(env));
            case Long:
                return TypeUtils.comapreLong(this.longValue(), other.longValue());
            case Double:
                return Double.compare(this.doubleValue(), other.doubleValue());
            default:
                throw new ExpressionRuntimeException(
                        "Could not compare " + this.desc(env) + " with " + other.desc(env));
        }
    }


    @Override
    public BaseAviatorObject innerDiv(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case BigInt:
                return AviatorBigInt.valueOf(this.toBigInt().divide(other.toBigInt()));
            case Decimal:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).divide(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
            case Long:
                return AviatorLong.valueOf(this.longValue / other.longValue());
            default:
                return AviatorDouble.valueOf(this.longValue / other.doubleValue());
        }
    }


    @Override
    public BaseAviatorObject innerAdd(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case BigInt:
                return AviatorBigInt.valueOf(this.toBigInt().add(other.toBigInt()));
            case Decimal:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).add(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
            case Long:
                return AviatorLong.valueOf(this.longValue + other.longValue());
            default:
                return new AviatorDouble(this.longValue + other.doubleValue());
        }
    }


    @Override
    public BaseAviatorObject innerMod(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case BigInt:
                return AviatorBigInt.valueOf(this.toBigInt().mod(other.toBigInt()));
            case Decimal:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).remainder(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
            case Long:
                return AviatorLong.valueOf(this.longValue % other.longValue());
            default:
                return new AviatorDouble(this.longValue % other.doubleValue());
        }
    }


    @Override
    public BaseAviatorObject innerMult(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case BigInt:
                return AviatorBigInt.valueOf(this.toBigInt().multiply(other.toBigInt()));
            case Decimal:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).multiply(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
            case Long:
                return AviatorLong.valueOf(this.longValue * other.longValue());
            default:
                return new AviatorDouble(this.longValue * other.doubleValue());
        }
    }


    protected void ensureLong(BaseAviatorObject other) {
        if (other.getAviatorType() != AviatorType.Long) {
            throw new ExpressionRuntimeException(
                    other + " is not long type,could not be used as a bit operand.");
        }
    }


    @Override
    public BaseAviatorObject bitAnd(BaseAviatorObject other, Map<String, Object> env) {
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                return this.innerBitAnd(other);
            case JavaType:
                AviatorJavaType otherJavaType = (AviatorJavaType) other;
                final Object otherValue = otherJavaType.getValue(env);
                if (otherValue instanceof Number) {
                    return this.innerBitAnd(BaseAviatorNumber.valueOf(otherValue));
                } else {
                    return super.bitAnd(other, env);
                }
            default:
                return super.bitAnd(other, env);
        }
    }


    protected BaseAviatorObject innerBitAnd(BaseAviatorObject other) {
        this.ensureLong(other);
        AviatorLong otherLong = (AviatorLong) other;
        return AviatorLong.valueOf(this.longValue & otherLong.longValue());
    }


    protected BaseAviatorObject innerBitOr(BaseAviatorObject other) {
        this.ensureLong(other);
        AviatorLong otherLong = (AviatorLong) other;
        return AviatorLong.valueOf(this.longValue | otherLong.longValue());
    }


    protected BaseAviatorObject innerBitXor(BaseAviatorObject other) {
        this.ensureLong(other);
        AviatorLong otherLong = (AviatorLong) other;
        return AviatorLong.valueOf(this.longValue ^ otherLong.longValue());
    }


    protected BaseAviatorObject innerShiftLeft(BaseAviatorObject other) {
        this.ensureLong(other);
        AviatorLong otherLong = (AviatorLong) other;
        return AviatorLong.valueOf(this.longValue << otherLong.longValue());
    }


    protected BaseAviatorObject innerShiftRight(BaseAviatorObject other) {
        this.ensureLong(other);
        AviatorLong otherLong = (AviatorLong) other;
        return AviatorLong.valueOf(this.longValue >> otherLong.longValue());
    }


    protected BaseAviatorObject innerUnsignedShiftRight(BaseAviatorObject other) {
        this.ensureLong(other);
        AviatorLong otherLong = (AviatorLong) other;
        return AviatorLong.valueOf(this.longValue >>> otherLong.longValue());
    }


    @Override
    public BaseAviatorObject bitNot(Map<String, Object> env) {
        return AviatorLong.valueOf(~this.longValue);
    }


    @Override
    public Object getValue(Map<String, Object> env) {
        return this.longValue;
    }


    @Override
    public long longValue() {
        return this.longValue;
    }


    @Override
    public double doubleValue() {
        return this.longValue;
    }


    @Override
    public BaseAviatorObject bitOr(BaseAviatorObject other, Map<String, Object> env) {
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                return this.innerBitOr(other);
            case JavaType:
                AviatorJavaType otherJavaType = (AviatorJavaType) other;
                final Object otherValue = otherJavaType.getValue(env);
                if (otherValue instanceof Number) {
                    return this.innerBitOr(BaseAviatorNumber.valueOf(otherValue));
                } else {
                    return super.bitOr(other, env);
                }
            default:
                return super.bitOr(other, env);
        }
    }


    @Override
    public BaseAviatorObject bitXor(BaseAviatorObject other, Map<String, Object> env) {
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                return this.innerBitXor(other);
            case JavaType:
                AviatorJavaType otherJavaType = (AviatorJavaType) other;
                final Object otherValue = otherJavaType.getValue(env);
                if (otherValue instanceof Number) {
                    return this.innerBitXor(BaseAviatorNumber.valueOf(otherValue));
                } else {
                    return super.bitXor(other, env);
                }
            default:
                return super.bitXor(other, env);
        }
    }


    @Override
    public BaseAviatorObject shiftLeft(BaseAviatorObject other, Map<String, Object> env) {
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                return this.innerShiftLeft(other);
            case JavaType:
                AviatorJavaType otherJavaType = (AviatorJavaType) other;
                final Object otherValue = otherJavaType.getValue(env);
                if (otherValue instanceof Number) {
                    return this.innerShiftLeft(BaseAviatorNumber.valueOf(otherValue));
                } else {
                    return super.shiftLeft(other, env);
                }
            default:
                return super.shiftLeft(other, env);
        }
    }


    @Override
    public BaseAviatorObject shiftRight(BaseAviatorObject other, Map<String, Object> env) {
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                return this.innerShiftRight(other);
            case JavaType:
                AviatorJavaType otherJavaType = (AviatorJavaType) other;
                final Object otherValue = otherJavaType.getValue(env);
                if (otherValue instanceof Number) {
                    return this.innerShiftRight(BaseAviatorNumber.valueOf(otherValue));
                } else {
                    return super.shiftRight(other, env);
                }
            default:
                return super.shiftRight(other, env);
        }
    }


    @Override
    public BaseAviatorObject unsignedShiftRight(BaseAviatorObject other, Map<String, Object> env) {
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                return this.innerUnsignedShiftRight(other);
            case JavaType:
                AviatorJavaType otherJavaType = (AviatorJavaType) other;
                final Object otherValue = otherJavaType.getValue(env);
                if (otherValue instanceof Number) {
                    return this.innerUnsignedShiftRight(BaseAviatorNumber.valueOf(otherValue));
                } else {
                    return super.unsignedShiftRight(other, env);
                }
            default:
                return super.unsignedShiftRight(other, env);
        }
    }


    @Override
    public BaseAviatorObject innerSub(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case BigInt:
                return AviatorBigInt.valueOf(this.toBigInt().subtract(other.toBigInt()));
            case Decimal:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).subtract(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
            case Long:
                return AviatorLong.valueOf(this.longValue - other.longValue());
            default:
                return new AviatorDouble(this.longValue - other.doubleValue());
        }
    }


    @Override
    public AviatorType getAviatorType() {
        return AviatorType.Long;
    }

}
