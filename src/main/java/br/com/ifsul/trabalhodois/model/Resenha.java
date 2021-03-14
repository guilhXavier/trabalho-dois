package br.com.ifsul.trabalhodois.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data
@NoArgsConstructor
@Builder
@Entity
@AllArgsConstructor
public class Resenha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String autor;

    private String conteudo;

    private Float nota;

    private String urlImagem;

    private Date dataCriacao;
}
