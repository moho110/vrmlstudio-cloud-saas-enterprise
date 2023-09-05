package com.vrmlstudio.system.monitor.service.impl;


import com.vrmlstudio.common.security.utils.SecurityUtils;
import com.vrmlstudio.common.web.entity.service.impl.BaseServiceImpl;
import com.vrmlstudio.system.api.log.domain.dto.SysLoginLogDto;
import com.vrmlstudio.system.monitor.manager.SysLoginLogManager;
import com.vrmlstudio.system.monitor.mapper.SysLoginLogMapper;
import com.vrmlstudio.system.monitor.service.ISysLoginLogService;
import org.springframework.stereotype.Service;

/**
 * 访问日志管理 服务层处理
 *
 * @author vrmlstudio
 */
@Service
public class SysLoginLogServiceImpl extends BaseServiceImpl<SysLoginLogDto, SysLoginLogManager, SysLoginLogMapper> implements ISysLoginLogService {

    /**
     * 新增系统登录日志
     *
     * @param loginLog 访问日志对象 | sourceName 数据源名称
     */
    @Override
    public int insert(SysLoginLogDto loginLog) {
        return baseManager.insert(loginLog);
    }

    /**
     * 清空系统登录日志
     */
    @Override
    public void cleanLoginLog() {
        baseManager.cleanLoginLog(SecurityUtils.getEnterpriseId());
    }
}
