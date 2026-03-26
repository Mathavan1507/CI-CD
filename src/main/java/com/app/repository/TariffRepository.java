package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.model.Tariff;

public interface TariffRepository extends JpaRepository<Tariff, Long> {
}
