package pl.mlopatka.transactionstest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by marcin.lopatka on 19-06-2019
 */

@Entity
@Table(name = "task")
public class TaskEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String status;
	
	public TaskEntity() {
	}
	
	public TaskEntity(final String status) {
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(final String status) {
		this.status = status;
	}
}
