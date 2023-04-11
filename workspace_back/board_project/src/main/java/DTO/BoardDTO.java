package DTO;

import java.sql.Timestamp;

public class BoardDTO {
    private long id;
    private String writer;
    private String title;
    private String contents;
    private int view_count;
    private Timestamp write_date;

    public BoardDTO(int id, String writer, String title, String contents, int view_count, Timestamp write_date) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.view_count = view_count;
        this.write_date = write_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public Timestamp getWrite_date() {
        return write_date;
    }

    public void setWrite_date(Timestamp write_date) {
        this.write_date = write_date;
    }
}
