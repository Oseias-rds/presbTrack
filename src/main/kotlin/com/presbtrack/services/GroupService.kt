package com.presbtrack.services

import com.presbtrack.controllers.projectDTO.GroupDTO
import com.presbtrack.controllers.projectDTO.UserDTO
import org.springframework.stereotype.Service

@Service
class GroupService {

    private val groups = mutableListOf<GroupDTO>()

    fun createGroup(name: String): GroupDTO {
        val group = GroupDTO(
                id = groups.size.toLong(),
                name = name
        )
        groups.add(group)
        return group
    }

    fun getAllGroups(): List<GroupDTO> {
        return groups
    }

    fun getGroupById(groupId: Long?): GroupDTO? {
        return groups.find { group -> group.id == groupId }
    }

    fun addUserToGroup(groupId: Long, user: UserDTO): GroupDTO? {
        val group = groups.find { it.id == groupId }
        return if (group != null) {
            group.users.add(user)
            group
        } else {
            null
        }
    }
    fun updateGroup(groupDTO: GroupDTO): GroupDTO? {
        val existingGroup = groups.find { it.id == groupDTO.id }
        existingGroup?.let {
            it.name = groupDTO.name
            it.users = groupDTO.users
            return it
        }
        return null
    }


    fun deleteGroup(groupId: Long): Boolean {
        return groups.removeIf { group -> group.id == groupId }
    }
}
