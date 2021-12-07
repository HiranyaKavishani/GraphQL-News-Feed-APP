package newsfeed.spring.graphql.dto;

import java.io.Serializable;

/**
 * Class for the compound key of the Feed entity
 * 
 * @author Hiranya Abeyrathne <hiranyakavi@gmail.com>
 *
 */
public class FeedKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private String execution;

	private int id;

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.execution.equals(((FeedKey) obj).getExecution()) && (this.id == (((FeedKey) obj).getId()));
	}

	public String getExecution() {
		return execution;
	}

	public void setExecution(String execution) {
		this.execution = execution;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
