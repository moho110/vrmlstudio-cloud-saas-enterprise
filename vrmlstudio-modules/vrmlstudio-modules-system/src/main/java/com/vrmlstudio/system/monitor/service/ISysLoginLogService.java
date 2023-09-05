package com.vrmlstudio.system.monitor.service;

import com.vrmlstudio.common.web.entity.service.IBaseService;
import com.vrmlstudio.system.api.log.domain.dto.SysLoginLogDto;

/**
 * 访问日志管理 服务层
 *
 * @author vrmlstudio
 */
public interface ISysLoginLogService extends IBaseService<SysLoginLogDto> {

    /**
     * 清空系统登录日志
     */
    void cleanLoginLog();
}
