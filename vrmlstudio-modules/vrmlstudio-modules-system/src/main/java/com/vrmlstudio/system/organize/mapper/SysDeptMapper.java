package com.vrmlstudio.system.organize.mapper;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.SubTreeMapper;
import com.vrmlstudio.system.api.organize.domain.dto.SysDeptDto;
import com.vrmlstudio.system.api.organize.domain.dto.SysPostDto;

/**
 * 部门管理 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysDeptMapper extends SubTreeMapper<SysDeptDto, SysPostDto> {
}
