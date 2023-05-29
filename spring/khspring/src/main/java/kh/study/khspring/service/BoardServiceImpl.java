package kh.study.khspring.service;

import kh.study.khspring.dto.FilesDto;
import kh.study.khspring.entity.Files;
import kh.study.khspring.entity.Board;
import kh.study.khspring.dto.BoardDto;
import kh.study.khspring.repository.BoardRepository;
import kh.study.khspring.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final FileRepository fileRepository;

    @Override
    public List<Board> findAll() throws SQLException {
        return boardRepository.findAll();
    }

    @Override
    public void save(BoardDto boardDto, MultipartFile[] files, String filePath) throws Exception {
        Board board = new Board(0L, boardDto.getWriter(), boardDto.getTitle(), boardDto.getContent(), null, null, null, null);
        Long saved = boardRepository.save(board);
        List<FilesDto> filesDto = transferFiles(files, filePath);
        if (filesDto.size() != 0) {
            uploadFiles(saved, filesDto);
        }
    }

    @Override
    public Board findBoardById(Long boardId) throws SQLException {
        return boardRepository.increaseViewCount(boardId)
                                .findById(boardId);
    }

    @Override
    public void delete(Long boardId) throws SQLException {
        boardRepository.delete(boardId);
    }

    @Override
    public void modify(Long boardId, Board board) throws SQLException {
        boardRepository.modify(boardId, board);
    }

    @Override
    public List<Files> findFilesByBoardId(Long boardId) throws SQLException {
        return fileRepository.findFilesByBoardId(boardId);
    }

    private String getRealPath(HttpSession session) {
        String realPath = session.getServletContext().getRealPath("upload");
        File realPathFile = new File(realPath);
        if (!realPathFile.exists()) {
            realPathFile.mkdir();
        }
        return realPath;
    }

    private List<FilesDto> transferFiles(MultipartFile[] files, String filePath) throws IOException {
        List<FilesDto> filesDto = new ArrayList<>();
        if (files != null) {
            for (MultipartFile file : files) {
                if(file.isEmpty()) {
                    break;
                }
                String oriName = file.getOriginalFilename();
                String sysName = UUID.randomUUID() + "_" + oriName;
                file.transferTo(new File(filePath + "/" + sysName));
                filesDto.add(new FilesDto(oriName, sysName));
            }
        }
        return filesDto;
    }

    private void uploadFiles(Long saved, List<FilesDto> filesDto) {
        filesDto.stream()
                .map(f -> new Files(0L, f.getOriName(), f.getSysName(), saved))
                .forEach(fileRepository::upload);
    }
}
