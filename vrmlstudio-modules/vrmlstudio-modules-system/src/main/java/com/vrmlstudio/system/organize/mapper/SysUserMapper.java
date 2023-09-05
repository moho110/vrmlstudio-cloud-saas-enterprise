package com.vrmlstudio.system.organize.mapper;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.api.organize.domain.dto.SysUserDto;

/**
 * 用户管理 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysUserMapper extends BaseMapper<SysUserDto> {
}
