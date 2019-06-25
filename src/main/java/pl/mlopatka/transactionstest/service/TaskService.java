package pl.mlopatka.transactionstest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.mlopatka.transactionstest.model.TaskEntity;
import pl.mlopatka.transactionstest.repo.TaskRepository;

/**
 * Created by marcin.lopatka on 19-06-2019
 */

@Service
public class TaskService {
	
	private TaskRepository taskRepository;
	
	public TaskService(final TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public long createTask() {
		TaskEntity taskEntity = new TaskEntity("STARTED");
		taskRepository.save(taskEntity);
		
		return taskEntity.getId();
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateTaskStatus(long id, String status) {
		TaskEntity task = taskRepository.getOne(id);
		task.setStatus(status);
	}
	
}
