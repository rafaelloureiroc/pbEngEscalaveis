package com.infnet.infnetPB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infnet.infnetPB.DTO.MesaDTO;
import com.infnet.infnetPB.model.Mesa;
import com.infnet.infnetPB.service.MesaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping("/lista")
    public List<Mesa> getAllMesas() {
        return mesaService.getAllMesas();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable Long id) {
        return mesaService.getMesaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/criar")
    public Mesa createMesa(@Valid @RequestBody MesaDTO mesaDTO) {
        Mesa mesa = new Mesa();
        mesa.setQtdAssentosMax(mesaDTO.getQtdAssentosMax());
        mesa.setInfoAdicional(mesaDTO.getInfoAdicional());
        mesa.setStatus(mesaDTO.getStatus());
        mesa.setNomeRestaurante(mesaDTO.getNomeRestaurante());
        mesa.setLocalizacao(mesaDTO.getLocalizacao());
        return mesaService.createMesa(mesa);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Mesa> updateMesa(@PathVariable Long id, @Valid @RequestBody MesaDTO mesaDTO) {
        return mesaService.getMesaById(id)
                .map(mesa -> {
                    mesa.setQtdAssentosMax(mesaDTO.getQtdAssentosMax());
                    mesa.setInfoAdicional(mesaDTO.getInfoAdicional());
                    mesa.setStatus(mesaDTO.getStatus());
                    mesa.setNomeRestaurante(mesaDTO.getNomeRestaurante());
                    mesa.setLocalizacao(mesaDTO.getLocalizacao());
                    Mesa updatedMesa = mesaService.updateMesa(mesa);
                    return ResponseEntity.ok(updatedMesa);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteMesa(@PathVariable Long id) {
        return mesaService.getMesaById(id)
                .map(mesa -> {
                    mesaService.deleteMesa(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
