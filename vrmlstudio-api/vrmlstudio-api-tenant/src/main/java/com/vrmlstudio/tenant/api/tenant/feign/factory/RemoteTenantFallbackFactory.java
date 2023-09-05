package com.vrmlstudio.tenant.api.tenant.feign.factory;

import cn.hutool.json.JSONObject;
import com.vrmlstudio.common.core.domain.R;
import com.vrmlstudio.tenant.api.tenant.feign.RemoteTenantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;


/**
 * 租户服务降级处理
 *
 * @author vrmlstudio
 */
@Component
public class RemoteTenantFallbackFactory implements FallbackFactory<RemoteTenantService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteTenantFallbackFactory.class);

    @Override
    public RemoteTenantService create(Throwable throwable) {
        log.error("租户服务调用失败:{}", throwable.getMessage());
        return new RemoteTenantService() {
            @Override
            public R<Boolean> registerTenantInfo(JSONObject register, String source)
            {
                return R.fail("注册租户失败:" + throwable.getMessage());
            }
        };
    }
}