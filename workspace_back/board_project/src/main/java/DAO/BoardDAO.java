package DAO;

import DTO.BoardDTO;
import commons.MyDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private final BasicDataSource basicDataSource;
    private static BoardDAO instance = null;

    public synchronized static BoardDAO getInstance() {
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
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, boardDTO.getWriter());
            preparedStatement.setString(2, boardDTO.getTitle());
            preparedStatement.setString(3, boardDTO.getContents());
            int result = preparedStatement.executeUpdate();
            connection.commit();
            return result;
        }
    }

    public int deleteContent(BoardDTO targetContent) throws Exception {
        String sql = "DELETE FROM BOARD WHERE ID = ?";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setLong(1, targetContent.getId());
            int result = preparedStatement.executeUpdate();
            connection.commit();
            return result;
        }
    }

    public List<BoardDTO> selectAll() throws Exception { //findAll
        String sql = "SELECT * FROM BOARD";
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                List<BoardDTO> contentsList = new ArrayList<>();
                while (resultSet.next()) {
                    contentsList.add(getContentsContainer(resultSet));
                }
                return contentsList;
            }
        }
    }

    public int updateContent(BoardDTO targetContent) throws Exception {
        String sql = "UPDATE BOARD SET TITLE = ?, CONTENTS = ? WHERE ID = ?";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setString(1, targetContent.getTitle());
            preparedStatement.setString(2, targetContent.getContents());
            preparedStatement.setLong(3, targetContent.getId());
            int result = preparedStatement.executeUpdate();
            connection.commit();
            return result;
        }
    }

    public BoardDTO searchById(long id) throws Exception {
        String sql = "SELECT * FROM BOARD WHERE ID = ?";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    return getContentsContainer(resultSet);
                } else {
                    throw new Exception("해당하는 게시글이 없습니다.");
                }
            }
        }
    }
    public BoardDTO viewTargetContent(BoardDTO targetContent) throws Exception {
        String sql = "UPDATE BOARD SET VIEW_COUNT = ? WHERE ID = ?";
        try(Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setInt(1, (targetContent.getViewCount()+1));
            preparedStatement.setLong(2, targetContent.getId());
            preparedStatement.executeUpdate();
            connection.commit();
            return searchById(targetContent.getId());
        }
    }

    private BoardDTO getContentsContainer(ResultSet resultSet) throws Exception { //
        long id = resultSet.getLong("ID");
        String writer = resultSet.getString("WRITER");
        String title = resultSet.getString("TITLE");
        String contents = resultSet.getString("CONTENTS");
        int view_count = resultSet.getInt("view_count");
        Timestamp write_date = resultSet.getTimestamp("WRITE_DATE");
        return new BoardDTO(id, writer, title, contents, view_count, write_date);
    }

    public String getPageNavi() throws Exception {
        // 네비게이터를 만들기 위해 필요한 초기 정보
        String sql = "SELECT COUNT(*) FROM BOARD";
        int recordTotalCount = selectAll().size(); // 1. 전체 글의 개수 (147)
        int recordCountPerPage = 10; // 2. 페이지 당 보여줄 글의 개수
        int naviCountPerPage = 10; // 3. 페이지 당 보여줄 네비게이터의 개수

        int pageTotalCount = (int)Math.ceil((double)recordTotalCount/recordCountPerPage);
        // 4. 1번과 2번 항목에 의해 총 페이지의 개수가 정해짐. 나머지가 발생하면 페이지 + 1

        int currentPage = 20;

        int startNavi = (currentPage-1) / naviCountPerPage * naviCountPerPage + 1;
        int endNavi = startNavi+(naviCountPerPage-1);
        System.out.println("현재 페이지 : " + currentPage);
        System.out.println("네비 시작 값 : " + startNavi);
        System.out.println("네비 끝 값 : " + endNavi);
        return "";
    }
}
