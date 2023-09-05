package com.vrmlstudio.system.dict.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.SubBaseMapper;
import com.vrmlstudio.system.api.dict.domain.dto.SysDictDataDto;
import com.vrmlstudio.system.api.dict.domain.dto.SysDictTypeDto;

/**
 * 字典类型管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface SysDictTypeMapper extends SubBaseMapper<SysDictTypeDto, SysDictDataDto> {
}
