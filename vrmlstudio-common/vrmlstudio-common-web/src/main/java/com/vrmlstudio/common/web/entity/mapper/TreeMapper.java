package com.vrmlstudio.common.web.entity.mapper;

import com.vrmlstudio.common.core.web.entity.base.TreeEntity;

/**
 * 数据层 树型通用数据处理
 *
 * @param <D> Dto
 * @author vrmlstudio
 */
public interface TreeMapper<D extends TreeEntity<D>> extends BaseMapper<D> {
}
