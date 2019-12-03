
package acme.features.auditor.auditRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordRepository extends AbstractRepository {

	@Query("select ar from AuditRecord ar where ar.id=?1")
	AuditRecord findOneAuditRecordById(int id);

	@Query("select ar from AuditRecord ar where ((ar.job.id=?1 and ar.auditor.id=?2) or (ar.job.id=?1 and ar.auditor.id!=?2 and ar.draft=false))")
	Collection<AuditRecord> findManyMineByJobId(int jobId, int auditorId);

	@Query("select ar from AuditRecord ar where ar.job.id=?1 and ar.auditor.id!=?2 and ar.draft=false")
	Collection<AuditRecord> findManyActiveByJobId(int jobId, int auditorId);

}
