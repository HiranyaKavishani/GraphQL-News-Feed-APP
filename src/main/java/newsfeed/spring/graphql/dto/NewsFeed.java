package newsfeed.spring.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity for storing the RSS Feed data
 * 
 * @author Hiranya Abeyrathne <hiranyakavi@gmail.com>
 *
 */
@Entity
@IdClass(FeedKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NewsFeed {

	@Id
	private String execution;

	@Id
	@GeneratedValue
	private int id;

	@Column(length=2048, name="title")
	private String title;

	@Column(length=2048 , name="link")
	private String link;

	@Column(name="publicationDate")
	private Date publicationDate;

	@Lob
	@Column(name="description")
	private String description;

	@Column(name = "imageUrl")
	private String imageUrl;

	@Lob
	@Column(name = "image")
	private byte[] image;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
