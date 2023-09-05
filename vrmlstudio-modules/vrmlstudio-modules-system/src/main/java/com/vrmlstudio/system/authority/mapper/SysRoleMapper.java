package com.vrmlstudio.system.authority.mapper;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.api.authority.domain.dto.SysRoleDto;

/**
 * 岗位管理 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysRoleMapper extends BaseMapper<SysRoleDto> {
}
