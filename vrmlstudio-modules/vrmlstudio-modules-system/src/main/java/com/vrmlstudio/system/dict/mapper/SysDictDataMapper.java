package com.vrmlstudio.system.dict.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.api.dict.domain.dto.SysDictDataDto;

/**
 * 字典数据管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface SysDictDataMapper extends BaseMapper<SysDictDataDto> {
}
