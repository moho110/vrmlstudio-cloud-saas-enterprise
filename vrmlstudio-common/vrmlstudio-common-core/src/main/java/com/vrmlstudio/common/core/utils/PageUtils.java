package com.vrmlstudio.common.core.utils;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.vrmlstudio.common.core.utils.sql.SqlUtil;
import com.vrmlstudio.common.core.web.page.PageDomain;
import com.vrmlstudio.common.core.web.page.TableSupport;

/**
 * 分页工具类
 *
 * @author vrmlstudio
 */
public class PageUtils extends PageHelper {

    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (ObjectUtil.isAllNotEmpty(pageNum, pageSize)) {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            Boolean reasonable = pageDomain.getReasonable();
            PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
        }
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage() {
        PageHelper.clearPage();
    }
}
