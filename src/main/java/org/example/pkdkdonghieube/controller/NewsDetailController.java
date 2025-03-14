package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.entity.NewsDetail;
import org.example.pkdkdonghieube.service.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news-details")
public class NewsDetailController {
    @Autowired
    private NewsDetailService newsDetailService;

    @PostMapping("/{newsId}")
    public ResponseEntity<NewsDetail> createNewsDetail(@PathVariable Integer newsId, @RequestBody NewsDetail newsDetail) {
        NewsDetail savedDetail = newsDetailService.createNewsDetail(newsId, newsDetail);
        return ResponseEntity.ok(savedDetail);
    }
}
