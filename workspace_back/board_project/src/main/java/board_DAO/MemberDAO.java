package board_DAO;

import board_DTO.MemberDTO;
import commons.MyDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    private final BasicDataSource basicDataSource;
    private static MemberDAO instance = null;
    public synchronized static MemberDAO getInstance(){
        if (instance == null) {
            instance = new MemberDAO(MyDataSource.getBasicDataSource("/Users/luke/Documents/GitHub/test/workspace_back/board_project/src/main/resources/DB_properties.properties"));
        }
        return instance;
    }

    private MemberDAO(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    public int insertMember(MemberDTO memberDTO) throws Exception{
        String sql = "INSERT INTO MEMBERS VALUES(?, ?, ?, ?, ?, ?, ?, ?, DEFAULT)";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setString(1, memberDTO.getId());
            preparedStatement.setString(2, memberDTO.getPw());
            preparedStatement.setString(3, memberDTO.getName());
            preparedStatement.setString(4, memberDTO.getPhone());
            preparedStatement.setString(5, memberDTO.getEmail());
            preparedStatement.setString(6, memberDTO.getZipcode());
            preparedStatement.setString(7, memberDTO.getAddress1());
            preparedStatement.setString(8, memberDTO.getAddress2());
            int result = preparedStatement.executeUpdate();
            connection.commit();
            System.out.println(result);
            return result;
        }
    }
    public boolean is_id_duplicated(String id) throws Exception{
        String sql = "SELECT * FROM MEMBERS WHERE ID = ?";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setString(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery();){
                return resultSet.next();
            }
        }
    }
}
