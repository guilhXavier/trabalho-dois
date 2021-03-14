package br.com.ifsul.trabalhodois.dto.resenha.request;

import br.com.ifsul.trabalhodois.model.Resenha;

import java.sql.Date;
import java.util.Calendar;

public class ResenhaRequestDtoFactory {

    public static ResenhaRequestDto criar(String autor, String conteudo, Float nota, String urlImagem) {
        return ResenhaRequestDto.builder()
                .autor(autor)
                .conteudo(conteudo)
                .nota(nota)
                .urlImagem(urlImagem)
                .build();
    }

    public static Resenha toModel(ResenhaRequestDto resenhaRequestDto) {
        return Resenha.builder()
                .autor(resenhaRequestDto.getAutor())
                .conteudo(resenhaRequestDto.getConteudo())
                .nota(resenhaRequestDto.getNota())
                .urlImagem(resenhaRequestDto.getUrlImagem())
                .dataCriacao(new Date(Calendar.getInstance().getTime().getTime()))
                .build();
    }
}
