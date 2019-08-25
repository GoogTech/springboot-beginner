package pers.huangyuhui.memo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import pers.huangyuhui.memo.object.BaseConditionVO;
import pers.huangyuhui.memo.dao.BaseMapper;
import pers.huangyuhui.memo.service.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * @project: memo
 * @description: 通用的Service实现类
 * @author: 黄宇辉
 * @date: 8/22/2019-8:55 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public abstract class AbstractService<T, ID extends Serializable> implements BaseService<T, ID> {

    private BaseMapper<T, ID> baseMapper;

    //初始化baseMapper
    public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int deleteByPrimaryKey(ID[] id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectBySelective(T record) {
        return baseMapper.selectBySelective(record);
    }

    @Override
    public PageInfo<T> selectForPage(T record, BaseConditionVO baseConditionVO) {
        PageHelper.startPage(baseConditionVO.getPageNum(), baseConditionVO.getPageSize()); //设置每页的记录数
        List<T> list = baseMapper.selectBySelective(record); //获取列表信息
        return new PageInfo<>(list);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(T record) {
        return baseMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }
}
