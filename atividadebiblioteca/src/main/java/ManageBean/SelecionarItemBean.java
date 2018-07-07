package ManageBean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import services.BookDAO;

@RequestScoped
@Named("selecionarItem")
public class SelecionarItemBean extends AbstractBean {

	private List<Book> books;
	
	private static final long serialVersionUID = -5976838804313515033L;	
	@Inject
	BookDAO bd;
	private Book book;

	public List<Book> getBooks() {
		books = bd.getBooks();
		return books;
	}


	public String description() {getBooks();
//		for(Book b: books) {
//			if(b.getTitle().equals(book.getTitle())) {
//				return b.getDescription();
//			}
//		}
		if (book != null)
			return book.getDescription();
		return "";
	}
//	public void yDes(String s) {
//		System.out.println(s);
//		ind.limpar();
//		bookFilter.setTitle(s);
//		ind.filtrar();
//	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
		System.out.println("Livro selecionado: " + book.getName());
	}
	
}
