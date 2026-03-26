package com.app.controller;

import org.springframework.web.bind.annotation.*;
import com.app.model.Tariff;
import com.app.service.TariffService;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api/admin/tariffs")
public class TariffController {

    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @PostMapping
    public Tariff addTariff(@RequestBody Tariff tariff) {
        return tariffService.addTariff(tariff);
    }

    @GetMapping
    public List<Tariff> getAllTariffs() {
        return tariffService.getAllTariffs();
    }

    @PutMapping("/{id}")
    public Tariff updateTariff(@PathVariable Long id, @RequestBody Tariff tariff) {
        return tariffService.updateTariff(id, tariff);
    }

    @DeleteMapping("/{id}")
    public void deleteTariff(@PathVariable Long id) {
        tariffService.deleteTariff(id);
    }
}
