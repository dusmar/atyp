package com.atyp.scorerecorder;

public class SRNodeData {

	private Integer score;
	private Integer count;

	public SRNodeData(Integer score, Integer count) {
		super();
		this.score = score;
		this.count = count;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
