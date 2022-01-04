package com.example.demo.Students;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentCommentService {

    private final UserRepository userRepository;
@Autowired
    public StudentCommentService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Student> getStudent() {
        return userRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student>StudentByEmail = userRepository.findStudentByEmail(student.getEmail());
        if(StudentByEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        userRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
        userRepository.findById(studentId);
        boolean exists = userRepository.existsById(studentId);
        if(!exists){

            throw  new IllegalStateException("Student with ID " + studentId + " Does not Exist");
        }
        userRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = userRepository.findById(studentId)
                .orElseThrow( ()-> new IllegalStateException("Student with ID" + studentId + "Does not exist"));
        if(name != null && name.length()> 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email != null && email.length()> 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student>StudentByEmail = userRepository.findStudentByEmail(student.getEmail());
            if(StudentByEmail.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }

    }
}
