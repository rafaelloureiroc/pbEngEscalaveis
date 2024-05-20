package com.infnet.infnetPB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infnet.infnetPB.repository.MesaRepository;
import com.infnet.infnetPB.model.Mesa;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    public Optional<Mesa> getMesaById(Long id) {
        return mesaRepository.findById(id);
    }

    public Mesa createMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id);
    }

    public Mesa updateMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }
}
