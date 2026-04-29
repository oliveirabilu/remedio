package com.exampleremedio.remedio.usuario;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService{
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getLogin())
                .password(user.getSenha())
                .roles("USER")
                .build();
    }
    public Usuario salvar(Usuario user) {
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        return usuarioRepository.save(user);
    }

}
