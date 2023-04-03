package messageDTO;

public class Message {
    private int id;
    private String writer;
    private String message;

    public Message(int id, String writer, String message) {
        this.id = id;
        this.writer = writer;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "글 번호 : " + this.id + "<br>작성자 : " + this.writer + "<br>메세지 : " + this.message + "<br>=======================";
    }
}
