package com.ucu.obligatoriobasededatos2023.carnet_salud;

import com.ucu.obligatoriobasededatos2023.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Carnet_saludService {
    @Autowired
    private final Carnet_saludRepository carnet_saludRepository;

    public Carnet_saludService(Carnet_saludRepository carnet_saludRepository) {
        this.carnet_saludRepository = carnet_saludRepository;
    }



    public List<Carnet_salud> getCarnet_salud() {
        return carnet_saludRepository.findAll();
    }

    public void addCarnet_salud(Carnet_salud carnet_salud) {
        var ci= carnet_salud.getCi().getCi();
        deleteCarnet_salud(ci);
        carnet_saludRepository.save(carnet_salud);
    }

    public void deleteCarnet_salud(long ci) {
        Carnet_salud carnet_salud = carnet_saludRepository.existsByCi(ci);
        if (carnet_salud!=null){
            carnet_saludRepository.delete(carnet_salud);
        }
    }

    public void updateCarnet_salud(long ci, Carnet_salud carnet_salud) {
        deleteCarnet_salud(ci);
        carnet_saludRepository.save(carnet_salud);
    }
}