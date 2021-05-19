package com.assessment.auditapp.query

import com.assessment.auditapp.service.AuditService
import com.assessment.auditapp.entity.Audit
import io.leangen.graphql.annotations.GraphQLMutation
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
@GraphQLApi
class AuditQuery (private val auditService: AuditService) {
    @GraphQLQuery(name = "audits")
    fun audits(): List<Audit> =
            auditService.findAll()

    @GraphQLMutation(name = "addAudit")
    fun addAudit(audit: Audit): Audit {
        var audit:Audit = auditService.save(audit)
        return audit
    }

}
