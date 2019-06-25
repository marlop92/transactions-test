package pl.mlopatka.transactionstest.service;

import org.springframework.stereotype.Service;

/**
 * Created by marcin.lopatka on 24-06-2019
 */
@Service
public class TaskableService {
	
	private FailingService failingService;
	private TaskService taskService;
	
	public TaskableService(final FailingService failingService, final TaskService taskService) {
		this.failingService = failingService;
		this.taskService = taskService;
	}
	
	public void handleTransactionEx() {
		long taskId = taskService.createTask();
		taskService.updateTaskStatus(taskId, "Running");
		try {
			failingService.failingTransaction();
			taskService.updateTaskStatus(taskId, "Success");
		} catch (Exception ex) {
			taskService.updateTaskStatus(taskId, "Failure");
		}
	}
}
