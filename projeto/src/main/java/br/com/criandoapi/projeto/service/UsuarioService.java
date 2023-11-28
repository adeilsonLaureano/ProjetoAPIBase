package br.com.criandoapi.projeto.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.model.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;

@Service
public class UsuarioService {
    private IUsuario repository;
    private PasswordEncoder passwordEncoder;
    
    public UsuarioService(IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    
    public List<Usuario> listarUsuario() {
        return repository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        return repository.save(usuario);
    }

    public Usuario editarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        return repository.save(usuario);
    }

    public boolean deletarUsuario(Integer id) {
        repository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario) {
        // Obtém a senha armazenada no banco de dados para o usuário fornecido
        String senha = repository.getReferenceById(usuario.getId()).getSenha();
        
        // Verifica se a senha fornecida pelo usuário corresponde à senha armazenada no banco de dados
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        
        // Retorna se as senhas correspondem
        return valid;
    }
    

    
    
}
