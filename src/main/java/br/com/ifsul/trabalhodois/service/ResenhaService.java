package br.com.ifsul.trabalhodois.service;

import br.com.ifsul.trabalhodois.dto.resenha.request.ResenhaRequestDto;
import br.com.ifsul.trabalhodois.dto.resenha.request.ResenhaRequestDtoFactory;
import br.com.ifsul.trabalhodois.dto.resenha.response.ResenhaResponseDto;
import br.com.ifsul.trabalhodois.dto.resenha.response.ResenhaResponseDtoFactory;
import br.com.ifsul.trabalhodois.model.Resenha;
import br.com.ifsul.trabalhodois.repository.ResenhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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

    public Page<ResenhaResponseDto> buscarTodasResenhas(Pageable pageable) {
        return repository.findAll(pageable).map(ResenhaResponseDtoFactory::criar);
    }

    public Page<ResenhaResponseDto> buscarResenhasPorPalavraChave(String palavraChave, Pageable pageable) {
        return repository.findAllByConteudoContains(palavraChave, pageable).map(ResenhaResponseDtoFactory::criar);
    }
}
