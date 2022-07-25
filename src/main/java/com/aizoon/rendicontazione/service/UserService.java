package com.aizoon.rendicontazione.service;

import com.aizoon.rendicontazione.error.exceptions.DuplicateResourceException;
import com.aizoon.rendicontazione.error.exceptions.ResourceNotFoundException;
import com.aizoon.rendicontazione.model.AuthenticatedUser;
import com.aizoon.rendicontazione.model.dto.request.UserRequest;
import com.aizoon.rendicontazione.model.dto.response.UserResponse;
import com.aizoon.rendicontazione.model.entity.User;
import com.aizoon.rendicontazione.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<UserResponse> findUsers() {
        return userRepository.findAll().stream()
                .map(u -> new UserResponse().from(u))
                .toList();
    }
    public UserResponse findUserByEmail(String email) throws ResourceNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("User with email " + email + " not found")
        );

        return new UserResponse().from(user);
    }

    public UserResponse findUserByID(Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + id + " not found")
        );

        return new UserResponse().from(user);
    }

    public UserResponse saveUser(UserRequest userRequest) throws DuplicateResourceException {
        if(userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new DuplicateResourceException("User with email " + userRequest.getEmail() + " already exists");
        }

        User user = userRequest.to(new User());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);

        return new UserResponse().from(user);
    }

    public UserResponse updateUser(UserRequest userRequest, Long userID) throws ResourceNotFoundException {
        if(!userRepository.findById(userID).isPresent()) {
            throw new ResourceNotFoundException("User with id " + userID + " not found");
        }

        User user = userRequest.to(new User());
        user.setId(userID);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        userRepository.save(user);
        return new UserResponse().from(user);
    }

    public UserResponse deleteUser(Long userID) throws ResourceNotFoundException {
        User user = userRepository.findById(userID).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + userID + " not found")
        );

        userRepository.delete(user);

        return new UserResponse().from(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User with email " + username + " does not exists")
        );

        return AuthenticatedUser.createFrom(user);
    }

}
