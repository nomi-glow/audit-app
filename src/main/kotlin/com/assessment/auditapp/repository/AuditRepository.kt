package com.assessment.auditapp.repository

import com.assessment.auditapp.entity.Audit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuditRepository : JpaRepository<Audit, Long> {

}