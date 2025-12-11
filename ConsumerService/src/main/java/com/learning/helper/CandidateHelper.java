package com.learning.helper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.learning.model.Candidate;
import com.learning.model.CandidateInfo;
import com.learning.utils.ConsumerUtils;

@Component
public class CandidateHelper {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CircuitBreakerFactory<?, ?> cbFactory;

	public CandidateInfo getCandidates() {
		CircuitBreaker cb = cbFactory.create(ConsumerUtils.CIRCUIT_BREAKER_CANDIDATE);
		return cb.run(() -> restTemplate.getForObject(ConsumerUtils.URL_CANDIDATES,
				CandidateInfo.class), throwable -> fallbackCandidates(throwable));
	}

	private CandidateInfo fallbackCandidates(Throwable t) {
		CandidateInfo ci = new CandidateInfo();
		ci.setTotalCount(ConsumerUtils.ONE);
		ci.setCandidates(List.of(new Candidate(ConsumerUtils.ONE, ConsumerUtils.DEFAULT, ConsumerUtils.DEFAULT, ConsumerUtils.DEFAULT)));
		return ci;
	}

	public Candidate getCandidate(int id) {
		CircuitBreaker cb = cbFactory.create(ConsumerUtils.CIRCUIT_BREAKER_CANDIDATE);
		return cb.run(() -> restTemplate.getForObject(ConsumerUtils.URL_CANDIDATES_ID + id,
				Candidate.class), throwable -> fallbackCandidate(id, throwable));
	}

	private Candidate fallbackCandidate(int id, Throwable t) {
		return new Candidate(ConsumerUtils.ONE, ConsumerUtils.DEFAULT, ConsumerUtils.DEFAULT, ConsumerUtils.DEFAULT);
	}
}
