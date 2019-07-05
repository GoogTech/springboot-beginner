package pers.haungyuhui.memo.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.haungyuhui.memo.bean.Friend;
import pers.haungyuhui.memo.dao.FriendMapper;
import pers.haungyuhui.memo.service.FriendService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: memo
 * @description: 业务层实现类-操控好友信息
 * @author: 黄宇辉
 * @date: 2019-07-03 11:52 AM
 * @version: 2.0
 * @website: https://yubuntu0109.github.io/
 */
@Service
@Transactional
public class FriendServiceImpl implements FriendService {

    //注入Mapper接口对象
    @Resource
    private FriendMapper friendMapper;

    @Override
    @CacheEvict(value = "UserCache", key = "'friend.add'")
    public int add(Friend friend) {
        return friendMapper.insert(friend);
    }

    @Override
    @CacheEvict(value = "UserCache", key = "'friend.findByName'")
    public Friend findByName(String name) { return friendMapper.selectByName(name); }

    @Override
    @CacheEvict(value = "UserCache", key = "'friend.findAll'")
    public List<Friend> findAll(Friend friend) {
        return friendMapper.selectAll(friend);
    }

    @Override
    @CacheEvict(value = "UserCache", key = "'friend.modify'")
    public int modify(Friend friend) {
        return friendMapper.updateById(friend);
    }

    @Override
    @CacheEvict(value = "UserCache", key = "'friend.delete'", allEntries = true)
    public int delete(Integer[] id) {
        return friendMapper.deleteById(id);
    }
}