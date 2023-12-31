package com.vrmlstudio.common.web.handler;

import cn.hutool.core.util.ObjectUtil;
import com.vrmlstudio.common.core.constant.basic.TenantConstants;
import com.vrmlstudio.common.security.utils.SecurityUtils;
import com.vrmlstudio.common.web.annotation.TenantIgnore;
import com.vrmlstudio.common.web.handler.basic.BasicLineHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 租户处理器
 *
 * @author vrmlstudio
 */
@Aspect
@Component
public class TenantLineHandler implements BasicLineHandler {

    /**
     * 通过ThreadLocal记录控制相关的属性值
     */
    private final ThreadLocal<TenantIgnore> threadLocal = new ThreadLocal<>();

    /**
     * 清空当前线程上次保存的控制信息
     */
    @After("@annotation(controllerTenantIgnore)")
    private void clearThreadLocal(TenantIgnore controllerTenantIgnore) {
        threadLocal.remove();
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    @Before("@annotation(controllerTenantIgnore)")
    private void doBefore(TenantIgnore controllerTenantIgnore) {
        // 获得注解
        if (controllerTenantIgnore != null)
            threadLocal.set(controllerTenantIgnore);
    }

    /**
     * 获取租户字段名
     *
     * @return 租户字段名
     */
    @Override
    public String getTenantIdColumn() {
        return TenantConstants.TENANT_ID;
    }

    /**
     * 租户表租户控制
     *
     * @return 租户值
     */
    @Override
    public Expression getTenantId() {
        return new LongValue(SecurityUtils.getEnterpriseId());
    }

    /**
     * 忽略租户控制
     *
     * @return 结果
     */
    @Override
    public boolean ignoreTable(String tableName) {
        if (isTenantTable(tableName)) {
            TenantIgnore tenantIgnore = threadLocal.get();
            return ObjectUtil.isNotNull(tenantIgnore) && tenantIgnore.tenantLine();
        }
        return true;
    }
}
