package com.ideyatech.ot.tutorial.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.opentides.web.controller.BaseCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideyatech.ot.tutorial.entity.Skill;

@Controller
@RequestMapping(value = "/skill")
public class SkillCrudController extends BaseCrudController<Skill> {

	@RequestMapping(value = "/findByEmployeeId/{employeeId}", produces = "application/json")
	public @ResponseBody List<Skill> findSkillsByEmployeeId(@PathVariable Long employeeId) {
		Skill sample = new Skill();
		sample.setEmployeeId(employeeId);
		System.out.println("find skills by employee id");
		return getService().findByExample(sample);
	}
	
	@RequestMapping(value="/addskill", method = RequestMethod.POST, produces="application/json")
	public String getJson(@RequestBody Skill data) {
		System.out.println("get json");
		System.out.println(data);
		return "string";
	}

}
