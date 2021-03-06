package br.com.ifsul.trabalhodois.dto.resenha.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResenhaResponseDto {

    private Integer id;

    private String autor;

    private String conteudo;

    private Float nota;

    private String urlImagem;

    private Date dataCriacao;
}
