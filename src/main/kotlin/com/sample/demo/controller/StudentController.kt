package com.sample.demo.controller

import com.sample.demo.businessLogic.StudentLogic
import com.sample.demo.model.StudentDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("students")
class StudentController {

    @Autowired
    lateinit var studentLogic: StudentLogic

    @GetMapping("/")
    fun getStudents(): List<StudentDto> {

        return studentLogic.selectAll()
    }

    @GetMapping("/{student_id}")
    fun getStudentById(@PathVariable("student_id") studentId: Int): StudentDto {

        return studentLogic.selectById(studentId)
    }
}