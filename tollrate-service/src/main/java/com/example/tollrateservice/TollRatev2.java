package com.example.tollrateservice;

public class TollRatev2 {

	private Integer stationId;
	private Float currentRate;
	private String timestamp;
	private String isBaseRate;

	public TollRatev2() {
	}

	@Override
	public String toString() {
		return "TollRatev2 [stationId=" + stationId + ", currentRate=" + currentRate + ", timestamp=" + timestamp
				+ ", isBaseRate=" + isBaseRate + "]";
	}

	public TollRatev2(Integer stationId, Float currentRate, String timestamp, String isBaseRate) {
		super();
		this.stationId = stationId;
		this.currentRate = currentRate;
		this.timestamp = timestamp;
		this.isBaseRate = isBaseRate;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Float getCurrentRate() {
		return currentRate;
	}

	public void setCurrentRate(Float currentRate) {
		this.currentRate = currentRate;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getIsBaseRate() {
		return isBaseRate;
	}

	public void setIsBaseRate(String isBaseRate) {
		this.isBaseRate = isBaseRate;
	}

}
