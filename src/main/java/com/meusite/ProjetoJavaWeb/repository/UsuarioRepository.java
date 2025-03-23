package com.meusite.ProjetoJavaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meusite.ProjetoJavaWeb.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email); // <-- Adicione esse método aqui
}
