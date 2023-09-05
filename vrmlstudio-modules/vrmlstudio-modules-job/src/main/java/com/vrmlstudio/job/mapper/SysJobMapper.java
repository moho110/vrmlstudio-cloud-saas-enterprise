package com.vrmlstudio.job.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.SubBaseMapper;
import com.vrmlstudio.job.api.domain.dto.SysJobDto;
import com.vrmlstudio.job.api.domain.dto.SysJobLogDto;

/**
 * 调度任务管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface SysJobMapper extends SubBaseMapper<SysJobDto, SysJobLogDto> {
}
