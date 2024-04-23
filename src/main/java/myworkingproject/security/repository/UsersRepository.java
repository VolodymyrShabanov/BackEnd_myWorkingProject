package myworkingproject.security.repository;

import myworkingproject.security.models.User;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository <User, Integer>{

}
