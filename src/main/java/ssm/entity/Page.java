package ssm.entity;

import java.util.List;

/**
 * 使用：需要页码，和每页显示个数，不设默认为1和10.得到数据后，调用init方法，填充其他成员变量
 * Created by Administrator on 2016/10/13.
 */
public class Page {
    //当前页码
    private Integer currentPage=1;
    private Integer currentNumber;
    //单页显示的数量
    private Integer pageNumber=8;
    //总的页码
    private Integer totalPage;
    //总的数量
    private Integer totalNumber;
    private Boolean lastPage;
    private Boolean firstPage;
    //列表数据
    private List<?> list;
    private Integer nextPage;
    private Integer frontPage;



    //得到数据后调用init方法，填充其他成员变量
    public void init(){
        this.firstPage=currentPage == 1;
        this.frontPage=currentPage - 1;
        this.nextPage=currentPage + 1;

        this.totalPage=totalNumber/pageNumber;
        if(totalNumber%pageNumber!=0){
            this.totalPage++;
        }
        this.lastPage=currentPage==totalPage;
    }

    //填充list
    public void setList(List<?> list) {
        this.list = list;
    }
    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Page() {
    }

    public Page(Integer currentPage,Integer pageNumber) {
        this.pageNumber = pageNumber;
        this.currentPage = currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        this.currentNumber=(currentPage - 1) * pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        this.currentNumber=(currentPage - 1) * pageNumber;

    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }
    public Integer getNextPage() {
        return nextPage;
    }
    public Integer getFrontPage() {
        return frontPage;
    }
    public boolean isLastPage() {
        return lastPage;
    }
    public boolean isFirstPage() {
        return firstPage;
    }
    public List<?> getList() {
        return list;
    }
    public Integer getPageNumber() {
        return pageNumber;
    }
    public Integer getTotalNumber() {
        return totalNumber;
    }
    public Integer getCurrentPage() {
        return currentPage;
    }
    public Integer getTotalPage() {
        return totalPage;
    }

}
