package com.ideyatech.ot.tutorial.web.controller;

import java.util.List;

import org.opentides.web.controller.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ideyatech.ot.tutorial.entity.DailyTimeRecord;
import com.ideyatech.ot.tutorial.entity.Employee;
import com.ideyatech.ot.tutorial.entity.Timesheet;
import com.ideyatech.ot.tutorial.service.TimesheetService;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseCrudController<Employee> {

	@ModelAttribute(value="dtr")
	public DailyTimeRecord initialDtr(){
		return new DailyTimeRecord();
	}
	
	@Autowired
	private TimesheetService timesheetService;
	
	@ModelAttribute(value="timesheets")
	public List<Timesheet> getTimesheets(){
		return timesheetService.findAll();
	}
	
}
