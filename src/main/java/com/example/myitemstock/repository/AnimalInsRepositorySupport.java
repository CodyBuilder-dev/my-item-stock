package com.example.myitemstock.repository;

import com.example.myitemstock.entity.AnimalIns;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.myitemstock.entity.QAnimalIns.animalIns;

@Repository
public class AnimalInsRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;


    public AnimalInsRepositorySupport(JPAQueryFactory queryFactory){
        super(AnimalIns.class);
        this.queryFactory = queryFactory;
    }


    public List<AnimalIns> findByName(String name){
        return queryFactory
                .selectFrom(animalIns)
                .where(animalIns.name.eq(name))
                .fetch();
    }
}
