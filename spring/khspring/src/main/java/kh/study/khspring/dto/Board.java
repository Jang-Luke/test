package kh.study.khspring.dto;

import lombok.*;
import org.springframework.format.datetime.DateFormatter;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private Long viewCount;
    private Long LikeCount;
    private LocalDateTime writeDate;

    public String getFormedWriteDate() {
        Duration duration = Duration.between(writeDate, LocalDateTime.now());
        if (duration.toMinutes() < 3) {
            return "방금 전";
        } else if (duration.toMinutes() < 30) {
            return "30분 이내";
        } else if (duration.toHours() < 1) {
            return "한 시간 이내";
        } else if (duration.toDays() < 1) {
            return "오늘";
        } else {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd");
            return writeDate.toLocalDate().format(dateFormat);
        }
    }
}
