package com.presbtrack.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "classes")
data class Classes(
        @Id var id: Long,
        var date: Date,
        var user: String,
        var presence: String
)
