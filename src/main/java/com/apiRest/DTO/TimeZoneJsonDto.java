package com.apiRest.DTO;

public class TimeZoneJsonDto {

	private String time;
	private String timeZone;
	
	public TimeZoneJsonDto() {
		super();
	}

	public TimeZoneJsonDto(String time, String timeZone) {
		super();
		this.time = time;
		this.timeZone = timeZone;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	
};
