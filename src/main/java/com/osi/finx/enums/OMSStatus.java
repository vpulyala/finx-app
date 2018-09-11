package com.osi.finx.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;

public enum OMSStatus {
	
	PENDING("pending", 101),
	FOR_PICKUP("for_pickup",	102),
	PICKED_UP("picked_up",	103),
	FAILED_PICKUP("failed_pickup",	104),
	IN_TRANSIT("in_transit", 105),
	CLAIMED("claimed", 106),
	OUT_FOR_DELIVERY("out_for_delivery",107),
	DELIVERED("delivered", 108),
	FAILED_DELIVERY("failed_delivery",	109),
	RETURN_IN_TRANSIT("return_in_transit",	110),
	RETURNED("returned",	111),
	FAILED_RETURN("failed_return",	112),
	CONFIRMED("confirmed	",113),
	CANCELED("canceled",	114),
	FOR_DROP_OFF("for_dropoff",	115),
	DROPPED_OFF("dropped_off",	116),
	CONSOLIDATED("consolidated",	117),
	FOR_TRANSFER("for_transfer", 118),
	FOR_ACCEPTANCE("for_acceptance", 119),
	ACCEPTED("accepted",	120),
	PAYMENT_ONLY("Payment only", 121),
	MLHUILLIER_DROP_OFF("MLhuillier Dropoff", 151);
	
	private static final List<OMSStatus> OMS_STATUSES = Arrays.asList(PENDING, FOR_PICKUP, PICKED_UP, FAILED_PICKUP, IN_TRANSIT, 
				CLAIMED, OUT_FOR_DELIVERY, DELIVERED, FAILED_DELIVERY, RETURN_IN_TRANSIT, RETURNED, FAILED_RETURN, CONFIRMED,
				CANCELED, FOR_DROP_OFF, DROPPED_OFF, CONSOLIDATED, FOR_TRANSFER, FOR_ACCEPTANCE, ACCEPTED, PAYMENT_ONLY, 
				MLHUILLIER_DROP_OFF);
	
	private int code;
	private String status;

	OMSStatus(String status, int code) {
		this.code = code;
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}
	
	public OMSStatus getOMSStatus(String name) {
		if (!StringUtils.isEmpty(name)) {
			for (OMSStatus status : OMS_STATUSES) {
				if (status.getStatus().trim().equalsIgnoreCase(name.trim())) {
					return status;
				}
			}
		}
		return null;
	}
}
