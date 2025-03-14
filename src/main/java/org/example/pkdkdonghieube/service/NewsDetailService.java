package org.example.pkdkdonghieube.service;

import org.example.pkdkdonghieube.entity.News;
import org.example.pkdkdonghieube.entity.NewsDetail;
import org.example.pkdkdonghieube.repository.NewsDetailRepository;
import org.example.pkdkdonghieube.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewsDetailService {
    @Autowired
    private NewsDetailRepository newsDetailRepository;

    @Autowired
    private NewsRepository newsRepository;

    public NewsDetail createNewsDetail(Integer newsId, NewsDetail newsDetail) {
        Optional<News> newsOptional = newsRepository.findById(newsId);
        if (newsOptional.isEmpty()) {
            throw new RuntimeException("News not found with id: " + newsId);
        }
        News news = newsOptional.get();
        newsDetail.setNews(news); // Gán bài báo cho chi tiết
        return newsDetailRepository.save(newsDetail);
    }
}