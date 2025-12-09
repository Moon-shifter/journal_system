package com.journalsystem.springprogram.service;

import com.journalsystem.springprogram.pojo.Student;
import com.journalsystem.springprogram.repository.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

    @Override
    public void insertStudent(Student student) {
        stuMapper.insertStudent(student);
    }
}
