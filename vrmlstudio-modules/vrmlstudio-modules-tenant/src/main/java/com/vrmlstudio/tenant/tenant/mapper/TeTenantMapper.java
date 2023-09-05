package com.vrmlstudio.tenant.tenant.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.tenant.api.tenant.domain.dto.TeTenantDto;

/**
 * 租户管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface TeTenantMapper extends BaseMapper<TeTenantDto> {
}