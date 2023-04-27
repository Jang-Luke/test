package dao;

import dto.FilesDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilesDAO {
    private static FilesDAO instance = null;

    public synchronized static FilesDAO getInstance() {
        if (instance == null) {
            instance = new FilesDAO();
        }
        return instance;
    }

    private Connection getConnection() throws Exception{
        Context initialContext = new InitialContext();
        Context envContext = (Context) initialContext.lookup("java:/comp/env");
        DataSource dataSource = (DataSource) envContext.lookup("jdbc/mysql");

        return dataSource.getConnection();
    }

    public void insertFile(FilesDTO filesDTO) throws Exception {
        String sql = "INSERT INTO FILES VALUES(0, ?, ?, ?, ?)";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setString(1, filesDTO.getOriginalName());
            preparedStatement.setString(2, filesDTO.getSystemName());
            preparedStatement.setString(3, filesDTO.getFilePath());
            preparedStatement.setLong(4, filesDTO.getParentId());
            preparedStatement.executeUpdate();
        }
    }

    public List<FilesDTO> findAllFiles() throws Exception {
        String sql = "SELECT * FROM FILES";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            try(ResultSet resultSet = preparedStatement.executeQuery();){
                List<FilesDTO> fileList = new ArrayList<>();
                while (resultSet.next()) {
                    fileList.add(getFileContainer(resultSet));
                }
                return fileList;
            }
        }
    }
public String testMethod(String a) throws Exception {
    String sql = "UPDATE TEST_RS SET NAME = ? WHERE ID = 1";
    String[] columnNames = new String[] {"VALUE"};
    System.out.println(sql);
    try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql, columnNames)) {
        preparedStatement.setString(1, a);
        preparedStatement.executeUpdate();
        try(ResultSet resultSet = preparedStatement.getResultSet()){
            resultSet.next();
            String value = resultSet.getString("VALUE");
            System.out.println(value);
            return value;
        } // 디폴트 값도 오토제네레이티드 키 인가?
    }
}

    private FilesDTO getFileContainer(ResultSet resultSet) throws Exception {
        long id = resultSet.getLong("ID");
        String originalName = resultSet.getString("ORIGINAL_NAME");
        String systemName = resultSet.getString("SYSTEM_NAME");
        String filePath = resultSet.getString("FILE_PATH");
        long parentId = resultSet.getLong("PARENT_ID");
        return FilesDTO.builder()
                .id(id)
                .originalName(originalName)
                .systemName(systemName)
                .filePath(filePath)
                .parentId(parentId)
                .build();
    }
}
