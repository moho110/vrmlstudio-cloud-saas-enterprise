package com.vrmlstudio.job.api.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vrmlstudio.job.api.domain.po.SysJobPo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 调度任务 数据传输对象
 *
 * @author vrmlstudio
 */
@TableName(value = "sys_job", excludeProperty = {"sort"})
public class SysJobDto extends SysJobPo<SysJobLogDto> {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("jobGroup", getJobGroup())
                .append("invokeTarget", getInvokeTarget())
                .append("cronExpression", getCronExpression())
                .append("misfirePolicy", getMisfirePolicy())
                .append("concurrent", getConcurrent())
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
