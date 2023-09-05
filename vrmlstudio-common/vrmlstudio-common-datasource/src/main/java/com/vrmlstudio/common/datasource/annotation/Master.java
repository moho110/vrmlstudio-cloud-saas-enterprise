package com.vrmlstudio.common.datasource.annotation;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.lang.annotation.*;

import static com.vrmlstudio.common.core.constant.basic.TenantConstants.MASTER;

/**
 * 主数据源
 *
 * @author vrmlstudio
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DS(MASTER)
public @interface Master {
}