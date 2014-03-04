package com.buildthedot.armingjob.response;

public class ResponseLogin {
	String responseStatus = "";
	String temp_json_data = "";

	public String getTemp_json_data() {
		return temp_json_data;
	}

	public void setTemp_json_data(String temp_json_data) {
		this.temp_json_data = temp_json_data;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
}
