package kh.study.khspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    private Long id;
    private String sender;
    private String message;
    private LocalDateTime writeDate;
}
