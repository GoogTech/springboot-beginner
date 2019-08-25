package pers.huangyuhui.memo.object;

/**
 * @project: memo
 * @description: 基础值对象(basic value Object)
 * @author: 黄宇辉
 * @date: 2019-08-25 10:20 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class BaseConditionVO {
    private int pageNum; //当前页码
    private int pageSize; //当前页码列表行数

    public BaseConditionVO(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
