package com.learning.service;

import com.learning.model.Candidate;
import com.learning.model.CandidateInfo;

public interface CandidateConsumerService {

	public CandidateInfo getCandidates();

	public Candidate getCandidate(int id);
}
