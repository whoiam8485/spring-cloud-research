package com.example.demo.client;

public class Skiploss {
	

	private Data data = new Data();

	public static class Data {
		private Lat positionlat;
		private Lon positionlong;

		public Lat getPositionlat() {
			return positionlat;
		}

		public void setPositionlat(Lat positionlat) {
			this.positionlat = positionlat;
		}

		public Lon getPositionlong() {
			return positionlong;
		}

		public void setPositionlong(Lon positionlong) {
			this.positionlong = positionlong;
		}
	}

	public static class Lat {

		private double value;
		private long ts;
		private int status;

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public long getTs() {
			return ts;
		}

		public void setTs(long ts) {
			this.ts = ts;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

	}

	public static class Lon {

		private double value;
		private long ts;
		private int status;

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public long getTs() {
			return ts;
		}

		public void setTs(long ts) {
			this.ts = ts;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
