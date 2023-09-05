package com.vrmlstudio.system.organize.mapper.merge;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.organize.domain.merge.SysRolePostMerge;

/**
 * 角色-岗位关联（权限范围） 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysRolePostMergeMapper extends BaseMapper<SysRolePostMerge> {
}