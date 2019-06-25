package pl.mlopatka.transactionstest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.mlopatka.transactionstest.model.Trash;

/**
 * Created by marcin.lopatka on 24-06-2019
 */
@Repository
public interface TrashRepository extends JpaRepository<Trash, Long> {
}
