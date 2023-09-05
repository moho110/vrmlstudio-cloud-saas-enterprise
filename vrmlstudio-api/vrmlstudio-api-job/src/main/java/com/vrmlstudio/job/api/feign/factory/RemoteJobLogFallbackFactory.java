package com.vrmlstudio.job.api.feign.factory;

import com.vrmlstudio.common.core.domain.R;
import com.vrmlstudio.job.api.domain.dto.SysJobLogDto;
import com.vrmlstudio.job.api.feign.RemoteJobLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 调度日志服务 降级处理
 *
 * @author vrmlstudio
 */
@Component
public class RemoteJobLogFallbackFactory implements FallbackFactory<RemoteJobLogService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteJobLogFallbackFactory.class);

    @Override
    public RemoteJobLogService create(Throwable throwable) {
        log.error("调度日志服务调用失败:{}", throwable.getMessage());
        return new RemoteJobLogService() {
            @Override
            public R<Boolean> saveJobLog(SysJobLogDto jobLog, Long enterpriseId, String isLessor, String sourceName, String source) {
                return null;
            }
        };
    }
}