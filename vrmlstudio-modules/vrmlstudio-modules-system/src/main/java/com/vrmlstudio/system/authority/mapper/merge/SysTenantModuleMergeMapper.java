package com.vrmlstudio.system.authority.mapper.merge;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.authority.domain.merge.SysTenantModuleMerge;

/**
 * 租户-模块关联 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysTenantModuleMergeMapper extends BaseMapper<SysTenantModuleMerge> {
}
