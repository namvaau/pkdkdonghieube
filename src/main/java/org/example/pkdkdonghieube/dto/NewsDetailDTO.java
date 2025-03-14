package org.example.pkdkdonghieube.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NewsDetailDTO {
    private Long id;
    private String content;
    private String content1;
    private String content2;
    private String image1;
    private String image2;
    private String image3;
    private String title;
    private Date createTime;


    public NewsDetailDTO() {
    }

    public NewsDetailDTO(Long id, String content, String content1, String content2, String image1, String image2, String image3) {
        this.id = id;
        this.content = content;
        this.content1 = content1;
        this.content2 = content2;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public NewsDetailDTO(Long id, String content, String content1, String content2, String image1, String image2, String image3, String title, Date createTime) {
        this.id = id;
        this.content = content;
        this.content1 = content1;
        this.content2 = content2;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.title = title;
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }
}
