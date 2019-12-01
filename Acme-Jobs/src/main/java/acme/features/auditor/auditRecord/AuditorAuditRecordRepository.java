
package acme.features.auditor.auditRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordRepository extends AbstractRepository {

	@Query("select ar from AuditRecord ar where ar.id=?1")
	AuditRecord findOneAuditRecordById(int id);

	@Query("select ar from AuditRecord ar where ar.job.id=?1")
	Collection<AuditRecord> findManyByJobId(int jobId);

	@Query("select j from Job j where j.id in (select ar.job.id from AuditRecord ar where ar.id=?1)")
	Job findJobByAuditRecord(int id);

}
