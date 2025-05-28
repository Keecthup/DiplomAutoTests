package model.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadlineNewsGroupDto {
    private List<HeadlineNewsDto> news;
    private Integer countPage;
}
