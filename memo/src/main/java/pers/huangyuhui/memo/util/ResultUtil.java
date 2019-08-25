package pers.huangyuhui.memo.util;

import com.github.pagehelper.PageInfo;
import org.springframework.web.servlet.ModelAndView;
import pers.huangyuhui.memo.object.PageResult;
import pers.huangyuhui.memo.object.ResponseResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @project: memo
 * @description: TODO
 * @author: 黄宇辉
 * @date: 8/24/2019-6:31 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class ResultUtil {

    public static ModelAndView view(String view) {
        return new ModelAndView(view);
    }

    public static ModelAndView view(String view, Map<String, Object> model) {
        return new ModelAndView(view, model);
    }

    public static ModelAndView redirect(String view) {
        return new ModelAndView("redirect:" + view);
    }

    public static Map<String, Object> error() { return new ResponseResult().error(); }

    public static Map<String, Object> success() {
        return new ResponseResult().success();
    }

    public static Map<String, Object> error(String message) {
        return new ResponseResult().error(message);
    }

    public static Map<String, Object> success(String message) {
        return new ResponseResult().success(message);
    }

    public static Map<String, Object> successWitPath(String path) {
        return new ResponseResult().successWithPath(path);
    }

    public static PageResult tablePage(Long total, List<?> list) {
        return new PageResult(total, list);
    }

    public static PageResult tablePage(PageInfo info) {
        if (info == null) {
            return new PageResult(0L, new ArrayList());
        }
        return tablePage(info.getTotal(), info.getList());
    }

}
