package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
