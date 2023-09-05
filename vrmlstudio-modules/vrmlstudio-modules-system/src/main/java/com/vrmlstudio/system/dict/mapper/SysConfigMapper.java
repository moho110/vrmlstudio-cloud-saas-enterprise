package com.vrmlstudio.system.dict.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.api.dict.domain.dto.SysConfigDto;

/**
 * 参数配置管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface SysConfigMapper extends BaseMapper<SysConfigDto> {
}