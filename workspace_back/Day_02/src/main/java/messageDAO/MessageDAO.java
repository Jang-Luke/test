package messageDAO;

import commons.MyDataSource;
import messageDTO.Message;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    private BasicDataSource basicDataSource;
    private static MessageDAO instance = null;

    // synchronized : Multi Tread 가 동시에 메서드를 실행하지 못하게 막는 Thread safe 한 코드
    public synchronized static MessageDAO getInstance() {
        if (instance == null) {
            instance = new MessageDAO(MyDataSource.getBasicDataSource("/Users/luke/Documents/GitHub/test/workspace_back/Day_02/src/main/resources/DB_properties.properties"));
        }
        return instance;
    }

    private MessageDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    public int insertMessage(String writer, String message) {
        int result = 0;
        String sql = "INSERT INTO MESSAGES VALUES(0, ?, ?)";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);){
            prepareStatement.setString(1, writer);
            prepareStatement.setString(2, message);
            result = prepareStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteMessageById(int id){
        int result = 0;
        String sql = "DELETE FROM MESSAGES WHERE ID = ?";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public int updateMessageById(String message, int id){
        int result = 0;
        String sql = "UPDATE MESSAGES SET MESSAGE = ? WHERE ID = ?";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, message);
            preparedStatement.setInt(2, id);
            result = preparedStatement.executeUpdate();
            connection.commit();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Message> selectAll() {
        String sql = "SELECT * FROM MESSAGES ORDER BY 1 DESC";
        List<Message> messageList = new ArrayList<>();
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){
                messageList.add(createMessage(resultSet));
            }
            return messageList;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return messageList;
    }

    private Message createMessage(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String writer = resultSet.getString(2);
        String message = resultSet.getString(3);
        return new Message(id, writer, message);
    }
}
