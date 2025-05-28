package pojo;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class JwtTokenPairDto {
    String refreshToken;
    String accessToken;
}