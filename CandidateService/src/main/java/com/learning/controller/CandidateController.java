package com.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.model.Candidate;
import com.learning.model.CandidateInfo;
import com.learning.service.CandidateService;
import com.learning.utils.CandidateUtils;

@RestController
@RequestMapping(CandidateUtils.CANDIDATES)
public class CandidateController {
	private static final Logger LOG = LoggerFactory.getLogger(CandidateController.class);

	@Autowired
	private CandidateService service;

	@GetMapping(CandidateUtils.SLASH)
	public CandidateInfo getCandidates() throws Exception {
		LOG.info(CandidateUtils.MSG_SUCCESSFUL);
		return service.findCandidates();
	}

	@GetMapping(CandidateUtils.ID_PATH)
	public Candidate getCandidate(@PathVariable(required = true) Integer id) throws Exception {
		LOG.info(CandidateUtils.MSG_SUCCESSFUL);
		return service.findCandidate(id);
	}
}