package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.dto.NewsDTO;
import org.example.pkdkdonghieube.dto.NewsDetailDTO;
import org.example.pkdkdonghieube.entity.News;
import org.example.pkdkdonghieube.entity.NewsDetail;
import org.example.pkdkdonghieube.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<NewsDTO> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}/details")
    public List<NewsDetailDTO> getNewsDetailsByNewsId(@PathVariable Long id) {
        return newsService.getNewsDetailsByNewsId(id);
    }

    @PostMapping
    public ResponseEntity<News> createNews(@RequestBody News news) {
        News savedNews = newsService.createNews(news);
        return ResponseEntity.ok(savedNews);
    }
}