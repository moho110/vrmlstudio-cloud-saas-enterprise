package com.vrmlstudio.common.web.entity.mapper.basic;

import com.vrmlstudio.common.core.web.entity.base.SubBaseEntity;

/**
 * 数据层 主子基类数据处理
 * 仅用于基类调用 禁止被继承使用
 *
 * @author vrmlstudio
 */
public interface BasicSubBaseMapper<S> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<SubBaseEntity<S>> {
}
