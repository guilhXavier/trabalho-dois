package br.com.ifsul.trabalhodois.controller;

import br.com.ifsul.trabalhodois.dto.resenha.request.ResenhaRequestDto;
import br.com.ifsul.trabalhodois.dto.resenha.response.ResenhaResponseDto;
import br.com.ifsul.trabalhodois.model.Resenha;
import br.com.ifsul.trabalhodois.service.ResenhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/resenha")
@RequiredArgsConstructor
public class ResenhaController {

    private final ResenhaService resenhaService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> cadastrarResenha(@RequestBody ResenhaRequestDto resenhaRequestDto) {
        return ResponseEntity.ok(resenhaService.cadastrarResenha(resenhaRequestDto));
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Page<ResenhaResponseDto>> buscarTodasResenhas(Pageable pageable) {
        return ResponseEntity.ok(resenhaService.buscarTodasResenhas(pageable));
    }

    @GetMapping(path = "/buscar/palavraChave/{palavraChave}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Page<ResenhaResponseDto>> buscarResenhasPorPalavraChave(@PathVariable("palavraChave") String palavraChave, Pageable pageable) {
        return ResponseEntity.ok(resenhaService.buscarResenhasPorPalavraChave(palavraChave, pageable));
    }

    @GetMapping(path = "/buscar/id/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<ResenhaResponseDto> buscarResenhaPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(resenhaService.buscarResenhaPorId(id));
    }
}
