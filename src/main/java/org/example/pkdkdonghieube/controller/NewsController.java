package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.dto.NewsDTO;
import org.example.pkdkdonghieube.dto.NewsDetailDTO;
import org.example.pkdkdonghieube.entity.News;
import org.example.pkdkdonghieube.entity.NewsDetail;
import org.example.pkdkdonghieube.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}