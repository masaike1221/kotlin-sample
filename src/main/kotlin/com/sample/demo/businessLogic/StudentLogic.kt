package com.sample.demo.businessLogic

import com.sample.demo.mapper.StudentMapper
import com.sample.demo.model.Student
import com.sample.demo.model.StudentDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentLogic() {

    @Autowired
    lateinit var studentMapper: StudentMapper

    fun selectAll(): List<StudentDto> {

        val studentList: List<Student> = studentMapper.selectAll() ?: throw Exception()

        val studentDtoList: MutableList<StudentDto> = mutableListOf()
        for (student: Student in studentList) {
            studentDtoList.add(castDto(student))
        }

        return studentDtoList
    }

    fun selectById(studentId: Int): StudentDto {

        val student: Student = studentMapper.selectById(studentId) ?: throw Exception()
        return castDto(student)
    }


    fun castDto(student: Student): StudentDto {

        // 名前
        val name = student.branchName ?: "no-name"

        // 性別
        val gender = if (student.gender == 1) "男性" else "女性"

        // 年齢
        val age = student.age.toString()

        // 職歴（XX年YYヶ月の形式に変換）
        val careerHistory = if (student.careerMon == null) {
            "no-career"
        } else {
            val year: Int = student.careerMon % 12
            val month: Int = student.careerMon / 12
            if (year != 0 && month != 0) {
                "${year}年${month}ヶ月"
            } else if (year != 0 && month == 0) {
                "${year}年"
            } else if (year == 0 && month != 0) {
                "${month}ヶ月"
            } else {
                "職歴なし"
            }
        }

        // 支店
        val branch = student.branchName ?: "no-branch"

        // コース
        val course = student.courseName ?: "no-course"

        // EntityをDTOにキャストして返却
        return StudentDto(
                name,
                gender,
                age,
                careerHistory,
                branch,
                course
        )
    }
}