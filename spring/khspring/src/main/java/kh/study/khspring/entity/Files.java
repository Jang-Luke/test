package kh.study.khspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Files {
    private Long id;
    private String oriName;
    private String sysName;
    private Long parentId;
}
