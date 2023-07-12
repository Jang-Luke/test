package kh.study.khspring.repository;

import kh.study.khspring.entity.Files;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void upload(Files file) {
        sqlSessionTemplate.insert("Files.upload", file);
    }

    @Override
    public List<Files> findFilesByBoardId(Long boardId) {
        return sqlSessionTemplate.selectList("Files.selectByBoardId", boardId);
    }
}
