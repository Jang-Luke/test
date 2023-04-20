package dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilesDTO {
    private long id;
    private String originalName;
    private String systemName;
    private String filePath;
    private long parentId;
}
