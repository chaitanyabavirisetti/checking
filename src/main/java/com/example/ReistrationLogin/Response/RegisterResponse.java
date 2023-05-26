package com.example.ReistrationLogin.Response;

import lombok.*;

@Builder

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegisterResponse
{
   String message;
   Boolean status;
}
