package com.vrmlstudio.system.material.mapper;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialDto;

/**
 * 素材管理 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysMaterialMapper extends BaseMapper<SysMaterialDto> {
}
