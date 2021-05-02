package com.example.myitemstock.repository;


import com.example.myitemstock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Repository는 오직 Data 전달만 하도록 설계
    // (1)왜 JPARepository를 extends할까?
    // (2) Spring Data JPA대신 JPA를 그냥 쓸 순 없나?
}
