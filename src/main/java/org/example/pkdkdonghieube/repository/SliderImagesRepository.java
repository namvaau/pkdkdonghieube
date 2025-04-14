package org.example.pkdkdonghieube.repository;

import org.example.pkdkdonghieube.entity.SliderImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderImagesRepository extends JpaRepository<SliderImages, Long> {
}
