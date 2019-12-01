
package acme.features.auditor.notWrittenJob;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorNotWrittenJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id=?1")
	Job findOneJobById(int id);

	@Query("select j from Job j join AuditRecord ar on ar.job.id=j.id where ar.auditor.id!=?1")
	Collection<Job> findManyByAuditorId(int auditorId);
}
