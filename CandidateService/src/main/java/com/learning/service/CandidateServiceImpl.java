package com.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.helper.CandidateHelper;
import com.learning.model.Candidate;
import com.learning.model.CandidateInfo;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateHelper helper;

	@Override
	public Candidate findCandidate(int id) throws Exception {
		return helper.findCandidate(id);
	}

	@Override
	public CandidateInfo findCandidates() throws Exception {
		return helper.findCandidates();
	}
}