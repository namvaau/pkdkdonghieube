package org.example.pkdkdonghieube.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public List<NewsDetail> getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(List<NewsDetail> newsDetails) {
        this.newsDetails = newsDetails;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String title;
    private String summary;
    private Date date;
    private String imageUrl;

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    private List<NewsDetail> newsDetails;
}