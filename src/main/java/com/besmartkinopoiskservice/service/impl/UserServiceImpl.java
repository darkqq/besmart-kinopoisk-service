package com.besmartkinopoiskservice.service.impl;

import com.besmartkinopoiskservice.domain.UserEntity;
import com.besmartkinopoiskservice.exception.ServiceException;
import com.besmartkinopoiskservice.repository.UserRepository;
import com.besmartkinopoiskservice.service.UserService;
import com.besmartkinopoiskservice.to.domain.UserDetailsTO;
import com.besmartkinopoiskservice.to.response.user.UserDetailsResponseTO;
import com.besmartkinopoiskservice.to.response.user.UsersListResponseTO;
import com.besmartkinopoiskservice.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UsersListResponseTO getUsersList(String username) {
        List<UserEntity> users = userRepository.findAllByUsernameContaining(username);
        List<UserDetailsTO> usersDetailsList = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            usersDetailsList.add(UserMapper.toDto(users.get(i)));
        }
        return new UsersListResponseTO(usersDetailsList);
    }

    @Override
    public UserDetailsResponseTO getUserDetails(UUID userId) throws ServiceException{
        Optional<UserEntity> user = userRepository.findById(userId);
        if (!user.isPresent()){
            throw new ServiceException("Пользователя не существует");
        }
        return new UserDetailsResponseTO(UserMapper.toFullDto(user.get()));
    }
}
