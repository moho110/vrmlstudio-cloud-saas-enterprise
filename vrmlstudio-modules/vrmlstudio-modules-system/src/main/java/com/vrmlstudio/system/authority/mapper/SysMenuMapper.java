package com.vrmlstudio.system.authority.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.TreeMapper;
import com.vrmlstudio.system.api.authority.domain.dto.SysMenuDto;

/**
 * 菜单管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface SysMenuMapper extends TreeMapper<SysMenuDto> {
}
