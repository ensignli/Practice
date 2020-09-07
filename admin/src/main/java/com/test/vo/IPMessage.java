package com.test.vo;

import lombok.Data;

@Data
public class IPMessage {
	// 地址
	private String ipAddress;
	// 端口
	private int ipPort;

	// 类型
	private String ipType;

	// 速度
	private double ipSpeed;

	// 存活时间
	private int aliveTime;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getIpPort() {
		return ipPort;
	}

	public void setIpPort(int ipPort) {
		this.ipPort = ipPort;
	}

	public double getIpSpeed() {
		return ipSpeed;
	}

	public void setIpSpeed(double ipSpeed) {
		this.ipSpeed = ipSpeed;
	}

	public int getAliveTime() {
		return aliveTime;
	}

	public void setAliveTime(int aliveTime) {
		this.aliveTime = aliveTime;
	}

	public String getIpType() {
		return ipType;
	}

	public void setIpType(String ipType) {
		this.ipType = ipType;
	}

}
