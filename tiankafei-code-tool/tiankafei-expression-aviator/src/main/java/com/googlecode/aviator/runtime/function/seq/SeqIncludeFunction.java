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
package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;


/**
 * include(seq,obj) function to check if seq contains object
 *
 * @author dennis
 */
public class SeqIncludeFunction extends AbstractFunction {

    @Override
    public BaseAviatorObject call(final Map<String, Object> env, final BaseAviatorObject arg1,
                                  final BaseAviatorObject arg2) {
        Object first = arg1.getValue(env);
        if (first == null) {
            throw new NullPointerException("null seq");
        }
        Class<?> clazz = first.getClass();
        boolean contains = false;
        if (Collection.class.isAssignableFrom(clazz)) {
            Collection<?> seq = (Collection<?>) first;
            try {
                for (Object obj : seq) {
                    if (new AviatorRuntimeJavaType(obj).compare(arg2, env) == 0) {
                        contains = true;
                        break;
                    }
                }
            } catch (Exception e) {
                RuntimeUtils.printStackTrace(env, e);
                return AviatorBoolean.FALSE;
            }
        } else if (clazz.isArray()) {
            // Object[] seq = (Object[]) first;
            try {
                int length = Array.getLength(first);
                for (int i = 0; i < length; i++) {
                    Object obj = Array.get(first, i);
                    if (new AviatorRuntimeJavaType(obj).compare(arg2, env) == 0) {
                        contains = true;
                        break;
                    }
                }
            } catch (Exception e) {
                RuntimeUtils.printStackTrace(env, e);
                return AviatorBoolean.FALSE;
            }
        } else {
            throw new IllegalArgumentException(arg1.desc(env) + " is not a seq collection");
        }

        return AviatorBoolean.valueOf(contains);
    }


    @Override
    public String getName() {
        return "include";
    }

}
