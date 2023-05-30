package kh.study.khspring.repository;

import kh.study.khspring.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisChatRepository implements ChatRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void save(ChatDto chatDto) {
        sqlSessionTemplate.insert("Chatting.insert", chatDto);
    }

    @Override
    public List<ChatDto> findAll() {
        return sqlSessionTemplate.selectList("Chatting.selectAll");
    }
}
