package com.joancolmenerodev.entities

data class Status(
    val credit_count: Int,
    val elapsed: Int,
    val error_code: Int,
    val error_message: Any,
    val timestamp: String
)