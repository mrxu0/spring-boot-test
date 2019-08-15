package springboot.demo.common;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("当前页")
    private int pageNum;
    @ApiModelProperty("每页的数量")
    private int pageSize;
    @ApiModelProperty("总记录数")
    private long total;
    @ApiModelProperty("总页数")
    private int pages;
    @ApiModelProperty("结果集")
    private List<T> list;
    @ApiModelProperty("是否为第一页")
    private boolean isFirstPage = false;
    @ApiModelProperty("是否为最后一页")
    private boolean isLastPage = false;


    public PageInfo() {
    }

    /**
     * 包装Page对象
     *
     * @param list
     */
    public PageInfo(List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.pages = page.getPages();
            this.list = page;
            this.total = page.getTotal();
        } else if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();

            this.pages = 1;
            this.list = list;
            this.total = list.size();
        }
        if (list instanceof Collection) {
            //判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
    }
}