package model.requestDTO;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class NewsRequestDto {
    private String title;
    private String content;
}
