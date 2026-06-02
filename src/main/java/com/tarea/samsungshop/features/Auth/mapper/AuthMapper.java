package com.tarea.samsungshop.features.Auth.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tarea.samsungshop.domain.model.Usuario;
import com.tarea.samsungshop.features.Auth.dto.RegisterRequest;

@Component
public class AuthMapper {
    
    @Autowired
    private PasswordEncoder encoder;

    public Usuario toEntity(RegisterRequest request){
        Usuario user = new Usuario();

        user.setNombres(request.getNombres());
        user.setApellidos(request.getApellidos());
        user.setFechaNacimiento(request.getF_nacimiento());
        user.setCorreo(request.getCorreo());
        user.setClave(encoder.encode(request.getClave()));
        user.setEstado(Byte.parseByte("1"));

        return user;
    }
}
