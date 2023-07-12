package com.ltp.gradesubmission;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;


@SpringBootApplication
public class GradeSubmissionApplication implements CommandLineRunner {

	@Autowired 
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[]{
			new Student(1L, "Harry Potter", LocalDate.parse("1999-02-01")),
			new Student(2L, "Xiara Sanchez", LocalDate.parse("1998-10-30")),
			new Student(3L, "Benajmin Baez", LocalDate.parse("1997-06-05")),
			new Student(4L, "Julian Lopez", LocalDate.parse("1949-02-08"))
			
		};

		for (int i = 0; i < students.length; i++) {
			studentRepository.save(students[i]);
		}
	}

}
