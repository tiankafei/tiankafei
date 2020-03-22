package com.googlecode.aviator.runtime.type;

import com.googlecode.aviator.runtime.RuntimeUtils;

import java.math.BigDecimal;
import java.util.Map;


/**
 * Aviator Big Decimal
 *
 * @author dennis<killme2008 @ gmail.com>
 * @since 2.3.0
 */
public class AviatorDecimal extends BaseAviatorNumber {

    public AviatorDecimal(Number number) {
        super(number);
    }


    public static final AviatorDecimal valueOf(BigDecimal d) {
        return new AviatorDecimal(d);
    }


    public static final AviatorDecimal valueOf(Map<String, Object> env, String d) {
        return new AviatorDecimal(new BigDecimal(d, RuntimeUtils.getMathContext(env)));
    }


    @Override
    public BaseAviatorObject innerSub(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Double:
                return AviatorDouble.valueOf(this.doubleValue() - other.doubleValue());
            default:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).subtract(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
        }
    }


    @Override
    public BaseAviatorObject neg(Map<String, Object> env) {
        return AviatorDecimal.valueOf(this.toDecimal(env).negate());
    }


    @Override
    public BaseAviatorObject innerMult(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Double:
                return AviatorDouble.valueOf(this.doubleValue() * other.doubleValue());
            default:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).multiply(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
        }
    }


    @Override
    public BaseAviatorObject innerMod(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Double:
                return AviatorDouble.valueOf(this.doubleValue() % other.doubleValue());
            default:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).remainder(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
        }
    }


    @Override
    public BaseAviatorObject innerDiv(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Double:
                return AviatorDouble.valueOf(this.doubleValue() / other.doubleValue());
            default:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).divide(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
        }
    }


    @Override
    public BaseAviatorNumber innerAdd(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Double:
                return AviatorDouble.valueOf(this.doubleValue() + other.doubleValue());
            default:
                return AviatorDecimal.valueOf(
                        this.toDecimal(env).add(other.toDecimal(env), RuntimeUtils.getMathContext(env)));
        }
    }


    @Override
    public int innerCompare(Map<String, Object> env, BaseAviatorNumber other) {
        switch (other.getAviatorType()) {
            case Double:
                return Double.compare(this.doubleValue(), other.doubleValue());
            default:
                return this.toDecimal(env).compareTo(other.toDecimal(env));
        }

    }


    @Override
    public AviatorType getAviatorType() {
        return AviatorType.Decimal;
    }

}
