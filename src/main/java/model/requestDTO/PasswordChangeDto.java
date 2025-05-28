package model.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordChangeDto {
    private String oldPassword;
    private String password;
    private String confirmPassword;
}
