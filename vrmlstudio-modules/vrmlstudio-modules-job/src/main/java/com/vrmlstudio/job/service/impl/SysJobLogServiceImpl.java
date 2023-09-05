package com.vrmlstudio.job.service.impl;

import com.vrmlstudio.common.web.entity.service.impl.BaseServiceImpl;
import com.vrmlstudio.job.api.domain.dto.SysJobLogDto;
import com.vrmlstudio.job.manager.SysJobLogManager;
import com.vrmlstudio.job.mapper.SysJobLogMapper;
import com.vrmlstudio.job.service.ISysJobLogService;
import org.springframework.stereotype.Service;

/**
 * 调度日志管理 服务层处理
 *
 * @author vrmlstudio
 */
@Service
public class SysJobLogServiceImpl extends BaseServiceImpl<SysJobLogDto, SysJobLogManager, SysJobLogMapper> implements ISysJobLogService {

    /**
     * 清空任务日志
     */
    @Override
    public void cleanLog() {
        baseManager.cleanLog();
    }
}
