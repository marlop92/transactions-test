package pl.mlopatka.transactionstest.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;

import pl.mlopatka.transactionstest.model.TaskEntity;
import pl.mlopatka.transactionstest.model.Trash;
import pl.mlopatka.transactionstest.repo.TaskRepository;
import pl.mlopatka.transactionstest.repo.TrashRepository;

/**
 * Created by marcin.lopatka on 24-06-2019
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskableServiceTest {

	@Autowired
	private TrashRepository trashRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	private TaskService taskService;
	private FailingService failingService;
	private TaskableService taskableService;
	
	@Before
	public void setup() {
		failingService = new FailingService(trashRepository);
		taskService = new TaskService(taskRepository);
		taskableService = new TaskableService(failingService, taskService);
	}
	
	@Test
	public void shouldNotLeaveAnyTrash() {
		taskableService.handleTransactionEx();
		
		afterTransaction();
	}
	
	@AfterTransaction
	public void afterTransaction() {
		List<Trash> trashes = failingService.getTrashes();
		assertEquals(trashes.size(), 0);
	}
	
	@Test
	public void shouldChangeStatusToFailure() {
		taskableService.handleTransactionEx();
		
		List<TaskEntity> tasks = taskRepository.findAll();
		assertEquals(tasks.get(0).getStatus(), "Failure");
	}
}