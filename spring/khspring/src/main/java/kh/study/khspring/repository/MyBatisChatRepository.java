package kh.study.khspring.repository;

import kh.study.khspring.dto.Chat;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisChatRepository implements ChatRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void save(Chat chat) {
        sqlSessionTemplate.insert("Chatting.insert", chat);
    }

    @Override
    public List<Chat> findAll() {
        return sqlSessionTemplate.selectList("Chatting.selectAll");
    }
}
