package com.vrmlstudio.system.material.mapper;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.SubTreeMapper;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialDto;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialFolderDto;

/**
 * 素材分类管理 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysMaterialFolderMapper extends SubTreeMapper<SysMaterialFolderDto, SysMaterialDto> {
}
