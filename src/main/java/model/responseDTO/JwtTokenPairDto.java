package model.responseDTO;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class JwtTokenPairDto {
    private String refreshToken;
    private String accessToken;
}