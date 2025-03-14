package org.example.pkdkdonghieube.repository;

import org.example.pkdkdonghieube.entity.ServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetail, Long> {
    List<ServiceDetail> findByServiceId(Long serviceId);
}
