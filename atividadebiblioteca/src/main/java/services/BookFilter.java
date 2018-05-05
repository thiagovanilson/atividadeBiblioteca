package services;

//Haviam 2 possiveis
import java.security.acl.Group;

import java.util.Date;


public class BookFilter {

	private String
		name,
		title,
		edition,
		type,
		isbn;
	
	private int upPages, downPages;
	
	private Date rangeBegin,rangeEnd;
	
	private Group group;

	public BookFilter() {

	}	

	public void setRangeEnd(Date RangeEnd) {
		this.rangeEnd = RangeEnd;
	}

	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean isEmpty() {
		if (this.name != null && !this.name.trim().isEmpty()) {
			return false;
		}
		
		if (this.rangeBegin != null) {
			return false;
		}
		if (this.rangeEnd != null) {
			return false;
		}
		if (this.group != null) {
			return false;
		}
		if (this.edition != null) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "UserFilter [firstName=" + name + ", lastName=" + name + ", birthdayRangeBegin="
				+ rangeBegin + ", birthdayRangeEnd=" + rangeEnd + ", group=" + group + "]";
	}
	
	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getRangeEnd() {
		return rangeEnd;
	}

	public Date getRangeBegin() {
		return rangeBegin;
	}

	public void setRangeBegin(Date rangeBegin) {
		this.rangeBegin = rangeBegin;
	}

	public int getUpPages() {
		return upPages;
	}

	public void setUpPages(int upPages) {
		this.upPages = upPages;
	}

	public int getDownPages() {
		return downPages;
	}

	public void setDownPages(int downPages) {
		this.downPages = downPages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
