package com.learning.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.learning.exception.MissingRequiredDataException;
import com.learning.model.Candidate;
import com.learning.model.CandidateInfo;
import com.learning.utils.CandidateUtils;

@Component
public class CandidateHelper {

	static List<Candidate> candidates = null;;

	static Map<Integer, Candidate> candidatesMap = null;

	static {
		Candidate c1 = new Candidate(CandidateUtils.ONE, "Ali", "Meerut", "India");
		Candidate c2 = new Candidate(CandidateUtils.TWO, "Baby", "London", "UK");
		Candidate c3 = new Candidate(CandidateUtils.THREE, "Celina", "New York", "USA");

		candidates = Arrays.asList(c1, c2, c3);

		candidatesMap = new HashMap<>();
		candidatesMap.put(CandidateUtils.ONE, c1);
		candidatesMap.put(CandidateUtils.TWO, c2);
		candidatesMap.put(CandidateUtils.THREE, c3);
	}

	public Candidate findCandidate(int id) throws Exception {
		if (id <= CandidateUtils.ZERO) {
			throw new MissingRequiredDataException(CandidateUtils.DATA_REQUIRED);
		}
		return candidatesMap.get(id);
	}

	public CandidateInfo findCandidates() {
		CandidateInfo ci = new CandidateInfo();
		ci.setTotalCount(candidates.size());
		ci.setCandidates(candidates);
		return ci;
	}
}
