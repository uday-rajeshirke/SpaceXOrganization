
package com.uday.android.spacexorg.network.model.photos;

import java.util.List;
import com.squareup.moshi.Json;

public class Photos {

    @Json(name = "page")
    private Long page;
    @Json(name = "pages")
    private Long pages;
    @Json(name = "perpage")
    private Long perpage;
    @Json(name = "total")
    private String total;
    @Json(name = "photo")
    private List<Photo> photo = null;

    public Photos() {
    }

    public Photos(Long page, Long pages, Long perpage, String total, List<Photo> photo) {
        super();
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getPerpage() {
        return perpage;
    }

    public void setPerpage(Long perpage) {
        this.perpage = perpage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

}
