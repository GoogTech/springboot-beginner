package pers.huangyuhui.memo.service;

import pers.huangyuhui.memo.bean.Friend;

import java.util.List;

/**
 * @project: memo
 * @description: 好友信息业务层
 * @author: 黄宇辉
 * @date: 2019-08-25 10:30 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public interface FriendService extends BaseService<Friend, Integer> {

    // TODO: 8/25/2019 添加好友信息 
    @Override
    int insertSelective(Friend friend);

    // TODO: 8/25/2019 选择性查询好友信息 
    @Override
    List<Friend> selectBySelective(Friend friend);

    // TODO: 8/25/2019 更新好友信息 
    @Override
    int updateByPrimaryKey(Friend friend);

    // TODO: 8/25/2019 删除好友信息
    @Override
    int deleteByPrimaryKey(Integer[] id);
}