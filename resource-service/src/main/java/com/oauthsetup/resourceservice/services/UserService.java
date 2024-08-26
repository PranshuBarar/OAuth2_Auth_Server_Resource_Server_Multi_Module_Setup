package com.oauthsetup.resourceservice.services;


import com.oauthsetup.reposervice.Dto.UserDto;
import com.oauthsetup.reposervice.entities.UserEntity;
import com.oauthsetup.reposervice.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String signup(UserDto userDto) {

        UserEntity userEntity = userRepository.findByUsername(userDto.getUsername());

        if(userEntity != null) {
            return "User already exists with this username";
        }

        userEntity = new UserEntity();

        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());

        userRepository.save(userEntity);

        return "User Created Successfully";
    }
}
