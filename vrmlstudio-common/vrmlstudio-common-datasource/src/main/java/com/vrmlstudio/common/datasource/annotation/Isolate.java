package com.vrmlstudio.common.datasource.annotation;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.lang.annotation.*;

import static com.vrmlstudio.common.core.constant.basic.TenantConstants.ISOLATE;

/**
 * 租户策略源
 *
 * @author vrmlstudio
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DS(ISOLATE)
public @interface Isolate {
}