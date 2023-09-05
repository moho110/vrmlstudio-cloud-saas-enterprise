package com.vrmlstudio.common.web.entity.manager.handle;

import com.vrmlstudio.common.core.web.entity.base.TreeEntity;
import com.vrmlstudio.common.web.entity.manager.BaseManager;
import com.vrmlstudio.common.web.entity.mapper.TreeMapper;

/**
 * 数据封装层 操作方法 树型通用数据处理
 *
 * @param <D>  Dto
 * @param <DM> DtoMapper
 * @author vrmlstudio
 */
public class TreeHandleManager<D extends TreeEntity<D>, DM extends TreeMapper<D>> extends BaseManager<D, DM> {
}
