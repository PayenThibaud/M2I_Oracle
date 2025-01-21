package org.example.exo7;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Mono<Void> deleteById(Integer id) {
        return userRepository.deleteById(id);
    }

    public Mono<User> updateUser(int id ,User user) {
        return userRepository.findById(id).flatMap(i ->{
            i.setName(user.getName());
            i.setEmail(user.getEmail());
            i.setActive(user.isActive());
            return userRepository.save(i);
        });
    }
}
