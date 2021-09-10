package models;

public class Additional {
    private Integer pageCount;
    private Size size;

    public Additional() {
    }

    public Additional(Integer pageCount){
        this.pageCount = pageCount;
        this.size = new Size(10.0, 10.0, 10.0);
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}