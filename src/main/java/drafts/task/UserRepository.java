//package myworkingproject.task;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Integer> {
////    List<User> findByEmailEndsWith(String ua);
//
//    @Query("SELECT u FROM User u WHERE u.email LIKE %?1")
//    List<User> findByEmailEndsWith(String text);
//}
