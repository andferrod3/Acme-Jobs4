
package acme.features.authenticated.job;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id=?1")
	Job findOneJobById(int id);

	@Query("select j from Job j where j.deadline > ?1 AND j.draft= ?2")
	Collection<Job> findManyActive(Date actual, boolean aux);

}
