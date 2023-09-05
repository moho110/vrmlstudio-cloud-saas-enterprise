package com.vrmlstudio.system.authority.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.SubBaseMapper;
import com.vrmlstudio.system.api.authority.domain.dto.SysMenuDto;
import com.vrmlstudio.system.api.authority.domain.dto.SysModuleDto;

/**
 * 角色管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface SysModuleMapper extends SubBaseMapper<SysModuleDto, SysMenuDto> {
}
