package pers.huangyuhui.memo.service;

import com.github.pagehelper.PageInfo;
import pers.huangyuhui.memo.object.BaseConditionVO;

import java.io.Serializable;
import java.util.List;

/**
 * @project: memo
 * @description: 通用的Service接口
 * @author: 黄宇辉
 * @date: 8/22/2019-8:54 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public interface BaseService<T, ID extends Serializable> {

    void setBaseMapper();

    int deleteByPrimaryKey(ID[] id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    List<T> selectBySelective(T record);

    PageInfo<T> selectForPage(T reccord, BaseConditionVO baseConditionVO);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);
}
