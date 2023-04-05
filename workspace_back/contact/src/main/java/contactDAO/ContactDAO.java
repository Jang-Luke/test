package contactDAO;

import commons.MyDataSource;
import contactDTO.ContactDTO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private final BasicDataSource basicDataSource;
    private static ContactDAO instance = null;
    public synchronized static ContactDAO getInstance(){
        if (instance == null) {
            instance = new ContactDAO(MyDataSource.getInstance("/Users/luke/Documents/GitHub/test/workspace_back/contact/src/main/resources/DB_properties.properties"));
        }
        return instance;
    }

    private ContactDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }


    public int insertContact(ContactDTO contactDTO) {
        int result = 0;
        String sql = "INSERT INTO CONTACTS VALUES(0, ?, ?, ?)";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setString(1, contactDTO.getName());
            preparedStatement.setString(2, contactDTO.getContact());
            preparedStatement.setString(3, contactDTO.getBirthday());
            result = preparedStatement.executeUpdate();
            connection.commit();
        } catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }

    public int deleteContact(int id) {
        int result = 0;
        String sql = "DELETE FROM CONTACTS WHERE ID = ?";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
            connection.commit();
        } catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }

    public int updateContact(ContactDTO contactDTO) {
        int result = 0;
        String sql = "UPDATE CONTACTS SET NAME = ?, CONTACT = ?, BIRTHDAY = ? WHERE ID = ?";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, contactDTO.getName());
            preparedStatement.setString(2, contactDTO.getContact());
            preparedStatement.setString(3, contactDTO.getBirthday());
            preparedStatement.setInt(4, contactDTO.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }

    public List<ContactDTO> SelectAll() {
        String sql = "SELECT * FROM CONTACTS";
        List<ContactDTO> contactList = new ArrayList<>();
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();){
            while(resultSet.next()){
                contactList.add(createContact(resultSet));
            }
        } catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return contactList;
    }

    private ContactDTO createContact(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String contact = resultSet.getString(3);
        Timestamp birthday = resultSet.getTimestamp(4);
        return new ContactDTO(id, name, contact, birthday);
    }

}
