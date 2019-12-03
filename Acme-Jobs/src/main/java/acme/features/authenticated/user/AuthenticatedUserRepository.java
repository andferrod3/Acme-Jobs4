
package acme.features.authenticated.user;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedUserRepository extends AbstractRepository {

	@Query("select ua from UserAccount ua where ua.id in (select m.authenticated.userAccount.id from Message m where m.messageThread.id = ?1)")
	Collection<UserAccount> findUsersByThreadId(int id);

	@Query("select ua from UserAccount ua where ua.id=?1")
	UserAccount findUserById(int id);

}
