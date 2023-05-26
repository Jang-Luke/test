package kh.study.khspring.repository;

import kh.study.khspring.entity.Files;

import java.util.List;

public interface FileRepository {
    void upload(Files file);
    List<Files> findFilesByBoardId(Long BoardId);
}
