package com.vrmlstudio.system.authority.service;

import com.vrmlstudio.common.web.entity.service.ISubBaseService;
import com.vrmlstudio.system.api.authority.domain.dto.SysMenuDto;
import com.vrmlstudio.system.api.authority.domain.dto.SysModuleDto;

import java.util.List;
import java.util.Set;

/**
 * 模块管理 服务层
 *
 * @author vrmlstudio
 */
public interface ISysModuleService extends ISubBaseService<SysModuleDto, SysMenuDto> {

    /**
     * 当前用户首页可展示的模块路由
     *
     * @param roleIds 角色Ids
     * @return 模块集合
     */
    List<SysModuleDto> getRoutes(Set<Long> roleIds);
}
