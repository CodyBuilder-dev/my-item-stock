package com.example.myitemstock.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    private String nickname;
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @OneToOne
    @NotNull
    private Password password;
    public void setPassword(Password password) {this.password = password; }
    public Password getPassword() { return password; }

    // DDD 스타일의 비밀번호 체크 로직을 짜려다 그냥 포기함
    // 포기한 이유 :
    // (1) DDD 스타일 코드는 엔티티 내부적으로 상태를 가지고, 이를 바꿔야 할 떄 의미가 있음
    // (2) 외부에서 온 값과 내부 값을 비교할 때는 굳이 DDD 스타일 코드가 필요 없음
//    @Transient
//    private PasswordRepository passwordRepository;

//    public boolean checkPassWord() {
//    }


    // 1대다 단방향 관계
    @OneToMany
    @JoinColumn(name = "USER_ID")
    private Set<Item> items;

    public Set<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }





}
