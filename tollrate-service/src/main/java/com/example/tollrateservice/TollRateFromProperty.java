package com.example.tollrateservice;

public class TollRateFromProperty {

	private String rateamount;
	private String lanes;
	private String tollstart;
	private String tollstop;

	@Override
	public String toString() {
		return "TollRateFromProperty [rateamount=" + rateamount + ", lanes=" + lanes + ", tollstart=" + tollstart
				+ ", tollstop=" + tollstop + "]";
	}

    public TollRateFromProperty() {}
    
	public TollRateFromProperty(String rateamount, String lanes, String tollstart, String tollstop) {
		super();
		this.rateamount = rateamount;
		this.lanes = lanes;
		this.tollstart = tollstart;
		this.tollstop = tollstop;
	}

	public String getRateamount() {
		return rateamount;
	}

	public void setRateamount(String rateamount) {
		this.rateamount = rateamount;
	}

	public String getLanes() {
		return lanes;
	}

	public void setLanes(String lanes) {
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
