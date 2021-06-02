package com.example.myitemstock.domain.common.service;

import com.example.myitemstock.entity.CommonCode;
import com.example.myitemstock.mapper.CommonCodeMapper;
import com.example.myitemstock.repository.CommonCodeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CommonCodeService {
    CommonCodeMapper commonCodeMapper;
    CommonCodeRepository commonCodeRepository;

    CommonCodeService(CommonCodeMapper commonCodeMapper,
                      CommonCodeRepository commonCodeRepository) {
        this.commonCodeMapper = commonCodeMapper;
        this.commonCodeRepository = commonCodeRepository;
    }

    public Object getCommonCodeList() {
        List<HashMap<Object,Object>> commonCodeList = commonCodeMapper.selectAllMajorCommonCodes();
        return null;
    }

    /**
     * 요구사항 : 존재하는 모든 공통코드를 JSON과 같은 계층구조로 반환
     */
    public List<CommonCode> getAllCommonCode() {
        return commonCodeRepository.findAll();
    }


}
