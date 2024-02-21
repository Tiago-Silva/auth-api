package com.example.auth.domain.user;

import com.example.auth.domain.permissions.Permission;

import java.util.List;

public record RegisterDTO(String nome, String sobreNome,String login, String password, Boolean accountNonExpired,
                          Boolean accountNonLocked, Boolean credentialsNonExpired,
                          Boolean enabled, List<Permission> permissions) {
}
