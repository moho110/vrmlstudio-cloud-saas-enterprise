package com.vrmlstudio.system.source.service;

import com.vrmlstudio.common.web.entity.service.IBaseService;
import com.vrmlstudio.system.api.source.domain.Source;

/**
 * 策略组管理 服务层
 *
 * @author vrmlstudio
 */
public interface ISysSourceService extends IBaseService<Source> {

    /**
     * 加载策略组缓存数据
     */
    void loadingSourceCache();

    /**
     * 清空策略组缓存数据
     */
    void clearSourceCache();

    /**
     * 重置策略组缓存数据
     */
    void resetSourceCache();

    /**
     * 根据Id更新策略组缓存数据
     */
    void refreshSourceCache(Long id);
}
