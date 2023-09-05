package com.vrmlstudio.job.mapper;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.job.api.domain.dto.SysJobLogDto;

/**
 * 调度日志管理 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysJobLogMapper extends BaseMapper<SysJobLogDto> {
}
