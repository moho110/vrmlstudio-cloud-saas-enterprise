package com.vrmlstudio.common.web.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.vrmlstudio.common.security.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 自动填充处理器
 *
 * @author vrmlstudio
 */
@Component
public class VrmlStudioMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter("createBy"))
            this.strictInsertFill(metaObject, "createBy", SecurityUtils::getUserId, Long.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter("updateBy"))
            this.strictUpdateFill(metaObject, "updateBy", SecurityUtils::getUserId, Long.class);
    }
}