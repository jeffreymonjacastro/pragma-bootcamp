package co.com.pragma.jpa;

import co.com.pragma.jpa.entity.UserEntity;
import co.com.pragma.jpa.exception.UserNotFoundException;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.model.user.User;
import co.com.pragma.model.user.gateways.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

// implements ModelRepository from domain
@Repository
public class JPARepositoryAdapter extends AdapterOperations<User, UserEntity, BigInteger, JPARepository> implements UserRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, User.class));
    }

    @Override
    public void saveUser(User user) {
        repository.save(toData(user));
    }

    @Override
    public List<User> getAllUsers() {
        return toList(repository.findAll());
    }

    @Override
    public User getUserByIdNumber(Long idNumber) {
        return toEntity(repository.findByIdNumber(idNumber).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public User editUser(User user) {
        UserEntity savedUser = repository.findByIdNumber(user.getIdNumber()).orElseThrow(UserNotFoundException::new);
        UserEntity editedUser = new UserEntity(
                savedUser.getId(),
                user.getName(),
                user.getLastname(),
                user.getAge(),
                user.getIdType(),
                user.getIdNumber()
        );

        return toEntity(repository.save(editedUser));
    }

    @Override
    public void deleteUser(Long idNumber) {
        UserEntity user = repository.findByIdNumber(idNumber).orElseThrow(UserNotFoundException::new);
        repository.deleteById(user.getId());
    }
}
