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

import com.googlecode.aviator.Options;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.utils.TypeUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Aviator variable
 *
 * @author dennis
 */
public class AviatorJavaType extends BaseAviatorObject {

    final private String name;

    @Override
    public AviatorType getAviatorType() {
        return AviatorType.JavaType;
    }

    public String getName() {
        return this.name;
    }

    public AviatorJavaType(String name) {
        super();
        this.name = name;
    }

    @Override
    public BaseAviatorObject div(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                if (value instanceof Number) {
                    BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
                    return aviatorNumber.div(other, env);
                } else {
                    return super.div(other, env);
                }
            case JavaType:
                if (value instanceof Number) {
                    BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(value);
                    return thisAviatorNumber.div(other, env);
                } else {
                    return super.div(other, env);
                }
            default:
                return super.div(other, env);
        }
    }

    @Override
    public BaseAviatorObject bitAnd(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                if (value instanceof Number) {
                    BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
                    return aviatorNumber.bitAnd(other, env);
                } else {
                    return super.bitAnd(other, env);
                }
            case JavaType:
                if (value instanceof Number) {
                    BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(value);
                    return thisAviatorNumber.bitAnd(other, env);
                } else {
                    return super.bitAnd(other, env);
                }
            default:
                return super.bitAnd(other, env);
        }
    }

    @Override
    public BaseAviatorObject bitNot(Map<String, Object> env) {
        final Object value = this.getValue(env);
        if (value instanceof Number) {
            return BaseAviatorNumber.valueOf(value).bitNot(env);
        } else {
            return super.bitNot(env);
        }
    }

    @Override
    public BaseAviatorObject bitOr(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                if (value instanceof Number) {
                    BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
                    return aviatorNumber.bitOr(other, env);
                } else {
                    return super.bitOr(other, env);
                }
            case JavaType:
                if (value instanceof Number) {
                    BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(value);
                    return thisAviatorNumber.bitOr(other, env);
                } else {
                    return super.bitOr(other, env);
                }
            default:
                return super.bitOr(other, env);
        }
    }

    @Override
    public BaseAviatorObject bitXor(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                if (value instanceof Number) {
                    BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
                    return aviatorNumber.bitXor(other, env);
                } else {
                    return super.bitXor(other, env);
                }
            case JavaType:
                if (value instanceof Number) {
                    BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(value);
                    return thisAviatorNumber.bitXor(other, env);
                } else {
                    return super.bitXor(other, env);
                }
            default:
                return super.bitXor(other, env);
        }
    }

    @Override
    public BaseAviatorObject shiftLeft(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                if (value instanceof Number) {
                    BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
                    return aviatorNumber.shiftLeft(other, env);
                } else {
                    return super.shiftLeft(other, env);
                }
            case JavaType:
                if (value instanceof Number) {
                    BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(value);
                    return thisAviatorNumber.shiftLeft(other, env);
                } else {
                    return super.shiftLeft(other, env);
                }
            default:
                return super.shiftLeft(other, env);
        }
    }

    @Override
    public BaseAviatorObject shiftRight(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                if (value instanceof Number) {
                    BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
                    return aviatorNumber.shiftRight(other, env);
                } else {
                    return super.shiftRight(other, env);
                }
            case JavaType:
                if (value instanceof Number) {
                    BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(value);
                    return thisAviatorNumber.shiftRight(other, env);
                } else {
                    return super.shiftRight(other, env);
                }
            default:
                return super.shiftRight(other, env);
        }
    }

    @Override
    public BaseAviatorObject unsignedShiftRight(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                if (value instanceof Number) {
                    BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
                    return aviatorNumber.unsignedShiftRight(other, env);
                } else {
                    return super.unsignedShiftRight(other, env);
                }
            case JavaType:
                if (value instanceof Number) {
                    BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(value);
                    return thisAviatorNumber.unsignedShiftRight(other, env);
                } else {
                    return super.unsignedShiftRight(other, env);
                }
            default:
                return super.unsignedShiftRight(other, env);
        }
    }

    @Override
    public Object getValue(Map<String, Object> env) {

        if (env != null) {
            String point = ".";
            if (this.name.contains(point) && RuntimeUtils.getInstance(env)
                    .getOptionValue(Options.ENABLE_PROPERTY_SYNTAX_SUGAR).bool) {
                return getProperty(env);
            }
            return env.get(this.name);
        }
        return null;
    }

    public BaseAviatorObject setValue(BaseAviatorObject value, Map<String, Object> env) {
        String point = ".";
        if (this.name.contains(point)) {
            throw new ExpressionRuntimeException("Can't assignment value to `" + this.name + "`");
        }

        if (RuntimeUtils.getInstance(env).getOptionValue(Options.DISABLE_ASSIGNMENT).bool) {
            throw new ExpressionRuntimeException("Disabled variable assignment.");
        }

        Object v = value.getValue(env);
        env.put(this.name, v);
        return new AviatorRuntimeJavaType(v);
    }

    @SuppressWarnings("unchecked")
    private Object getProperty(Map<String, Object> env) {
        try {
            String[] names = this.name.split("\\.");
            Map<String, Object> innerEnv = env;
            for (int i = 0; i < names.length; i++) {
                // Fast path for nested map.
                Object val = innerEnv.get(names[i]);

                if (i == names.length - 1) {
                    return val;
                }

                // fallback to property utils
                if (!(val instanceof Map)) {
                    return PropertyUtils.getProperty(env, this.name);
                }

                innerEnv = (Map<String, Object>) val;
            }
            return PropertyUtils.getProperty(env, this.name);

        } catch (Throwable t) {
            if (RuntimeUtils.getInstance(env).getOptionValue(Options.TRACE_EVAL).bool) {
                t.printStackTrace();
            }
            if (RuntimeUtils.getInstance(env).getOptionValue(Options.NIL_WHEN_PROPERTY_NOT_FOUND).bool) {
                return null;
            } else {
                throw new ExpressionRuntimeException("Could not find variable " + this.name, t);
            }
        }
    }

    @Override
    public BaseAviatorObject mod(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                if (value instanceof Number) {
                    BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
                    return aviatorNumber.mod(other, env);
                } else {
                    return super.mod(other, env);
                }
            case JavaType:
                if (value instanceof Number) {
                    BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(value);
                    return thisAviatorNumber.mod(other, env);
                } else {
                    return super.mod(other, env);
                }
            default:
                return super.mod(other, env);
        }
    }

    @Override
    public BaseAviatorObject sub(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                if (value instanceof Number) {
                    BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
                    return aviatorNumber.sub(other, env);
                } else {
                    return super.sub(other, env);
                }
            case JavaType:
                if (value instanceof Number) {
                    BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(value);
                    return thisAviatorNumber.sub(other, env);
                } else {
                    return super.sub(other, env);
                }
            default:
                return super.sub(other, env);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compare(BaseAviatorObject other, Map<String, Object> env) {
        if (this == other) {
            return 0;
        }
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                BaseAviatorNumber aviatorNumber = (BaseAviatorNumber) other;
                return -aviatorNumber.compare(this, env);
            case String:
                AviatorString aviatorString = (AviatorString) other;
                return -aviatorString.compare(this, env);
            case Boolean:
                AviatorBoolean aviatorBoolean = (AviatorBoolean) other;
                return -aviatorBoolean.compare(this, env);
            case JavaType:

                AviatorJavaType otherJavaType = (AviatorJavaType) other;
                final Object thisValue = this.getValue(env);
                final Object otherValue = otherJavaType.getValue(env);
                if (thisValue == null) {
                    return AviatorNil.NIL.compare(other, env);
                }
                if (thisValue.equals(otherValue)) {
                    return 0;
                } else {
                    if (thisValue instanceof Number) {
                        BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(thisValue);
                        return thisAviatorNumber.compare(other, env);
                    } else if (TypeUtils.isString(thisValue)) {
                        AviatorString thisAviatorString = new AviatorString(String.valueOf(thisValue));
                        return thisAviatorString.compare(other, env);
                    } else if (thisValue instanceof Boolean) {
                        AviatorBoolean thisAviatorBoolean = AviatorBoolean.valueOf((Boolean) thisValue);
                        return thisAviatorBoolean.compare(other, env);
                    } else if (thisValue instanceof Date && otherValue instanceof String) {
                        // This is date,other is string
                        return this.tryCompareDate(thisValue, otherValue);
                    } else {
                        try {
                            return ((Comparable<Object>) thisValue).compareTo(otherValue);
                        } catch (Throwable t) {
                            throw new ExpressionRuntimeException("Compare " + this + " with " + other + " error",
                                    t);
                        }
                    }
                }
            case Nil:
                // Any object is greater than nil except nil
                if (this.getValue(env) == null) {
                    return 0;
                } else {
                    return 1;
                }
            default:
                throw new ExpressionRuntimeException("Unknow aviator type");
        }
    }

    private int tryCompareDate(final Object thisValue, final Object otherValue) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
            Date otherDate = simpleDateFormat.parse((String) otherValue);
            return ((Date) thisValue).compareTo(otherDate);
        } catch (Throwable t) {
            throw new ExpressionRuntimeException("Compare date error", t);
        }
    }

    @Override
    public BaseAviatorObject mult(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        switch (other.getAviatorType()) {
            case BigInt:
            case Decimal:
            case Long:
            case Double:
                if (value instanceof Number) {
                    BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
                    return aviatorNumber.mult(other, env);
                } else {
                    return super.mult(other, env);
                }
            case JavaType:
                if (value instanceof Number) {
                    BaseAviatorNumber thisAviatorNumber = BaseAviatorNumber.valueOf(value);
                    return thisAviatorNumber.mult(other, env);
                } else {
                    return super.mult(other, env);
                }
            default:
                return super.mult(other, env);
        }
    }

    @Override
    public BaseAviatorObject neg(Map<String, Object> env) {
        final Object value = this.getValue(env);
        if (value instanceof Number) {
            return BaseAviatorNumber.valueOf(value).neg(env);
        } else {
            return super.neg(env);
        }
    }

    @Override
    public BaseAviatorObject not(Map<String, Object> env) {
        final Object value = this.getValue(env);
        if (value instanceof Boolean) {
            return AviatorBoolean.valueOf((Boolean) value).not(env);
        } else {
            return super.not(env);
        }
    }

    /**
     * Access array or list element
     *
     * @param env
     * @param indexObject
     * @return
     */
    @Override
    public BaseAviatorObject getElement(Map<String, Object> env, BaseAviatorObject indexObject) {
        Object thisValue = this.getValue(env);
        if (!thisValue.getClass().isArray() && !(thisValue instanceof List)) {
            throw new ExpressionRuntimeException(
                    this.desc(env) + " is not a array or list,could not use [] to get element");
        }
        Object indexValue = indexObject.getValue(env);
        if (!this.isInteger(indexValue)) {
            throw new IllegalArgumentException("Illegal index " + indexObject.desc(env));
        }
        int index = ((Number) indexValue).intValue();
        if (thisValue.getClass().isArray()) {
            return new AviatorRuntimeJavaType(Array.get(thisValue, index));
        } else {
            return new AviatorRuntimeJavaType(((List<?>) thisValue).get(index));
        }
    }

    private boolean isInteger(Object value) {
        return value instanceof Long && ((Long) value).longValue() < Integer.MAX_VALUE
                || value instanceof Integer || value instanceof Short || value instanceof Byte;
    }

    @Override
    public BaseAviatorObject add(BaseAviatorObject other, Map<String, Object> env) {
        final Object value = this.getValue(env);
        if (value instanceof Number) {
            BaseAviatorNumber aviatorNumber = BaseAviatorNumber.valueOf(value);
            return aviatorNumber.add(other, env);
        } else if (TypeUtils.isString(value)) {
            AviatorString aviatorString = new AviatorString(String.valueOf(value));
            return aviatorString.add(other, env);
        } else if (value instanceof Boolean) {
            return AviatorBoolean.valueOf((Boolean) value).add(other, env);
        } else {
            return super.add(other, env);
        }
    }

    @Override
    public String desc(Map<String, Object> env) {
        Object value = this.getValue(env);
        return "<" + this.getAviatorType() + ", " + value + ", "
                + (value == null ? "null" : value.getClass().getSimpleName()) + ">";
    }

}
