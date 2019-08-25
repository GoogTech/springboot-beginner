package pers.huangyuhui.memo.dao;

import org.springframework.stereotype.Repository;
import pers.huangyuhui.memo.bean.Friend;

import java.util.List;

/**
 * @project: memo
 * @description: 好友信息数据访问层
 * @author: 黄宇辉
 * @date: 2019-08-25 10:06 AM
 * @version: 2.0
 * @website: https://yubuntu0109.github.io/
 */
@Repository
public interface FriendMapper extends BaseMapper<Friend, Integer> {

    // TODO: 8/23/2019 添加好友信息
    @Override
    int insertSelective(Friend friend);

    // TODO: 8/23/2019 选择性查询好友信息
    @Override
    List<Friend> selectBySelective(Friend friend);

    // TODO: 8/23/2019 更新好友信息
    @Override
    int updateByPrimaryKey(Friend friend);

    // TODO: 8/23/2019 删除好友信息
    @Override
    int deleteByPrimaryKey(Integer[] id);
}