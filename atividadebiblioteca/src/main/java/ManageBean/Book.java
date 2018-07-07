package ManageBean;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Book {

	private String
		title,
		edition,	
		subject,
		description;
	@Id
	private String isbn;
	
	@Column(name="tipo")
	private String type;
	
	private String[] types = new String[] {"Livro","Livro de bolso","Capa dura", 
			"Ebook","Revista","Periodico"};
	
	
	private int qtdPages=1;
	@Column (name="data")
	private Date date = new Date();
	
	Book(){
		//System.out.println("Livro criado");
		
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getQtdPages() {
		return qtdPages;
	}
	public void setQtdPages(int qtdPages) {
		this.qtdPages = qtdPages;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}	
}
