package pers.haungyuhui.memo.dao;

import pers.haungyuhui.memo.bean.Friend;

import java.util.List;

/**
 * @project: memo
 * @description: 数据访问层-操控好友信息
 * @author: 黄宇辉
 * @date: 6/28/2019-10:07 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public interface FriendMapper {

    // TODO: 6/28/2019 添加好友信息
    int insert(Friend friend);

    // TODO: 6/28/2019 通过姓名查询指定好友信息
    Friend selectByName(String name);

    // TODO: 6/28/2019 查询所有好友信息
    List<Friend> selectAll(Friend friend);

    // TODO: 6/28/2019 修改指定id的好友信息
    int updateById(Friend friend);

    // TODO: 6/28/2019 根据id删除指定好友
    int deleteById(Integer[] id);
}