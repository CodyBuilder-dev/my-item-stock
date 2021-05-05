package com.example.myitemstock.repository;

import com.example.myitemstock.entity.AnimalIns;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.myitemstock.entity.QAnimalIns.animalIns;

@Repository
public class AnimalInsRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory query;

    public AnimalInsRepositorySupport(JPAQueryFactory query){
        super(AnimalIns.class);
        this.query = query;
    }

    public List<AnimalIns> findAnimalIns(){
        return query.selectFrom(animalIns);
    }

    public List<AnimalIns> findAnimalInsByName(String name){
        return query.selectFrom(animalIns)
                .where(animalIns.name.eq(name));
    }
}
