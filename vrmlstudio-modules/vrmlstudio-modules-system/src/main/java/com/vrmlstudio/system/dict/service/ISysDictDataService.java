package com.vrmlstudio.system.dict.service;

import com.vrmlstudio.common.web.entity.service.IBaseService;
import com.vrmlstudio.system.api.dict.domain.dto.SysDictDataDto;

import java.util.List;

/**
 * 字典数据管理 服务层
 *
 * @author vrmlstudio
 */
public interface ISysDictDataService extends IBaseService<SysDictDataDto> {

    /**
     * 查询字典数据对象列表
     *
     * @param code 字典编码
     * @return 字典数据对象集合
     */
    List<SysDictDataDto> selectListByCode(String code);
}
