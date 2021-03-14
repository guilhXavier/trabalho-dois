package br.com.ifsul.trabalhodois.service;

import br.com.ifsul.trabalhodois.dto.resenha.request.ResenhaRequestDto;
import br.com.ifsul.trabalhodois.dto.resenha.request.ResenhaRequestDtoFactory;
import br.com.ifsul.trabalhodois.dto.resenha.response.ResenhaResponseDto;
import br.com.ifsul.trabalhodois.dto.resenha.response.ResenhaResponseDtoFactory;
import br.com.ifsul.trabalhodois.model.Resenha;
import br.com.ifsul.trabalhodois.repository.ResenhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResenhaService {

    private final ResenhaRepository repository;

    public String cadastrarResenha(ResenhaRequestDto resenhaRequestDto) {
        repository.save(ResenhaRequestDtoFactory.toModel(resenhaRequestDto));

        return "Cadastrado!";
    }

    public ResenhaResponseDto buscarResenhaPorId(Integer id) {
        return ResenhaResponseDtoFactory.criar(repository.findById(id).orElse(new Resenha()));
    }

    public List<ResenhaResponseDto> buscarTodasResenhas(Pageable pageable) {
        return repository.findAll(pageable)
                .stream()
                .map(ResenhaResponseDtoFactory::criar)
                .collect(Collectors.toList());
    }

    public List<ResenhaResponseDto> buscarResenhasPorPalavraChave(String palavraChave, Pageable pageable) {
        return repository.findAllByConteudoContains(palavraChave, pageable)
                .stream()
                .map(ResenhaResponseDtoFactory::criar)
                .collect(Collectors.toList());
    }
}
