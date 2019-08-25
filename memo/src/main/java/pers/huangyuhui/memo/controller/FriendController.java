package pers.huangyuhui.memo.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pers.huangyuhui.memo.bean.Friend;
import pers.huangyuhui.memo.object.BaseConditionVO;
import pers.huangyuhui.memo.object.PageResult;
import pers.huangyuhui.memo.service.FriendService;
import pers.huangyuhui.memo.util.FileUtil;
import pers.huangyuhui.memo.util.ResultUtil;

import java.io.FileNotFoundException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @project: memo
 * @description: 好友列表信息页管理器
 * @author: 黄宇辉
 * @date: 2019-08-25 9:57 AM
 * @version: 2.0
 * @website: https://yubuntu0109.github.io/
 */
@Controller
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/goMainView")
    public ModelAndView goMainView() { return ResultUtil.view("main"); }

    @GetMapping("/goFriendListView")
    public ModelAndView goFriendListView() { return ResultUtil.view("friendList"); }

    /**
     * @description: 分页查询:根据好友姓名获取指定/所有好友列表信息
     * @param: page 当前页码
     * @param: rows 列表行数
     * @param: username 好友姓名
     * @date: 2019-08-25 9:58 AM
     * @return: PageResult
     */
    @PostMapping("/getFriendList")
    @ResponseBody//these params seem like...why not included in basic value Object
    public PageResult getFriendList(Integer page, Integer rows, String username) {
        //获取封装查询结果
        PageInfo<Friend> pageInfo = friendService.selectForPage(new Friend(username), new BaseConditionVO(page, rows));
        //返回分页数据
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * @description: 添加好友信息
     * @param: friend
     * @date: 2019-08-25 9:59 AM
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/addFriend")
    @ResponseBody
    public Map<String, Object> addFriend(Friend friend) {
        return friendService.insertSelective(friend) > 0 ? ResultUtil.success() : ResultUtil.error("添加失败:服务器端发生异常!");
    }

    /**
     * @description: 更新好友信息
     * @param: friend
     * @date: 2019-08-25 10:00 AM
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/editFriend")
    @ResponseBody
    public Map<String, Object> editFriend(Friend friend) {
        return friendService.updateByPrimaryKey(friend) > 0 ? ResultUtil.success() : ResultUtil.error("更新失败:服务器端发生异常!");
    }

    /**
     * @description: 删除好友信息
     * @param: ids
     * @date: 2019-08-25 10:00 AM
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/deleteFriend")
    @ResponseBody
    public Map<String, Object> deleteFriend(@RequestParam(value = "ids[]", required = true) Integer[] ids) {
        return friendService.deleteByPrimaryKey(ids) > 0 ? ResultUtil.success() : ResultUtil.error("删除失败:服务器端发生异常!");
    }

    /**
     * @description: 头像上传:将头像上传到项目发布目录中,通过读取数据库中的头像路径来显示头像
     * @param: photo
     * @param: request
     * @date: 2019-06-29 4:20 PM
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/uploadPhoto")
    @ResponseBody
    public Map<String, Object> uploadPhoto(MultipartFile photo) throws FileNotFoundException {
        //指定存储头像目录的完整路径(项目发布路径): 若不使用绝对路径,则Spring boot会默认将上传的文件存储到临时目录中
        var dirPath = URLDecoder.decode(ResourceUtils.getURL("classpath:").getPath(), StandardCharsets.UTF_8) + FileUtil.uploadPath;
        //返回头像的上传结果
        return FileUtil.getUploadResult(photo, dirPath, FileUtil.uploadPath);
    }
}
