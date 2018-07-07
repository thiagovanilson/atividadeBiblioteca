package ManageBean;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import exceptions.ServiceDacException;
import services.BookFilter;
import services.BookService;



@ViewScoped
@Named("index")
public class IndexBean extends AbstractBean {

	@Inject
	private BookService bookService;
	private BookFilter bookFilter;
	private List<Book> books;
	
	private static final long serialVersionUID = -5976838804313515033L;	
	private String book;
	
	
	public IndexBean getInstance() {
		return this;
	}
	@PostConstruct
	public void init() {
		filtrar();
		limpar();
		
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
	public BookFilter getBookFilter() {
		return bookFilter;
	}

	public void setBookFilter(BookFilter bookFilter) {
		this.bookFilter = bookFilter;
	}
	public String limpar() {
		this.bookFilter = new BookFilter();
		return null;
	}

	public List<Book> getBooks() {
		
		filtrar();
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
	public String getBook() {
		
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	private static boolean menuVisibility = false;
	
	public boolean IsVisible() {
		return menuVisibility;
	}
	public static void setMenuVisibility(boolean flag) {
		menuVisibility = flag;
	}
}
