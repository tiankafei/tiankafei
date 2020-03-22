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

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * sort(list) function to sort java.util.List or array,return a sorted duplicate object
 *
 * @author dennis
 */
public class SeqSortFunction extends AbstractFunction {

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1) {

        Object first = arg1.getValue(env);
        if (first == null) {
            throw new NullPointerException("null seq");
        }
        Class<?> clazz = first.getClass();

        if (List.class.isAssignableFrom(clazz)) {
            List<?> list = (List<?>) first;
            Object[] a = list.toArray();
            Arrays.sort(a);
            return new AviatorRuntimeJavaType(Arrays.asList(a));
        } else if (clazz.isArray()) {
            int length = Array.getLength(first);
            Object[] dup = (Object[]) Array.newInstance(first.getClass().getComponentType(), length);
            for (int i = 0; i < length; i++) {
                dup[i] = Array.get(first, i);
            }
            Arrays.sort(dup);
            return new AviatorRuntimeJavaType(dup);
        } else {
            throw new IllegalArgumentException(arg1.desc(env) + " is not a seq");
        }
    }


    @Override
    public String getName() {
        return "sort";
    }

}
