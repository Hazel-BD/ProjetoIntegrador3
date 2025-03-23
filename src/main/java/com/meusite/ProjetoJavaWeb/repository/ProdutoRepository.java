package com.meusite.ProjetoJavaWeb.repository;

import com.meusite.ProjetoJavaWeb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário.
}
