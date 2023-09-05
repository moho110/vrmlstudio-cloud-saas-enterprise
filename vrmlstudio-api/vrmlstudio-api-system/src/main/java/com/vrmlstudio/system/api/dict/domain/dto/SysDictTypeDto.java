package com.vrmlstudio.system.api.dict.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vrmlstudio.system.api.dict.domain.po.SysDictTypePo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 字典类型 数据传输对象
 *
 * @author vrmlstudio
 */
@TableName(value = "sys_dict_type", excludeProperty = {"delFlag"})
public class SysDictTypeDto extends SysDictTypePo<SysDictDataDto> {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("code", getCode())
                .append("sort", getSort())
                .append("status", getStatus())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createName", getCreateName())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateName", getUpdateName())
                .append("updateTime", getUpdateTime())
                .append("subList", getSubList())
                .toString();
    }

}
