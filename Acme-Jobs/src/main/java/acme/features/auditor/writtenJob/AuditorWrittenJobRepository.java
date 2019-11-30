
package acme.features.auditor.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select j from Job j join AuditRecord ar on ar.job.id=j.id where ar.auditor.id=?1")
	Collection<Job> findManyByEmployerId(int auditorId);
}
