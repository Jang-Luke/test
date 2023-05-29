package kh.study.khspring.controller;

import kh.study.khspring.dto.Movie;
import kh.study.khspring.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MyBatisRepository {

    private final SqlSessionTemplate sqlSessionTemplate;


    public List<Movie> selectByCondition(SearchDto searchDto) {
        Map<String, String> params = new HashMap<>();
        params.put("column", searchDto.getColumn());
        params.put("keyword", searchDto.getKeyword());
        return sqlSessionTemplate.selectList("Movies.searchByCondition", params);
    }

    public List<Movie> selectByMultiCondition(Movie movie) {
        return sqlSessionTemplate.selectList("Movies.searchByMultiCondition", movie);
    }
}
