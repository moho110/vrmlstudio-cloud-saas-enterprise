package com.vrmlstudio.job.manager;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.vrmlstudio.common.web.entity.manager.BaseManager;
import com.vrmlstudio.job.api.domain.dto.SysJobLogDto;
import com.vrmlstudio.job.mapper.SysJobLogMapper;
import org.springframework.stereotype.Component;

/**
 * 调度任务日志管理 数据封装层
 *
 * @author vrmlstudio
 */
@Component
public class SysJobLogManager extends BaseManager<SysJobLogDto, SysJobLogMapper> {

    /**
     * 清空任务日志
     */
    public void cleanLog() {
        baseMapper.delete(Wrappers.update());
    }
}
