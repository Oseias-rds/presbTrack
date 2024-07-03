package com.presbtrack.services

import com.presbtrack.controllers.projectDTO.ClassDTO
import com.presbtrack.controllers.projectDTO.GroupDTO
import org.springframework.stereotype.Service

@Service
class ClassService {

    private val classes = mutableListOf<ClassDTO>()

    fun createClass(name: String, group: GroupDTO): ClassDTO {
        val classDTO = ClassDTO(
                id = classes.size.toLong(),
                name = name,
                group = group,
        )
        classes.add(classDTO)
        return classDTO
    }

    fun getAllClasses(): List<ClassDTO> {
        return classes
    }

    fun getClassById(classId: Long?): ClassDTO? {
        return classes.find { classDTO -> classDTO.id == classId }
    }

    fun addGroupToClass(classId: Long, group: GroupDTO): ClassDTO? {
        val classDto = classes.find { it.id == classId }
        return if (classDto != null) {
            classDto.group = group
            classDto
        } else {
            null
        }
    }

    fun updateClass(classDTO: ClassDTO): ClassDTO? {
        val existingClass = classes.find { it.id == classDTO.id }
        existingClass?.let {
            it.name = classDTO.name
            it.group = classDTO.group
            return it
        }
        return null
    }


    fun deleteClass(classId: Long): Boolean {
        return classes.removeIf { classes -> classes.id == classId }
    }
}