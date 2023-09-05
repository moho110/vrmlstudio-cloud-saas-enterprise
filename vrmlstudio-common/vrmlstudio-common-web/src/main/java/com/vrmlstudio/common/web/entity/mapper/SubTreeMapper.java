package com.vrmlstudio.common.web.entity.mapper;

import com.vrmlstudio.common.core.web.entity.base.BaseEntity;
import com.vrmlstudio.common.core.web.entity.base.SubTreeEntity;

/**
 * 数据层 主子树型通用数据处理
 *
 * @param <D> Dto
 * @param <S> SubDto
 * @author vrmlstudio
 */
public interface SubTreeMapper<D extends SubTreeEntity<D, S>, S extends BaseEntity> extends TreeMapper<D>{
}
