package se.lexicon.emil.SchoolManager.data_access;

import java.util.LinkedList;
import java.util.List;

import se.lexicon.emil.SchoolManager.data.Course;
import se.lexicon.emil.SchoolManager.data.Student;

public class StudentDaoList implements StudentDao {

	private List<Student> students;
	
	public StudentDaoList() {
		students = new LinkedList<>();
	}
	
	@Override
	public Student addStudent(Student student) {
		students.add(student);
		return student;
	}

	@Override
	public Student getByEmail(String email) {
		for(Student student : students) {
			if(student.getEmail().equals(email))
				return student;
		}
		return null;
	}

	@Override
	public Student getByID(String id) {
		for(Student student : students) {
			if(student.getId().equals(id))
				return student;
		}
		return null;
	}

	@Override
	public List<Student> getByFirstName(String firstName) {
		List<Student> retStudents = new LinkedList<>();
		for(Student student : students) {
			if(student.getFirstName().equals(firstName))
				retStudents.add(student);
		}
		return retStudents;
	}

	@Override
	public List<Student> getBySurname(String surname) {
		List<Student> retStudents = new LinkedList<>();
		for(Student student : students) {
			if(student.getSurname().equals(surname))
				retStudents.add(student);
		}
		return retStudents;
	}

	@Override
	public List<Student> getByFullName(String firstName, String surname) {
		List<Student> retStudents = new LinkedList<>();
		for(Student student : students) {
			if(student.getFirstName().equals(firstName) && student.getSurname().equals(surname))
				retStudents.add(student);
		}
		return retStudents;
	}

	@Override
	public List<Student> getAllStudents() {
		return students;
	}

	@Override
	public boolean removeStudent(Student student) {
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i) == student) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String retString = new String();
		
		for(Student student : students) {
			retString += student.toString() + '\n';
		}
		return retString;
	}
}
