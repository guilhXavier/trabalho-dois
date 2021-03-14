package br.com.ifsul.trabalhodois.dto.resenha.response;

import br.com.ifsul.trabalhodois.model.Resenha;

public class ResenhaResponseDtoFactory {

    public static ResenhaResponseDto criar(Resenha resenha) {
        return ResenhaResponseDto.builder()
                .id(resenha.getId())
                .autor(resenha.getAutor())
                .conteudo(resenha.getConteudo())
                .dataCriacao(resenha.getDataCriacao())
                .nota(resenha.getNota())
                .urlImagem(resenha.getUrlImagem())
                .build();
    }
}
