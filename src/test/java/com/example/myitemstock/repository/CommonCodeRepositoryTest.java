package com.example.myitemstock.repository;

import com.example.myitemstock.entity.MajorCommonCode;
import com.example.myitemstock.entity.MiddleCommonCode;
import com.example.myitemstock.entity.MinorCommonCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class CommonCodeRepositoryTest {
    @Autowired CommonCodeRepository commonCodeRepository;
    @Autowired MiddleCodeRepository middleCodeRepository;

    //todo: 단순 저장 테스트
    @Test
    void save() {
        // 대분류 저장
        MajorCommonCode majorCommonCode = new MajorCommonCode();
        majorCommonCode.setCategoryCode("MAJ0001");
        majorCommonCode.setCategoryName("대분류1");
        Assertions.assertDoesNotThrow(() -> {
            commonCodeRepository.save(majorCommonCode);
        });

        // 중분류 저장
        MiddleCommonCode middleCommonCode = new MiddleCommonCode();
        middleCommonCode.setCategoryCode("MID0001");
        middleCommonCode.setCategoryName("중분류1");
        majorCommonCode.getMiddleCommonCodeList().add(middleCommonCode);
        Assertions.assertDoesNotThrow(() -> {
            commonCodeRepository.save(middleCommonCode);
        });

        // 소분류 저장
        MinorCommonCode minorCommonCode = new MinorCommonCode();
        minorCommonCode.setCategoryCode("MIN0001");
        minorCommonCode.setCategoryName("소분류1");
        middleCommonCode.getMinorCommonCodeList().add(minorCommonCode);
        Assertions.assertDoesNotThrow(() -> {
            commonCodeRepository.save(minorCommonCode);
        });

    }

    //todo: null값 저장 테스트
    @Test
    void saveNull() {
        Assertions.assertThrows(Exception.class, ()->{
            MajorCommonCode majorCommonCode = new MajorCommonCode();
            majorCommonCode.setCategoryCode("MAJ0001");
            commonCodeRepository.save(majorCommonCode);
        });

        Assertions.assertThrows(Exception.class, ()->{
            MiddleCommonCode middleCommonCode = new MiddleCommonCode();
            middleCommonCode.setCategoryName("중분류1");
            commonCodeRepository.save(middleCommonCode);
        });

        Assertions.assertThrows(Exception.class, ()->{
            MinorCommonCode minorCommonCode = new MinorCommonCode();
            minorCommonCode.setCategoryCode("MIN0001");
            commonCodeRepository.save(minorCommonCode);
        });
    }

    //todo: 상위 없는 하위 저장 테스트
    @Test
    void saveWithoutUpperCategory() {
        Assertions.assertThrows(Exception.class, () -> {
            MiddleCommonCode middleCommonCode = new MiddleCommonCode();
            middleCommonCode.setCategoryCode("MID0001");
            middleCommonCode.setCategoryName("중분류1");
            commonCodeRepository.save(middleCommonCode);
        });
    }
    //CasCade설정 없이 하위 있는 상위 삭제 테스트
//    @Test
    void deleteWithLowerCategoryNoCascade() {
        // 대분류 저장
        MajorCommonCode majorCommonCode = new MajorCommonCode();
        majorCommonCode.setCategoryCode("MAJ0001");
        majorCommonCode.setCategoryName("대분류1");

        commonCodeRepository.save(majorCommonCode);

        // 중분류 저장
        MiddleCommonCode middleCommonCode = new MiddleCommonCode();
        middleCommonCode.setCategoryCode("MID0001");
        middleCommonCode.setCategoryName("중분류1");
        majorCommonCode.getMiddleCommonCodeList().add(middleCommonCode);

        commonCodeRepository.save(middleCommonCode);

        // 소분류 저장
        MinorCommonCode minorCommonCode = new MinorCommonCode();
        minorCommonCode.setCategoryCode("MIN0001");
        minorCommonCode.setCategoryName("소분류1");
        middleCommonCode.getMinorCommonCodeList().add(minorCommonCode);

        commonCodeRepository.save(minorCommonCode);

        // delete 후 flush 발생시 예외가 나야 정상
        commonCodeRepository.delete(middleCommonCode);
        Assertions.assertThrows(Exception.class,() -> {
            commonCodeRepository.flush();
        });
    }
    @Test
    void deleteWithLowerCategoryCascade() {
        // 대분류 저장
        MajorCommonCode majorCommonCode = new MajorCommonCode();
        majorCommonCode.setCategoryCode("MAJ0001");
        majorCommonCode.setCategoryName("대분류1");

        commonCodeRepository.save(majorCommonCode);

        // 중분류 저장
        MiddleCommonCode middleCommonCode = new MiddleCommonCode();
        middleCommonCode.setCategoryCode("MID0001");
        middleCommonCode.setCategoryName("중분류1");
        majorCommonCode.getMiddleCommonCodeList().add(middleCommonCode);

        commonCodeRepository.save(middleCommonCode);

        // 소분류 저장
        MinorCommonCode minorCommonCode = new MinorCommonCode();
        minorCommonCode.setCategoryCode("MIN0001");
        minorCommonCode.setCategoryName("소분류1");
        middleCommonCode.getMinorCommonCodeList().add(minorCommonCode);

        commonCodeRepository.save(minorCommonCode);

        // delete 후 flush 발생시 예외가 안 나고, minor도 null 이어야 정상
        commonCodeRepository.delete(middleCommonCode);
        commonCodeRepository.flush();

        Assertions.assertNull(commonCodeRepository.findMinorByCategoryCode("MIN0001"));
    }
}