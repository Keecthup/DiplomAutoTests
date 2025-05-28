package pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AuthLogin {
    public String username;
    public String password;
}
