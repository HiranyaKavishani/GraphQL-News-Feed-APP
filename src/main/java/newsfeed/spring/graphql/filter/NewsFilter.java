package newsfeed.spring.graphql.filter;

import lombok.Data;

@Data
public class NewsFilter {
	private FilterField title;
	private FilterField link;
	private FilterField id;

	public FilterField getTitle() {
		return title;
	}

	public void setTitle(FilterField title) {
		this.title = title;
	}

	public FilterField getLink() {
		return link;
	}

	public void setLink(FilterField link) {
		this.link = link;
	}

	public FilterField getId() {
		return id;
	}

	public void setId(FilterField id) {
		this.id = id;
	}
}
