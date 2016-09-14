package com.ideyatech.ot.tutorial.web.controller;

import java.util.List;

import org.opentides.web.controller.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideyatech.ot.tutorial.entity.Employee;
import com.ideyatech.ot.tutorial.entity.Timesheet;
import com.ideyatech.ot.tutorial.service.EmployeeService;

@Controller
@RequestMapping("/timesheet")
public class TimesheetCrudController extends BaseCrudController<Timesheet> {

	@Autowired
	private EmployeeService employeeService;
	
	@ModelAttribute(value="employees")
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}
	
	@RequestMapping(value = "/findTimesheetsByEmployeeId/{employeeId}", produces = "application/json")
	public @ResponseBody List<Timesheet> findTimesheetsByEmployeeId(@PathVariable Long employeeId) {
		Timesheet sample = new Timesheet();
		sample.setEmployeeId(employeeId);
		List<Timesheet> t = getService().findByExample(sample);
		System.out.println("This: " + t.get(0).getEmployeeId());
		return t;
//		return getService().findByExample(sample);
	}
	
}
