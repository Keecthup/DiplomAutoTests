package model.responseDTO;

import lombok.Data;

import java.util.List;

@Data
public class UserProfileDto {
    private String username;
    private List<String> roles;
    private String avatarUrl;
}
