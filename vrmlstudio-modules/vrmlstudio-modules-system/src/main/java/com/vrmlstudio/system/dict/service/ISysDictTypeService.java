package com.vrmlstudio.system.dict.service;

import com.vrmlstudio.common.web.entity.service.ISubBaseService;
import com.vrmlstudio.system.api.dict.domain.dto.SysDictDataDto;
import com.vrmlstudio.system.api.dict.domain.dto.SysDictTypeDto;

/**
 * 字典类型管理 服务层
 *
 * @author vrmlstudio
 */
public interface ISysDictTypeService extends ISubBaseService<SysDictTypeDto, SysDictDataDto> {

    /**
     * 加载字典缓存数据
     */
    void loadingDictCache();

    /**
     * 清空字典缓存数据
     */
    void clearDictCache();

    /**
     * 重置字典缓存数据
     */
    void resetDictCache();

    /**
     * 校验字典编码是否唯一
     *
     * @param Id       字典类型Id
     * @param dictCode 字典类型编码
     * @return 结果 | true/false 唯一/不唯一
     */
    boolean checkDictCodeUnique(Long Id, String dictCode);
}
