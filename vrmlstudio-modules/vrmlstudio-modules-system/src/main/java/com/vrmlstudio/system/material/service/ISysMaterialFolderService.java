package com.vrmlstudio.system.material.service;

import com.vrmlstudio.common.web.entity.service.ISubTreeService;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialDto;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialFolderDto;

/**
 * 素材分类管理 服务层
 *
 * @author vrmlstudio
 */
public interface ISysMaterialFolderService extends ISubTreeService<SysMaterialFolderDto, SysMaterialDto> {
}
