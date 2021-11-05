package query;

/**
 * 分页查询
 */
public class BaseQuery {
    private Integer page = 1;

    private Integer limit = 5;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public BaseQuery(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }
}
