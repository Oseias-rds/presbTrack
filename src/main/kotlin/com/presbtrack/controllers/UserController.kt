package com.presbtrack.controllers

import com.presbtrack.controllers.projectDTO.UserDTO
import com.presbtrack.models.enums.Role
import com.presbtrack.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
        var userService: UserService,
) {

    @PostMapping("/create")
    fun createUser(
            @RequestParam("name") name: String,
            @RequestParam("bornDate") bornDate: String,
            @RequestParam("cpf") cpf: String,
            @RequestParam("phoneNumber") phoneNumber: String,
            @RequestParam("role") role: Role
    ): UserDTO {
        return userService.createUser(name, bornDate, cpf, phoneNumber, role)
    }

    @GetMapping("/all")
    fun getAllUsers(): List<UserDTO> {
        return userService.getAllUsers()
    }

    @GetMapping("/id")
    fun getUserById(@RequestParam("id") userId: Long?): UserDTO? {
        return userService.getUserById(userId)
    }

    fun getUsersByGroup(@RequestParam("groupId") groupId: String): List<UserDTO> {
        return emptyList()
    }

    fun updateUser(@RequestParam("user") user: UserDTO): UserDTO? {
        return userService.updateUser(user)
    }

    fun deleteUser(@RequestParam("id") userId: Long): Boolean {
        return userService.deleteUser(userId)
    }
}