package users.data;
import org.springframework.data.repository.CrudRepository;
public interface UsersRepository extends CrudRepository<userEntity,Long> {
 userEntity findByEmail(String s);
 userEntity findByuserId(String userId);
}