package br.com.dea.management.user.dto;

import br.com.dea.management.user.domain.User;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String linkedin;

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setLinkedin(user.getLinkedin());

        return userDto;
    }

    public static List<UserDto> fromUsers(List<User> users) {
        return users.stream().map(user -> {
            UserDto userDto = UserDto.fromUser(user);
            return userDto;
        }).collect(Collectors.toList());
    }
}
