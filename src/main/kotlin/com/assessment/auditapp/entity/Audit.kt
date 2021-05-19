package com.assessment.auditapp.entity

import java.sql.Timestamp
import javax.persistence.*

@Entity

data class Audit(@Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
                 var id: Long? = -1,
                 @Column(nullable = false)
                 var method: String,
                 @Column(nullable = false)
                 var amount: Double,
                 @Column(nullable = false)
                 var account_id: Long,
                 @Column(nullable = false)
                 var start_balance: Double,
                 @Column(nullable = false)
                 var end_balance: Double,
                 @Column(nullable = false)
                 var user_id: String?,
                 @Column(nullable = true)
                 var created_at: Timestamp?=Timestamp(System.currentTimeMillis()))