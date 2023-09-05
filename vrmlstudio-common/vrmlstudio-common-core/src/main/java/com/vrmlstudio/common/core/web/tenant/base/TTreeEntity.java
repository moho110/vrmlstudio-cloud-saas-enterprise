package com.vrmlstudio.common.core.web.tenant.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.vrmlstudio.common.core.web.entity.base.TreeEntity;

/**
 * Tree 租户基类
 *
 * @param <D> Dto
 * @author vrmlstudio
 */
public class TTreeEntity<D> extends TreeEntity<D> {

    private static final long serialVersionUID = 1L;

    /** 租户Id */
    @TableField(exist = false)
    private Long enterpriseId;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
