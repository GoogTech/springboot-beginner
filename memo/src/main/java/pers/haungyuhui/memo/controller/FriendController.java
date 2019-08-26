package pers.haungyuhui.memo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.haungyuhui.memo.bean.Friend;
import pers.haungyuhui.memo.service.FriendService;
import pers.haungyuhui.memo.util.UploadFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: memo
 * @description: 控制器-管理好友信息页面
 * @author: 黄宇辉
 * @date: 6/28/2019-8:25 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
@Controller
@RequestMapping("/memo")
public class StudentController {

    //注入业务对象
    @Resource
    private FriendService friendService;
    //存储预返回页面的结果对象
    private Map<String, Object> result = new HashMap<>();
    //项目下存储头像的目录,需放在静态资源'static'目录下哟
    private final String uploadPath = "/static/upload/friend_portrait/";

    /**
     * @description: 跳转到系统主页面
     * @date: 2019-06-28 11:25 AM
     * @return: java.lang.String
     */
    @GetMapping("/goMainView")
    public String goMainView() {
        return "main";
    }

    /**
     * @description: 跳转到好友信息列表管理页面
     * @date: 2019-06-28 9:06 PM
     * @return: java.lang.String
     */
    @GetMapping("/goFriendListView")
    public String getFriendListView() {
        return "friendList";
    }

    /**
     * @description: 分页查询:根据好友姓名获取指定/所有好友信息列表
     * @param: page 当前页码
     * @param: rows 列表行数
     * @param: username 好友姓名
     * @date: 2019-06-28 9:16 PM
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/getFriendList")
    @ResponseBody
    public Map<String, Object> getFriendList(Integer page, Integer rows, String username) {

        //获取查询的好友姓名
        Friend friend = new Friend();
        friend.setName(username);
        //设置每页的记录数
        PageHelper.startPage(page, rows);
        //根据姓名获取指定或所有好友信息列表
        List<Friend> list = friendService.findAll(friend);
        //封装查询结果
        PageInfo<Friend> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<Friend> friendList = pageInfo.getList();
        //存储对象数据
        result.put("total", total);
        result.put("rows", friendList);

        return result;
    }


    /**
     * @description: 添加好友信息
     * @param: friend
     * @date: 2019-06-28 9:22 PM
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/addFriend")
    @ResponseBody
    public Map<String, Object> addFriend(Friend friend) {
        //判断姓名是否已存在
        Friend f = friendService.findByName(friend.getName());
        if (f == null) {
            if (friendService.add(friend) > 0) {
                result.put("success", true);
            } else {
                result.put("success", false);
                result.put("msg", "添加失败! (ಥ_ಥ)服务器端发生异常!");
            }
        } else {
            result.put("success", false);
            result.put("msg", "该好友姓名已存在! 请检查后重试哟!");
        }
        return result;
    }

    /**
     * @description: 根据id修改指定好友信息
     * @param: friend
     * @date: 2019-06-13 5:29 PM
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/editFriend")
    @ResponseBody
    public Map<String, Object> editFriend(Friend friend) {
        //需排除只修改姓名以外信息的操作
        Friend user = friendService.findByName(friend.getName());
        if (user != null) {
            if (!(friend.getId().equals(user.getId()))) {
                result.put("success", false);
                result.put("msg", "该好友姓名已存在! 请检查后重试哟!");
                return result;
            }
        }
        //添加操作
        if (friendService.modify(friend) > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("msg", "添加失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    /**
     * @description: 删除指定id的好友信息
     * @param: ids 拼接后的id
     * @date: 2019-06-28 9:25 PM
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/deleteFriend")
    @ResponseBody
    public Map<String, Object> deleteFriend(@RequestParam(value = "ids[]", required = true) Integer[] ids) {

        if (friendService.delete(ids) > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        return result;
    }


    /**
     * @description: 上传头像-原理:将头像上传到项目发布目录中,通过读取数据库中的头像路径来显示头像
     * @param: photo
     * @param: request
     * @date: 2019-06-29 4:20 PM
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/uploadPhoto")
    @ResponseBody
    public Map<String, Object> uploadPhoto(MultipartFile photo) throws FileNotFoundException {
        //指定存储头像目录的完整路径(项目发布路径): 若不使用绝对路径,则Spring boot会默认将上传的文件存储到临时目录中
        String dirPath = URLDecoder.decode(ResourceUtils.getURL("classpath:").getPath(), StandardCharsets.UTF_8) + uploadPath;
        //返回头像的上传结果
        return UploadFile.getUploadResult(photo, dirPath, uploadPath);
    }
}
