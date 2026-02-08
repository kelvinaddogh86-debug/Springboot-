package shops.shops.userrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import shops.shops.userentity.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {
   Optional <Users> findByEmail(String email);
   
}
