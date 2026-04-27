package com.jnh.board.servlet.boundContext.member.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
    private final long id;
    private  String  username;
    private String password;
    private String name;
}
