package ManageBean;


import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import exceptions.PersistenciaDacException;
import exceptions.ServiceDacException;
import services.BookDAO;
import services.BookService;


@ViewScoped
@Named("bookEdit")
public class BookEditBean extends AbstractBean {

	@Inject
	private BookService bookService ;
	private Book book;
	/**
	 * 
	 *
	private static final long serialVersionUID = -7779155604704232174L;

	
	private String confirmacaoPassword;
	
	*/
	@PostConstruct
	public void init() {
		if (book == null) {
			book = new Book();
		}
	}
	public void povoar() {
		Book b = new Book();
		b.setIsbn("1111");
		b.setName("Livro01");
		b.setDescription("Descrição 01");
		b.setType(b.getTypes()[1]);
		b.setQtdPages(10);
		b.setDate(new Date());
		b.setEdition("Abril");
		
		Book c = new Book();
		c.setIsbn("2222");
		c.setName("Livro02");
		c.setDescription("Descrição 02");
		c.setType(b.getTypes()[1]);
		c.setQtdPages(10);
		c.setDate(new Date());
		c.setEdition("Março");
		
		try {
			
			bookService.save(b);
			bookService.save(c);

			//System.out.println("Povoou");
		} catch (Exception e) {
			System.out.println("Erro ao povoar " + e.getMessage());			
			e.printStackTrace();
		}
		
	}

	public String toString() {
		String text = "Name: " + book.getName();
		return text;
	}
	
	public String saveBook() {
		try {
			bookService.save(book);
		} catch (ServiceDacException e) {
			// TODO Auto-generated catch block
			reportarMensagemDeErro(e.getMessage());
		}
		reportarMensagemDeSucesso("Publicação salva!");

		return "index.xhtml";
	}


	public Book getBook() {
		return book;
	}
	public void getById() {
		try {
			book = new BookDAO().getByID(book.getIsbn());
			
		} catch (PersistenciaDacException e) {
		}
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
