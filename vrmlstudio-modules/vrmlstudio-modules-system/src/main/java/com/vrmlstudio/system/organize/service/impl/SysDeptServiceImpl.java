package com.vrmlstudio.system.organize.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.vrmlstudio.common.core.constant.basic.BaseConstants;
import com.vrmlstudio.common.datascope.annotation.DataScope;
import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.service.impl.SubTreeServiceImpl;
import com.vrmlstudio.system.api.organize.domain.dto.SysDeptDto;
import com.vrmlstudio.system.api.organize.domain.dto.SysPostDto;
import com.vrmlstudio.system.organize.manager.SysDeptManager;
import com.vrmlstudio.system.organize.mapper.SysDeptMapper;
import com.vrmlstudio.system.organize.mapper.SysPostMapper;
import com.vrmlstudio.system.organize.service.ISysDeptService;
import com.vrmlstudio.system.organize.service.ISysPostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 部门管理 服务层处理
 *
 * @author vrmlstudio
 */
@Service
@Isolate
public class SysDeptServiceImpl extends SubTreeServiceImpl<SysDeptDto, SysDeptManager, SysDeptMapper, SysPostDto, ISysPostService, SysPostMapper> implements ISysDeptService {

    /**
     * 新增部门 | 内部调用
     *
     * @param dept 部门对象
     * @return 结果
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int addInner(SysDeptDto dept) {
        return baseManager.insert(dept);
    }

    /**
     * 查询部门对象列表 | 数据权限 | 附加数据
     *
     * @param dept 部门对象
     * @return 部门对象集合
     */
    @Override
    @DataScope(deptAlias = "id", mapperScope = {"SysDeptMapper"})
    public List<SysDeptDto> selectListScope(SysDeptDto dept) {
        return baseManager.selectListExtra(dept);
    }
    
    /**
     * 校验部门编码是否唯一
     *
     * @param Id   部门Id
     * @param code 部门编码
     * @return 结果 | true/false 唯一/不唯一
     */
    @Override
    public boolean checkDeptCodeUnique(Long Id, String code) {
        return ObjectUtil.isNotNull(baseManager.checkDeptCodeUnique(ObjectUtil.isNull(Id) ? BaseConstants.NONE_ID : Id, code));
    }

    /**
     * 设置子数据的外键值
     */
    @Override
    protected void setForeignKey(Collection<SysPostDto> postList, SysPostDto post, SysDeptDto dept, Serializable key) {
        Long deptId = ObjectUtil.isNotNull(dept) ? dept.getId() : (Long) key;
        if (ObjectUtil.isNotNull(post))
            post.setDeptId(deptId);
        else
            postList.forEach(sub -> sub.setDeptId(deptId));
    }
}
