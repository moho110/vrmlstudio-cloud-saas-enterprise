package com.vrmlstudio.system.organize.domain.merge;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.vrmlstudio.common.core.web.tenant.base.TBasisEntity;

/**
 * 角色-部门关联（权限范围） 持久化对象
 *
 * @author vrmlstudio
 */
@TableName("sys_role_dept_merge")
public class SysRoleDeptMerge extends TBasisEntity {

    private static final long serialVersionUID = 1L;

    /** 角色Id */
    @TableField("role_id")
    private Long roleId;

    /** 部门Id */
    @TableField("dept_id")
    private Long deptId;

    public SysRoleDeptMerge() {
    }

    public SysRoleDeptMerge(Long roleId, Long deptId) {
        setRoleId(roleId);
        setDeptId(deptId);
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}