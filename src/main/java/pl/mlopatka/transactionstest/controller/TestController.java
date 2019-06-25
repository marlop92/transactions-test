package pl.mlopatka.transactionstest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.mlopatka.transactionstest.service.TaskableService;

/**
 * Created by marcin.lopatka on 19-06-2019
 */

@RestController
@RequestMapping("tests")
public class TestController {
	
	private TaskableService taskableService;
	
	public TestController(final TaskableService taskableService) {
		this.taskableService = taskableService;
	}
	
	@GetMapping
	public void testTransaction() {
		taskableService.handleTransactionEx();
	}
	
}
