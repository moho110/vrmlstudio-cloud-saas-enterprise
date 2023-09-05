package com.vrmlstudio.system.organize.service;

import com.vrmlstudio.common.web.entity.service.IBaseService;
import com.vrmlstudio.system.api.organize.domain.dto.SysEnterpriseDto;

/**
 * 企业管理 服务层
 *
 * @author vrmlstudio
 */
public interface ISysEnterpriseService extends IBaseService<SysEnterpriseDto> {

    /**
     * 根据名称查询状态正常企业对象
     *
     * @param name 名称
     * @return 企业对象
     */
    SysEnterpriseDto selectByName(String name);
}
