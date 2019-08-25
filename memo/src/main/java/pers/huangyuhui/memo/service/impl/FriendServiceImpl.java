package pers.huangyuhui.memo.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.huangyuhui.memo.bean.Friend;
import pers.huangyuhui.memo.dao.FriendMapper;
import pers.huangyuhui.memo.object.BaseConditionVO;
import pers.huangyuhui.memo.service.FriendService;

import java.util.List;

/**
 * @project: memo
 * @description: 好友信息业务层的实现类
 * @author: 黄宇辉
 * @date: 8/22/2019-x:xx PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
@Service
@Transactional
public class FriendServiceImpl extends AbstractService<Friend, Integer> implements FriendService {

    @Autowired
    private FriendMapper friendMapper;

    //the method must be implemented
    //注:这句必须要加上哟,不然会报空指针异常,因为在实际掉用的时候不是BaseMapper调用,而是这个firendMapper
    @Autowired
    @Override
    public void setBaseMapper() { super.setBaseMapper(friendMapper); }

    @Override
    public int insertSelective(Friend record) {
        return super.insertSelective(record);
    }

    @Override
    public List<Friend> selectBySelective(Friend record) {
        return super.selectBySelective(record);
    }

    @Override
    public PageInfo<Friend> selectForPage(Friend record, BaseConditionVO baseConditionVO) { return super.selectForPage(record, baseConditionVO); }

    @Override
    public int updateByPrimaryKeySelective(Friend record) {
        return super.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer[] id) {
        return super.deleteByPrimaryKey(id);
    }

}