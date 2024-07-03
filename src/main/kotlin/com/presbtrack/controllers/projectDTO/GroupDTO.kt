package com.presbtrack.controllers.projectDTO

data class GroupDTO(
        val id: Long,
        var name: String,
        var users: MutableList<UserDTO> = mutableListOf()
)