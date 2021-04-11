package com.apiRest.DTO;

public class ResponseJsonDto {
	
	private TimeZoneJsonDto response;

	public ResponseJsonDto(TimeZoneJsonDto response) {
		super();
		this.response = response;
	}

	public ResponseJsonDto() {
		super();
	}

	public TimeZoneJsonDto getResponse() {
		return response;
	}

	public void setResponse(TimeZoneJsonDto response) {
		this.response = response;
	}

}
