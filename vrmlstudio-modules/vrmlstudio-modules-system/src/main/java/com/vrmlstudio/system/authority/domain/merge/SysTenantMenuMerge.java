package com.vrmlstudio.system.authority.domain.merge;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.vrmlstudio.common.core.web.tenant.base.TBasisEntity;

/**
 * 租户-菜单关联 持久化对象
 *
 * @author vrmlstudio
 */
@TableName("sys_tenant_menu_merge")
public class SysTenantMenuMerge extends TBasisEntity {

    private static final long serialVersionUID = 1L;

    /** 菜单Id */
    @TableField("menu_id")
    private Long menuId;

    public SysTenantMenuMerge(){}

    public SysTenantMenuMerge(Long menuId){
        setMenuId(menuId);
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
