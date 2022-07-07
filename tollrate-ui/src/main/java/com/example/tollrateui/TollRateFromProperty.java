package com.example.tollrateui;

public class TollRateFromProperty {

	private Integer rateamount;
	private Float lanes;
	private String tollstart;
	private String tollstop;

	@Override
	public String toString() {
		return "TollRateFromProperty [rateamount=" + rateamount + ", lanes=" + lanes + ", tollstart=" + tollstart
				+ ", tollstop=" + tollstop + "]";
	}
	
    public TollRateFromProperty() {}

	public TollRateFromProperty(Integer rateamount, Float lanes, String tollstart, String tollstop) {
		super();
		this.rateamount = rateamount;
		this.lanes = lanes;
		this.tollstart = tollstart;
		this.tollstop = tollstop;
	}

	public Integer getRateamount() {
		return rateamount;
	}

	public void setRateamount(Integer rateamount) {
		this.rateamount = rateamount;
	}

	public Float getLanes() {
		return lanes;
	}

	public void setLanes(Float lanes) {
		this.lanes = lanes;
	}

	public String getTollstart() {
		return tollstart;
	}

	public void setTollstart(String tollstart) {
		this.tollstart = tollstart;
	}

	public String getTollstop() {
		return tollstop;
	}

	public void setTollstop(String tollstop) {
		this.tollstop = tollstop;
	}

}
