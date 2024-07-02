package com.presbtrack.controllers

import com.presbtrack.controllers.projectDTO.GroupDTO
import com.presbtrack.services.GroupService
import com.presbtrack.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/group")
class GroupController(private val groupService: GroupService) {

    @PostMapping("/create")
    fun createGroup(@RequestParam("name") name: String): GroupDTO {
        return groupService.createGroup(name)
    }

    @GetMapping("/all")
    fun getAllGroups(): List<GroupDTO> {
        return groupService.getAllGroups()
    }

    @GetMapping("/id")
    fun getGroupById(@RequestParam("id") groupId: Long?): GroupDTO? {
        return groupService.getGroupById(groupId)
    }

    @PostMapping("/addUser")
    fun addUserToGroup(
            @RequestParam("groupId") groupId: Long,
            @RequestParam("userId") userId: Long
    ): GroupDTO? {
        val userService: UserService = UserService()
        val user = userService.getUserById(userId)
        return user?.let { groupService.addUserToGroup(groupId, it) }
    }
}