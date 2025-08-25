package co.com.pragma.jpa;

import co.com.pragma.jpa.entity.UserEntity;
import co.com.pragma.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.math.BigInteger;
import java.util.Optional;

// This interface is used for the CRUD operations and query by example capabilities.
public interface JPARepository extends CrudRepository<UserEntity, BigInteger>, QueryByExampleExecutor<UserEntity> {
    Optional<UserEntity> findByIdNumber(Long idNumber);
}
