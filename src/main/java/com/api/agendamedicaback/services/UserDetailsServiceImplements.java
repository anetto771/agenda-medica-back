package com.api.agendamedicaback.security;

import com.api.agendamedicaback.domain.Pessoa;
import com.api.agendamedicaback.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserDetailsServiceImplements implements UserDetailsService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Pessoa> user = repository.findByEmail(email);
        if (user.isPresent()){
            return new UserSS(
                    user.get().getId(),
                    user.get().getEmail(),
                    user.get().getSenha(),
                    user.get().getPerfis()
            );
        }
        throw new UsernameNotFoundException(email);
    }

}


