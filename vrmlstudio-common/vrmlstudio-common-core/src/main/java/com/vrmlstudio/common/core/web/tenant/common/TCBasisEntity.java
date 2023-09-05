package com.vrmlstudio.common.core.web.tenant.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.vrmlstudio.common.core.web.entity.common.CBasisEntity;

/**
 * Basis 租户混合基类
 *
 * @author vrmlstudio
 */
public class TCBasisEntity extends CBasisEntity {

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
