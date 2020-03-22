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
package com.googlecode.aviator.lexer.token;

import java.util.Map;


/**
 * Lex token interface
 *
 * @param <T>
 * @author dennis
 */
public interface Token<T> {
    public enum TokenType {

        /**
         * String
         */
        String,

        /**
         * Variable
         */
        Variable,

        /**
         * Number
         */
        Number,

        /**
         * Char
         */
        Char,

        /**
         * Operator
         */
        Operator,

        /**
         * Pattern
         */
        Pattern,

        /**
         * Delegate
         */
        Delegate
    }

    /**
     * getValue
     *
     * @param env
     * @return
     */
    public T getValue(Map<String, Object> env);

    /**
     * getType
     *
     * @return
     */
    public TokenType getType();

    /**
     * getLexeme
     *
     * @return
     */
    public String getLexeme();

    /**
     * getStartIndex
     *
     * @return
     */
    public int getStartIndex();
}
