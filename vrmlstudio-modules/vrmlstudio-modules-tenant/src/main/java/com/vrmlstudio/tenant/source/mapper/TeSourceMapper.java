package com.vrmlstudio.tenant.source.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.tenant.api.source.domain.dto.TeSourceDto;

/**
 * 数据源管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface TeSourceMapper extends BaseMapper<TeSourceDto> {
}