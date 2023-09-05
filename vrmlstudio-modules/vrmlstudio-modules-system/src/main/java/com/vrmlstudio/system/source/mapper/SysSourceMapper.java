package com.vrmlstudio.system.source.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.api.source.domain.Source;

/**
 * 策略组管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface SysSourceMapper extends BaseMapper<Source> {
}
