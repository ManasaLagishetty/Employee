package com.evoke.employee.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JwtResponse {

    private  String jwtToken;

    private String username;

}
