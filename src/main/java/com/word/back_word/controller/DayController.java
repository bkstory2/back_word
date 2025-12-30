package com.word.back_word.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/day")
@CrossOrigin
public class DayController {

    private final SqlSession sqlSession;

    public DayController(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        return sqlSession.selectList("dayMapper.selectList");
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Map<String, Object> param) {
        return sqlSession.insert("dayMapper.insertDay", param);
    }

    @PostMapping("/update")
    public int update(@RequestBody Map<String, Object> param) {
        return sqlSession.update("dayMapper.updateDay", param);
    }

    @PostMapping("/delete")
    public int delete(@RequestBody Map<String, Object> param) {
        return sqlSession.delete("dayMapper.deleteDay", param);
    }
}
