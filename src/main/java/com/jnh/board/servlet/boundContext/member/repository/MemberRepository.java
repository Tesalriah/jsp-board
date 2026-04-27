package com.jnh.board.servlet.boundContext.member.repository;

import com.jnh.board.db.DBConnection;
import com.jnh.board.servlet.boundContext.base.Container;
import com.jnh.board.servlet.boundContext.member.dto.Member;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private List<Member>  memberList;
    private long lastId;
    private DBConnection dbConnection;

    public MemberRepository() {
        memberList = new ArrayList<>();
        dbConnection = Container.dbConnection;
    }

    public void save(String username, String password, String name) {
        String encryptedPassword = Base64.getEncoder().encodeToString((password + "salt").getBytes());

        dbConnection.insert("""
                insert into member
                set username = '%s',
                password = '%s',
                name = '%s',
                regDate = now()
                """.formatted(username, encryptedPassword, name)
        );
    }

    public Member findByUsername(String username) {
        Map<String, Object> row = dbConnection.selectRow("select * from member where username = '%s'".formatted(username));
        Member member = null;
        if(row.size() != 0){
            member = new Member(row);
        }
        return member;
    }
}
