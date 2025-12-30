package com.word.back_word.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/word")
@CrossOrigin
public class WordController {

    private final SqlSession sqlSession;

    public WordController(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @GetMapping("/list/{d_seq}")
    public List<Map<String, Object>> list(@PathVariable int d_seq) {
        return sqlSession.selectList("wordMapper.selectByDay", d_seq);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Map<String, Object> param) {
        return sqlSession.insert("wordMapper.insertWord", param);
    }

    @PostMapping("/update")
    public int update(@RequestBody Map<String, Object> param) {
        return sqlSession.update("wordMapper.updateWord", param);
    }

    @PostMapping("/delete")
    public int delete(@RequestBody Map<String, Object> param) {
        return sqlSession.delete("wordMapper.deleteWord", param);
    }
}
