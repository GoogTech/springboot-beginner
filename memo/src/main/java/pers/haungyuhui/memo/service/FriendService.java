package pers.haungyuhui.memo.service;

import pers.haungyuhui.memo.bean.Friend;

import java.util.List;

/**
 * @project: memo
 * @description: 业务层-操控好友信息
 * @author: 黄宇辉
 * @date: 6/28/2019-8:56 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public interface FriendService {

    // TODO: 6/28/2019 添加好友信息
    int add(Friend friend);

    // TODO: 6/28/2019 通过姓名查询指定好友信息
    Friend findByName(String name);

    // TODO: 6/28/2019 查询所有好友信息
    List<Friend> findAll(Friend friend);

    // TODO: 6/28/2019 修改指定id的好友信息
    int modify(Friend friend);

    // TODO: 6/28/2019 根据id删除指定好友
    int delete(Integer[] id);
}