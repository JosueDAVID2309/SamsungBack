package com.tarea.samsungshop.features.Auth.service;

import javax.management.RuntimeErrorException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.tarea.samsungshop.domain.model.Usuario;
import com.tarea.samsungshop.domain.repository.UsuarioRepository;
import com.tarea.samsungshop.features.Auth.dto.AuthTokens;
import com.tarea.samsungshop.features.Auth.dto.LoginRequest;
import com.tarea.samsungshop.features.Auth.dto.RegisterRequest;
import com.tarea.samsungshop.features.Auth.mapper.AuthMapper;
import com.tarea.samsungshop.features.Auth.utils.TokenUtil;

@Service
public class AuthService {
    private final UsuarioRepository repository;
    private final BCryptPasswordEncoder encoder;
    private final TokenUtil jwt;
    private final AuthMapper mapper;

    public AuthService(UsuarioRepository repository,
         TokenUtil jwt,
         BCryptPasswordEncoder encoder,
        AuthMapper mapper){
        this.repository = repository;
        this.jwt = jwt;
        this.encoder = encoder;
        this.mapper = mapper;
    }

    public AuthTokens login(LoginRequest request){
        //validar correo
        Usuario user = repository.findByCorreo(request.getCorreo()).orElseThrow(() -> new BadCredentialsException("Correo o contraseña invalido"));

        //validar contraseña
        if(!encoder.matches(request.getClave(),user.getClave())){
            throw new BadCredentialsException("Credenciales Incorrectas");
        }

        //generar tokens
        String access_token = jwt.generateAccessToken(user.getCorreo());
        String refresh_token = jwt.generateRefreshToken(user.getCorreo());
        
        return new AuthTokens(access_token, refresh_token);
    }

    public AuthTokens register(RegisterRequest request){

        //validar correo unico
        if(repository.existsByCorreo(request.getCorreo())){
            throw new RuntimeException("Este correo ya existe");
        }

        //añadir nuevo usuario
        Usuario user = mapper.toEntity(request);
        repository.save(user);

        //generar tokens
        String access_token = jwt.generateAccessToken(user.getCorreo());
        String refresh_token = jwt.generateRefreshToken(user.getCorreo());

        return new AuthTokens(access_token, refresh_token);
    }

}
