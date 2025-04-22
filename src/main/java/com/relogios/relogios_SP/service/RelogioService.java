package com.relogios.relogios_SP.service;

import com.relogios.relogios_SP.DTO.RelogioDTO;
import com.relogios.relogios_SP.DTO.RelogioMapper;
import com.relogios.relogios_SP.model.Relogio;
import com.relogios.relogios_SP.repository.RelogioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelogioService {

    @Autowired
    private RelogioRepository repository;

    public List<RelogioDTO> listarTodos(){
        return repository.findAll().stream()
                .map(RelogioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RelogioDTO bucarPorId(Long id){
        Relogio relogio = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relogio não encontrado"));
        return RelogioMapper.toDTO(relogio);
    }

    public RelogioDTO salvar(RelogioDTO dto){
        Relogio novo = RelogioMapper.toEntity(dto);
        Relogio salvo = repository.save(novo);
        return RelogioMapper.toDTO(salvo);
    }

    public RelogioDTO atualizar(Long id, RelogioDTO dto) {
        Relogio existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Relógio não encontrado"));

        existente.setNumberRelogio(dto.numberRelogio());
        existente.setAddressRelogio(dto.addressRelogio());
//        existente.setLatitude(dto.latitude());
//        existente.setLongitude(dto.longitude());

        Relogio atualizado = repository.save(existente);
        return RelogioMapper.toDTO(atualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
