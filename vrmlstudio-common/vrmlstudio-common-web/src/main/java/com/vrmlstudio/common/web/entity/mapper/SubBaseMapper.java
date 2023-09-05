package com.vrmlstudio.common.web.entity.mapper;

import com.vrmlstudio.common.core.web.entity.base.BaseEntity;
import com.vrmlstudio.common.core.web.entity.base.SubBaseEntity;

/**
 * 数据层 主子基类通用数据处理
 *
 * @param <D> Dto
 * @param <S> SubDto
 * @author vrmlstudio
 */
public interface SubBaseMapper<D extends SubBaseEntity<S>, S extends BaseEntity> extends BaseMapper<D> {

}
