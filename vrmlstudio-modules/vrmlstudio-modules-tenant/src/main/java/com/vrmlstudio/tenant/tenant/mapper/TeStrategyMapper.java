package com.vrmlstudio.tenant.tenant.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.tenant.api.tenant.domain.dto.TeStrategyDto;

/**
 * 数据源策略管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface TeStrategyMapper extends BaseMapper<TeStrategyDto> {
}