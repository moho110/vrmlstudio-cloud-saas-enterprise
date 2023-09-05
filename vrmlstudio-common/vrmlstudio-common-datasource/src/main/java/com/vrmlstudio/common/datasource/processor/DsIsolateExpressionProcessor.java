package com.vrmlstudio.common.datasource.processor;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.processor.DsProcessor;
import com.vrmlstudio.common.datasource.utils.DSUtils;
import com.vrmlstudio.common.security.utils.SecurityUtils;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import static com.vrmlstudio.common.core.constant.basic.TenantConstants.ISOLATE;

/**
 * 租户库源策略
 *
 * @author vrmlstudio
 */
@Component
public class DsIsolateExpressionProcessor extends DsProcessor {

    @Override
    public boolean matches(String key) {
        return key.startsWith(ISOLATE);
    }

    @Override
    public String doDetermineDatasource(MethodInvocation invocation, String key) {
        String sourceName = SecurityUtils.getSourceName();
        return StrUtil.isNotEmpty(sourceName) ? sourceName : DSUtils.getNowDsName();
    }
}