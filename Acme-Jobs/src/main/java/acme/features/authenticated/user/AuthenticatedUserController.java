
package acme.features.authenticated.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;

@Controller
@RequestMapping("/authenticated/user/")
public class AuthenticatedUserController extends AbstractController<Authenticated, UserAccount> {

	@Autowired
	private AuthenticatedUserListService listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}

}
