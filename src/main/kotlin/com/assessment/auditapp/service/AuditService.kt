package com.assessment.auditapp.service


import com.assessment.auditapp.entity.Audit
import com.assessment.auditapp.repository.AuditRepository
import org.springframework.stereotype.Service

@Service
class AuditService(private val auditRepository: AuditRepository) {

    fun save(audit: Audit) = auditRepository.save(audit)

    fun findAll() = auditRepository.findAll();
}