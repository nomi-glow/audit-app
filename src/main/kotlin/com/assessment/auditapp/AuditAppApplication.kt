package com.assessment.auditapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AuditAppApplication

fun main(args: Array<String>) {
	runApplication<AuditAppApplication>(*args)
}
