package br.com.ifsul.trabalhodois.repository;

import br.com.ifsul.trabalhodois.model.Resenha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ResenhaRepository extends JpaRepository<Resenha, Integer> {

    List<Resenha> findAllByConteudoContains(String palavraChave, Pageable pageable);

    Resenha findResenhaByAutorEquals(String autor);

    List<Resenha> findAll(Pageable pageable);

}
