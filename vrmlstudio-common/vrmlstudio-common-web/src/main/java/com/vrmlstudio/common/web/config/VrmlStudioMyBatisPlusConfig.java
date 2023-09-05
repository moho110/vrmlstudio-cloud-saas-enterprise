package com.vrmlstudio.common.web.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.DataPermissionInterceptor;
import com.github.pagehelper.PageInterceptor;
import com.vrmlstudio.common.datascope.interceptor.VrmlStudioDataScopeHandler;
import com.vrmlstudio.common.web.handler.TenantLineHandler;
import com.vrmlstudio.common.web.handler.VrmlStudioMetaObjectHandler;
import com.vrmlstudio.common.web.injector.CustomizedSqlInjector;
import com.vrmlstudio.common.web.interceptor.TenantLineInnerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MP配置
 *
 * @author vrmlstudio
 */
@Configuration
public class VrmlStudioMyBatisPlusConfig {

    @Autowired
    private VrmlStudioDataScopeHandler dataScopeAspect;

    @Autowired
    private TenantLineHandler tenantLineHandler;

    /**
     * PageHelper分页配置
     */
    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }

    /**
     * 方法注入
     */
    @Bean
    public CustomizedSqlInjector customizedSqlInjector() {
        return new CustomizedSqlInjector();
    }

    /**
     * 自动填充
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new VrmlStudioMetaObjectHandler());
        return globalConfig;
    }

    /**
     * 插件配置
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 数据权限插件
        interceptor.addInnerInterceptor(new DataPermissionInterceptor(dataScopeAspect));
        // 租户控制插件
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(tenantLineHandler));
        // 禁全表更删插件
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }
}
