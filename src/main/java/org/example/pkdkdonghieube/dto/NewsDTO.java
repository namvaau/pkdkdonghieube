package org.example.pkdkdonghieube.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class NewsDTO {
    private Long id;
    private String title;
    private String summary;
    private Date date;
    private String imageUrl;
    private List<NewsDetailDTO> newsDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<NewsDetailDTO> getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(List<NewsDetailDTO> newsDetails) {
        this.newsDetails = newsDetails;
    }
}
