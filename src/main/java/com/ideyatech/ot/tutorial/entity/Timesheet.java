package com.ideyatech.ot.tutorial.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.opentides.bean.BaseEntity;
import org.opentides.web.json.Views;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="TIMESHEET")
public class Timesheet extends BaseEntity {
	
	@JsonView(Views.SearchView.class)
	@ManyToOne
	@JoinColumn(name="employee_id")
	@JsonManagedReference
	private Employee employee;
	
	@Column(name="e_id", insertable=false, updatable=false)
//	@Transient
	@JsonManagedReference
	private Long employeeId;

	@JsonView(Views.SearchView.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_CUTOFF")
	private Date startCutOff;
	
	@JsonView(Views.SearchView.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_CUTOFF")
	private Date endCutOff;
	
	@OneToMany
	private List<DailyTimeRecord> records = new ArrayList<DailyTimeRecord>();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStartCutOff() {
		return startCutOff;
	}

	public void setStartCutOff(Date startCutOff) {
		this.startCutOff = startCutOff;
	}

	public Date getEndCutOff() {
		return endCutOff;
	}

	public void setEndCutOff(Date endCutOff) {
		this.endCutOff = endCutOff;
	}

	public List<DailyTimeRecord> getRecords() {
		return records;
	}

	public void setRecords(List<DailyTimeRecord> records) {
		this.records = records;
	}
	
}
