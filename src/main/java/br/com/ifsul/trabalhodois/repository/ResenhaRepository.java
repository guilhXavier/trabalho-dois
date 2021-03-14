package br.com.ifsul.trabalhodois.repository;

import br.com.ifsul.trabalhodois.model.Resenha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResenhaRepository extends JpaRepository<Resenha, Integer> {

    Page<Resenha> findAllByConteudoContains(String palavraChave, Pageable pageable);

    Resenha findResenhaByAutorEquals(String autor);

    Page<Resenha> findAll(Pageable pageable);
}
