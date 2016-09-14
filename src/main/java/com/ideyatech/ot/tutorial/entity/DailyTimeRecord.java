package com.ideyatech.ot.tutorial.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.opentides.bean.BaseEntity;

@Entity
@Table(name="DAILY_TIME_RECORD")
public class DailyTimeRecord extends BaseEntity {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME_IN")
	private Date timeIn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME_OUT")
	private Date timeOut;
	
	@ManyToOne
	@JoinColumn(name="timesheet")
	private Timesheet timesheet;
	
	@Transient
	private int overtime;
	
	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

	public Timesheet getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.HOURS);
	}

	public int getTotalHours(){
		return (int) getDateDiff(timeIn,timeOut,TimeUnit.HOURS);
	}
	
	public String getTimeInWithTime() {
		if(getTimeOut() != null) {
			return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(getTimeOut());
		}
		return "";
	}
	
}
