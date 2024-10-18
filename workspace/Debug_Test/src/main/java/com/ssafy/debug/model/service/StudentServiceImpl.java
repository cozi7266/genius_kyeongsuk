package com.ssafy.debug.model.service;

import java.util.List;

import com.ssafy.debug.model.dao.StudentDao;
import com.ssafy.debug.model.dao.StudentDaoImpl;
import com.ssafy.debug.model.dto.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDao dao = new StudentDaoImpl();

	@Override
	public void registStudent(Student Student) {
		dao.InsertStudnet(Student);
	}

	@Override
	public List<Student> getStudentList() {
		return dao.selectOne();
	}

	@Override
	public Student getStudent(int id) {
		return dao.selectList(id);
	}

	@Override
	public void modifyStudent(Student student) {
		modifyStudent(student);
	}

	@Override
	public void removeStudent(int id) {
		dao.deleteStudent(id);
	}
}
