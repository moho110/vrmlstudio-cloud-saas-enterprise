package com.vrmlstudio.system.api.file.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vrmlstudio.system.api.file.domain.po.SysMaterialFolderPo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 素材分类 数据传输对象
 *
 * @author vrmlstudio
 */
@TableName(value = "xy_material_folder", excludeProperty = {"remark"})
public class SysMaterialFolderDto extends SysMaterialFolderPo<SysMaterialFolderDto, SysMaterialDto> {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("Id", getId())
                .append("parentId", getParentId())
                .append("name", getName())
                .append("subList", getSubList())
                .append("children", getChildren())
                .append("ancestors", getAncestors())
                .append("type", getType())
                .append("sort", getSort())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createName", getCreateName())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateName", getUpdateName())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
