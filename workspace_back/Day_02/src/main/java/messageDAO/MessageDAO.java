package messageDAO;

import messageDTO.Message;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    private static BasicDataSource basicDataSource = new BasicDataSource();

    public void setBasicDataSource() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        this.basicDataSource.setUrl("jdbc:mysql://kh.cvssgzojc9ja.ap-northeast-2.rds.amazonaws.com:3306/syhrje10_db");
        this.basicDataSource.setUsername("syhrje10");
        this.basicDataSource.setPassword("vtrol!Q2w3e");
        this.basicDataSource.setInitialSize(8);
    }

    public int insertMessage(String writer, String message) {
        int result = 0;
        String sql = "INSERT INTO MESSAGES VALUES(0, ?, ?)";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);){
            prepareStatement.setString(1, writer);
            prepareStatement.setString(2, message);
            result = prepareStatement.executeUpdate();
//          con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<Message> selectAll() {
        String sql = "SELECT * FROM MESSAGES";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            List<Message> messageList = new ArrayList<>();
            while(resultSet.next()){
                messageList.add(createMessage(resultSet));
            }
            return messageList;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<Message>();
    }

    private Message createMessage(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String writer = resultSet.getString(2);
        String message = resultSet.getString(3);
        return new Message(id, writer, message);
    }
}
