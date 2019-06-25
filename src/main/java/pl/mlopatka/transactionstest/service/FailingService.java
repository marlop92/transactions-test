package pl.mlopatka.transactionstest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.mlopatka.transactionstest.model.Trash;
import pl.mlopatka.transactionstest.repo.TrashRepository;

/**
 * Created by marcin.lopatka on 24-06-2019
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class FailingService {
	
	private TrashRepository trashRepository;
	
	public FailingService(final TrashRepository trashRepository) {
		this.trashRepository = trashRepository;
	}
	
	public void failingTransaction() {
		trashRepository.save(new Trash("Trash content"));
		throw new RuntimeException("Some exception..");
	}
	
	public List<Trash> getTrashes() {
		return trashRepository.findAll();
	}
	
}
