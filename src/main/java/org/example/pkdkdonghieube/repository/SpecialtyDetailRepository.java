package org.example.pkdkdonghieube.repository;

import org.example.pkdkdonghieube.entity.SpecialtyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SpecialtyDetailRepository extends JpaRepository<SpecialtyDetail, Long> {
    Optional<SpecialtyDetail> findBySpecialtyId(Long specialtyId);
}
