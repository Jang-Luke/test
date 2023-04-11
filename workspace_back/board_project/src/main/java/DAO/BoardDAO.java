package DAO;

import DTO.BoardDTO;
import commons.MyDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardDAO {
    private final BasicDataSource basicDataSource;
    private static BoardDAO instance = null;
    public synchronized static BoardDAO getInstance(){
        if (instance == null) {
            instance = new BoardDAO(MyDataSource.getBasicDataSource("/Users/luke/Documents/GitHub/test/workspace_back/board_project/src/main/resources/DB_properties.properties"));
        }
        return instance;
    }
    private BoardDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    public int insertContent(BoardDTO boardDTO) throws Exception {
        String sql = "INSERT INTO BOARD VALUES (0, ?, ?, ?, DEFAULT, DEFAULT)";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setString(1, boardDTO.getWriter());
            preparedStatement.setString(2, boardDTO.getTitle());
            preparedStatement.setString(3, boardDTO.getContents());
            int result = preparedStatement.executeUpdate();
            connection.commit();
            return result;
        }
    }
}
