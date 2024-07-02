package com.presbtrack.controllers.projectDTO

data class GroupDTO(
        val id: Long,
        val name: String,
        val users: MutableList<UserDTO> = mutableListOf()
)