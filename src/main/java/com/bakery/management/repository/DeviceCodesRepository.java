package com.bakery.management.repository;

import com.bakery.management.domain.DeviceCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceCodesRepository
        extends JpaRepository<DeviceCodes, UUID> {
}
