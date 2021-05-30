package com.example.myitemstock.entity;

import javax.persistence.*;

@Entity
public class Password {
    public Password() {}

    public Password(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public void setId(long id) { this.id = id; }


    private String password;
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    // 유저<->패스워드 관계는 단방향으로 설정
    // 단방향으로 하는 이유 : 패스워드로부터 유저를 알아낼 수 있으면 위험하다!
//    @OneToOne(mappedBy = "password")
//    private User user;

}
