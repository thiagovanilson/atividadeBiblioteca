package ManageBean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import exceptions.ServiceDacException;
import services.BookFilter;
import services.BookService;



@RequestScoped
@ManagedBean
public class Index extends AbstractBean {

	private List<Book> books;
	private BookService bookService = new BookService();
	private BookFilter bookFilter;
	
	private static final long serialVersionUID = -5976838804313515033L;	
	private String book;
	
	
	public Index getInstance() {
		return this;
	}
	@PostConstruct
	public void init() {
		filtrar();
		limpar();
		//povoar();
	}
	public String description() {
		for(Book b: books) {
			if(b.getName().equals(book)) {
				return b.getDescription();
			}
		}
		return "";
	}
	
	public String filtrar() {
		try {
			books = bookService.findBy(getBookFilter());
		} catch (ServiceDacException e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		return null;
	}

	public String limpar() {
		this.bookFilter = new BookFilter();
		return null;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public BookFilter getBookFilter() {
		return bookFilter;
	}

	public void setBookFilter(BookFilter bookFilter) {
		this.bookFilter = bookFilter;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	
}
