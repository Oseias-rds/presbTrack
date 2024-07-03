package com.presbtrack.services

import com.presbtrack.controllers.projectDTO.UserDTO
import com.presbtrack.models.enums.Role
import org.springframework.stereotype.Service

@Service
class UserService {

    private val users = mutableListOf<UserDTO>()


    fun createUser(name: String, bornDate: String, cpf: String, phoneNumber: String, role: Role): UserDTO {
        return UserDTO(
                id = users.size.toLong(),
                name = name,
                bornDate = bornDate,
                cpf = cpf,
                phoneNumber = phoneNumber,
                role = role
        ).also { users.add(it) }
    }

    fun getAllUsers(): List<UserDTO> {
        return users
    }

    fun getUserById(userId: Long?): UserDTO? {
        return users.find { user -> user.id == userId }
    }

    fun updateUser(user: UserDTO): UserDTO? {
        val existingUser = users.find { it.id == user.id }
        existingUser?.let {
            it.name = user.name
            it.bornDate = user.bornDate
            it.cpf = user.cpf
            it.phoneNumber = user.phoneNumber
            it.role = user.role
            return it
        }
        return null
    }


    fun deleteUser(userId: Long): Boolean {
        return users.removeIf { user -> user.id == userId }
    }
}
