package com.vrmlstudio.system.organize.mapper;

import com.vrmlstudio.common.datasource.annotation.Master;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.api.organize.domain.dto.SysEnterpriseDto;

/**
 * 企业管理 数据层
 *
 * @author vrmlstudio
 */
@Master
public interface SysEnterpriseMapper extends BaseMapper<SysEnterpriseDto> {
}
