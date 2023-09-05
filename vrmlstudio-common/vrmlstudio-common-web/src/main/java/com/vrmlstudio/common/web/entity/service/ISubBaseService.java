package com.vrmlstudio.common.web.entity.service;

import com.vrmlstudio.common.core.web.entity.base.BaseEntity;
import com.vrmlstudio.common.core.web.entity.base.SubBaseEntity;

/**
 * 服务层 主子基类通用数据处理
 *
 * @param <D> Dto
 * @param <S> SubDto
 * @author vrmlstudio
 */
public interface ISubBaseService<D extends SubBaseEntity<S>, S extends BaseEntity> extends IBaseService<D>,ISubService<D,S> {
}
