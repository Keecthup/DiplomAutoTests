package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadlineNewsGroupDto {
    List<HeadlineNewsDto> news;
    int countPage;
}
