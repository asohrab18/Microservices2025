package com.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.learning.model.Candidate;
import com.learning.model.CandidateInfo;
import com.learning.model.Person;
import com.learning.model.PersonInfo;
import com.learning.model.Product;
import com.learning.model.ProductInfo;
import com.learning.service.CandidateConsumerService;
import com.learning.service.PersonConsumerService;
import com.learning.service.ProductConsumerService;
import com.learning.utils.ConsumerUtils;

@RestController
@RequestMapping(ConsumerUtils.CONSUMERS)
public class ConsumerController {
	private static final Logger LOG = LoggerFactory.getLogger(ConsumerController.class);

	private final PersonConsumerService personConsumerService;
	private final ProductConsumerService productConsumerService;
	private final CandidateConsumerService candidateConsumerService;

	public ConsumerController(PersonConsumerService personConsumerService,
			ProductConsumerService productConsumerService, CandidateConsumerService candidateConsumerService) {

		this.personConsumerService = personConsumerService;
		this.productConsumerService = productConsumerService;
		this.candidateConsumerService = candidateConsumerService;
	}

	@GetMapping(ConsumerUtils.GREETINGS)
	public String greet(@RequestParam(required = false) Integer num) {
		if (num == null) {
			num = ConsumerUtils.ZERO;
		}
		LOG.info(ConsumerUtils.MSG_SUCCESSFUL);
		return personConsumerService.greet(num);
	}

	@GetMapping(ConsumerUtils.PERSONS)
	public PersonInfo getPersons() {
		LOG.info(ConsumerUtils.MSG_SUCCESSFUL);
		return personConsumerService.getPersons();
	}

	@GetMapping(ConsumerUtils.PERSONS_ID_PATH)
	public Person getPerson(@PathVariable(required = true) Integer id) {
		LOG.info(ConsumerUtils.MSG_SUCCESSFUL);
		return personConsumerService.getPerson(id);
	}

	@GetMapping(ConsumerUtils.PRODUCTS)
	public ProductInfo getProducts() {
		LOG.info(ConsumerUtils.MSG_SUCCESSFUL);
		return productConsumerService.getProducts();
	}

	@GetMapping(ConsumerUtils.PRODUCTS_ID_PATH)
	public Product getProduct(@PathVariable(required = true) Integer id) {
		LOG.info(ConsumerUtils.MSG_SUCCESSFUL);
		return productConsumerService.getProduct(id);
	}

	@GetMapping(ConsumerUtils.CANDIDATES)
	public CandidateInfo getCandidates() {
		LOG.info(ConsumerUtils.MSG_SUCCESSFUL);
		return candidateConsumerService.getCandidates();
	}

	@GetMapping(ConsumerUtils.CANDIDATES_ID_PATH)
	public Candidate getCandidate(@PathVariable(required = true) Integer id) {
		LOG.info(ConsumerUtils.MSG_SUCCESSFUL);
		return candidateConsumerService.getCandidate(id);
	}
}