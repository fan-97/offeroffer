package com.aop.annotation;

import java.lang.annotation.*;

/**
 * @author fanjie
 * @date 2022/12/9 15:50
 */
@Target(value = {ElementType.METHOD})
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Download {
//    FileType
}
