package com.vrmlstudio.common.web.entity.controller;

import com.vrmlstudio.common.core.constant.basic.BaseConstants;
import com.vrmlstudio.common.core.web.entity.base.BaseEntity;
import com.vrmlstudio.common.core.web.entity.base.SubBaseEntity;
import com.vrmlstudio.common.core.web.result.AjaxResult;
import com.vrmlstudio.common.core.web.validate.V_E;
import com.vrmlstudio.common.web.entity.controller.handle.SubBaseHandleController;
import com.vrmlstudio.common.web.entity.service.IBaseService;
import com.vrmlstudio.common.web.entity.service.ISubBaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 操作层 主子基类通用数据处理
 *
 * @param <D>  Dto
 * @param <DS> DtoService
 * @param <S>  SubDto
 * @param <SS> SubService
 * @author vrmlstudio
 */
public abstract class SubBaseController<D extends SubBaseEntity<S>, DS extends ISubBaseService<D, S>, S extends BaseEntity, SS extends IBaseService<S>> extends SubBaseHandleController<D, DS, S, SS> {

    /**
     * 主子型 修改
     * 考虑归属数据状态
     *
     * @see #EHandleSubStatusValidated(SubBaseEntity) 主子树型 归属数据状态逻辑校验
     */
    @Override
    public AjaxResult edit(@Validated({V_E.class}) @RequestBody D d) {
        EHandleSubStatusValidated(d);
        return super.edit(d);
    }

    /**
     * 主子型 修改
     * 考虑归属数据状态
     *
     * @see #ESHandleSubStatusValidated(SubBaseEntity)  主子树型 归属数据状态逻辑校验
     */
    public AjaxResult editStatus(@RequestBody D d) {
        ESHandleSubStatusValidated(d);
        return super.editStatus(d);
    }

    /**
     * 主子型 批量删除
     * 考虑归属数据存在与否&&子节点存在与否
     *
     * @see #RHandleEmptyValidated(List)   基类 空校验
     * @see #RHandleSubValidated(List)  主子型 归属数据存在与否校验
     */
    @Override
    public AjaxResult batchRemove(@PathVariable List<Long> idList) {
        RHandleEmptyValidated(idList);
        RHandleValidated(BaseConstants.Operate.DELETE, idList);
        RHandleEmptyValidated(idList);
        RHandleSubValidated(idList);
        return toAjax(baseService.deleteByIds(idList));
    }
}
