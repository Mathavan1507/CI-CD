package com.app.service;

import org.springframework.stereotype.Service;
import com.app.model.Tariff;
import com.app.repository.TariffRepository;
import java.util.List;

@Service
public class TariffService {
    private final TariffRepository tariffRepository;

    public TariffService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    public Tariff addTariff(Tariff tariff) {
        return tariffRepository.save(tariff);
    }

    public List<Tariff> getAllTariffs() {
        return tariffRepository.findAll();
    }

    public Tariff updateTariff(Long id, Tariff updatedTariff) {
        return tariffRepository.findById(id).map(tariff -> {
            tariff.setPlanName(updatedTariff.getPlanName());
            tariff.setUnitPrice(updatedTariff.getUnitPrice());
            return tariffRepository.save(tariff);
        }).orElseThrow(() -> new RuntimeException("Tariff not found with id " + id));
    }

    public void deleteTariff(Long id) {
        tariffRepository.deleteById(id);
    }
}
