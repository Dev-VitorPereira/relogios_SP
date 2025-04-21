package com.relogios.relogios_SP.controller;

import com.relogios.relogios_SP.DTO.RelogioDTO;
import com.relogios.relogios_SP.service.RelogioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/relogios")

public class RelogioController {

    @Autowired
    private RelogioService relogioService;

    @GetMapping
    public List<RelogioDTO> listaTodos(){
        return relogioService.listarTodos();
    }
    @GetMapping ("/{id}")
    public RelogioDTO bucarPorId(@PathVariable Long id){
        return relogioService.bucarPorId(id);
    }

    @PostMapping
    public RelogioDTO salvar(@RequestBody RelogioDTO dto){
        return relogioService.salvar(dto);
    }
    @PutMapping("/{id}")
    public RelogioDTO atualizar(@PathVariable Long id, @RequestBody RelogioDTO dto) {
        return relogioService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        relogioService.deletar(id);
    }
}
