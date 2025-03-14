package org.example.pkdkdonghieube.service;

import org.example.pkdkdonghieube.dto.NewsDTO;
import org.example.pkdkdonghieube.dto.NewsDetailDTO;
import org.example.pkdkdonghieube.entity.News;
import org.example.pkdkdonghieube.entity.NewsDetail;
import org.example.pkdkdonghieube.repository.NewsDetailRepository;
import org.example.pkdkdonghieube.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {
    private final NewsRepository newsRepository;
    private final NewsDetailRepository newsDetailRepository;

    public NewsService(NewsRepository newsRepository, NewsDetailRepository newsDetailRepository) {
        this.newsRepository = newsRepository;
        this.newsDetailRepository = newsDetailRepository;
    }


    public List<NewsDTO> getAllNews() {
        List<News> newsList = newsRepository.findAll();
        return newsList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private NewsDTO convertToDTO(News news) {
        NewsDTO dto = new NewsDTO();
        dto.setId(news.getId());
        dto.setTitle(news.getTitle());
        dto.setSummary(news.getSummary());
        dto.setDate(news.getDate());
        dto.setImageUrl(news.getImageUrl());

        dto.setNewsDetails(news.getNewsDetails().stream().map(detail -> {
            NewsDetailDTO detailDTO = new NewsDetailDTO();
            detailDTO.setId(detail.getId());
            detailDTO.setContent(detail.getContent());
            detailDTO.setContent1(detail.getContent1());
            detailDTO.setContent2(detail.getContent2());
            detailDTO.setImage1(detail.getImage1());
            detailDTO.setImage2(detail.getImage2());
            detailDTO.setImage3(detail.getImage3());
            return detailDTO;
        }).collect(Collectors.toList()));

        return dto;
    }

    public List<NewsDetailDTO> getNewsDetailsByNewsId(Long newsId) {
        List<NewsDetail> details = newsDetailRepository.findByNewsId(newsId);
        return details.stream()
                .map(detail -> new NewsDetailDTO(
                        detail.getId(),
                        detail.getContent(),
                        detail.getContent1(),
                        detail.getContent2(),
                        detail.getImage1(),
                        detail.getImage2(),
                        detail.getImage3(),
                        detail.getNews().getTitle(),
                        detail.getNews().getDate()
                ))
                .collect(Collectors.toList());
    }
}
