package model.responseDTO;

import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthLoginResponse {
    private JwtTokenPairDto tokens;
    private List<String> roles;
}

