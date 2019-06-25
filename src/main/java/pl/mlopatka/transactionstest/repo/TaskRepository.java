package pl.mlopatka.transactionstest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.mlopatka.transactionstest.model.TaskEntity;

/**
 * Created by marcin.lopatka on 19-06-2019
 */

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
