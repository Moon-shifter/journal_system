package com.journalsystem.springprogram.repository;

import com.journalsystem.springprogram.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StuMapper {
    @Insert("insert into student (sno,sname, ssex, sbirth, fav, photoPath) " +
            "values (#{sno},#{sname}, #{ssex}, #{sbirth}, #{fav}, #{photoPath})")
  public abstract   void insertStudent(Student student);
}
