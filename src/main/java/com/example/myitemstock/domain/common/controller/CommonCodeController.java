package com.example.myitemstock.domain.common.controller;

import com.example.myitemstock.domain.common.service.CommonCodeService;
import com.example.myitemstock.entity.CommonCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommonCodeController {
    CommonCodeService commonCodeService;

    CommonCodeController(CommonCodeService commonCodeService) {
        this.commonCodeService = commonCodeService;
    }

    @GetMapping("/api/common/code")
    public ResponseEntity getCommonCodeList() {
        List<CommonCode> commonCodeList =commonCodeService.getAllCommonCode();
        return new ResponseEntity(commonCodeList, HttpStatus.OK);
    }

    @PostMapping("/api/common/code/major")
    public ResponseEntity addMajorCommonCode() {
        return null;
    }

    @PostMapping("/api/common/code/middle")
    public ResponseEntity addMiddleCommonCode() {
        return null;
    }

    @PostMapping("/api/common/code/minor")
    public ResponseEntity addMinorCommonCode() {
        return null;
    }

    @PutMapping("/api/common/code/major")
    public ResponseEntity editMajorCommonCode() {
        return null;
    }

    @PutMapping("/api/common/code/middle")
    public ResponseEntity editMiddleCommonCode() {
        return null;
    }

    @PutMapping("/api/common/code/minor")
    public ResponseEntity editMinorCommonCode() {
        return null;
    }

    @DeleteMapping("/api/common/code/major")
    public ResponseEntity deleteMajorCommonCode() {
        return null;
    }

    @DeleteMapping("/api/common/code/middle")
    public ResponseEntity deleteMiddleCommonCode() {
        return null;
    }

    @DeleteMapping("/api/common/code/minor")
    public ResponseEntity deleteMinorCommonCode() {
        return null;
    }

}
