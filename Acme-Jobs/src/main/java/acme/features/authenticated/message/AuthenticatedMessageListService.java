
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThreads.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageListService implements AbstractListService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;

		return true;
	}
	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "tags", "messageThread.title");
	}
	@Override
	public Collection<Message> findMany(final Request<Message> request) {
		assert request != null;
		Collection<Message> result;
		int id;

		String[] aux = request.getServletRequest().getQueryString().trim().split("id=");
		id = Integer.parseInt(aux[1]);
		result = this.repository.findMessagesByThreadId(id);

		return result;
	}
}
