package com.vrmlstudio.system.authority.mapper.merge;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.authority.domain.merge.SysTenantMenuMerge;

/**
 * 租户-菜单关联 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysTenantMenuMergeMapper extends BaseMapper<SysTenantMenuMerge> {
}
