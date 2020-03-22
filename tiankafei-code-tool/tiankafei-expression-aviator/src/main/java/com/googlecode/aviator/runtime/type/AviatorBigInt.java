package com.googlecode.aviator.runtime.type;

import com.googlecode.aviator.runtime.RuntimeUtils;

import java.math.BigInteger;
import java.util.Map;


/**
 * Aviator Big Integer
 *
 * @author dennis<killme2008 @ gmail.com>
 * @since 2.3.0
 */
public class AviatorBigInt extends AviatorLong {

    private static class BigIntCache {
        private BigIntCache() {
        }

        static final AviatorBigInt[] CACHE = new AviatorBigInt[256];

        static {
            for (long i = 0; i < CACHE.length; i++) {
                CACHE[(int) i] = new AviatorBigInt(BigInteger.valueOf(i - 128));
            }
        }
    }


    @Override
    public Object getValue(Map<String, Object> env) {
        return this.number;
    }


    @Override
    public long longValue() {
        return this.number.longValue();
    }


    @Override
    public double doubleValue() {
        return this.number.doubleValue();
    }


    public AviatorBigInt(Number number) {
        super(number);
    }


    public static final AviatorBigInt valueOf(BigInteger v) {
        return new AviatorBigInt(v);
    }


    public static final AviatorBigInt valueOf(String v) {
        return new AviatorBigInt(new BigInteger(v));
    }


    public static final AviatorBigInt valueOf(long l) {
        final int offset = 128;
        int number128 = -128;
        int number127 = 127;
        if (l >= number128 && l <= number127) {
            return BigIntCache.CACHE[(int) l + offset];
        }
        return valueOf(BigInteger.valueOf(l));
    }


    @Override
    public BaseAviatorObject neg(Map<String, Object> env) {
        return AviatorBigInt.valueOf(this.toBigInt().negate());
    }


    @Override
    public BaseAviatorObject innerSub(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Decimal:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).subtract(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
            case Double:
                return AviatorDouble.valueOf(this.doubleValue() - other.doubleValue());
            default:
                return AviatorBigInt.valueOf(this.toBigInt().subtract(other.toBigInt()));
        }
    }


    @Override
    public BaseAviatorObject innerMult(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Decimal:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).multiply(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
            case Double:
                return AviatorDouble.valueOf(this.doubleValue() * other.doubleValue());
            default:
                return AviatorBigInt.valueOf(this.toBigInt().multiply(other.toBigInt()));
        }
    }


    @Override
    public BaseAviatorObject innerMod(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Decimal:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).remainder(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
            case Double:
                return AviatorDouble.valueOf(this.doubleValue() % other.doubleValue());
            default:
                return AviatorBigInt.valueOf(this.toBigInt().mod(other.toBigInt()));
        }
    }


    @Override
    public BaseAviatorObject innerDiv(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Decimal:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).divide(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
            case Double:
                return AviatorDouble.valueOf(this.doubleValue() / other.doubleValue());
            default:
                return AviatorBigInt.valueOf(this.toBigInt().divide(other.toBigInt()));
        }
    }


    @Override
    public BaseAviatorNumber innerAdd(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Decimal:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).add(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
            case Double:
                return AviatorDouble.valueOf(this.doubleValue() + other.doubleValue());
            default:
                return AviatorBigInt.valueOf(this.toBigInt().add(other.toBigInt()));
        }
    }


    @Override
    public int innerCompare(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Decimal:
                return this.toDecimal(env).compareTo(other.toDecimal(env));
            case Double:
                return Double.compare(this.doubleValue(), other.doubleValue());
            default:
                return this.toBigInt().compareTo(other.toBigInt());
        }
    }


    @Override
    protected BaseAviatorObject innerBitAnd(BaseAviatorObject other) {
        return AviatorBigInt.valueOf(this.toBigInt().and(((BaseAviatorNumber) other).toBigInt()));
    }


    @Override
    protected BaseAviatorObject innerBitOr(BaseAviatorObject other) {
        return AviatorBigInt.valueOf(this.toBigInt().or(((BaseAviatorNumber) other).toBigInt()));
    }


    @Override
    protected BaseAviatorObject innerBitXor(BaseAviatorObject other) {
        return AviatorBigInt.valueOf(this.toBigInt().xor(((BaseAviatorNumber) other).toBigInt()));
    }


    @Override
    protected BaseAviatorObject innerShiftLeft(BaseAviatorObject other) {
        this.ensureLong(other);
        return AviatorBigInt
                .valueOf(this.toBigInt().shiftLeft((int) ((BaseAviatorNumber) other).longValue()));
    }


    @Override
    protected BaseAviatorObject innerShiftRight(BaseAviatorObject other) {
        this.ensureLong(other);
        return AviatorBigInt
                .valueOf(this.toBigInt().shiftRight((int) ((BaseAviatorNumber) other).longValue()));
    }


    @Override
    protected BaseAviatorObject innerUnsignedShiftRight(BaseAviatorObject other) {
        return this.innerShiftRight(other);
    }


    @Override
    public AviatorType getAviatorType() {
        return AviatorType.BigInt;
    }

}
