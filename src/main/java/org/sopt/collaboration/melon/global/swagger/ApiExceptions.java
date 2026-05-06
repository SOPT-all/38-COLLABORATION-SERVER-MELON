package org.sopt.collaboration.melon.global.swagger;

import org.sopt.collaboration.melon.global.exception.BusinessException;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiExceptions {

    Class<? extends BusinessException>[] value();
}