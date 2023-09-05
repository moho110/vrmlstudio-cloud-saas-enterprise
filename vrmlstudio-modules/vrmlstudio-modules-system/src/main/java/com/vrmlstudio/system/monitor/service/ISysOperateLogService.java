package com.vrmlstudio.system.monitor.service;

import com.vrmlstudio.common.web.entity.service.IBaseService;
import com.vrmlstudio.system.api.log.domain.dto.SysOperateLogDto;

/**
 * 操作日志管理 服务层
 *
 * @author vrmlstudio
 */
public interface ISysOperateLogService extends IBaseService<SysOperateLogDto> {

    /**
     * 清空操作日志
     */
    void cleanOperateLog();
}
