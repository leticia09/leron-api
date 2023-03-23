package com.leron.api.model.DTO.userAuth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserValidResponse {
    private String name;
    private String login;
    private String password;
    private String sex;
}
