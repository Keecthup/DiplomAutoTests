package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuildOrderDto {
    private String header;
    private String message;
    private String pseudonym;
}
