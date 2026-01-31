package com.example.correct.Easy.core.dto.response;

import com.example.correct.Easy.core.enums.Permission;

public record UserResponseDto(Long id, String fullName, String email, Permission permission){
}
