package com.presbtrack.controllers

import com.presbtrack.controllers.projectDTO.GroupDTO
import com.presbtrack.controllers.projectDTO.UserDTO
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

    @PostMapping("/{groupId}/addUser")
    fun addUserToGroup(@PathVariable groupId: Long, @RequestBody user: UserDTO): GroupDTO? {
        return groupService.addUserToGroup(groupId, user)
    }

    fun updateGroup(@RequestParam("group") group: GroupDTO): GroupDTO? {
        return groupService.updateGroup(group)
    }

    fun deleteGroup(@RequestParam("id") groupId: Long): Boolean {
        return groupService.deleteGroup(groupId)
    }
}