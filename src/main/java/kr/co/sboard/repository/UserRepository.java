package kr.co.sboard.repository;

import kr.co.sboard.entity.Article;
import kr.co.sboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    int countByUserid(String userid);
    int countByNick(String nick);
<<<<<<< HEAD

    int countByEmail(String email);

=======
    int countByEmail(String email);
>>>>>>> 9f0fe0f6c8c54e72ec71820863c85f44633c6899
    int countByHp(String hp);
}
