package com.example.myitemstock.repository;

import com.example.myitemstock.entity.AnimalIns;
import com.example.myitemstock.entity.CommonCode;
import com.example.myitemstock.entity.MiddleCommonCode;
import com.example.myitemstock.entity.MinorCommonCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonCodeRepository extends JpaRepository<CommonCode, Integer> {
    MiddleCommonCode findMiddleByCategoryCode(String categoryCode);
    MinorCommonCode findMinorByCategoryCode(String categoryCode);
}
