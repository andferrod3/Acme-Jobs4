
package acme.features.authenticated.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedUserListService implements AbstractListService<Authenticated, UserAccount> {

	@Autowired
	AuthenticatedUserRepository repository;


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;

		return true;
	}
	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "username");
	}
	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;
		Collection<UserAccount> result;
		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("id=");
		id = Integer.parseInt(aux[1]);
		result = this.repository.findUsersByThreadId(id);

		return result;
	}
}
