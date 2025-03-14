package org.example.pkdkdonghieube.repository;

import org.example.pkdkdonghieube.entity.ServiceDetail;
import org.example.pkdkdonghieube.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {
}
