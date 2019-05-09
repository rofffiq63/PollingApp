package under.the.bridge.pollingapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ApiResponseModel<T> {
    @SerializedName("data")
    @Expose
    private List<T> data  = new ArrayList<>();

    @SerializedName("error")
    @Expose
    private boolean error;

    @SerializedName("total")
    @Expose
    private int total;

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("total_page")
    @Expose
    private int totalPage;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
