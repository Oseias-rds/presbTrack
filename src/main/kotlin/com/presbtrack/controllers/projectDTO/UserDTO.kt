package com.presbtrack.controllers.projectDTO

import com.presbtrack.models.enums.Role
import javax.persistence.Id

data class UserDTO(
        @Id val id: Long,
        var name: String,
        var bornDate: String,
        var cpf: String,
        var phoneNumber: String,
        var role: Role
)
