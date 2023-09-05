package com.vrmlstudio.job.service;

import com.vrmlstudio.common.web.entity.service.IBaseService;
import com.vrmlstudio.job.api.domain.dto.SysJobLogDto;

/**
 * 调度日志管理 服务层
 *
 * @author vrmlstudio
 */
public interface ISysJobLogService extends IBaseService<SysJobLogDto> {

    /**
     * 清空任务日志
     */
    public void cleanLog();
}
