package model.responseDTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data

public class ImageResponseDto {
    private UUID id;
    private String originalName;
    private String mimeType;
    private Long size;
    private LocalDateTime uploadedAt;
    private String downloadUrl;
}
