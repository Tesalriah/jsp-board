package com.jnh.board.servlet.boundContext.member.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Data
@AllArgsConstructor
public class Member {
    private long id;
    private  String  username;
    private String password;
    private String name;
    private LocalDateTime regDate;

    public Member(Map<String, Object> row){
        this.id = ((BigInteger)row.get("id")).longValue();
        this.username = (String)row.get("username");
        this.password = (String)row.get("password");
        this.name = (String)row.get("name");
        this.regDate = (LocalDateTime)row.get("regDate");
    }

    public String getRegDate(){
        return regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
