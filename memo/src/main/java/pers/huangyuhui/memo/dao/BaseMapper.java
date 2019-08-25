package pers.huangyuhui.memo.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @project: memo
 * @description: 通用的Mapper接口
 * @author: 黄宇辉
 * @date: 8/22/2019-8:44 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public interface BaseMapper<T, ID extends Serializable> {

    int deleteByPrimaryKey(ID[] id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    List<T> selectBySelective(T t);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);

}
