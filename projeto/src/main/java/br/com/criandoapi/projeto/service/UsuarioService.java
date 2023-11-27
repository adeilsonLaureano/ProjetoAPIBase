package br.com.criandoapi.projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.model.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;

@Service
public class UsuarioService {
    private IUsuario repository;
    public UsuarioService(IUsuario repository) {
        this.repository = repository;
    }
    
    public List<Usuario> listarUsuario() {
        return repository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario editarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public boolean deletarUsuario(Integer id) {
        repository.deleteById(id);
        return true;
    }
    
}
