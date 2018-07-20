package com.example.smsviewer;

public class SMSObject {

	private String sender;
	private String contents;
	private long timestamp;
	
	public SMSObject() {}
	
	public SMSObject(String sender, String contents, long timestamp) {
		this.sender = sender;
		this.contents = contents;
		this.timestamp = timestamp;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getSender() {
		return this.sender;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getContents() {
		return this.contents;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public long getTimestamp() {
		return this.timestamp;
	}
}
