package com.presbtrack.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "group")
data class Group(
        @Id var id: Long,
        var name:String,
        var ageGroup: String,
        var students: String,
        var responsible: String,
        var classes: String
)
