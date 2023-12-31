package com.vrmlstudio.system.dict.service.impl;

import com.vrmlstudio.common.core.constant.basic.CacheConstants;
import com.vrmlstudio.common.redis.service.RedisService;
import com.vrmlstudio.common.web.entity.service.impl.BaseServiceImpl;
import com.vrmlstudio.system.api.dict.domain.dto.SysDictDataDto;
import com.vrmlstudio.system.dict.manager.SysDictDataManager;
import com.vrmlstudio.system.dict.mapper.SysDictDataMapper;
import com.vrmlstudio.system.dict.service.ISysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 字典数据管理 业务层处理
 *
 * @author vrmlstudio
 */
@Service
public class SysDictDataServiceImpl extends BaseServiceImpl<SysDictDataDto, SysDictDataManager, SysDictDataMapper> implements ISysDictDataService {

    @Autowired
    private RedisService redisService;

    /**
     * 新增数据对象
     *
     * @param data 数据对象
     * @return 结果
     */
    @Override
    public int insert(SysDictDataDto data) {
        return refreshCache(baseManager.insert(data), data.getCode());
    }

    /**
     * 修改数据对象
     *
     * @param data 数据对象
     * @return 结果
     */
    @Override
    public int update(SysDictDataDto data) {
        return refreshCache(baseManager.update(data), data.getCode());
    }

    /**
     * 根据Id删除数据对象
     *
     * @param id Id
     * @return 结果
     */
    @Override
    public int deleteById(Serializable id) {
        SysDictDataDto data = baseManager.selectById(id);
        return refreshCache(baseManager.deleteById(id), data.getCode());
    }

    /**
     * 根据Id集合删除数据对象
     *
     * @param idList Id集合
     * @return 结果
     */
    @Override
    public int deleteByIds(Collection<? extends Serializable> idList) {
        List<SysDictDataDto> dataList = baseManager.selectListByIds(idList);
        int rows = baseManager.deleteByIds(idList);
        if (rows > 0) {
            Set<String> codes = dataList.stream().map(SysDictDataDto::getCode).collect(Collectors.toSet());
            for (String code : codes)
                redisService.setCacheMapValue(CacheConstants.SYS_DICT_KEY, code, baseManager.selectListByCode(code));
        }
        return rows;
    }

    /**
     * 查询字典数据对象列表
     *
     * @param code 字典编码
     * @return 字典数据对象集合
     */
    @Override
    public List<SysDictDataDto> selectListByCode(String code) {
        return baseManager.selectListByCode(code);
    }

    /**
     * 新增/修改缓存
     *
     * @param rows 结果
     * @param code 参数编码
     * @return 结果
     */
    private int refreshCache(int rows, String code) {
        if (rows > 0)
            redisService.setCacheMapValue(CacheConstants.SYS_DICT_KEY, code, baseManager.selectListByCode(code));
        return rows;
    }
}