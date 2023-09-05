package com.vrmlstudio.system.monitor.service.impl;

import com.vrmlstudio.common.web.entity.service.impl.BaseServiceImpl;
import com.vrmlstudio.system.api.log.domain.dto.SysOperateLogDto;
import com.vrmlstudio.system.monitor.manager.SysOperateLogManager;
import com.vrmlstudio.system.monitor.mapper.SysOperateLogMapper;
import com.vrmlstudio.system.monitor.service.ISysOperateLogService;
import org.springframework.stereotype.Service;

/**
 * 操作日志管理 服务层处理
 *
 * @author vrmlstudio
 */
@Service
public class SysOperateLogServiceImpl extends BaseServiceImpl<SysOperateLogDto, SysOperateLogManager, SysOperateLogMapper> implements ISysOperateLogService {

    /**
     * 新增操作日志
     *
     * @param operationLog 操作日志对象
     * @return 结果
     */
    @Override
    public int insert(SysOperateLogDto operationLog) {
        return baseManager.insert(operationLog);
    }

    /**
     * 清空操作日志
     */
    @Override
    public void cleanOperateLog() {
        baseManager.cleanOperateLog();
    }
}
