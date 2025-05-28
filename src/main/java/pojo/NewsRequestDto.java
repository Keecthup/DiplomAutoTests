package pojo;
import lombok.*;
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class NewsRequestDto {
    public String title;
    public String content;
}
