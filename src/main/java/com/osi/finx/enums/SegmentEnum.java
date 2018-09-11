package com.osi.finx.enums;

public enum SegmentEnum {
	
	ACTIVITY("Activity","00000"),
	HUBS("Hubs","000"),
	INTERCOMPANY("Intercompany","00"),
	FUTURE_USE("Future Use","0000");

	private String segment;
	private String defaultValue;
	
	SegmentEnum(String segment, String defaultValue) {
		this.segment = segment;
		this.defaultValue = defaultValue;
	}

	public String getSegment() {
		return segment;
	}

	public String getDefaultValue() {
		return defaultValue;
	}
}
