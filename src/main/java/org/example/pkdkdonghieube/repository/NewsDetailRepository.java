package org.example.pkdkdonghieube.repository;

import org.example.pkdkdonghieube.entity.NewsDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDetailRepository extends JpaRepository<NewsDetail, Long> {
    List<NewsDetail> findByNewsId(Long newsId);

}
