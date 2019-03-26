package date0326;

import java.util.List;

public class RssVO {
	
	private String title, link, description, pubDate;

	public RssVO(String title, String link, String description, String pubDate) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
		this.pubDate = pubDate;
	}
	
	public RssVO() {
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "RssVO [title=" + title + ", link=" + link + ", description=" + description + ", pubDate=" + pubDate
				+ "]";
	}
}
