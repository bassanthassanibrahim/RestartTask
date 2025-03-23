package com.example.restarttask.domain.model

data class StudyPartner(
    val name: String,
    val lastSeen: String,
    val languages: List<String>,
    val location: String,
    val gender: String,
    val age: Int,
    val joinDate: String
)
