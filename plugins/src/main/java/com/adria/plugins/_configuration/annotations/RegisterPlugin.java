package com.adria.plugins._configuration.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RegisterPlugin {
    String id() default "";
    String version() default "";
    String name() default "";
    boolean enabled() default false;
}

