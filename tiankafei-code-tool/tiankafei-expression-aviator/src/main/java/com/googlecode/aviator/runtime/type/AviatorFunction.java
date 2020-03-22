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

import java.util.Map;


/**
 * A aviator function,all functions must implement this interface
 *
 * @author dennis
 */
public interface AviatorFunction {
    /**
     * Get the function name
     *
     * @return
     */
    public String getName();

    /**
     * call function
     *
     * @param env Variable environment
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3);


    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @param arg12
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @param arg12
     * @param arg13
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @param arg12
     * @param arg13
     * @param arg14
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @param arg12
     * @param arg13
     * @param arg14
     * @param arg15
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @param arg12
     * @param arg13
     * @param arg14
     * @param arg15
     * @param arg16
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @param arg12
     * @param arg13
     * @param arg14
     * @param arg15
     * @param arg16
     * @param arg17
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @param arg12
     * @param arg13
     * @param arg14
     * @param arg15
     * @param arg16
     * @param arg17
     * @param arg18
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @param arg12
     * @param arg13
     * @param arg14
     * @param arg15
     * @param arg16
     * @param arg17
     * @param arg18
     * @param arg19
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @param arg12
     * @param arg13
     * @param arg14
     * @param arg15
     * @param arg16
     * @param arg17
     * @param arg18
     * @param arg19
     * @param arg20
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19, BaseAviatorObject arg20);

    /**
     * call function
     *
     * @param env
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @param arg10
     * @param arg11
     * @param arg12
     * @param arg13
     * @param arg14
     * @param arg15
     * @param arg16
     * @param arg17
     * @param arg18
     * @param arg19
     * @param arg20
     * @param args
     * @return
     */
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19, BaseAviatorObject arg20, BaseAviatorObject... args);

}
