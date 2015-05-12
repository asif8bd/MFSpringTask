package com.asif.student.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asif.student.model.Student;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:Beans.xml");

	StudentRepository studentRepository = (StudentRepository) context
			.getBean("studentRepository");

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}

	// Insert Student Information
	@RequestMapping(value = "insertStudent.html", method = RequestMethod.POST)
	public String insertData(Student student, BindingResult result, Model model) {
		String id = student.getStudentId();
		String name = student.getStudentName();
		String email = student.getStudentEmail();

		studentRepository.create(id, name, email);

		return "redirect:searchAll.html";

	}

	// Display Table
	@RequestMapping(value = "searchAll.html")
	public ModelAndView searchAllData() {
		ModelAndView mav = new ModelAndView("home");
		List<Student> students = studentRepository.findAllStudents();
		mav.addObject("alldata", students);
		return mav;
	}

	// Update Student Information
	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public String updateData(Student student, Model model) {
		return "edit";
	}

	@RequestMapping(value = "edit.html", method = RequestMethod.POST)
	public String updateData(Student student, HttpServletRequest request) {
		int n = Integer.valueOf(request.getParameter("n"));
		String id = student.getStudentId();
		String name = student.getStudentName();
		String email = student.getStudentEmail();

		studentRepository.update(n, id, name, email);

		return "redirect:searchAll.html";
	}

	// Delete Student Information
	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public String deleteData(Student student, HttpServletRequest request) {
		int n = Integer.valueOf(request.getParameter("n"));
		studentRepository.delete(n);
		return "redirect:searchAll.html";
	}

}
