package com.vrmlstudio.system.monitor.manager;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.vrmlstudio.common.web.entity.manager.BaseManager;
import com.vrmlstudio.system.api.log.domain.dto.SysOperateLogDto;
import com.vrmlstudio.system.monitor.mapper.SysOperateLogMapper;
import org.springframework.stereotype.Component;

/**
 * 操作日志管理 数据封装层
 *
 * @author vrmlstudio
 */
@Component
public class SysOperateLogManager extends BaseManager<SysOperateLogDto, SysOperateLogMapper> {

    /**
     * 清空系统操作日志
     */
    public void cleanOperateLog() {
        baseMapper.delete(Wrappers.query());
    }

}
