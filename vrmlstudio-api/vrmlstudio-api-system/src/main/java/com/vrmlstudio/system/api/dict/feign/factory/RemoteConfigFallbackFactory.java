package com.vrmlstudio.system.api.dict.feign.factory;

import com.vrmlstudio.system.api.dict.feign.RemoteConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import com.vrmlstudio.common.core.domain.R;

/**
 * 参数服务 降级处理
 *
 * @author vrmlstudio
 */
@Component
public class RemoteConfigFallbackFactory implements FallbackFactory<RemoteConfigService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteConfigFallbackFactory.class);

    @Override
    public RemoteConfigService create(Throwable throwable) {
        log.error("参数服务调用失败:{}", throwable.getMessage());
        return new RemoteConfigService() {
            @Override
            public R<String> getCode(String configCode) {
                return R.fail("获取参数失败:" + throwable.getMessage());
            }
        };
    }
}