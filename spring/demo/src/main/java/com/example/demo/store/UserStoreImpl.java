package com.example.demo.store;

import com.example.demo.commons.DataSource;
import com.example.demo.commons.MySqlConnection;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserStoreImpl implements UserStore {

    private Map<String, User> userMap;

    public UserStoreImpl() {
        this.userMap = new HashMap<>();
    }

    @Override
    public String create(User newUser) {
        String sql = "INSERT INTO users VALUES(0, ?, ?)";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement()) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.userMap.put(newUser.getId(), newUser);
        return newUser.getId();
    }

    @Override
    public void update(User newUser) {
        this.userMap.put(newUser.getId(), newUser);
    }

    @Override
    public void delete(String id) {
        this.userMap.remove(id);
    }

    @Override
    public User retrieve(String id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> retrieveAll() {
        return this.userMap.values().stream()
                .collect(Collectors.toList());
    }
}
