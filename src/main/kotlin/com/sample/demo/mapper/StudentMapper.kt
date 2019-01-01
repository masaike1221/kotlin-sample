package com.sample.demo.mapper

import com.sample.demo.model.Student
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
public interface StudentMapper {

    // 全取得
    fun selectAll(): List<Student>?

    // IDで取得
    fun selectById(@Param("studentId") studentId: Int): Student?

}