package pers.huangyuhui.memo.object;

import java.util.List;

/**
 * @project: memo
 * @description: 分页结果
 * @author: 黄宇辉
 * @date: 8/24/2019-6:48 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class PageResult {

    private Long total;
    private List rows;

    public PageResult() {
    }

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}