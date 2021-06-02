package com.example.myitemstock.repository;

import com.example.myitemstock.entity.AnimalIns;
import com.example.myitemstock.entity.CommonCode;
import com.example.myitemstock.entity.MinorCommonCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonCodeRepository extends JpaRepository<CommonCode, String> {
    MinorCommonCode findMinorByCategoryCode(String categoryCode);
}
