package com.learning.model;

import java.util.List;

public class CandidateInfo {

	private int totalCount;
	private List<Candidate> candidates;

	public CandidateInfo() {
	}

	public CandidateInfo(int totalCount, List<Candidate> candidates) {
		this.totalCount = totalCount;
		this.candidates = candidates;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	@Override
	public String toString() {
		return "CandidateInfo [totalCount=" + totalCount + ", candidates=" + candidates + "]";
	}
}
