package com.vrmlstudio.tenant.source.manager;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.vrmlstudio.common.web.entity.manager.BaseManager;
import com.vrmlstudio.tenant.api.source.domain.dto.TeSourceDto;
import com.vrmlstudio.tenant.source.mapper.TeSourceMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 数据源管理 数据封装层
 *
 * @author vrmlstudio
 */
@Component
public class TeSourceManager extends BaseManager<TeSourceDto, TeSourceMapper> {

    /**
     * 新增数据源对象
     *
     * @param source 数据源对象
     * @return 结果
     */
    @Override
    public int insert(TeSourceDto source) {
        source.setSlave(IdUtil.simpleUUID());
        return baseMapper.insert(source);
    }

    /**
     * 新增数据源对象（批量）
     *
     * @param sourceList 数据源对象集合
     * @return 结果
     */
    @Override
    @DSTransactional
    public int insertBatch(Collection<TeSourceDto> sourceList) {
        if (CollUtil.isNotEmpty(sourceList))
            sourceList.forEach(source -> source.setSlave(IdUtil.simpleUUID()));
        return baseMapper.insertBatch(sourceList);
    }
}