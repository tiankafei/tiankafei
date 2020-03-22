package com.googlecode.aviator.spring;

import com.googlecode.aviator.FunctionLoader;
import org.springframework.context.ApplicationContext;

/**
 * Function loader based on spring context, try to find the function by name from spring context.
 *
 * @author dennis
 * @since 4.0.0
 * @deprecated Use {@link SpringContextFunctionLoader} instead.
 */
@Deprecated
public class SringContextFunctionLoader extends SpringContextFunctionLoader
        implements FunctionLoader {
    public SringContextFunctionLoader() {
        super();
    }

    public SringContextFunctionLoader(ApplicationContext applicationContext) {
        super(applicationContext);
    }
}
