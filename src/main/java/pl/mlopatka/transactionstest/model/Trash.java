package pl.mlopatka.transactionstest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by marcin.lopatka on 24-06-2019
 */
@Entity
@Table(name = "TRASH")
public class Trash {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	public Trash() {
	}
	
	public Trash(final String content) {
		this.id = id;
		this.content = content;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(final String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Trash{" +
				"id=" + id +
				", content='" + content + '\'' +
				'}';
	}
}
