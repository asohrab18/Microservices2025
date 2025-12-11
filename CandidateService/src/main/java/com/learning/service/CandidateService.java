package com.learning.service;

import com.learning.model.Candidate;
import com.learning.model.CandidateInfo;

public interface CandidateService {

	Candidate findCandidate(int id) throws Exception;

	CandidateInfo findCandidates() throws Exception;
}
