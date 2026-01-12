package com.example.SpringJdbcCrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SpringJdbcCrud.Dao.CourseDao;
import com.example.SpringJdbcCrud.model.Course;

@Controller
public class CourseController {

    private final CourseDao dao;

    public CourseController(CourseDao dao) {
        this.dao = dao;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("courses", dao.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Course course) {
        dao.save(course);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("course", dao.getId(id));
        return "edit-course";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Course course) {
        dao.update(course);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/";
    }
}
