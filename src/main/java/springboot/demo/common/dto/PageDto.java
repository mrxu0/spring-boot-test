package springboot.demo.common.dto;
import java.util.Date;
import java.util.List;

public class PageDto {​
    private Integer rows = 10;​
    private Integer offset = 0;​
    private Integer pageNo = 1;​
    private Integer totalRecord = 0;​
    private Integer totalPage = 1;​
    private Boolean hasPrevious = false;​
    private Boolean hasNext = false;​
    private Date start;​
    private Date end;​
//    private T searchCondition;​
    private List dtos;​​

    public Date getStart() {
        return start;
    }​

    public void setStart(Date start) {
        this.start = start;
    }​

    public Date getEnd() {
        return end;
    }​

    public void setEnd(Date end) {
        this.end = end;
    }​

    public void setDtos(List dtos) {
        this.dtos = dtos;
    }​

    public List getDtos() {
        return dtos;
    }​

    public Integer getRows() {
        return rows;
    }​

    public void setRows(Integer rows) {
        this.rows = rows;
    }​

    public Integer getOffset() {
        return offset;
    }​

    public void setOffset(Integer offset) {
        this.offset = offset;
    }​

    public Integer getPageNo() {
        return pageNo;
    }​

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }​

    public Integer getTotalRecord() {
        return totalRecord;
    }​

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }​​

    public Integer getTotalPage() {
        return totalPage;
    }​

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }​

    public Boolean getHasPrevious() {
        return hasPrevious;
    }​

    public void setHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }​

    public Boolean getHasNext() {
        return hasNext;
    }​

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }
}