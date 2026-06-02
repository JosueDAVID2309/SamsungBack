package com.tarea.samsungshop.features.Auth.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String correo;
    private String clave;
    private String nombres;
    private String apellidos;
    private LocalDate f_nacimiento;
}
