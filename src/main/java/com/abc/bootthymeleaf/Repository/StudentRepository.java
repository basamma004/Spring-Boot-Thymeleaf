package com.abc.bootthymeleaf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.bootthymeleaf.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
