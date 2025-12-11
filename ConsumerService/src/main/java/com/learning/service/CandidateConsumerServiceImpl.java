package com.learning.service;

import org.springframework.stereotype.Service;

import com.learning.helper.CandidateHelper;
import com.learning.model.Candidate;
import com.learning.model.CandidateInfo;

@Service
public class CandidateConsumerServiceImpl implements CandidateConsumerService {
	private final CandidateHelper helper;

	public CandidateConsumerServiceImpl(CandidateHelper helper) {
		this.helper = helper;
	}

	@Override
	public CandidateInfo getCandidates() {
		return helper.getCandidates();
	}

	@Override
	public Candidate getCandidate(int id) {
		return helper.getCandidate(id);
	}

}