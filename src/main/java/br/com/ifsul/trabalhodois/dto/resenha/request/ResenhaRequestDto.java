package br.com.ifsul.trabalhodois.dto.resenha.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ResenhaRequestDto {

    private String autor;

    private String conteudo;

    private Float nota;

    private String urlImagem;

}
