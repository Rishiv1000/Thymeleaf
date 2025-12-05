package com.student.form.controller;

import com.student.form.ResourceNotFoundException;
import com.student.form.entity.city;
import com.student.form.entity.student;
import com.student.form.entity.studentmarks;
import com.student.form.repo.cityrepo;
import com.student.form.repo.studentmarksrepo;
import com.student.form.repo.studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class studentcontroller {

    @Autowired
    private studentrepo studentrepo;
    @Autowired
    private cityrepo cityrepo;
    @Autowired
    private studentmarksrepo studentmarksrepo;

    @GetMapping("/")
    public String showForm(Model model) {
        student student = new student();

        model.addAttribute("student", student);
        model.addAttribute("cities", cityrepo.findAll());
        return "index";
    }

    @GetMapping("/city/{id}")
    @ResponseBody
    public Map<String, String> getCityDetails(@PathVariable Long id) {
        Object result = cityrepo.getCityStateCountry(id);
        Object[] row = (Object[]) result;

        Map<String, String> map = new HashMap<>();
        map.put("city", row[1].toString());
        map.put("state", row[5].toString());
        map.put("country", row[7].toString());
        return map;
    }

    @PostMapping("/save")
//    @ResponseBody
    public String  save( student student) {
        if (student.getCity() != null && student.getCity().getCityId() != null) {
            city city = cityrepo.findById(student.getCity().getCityId())
                    .orElseThrow(() ->new ResourceNotFoundException( "City Not Found"));
            student.setCity(city);
        }
        if(student.getStudentmarksList() != null){
            for(studentmarks one : student.getStudentmarksList()){
                one.setStudent(student);
            }
        }

        studentrepo.save(student);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String getAllStudent(Model model){
        model.addAttribute("students", studentrepo.findAll());
        return "list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
//        model.addAttribute("students", studentrepo.findAll());
        studentrepo.deleteById(id);
        return "redirect:/students";
    }


    @GetMapping("/student/{id}")
    public String editStudent(Model model, @PathVariable Long id){
//        model.addAttribute("students", studentrepo.findAll());
        student stu = studentrepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student is not present"));
        model.addAttribute("student", stu);
        model.addAttribute("cities", cityrepo.findAll());
        return "index";
    }


}