package com.presbtrack.controllers

import com.presbtrack.controllers.projectDTO.ClassDTO
import com.presbtrack.services.ClassService
import com.presbtrack.services.GroupService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/class")
class ClassController(
        private val classService: ClassService,
        private val groupService: GroupService
) {

    @PostMapping("/create")
    fun createClass(
            @RequestParam("name") name: String,
            @RequestParam("groupId") groupId: Long
    ): ClassDTO? {
        val group = groupService.getGroupById(groupId)
        return group?.let { classService.createClass(name, it) }
    }

    @GetMapping("/all")
    fun getAllClasses(): List<ClassDTO> {
        return classService.getAllClasses()
    }

    @GetMapping("/id")
    fun getClassById(@RequestParam("id") classId: Long?): ClassDTO? {
        return classService.getClassById(classId)
    }
}
