package ManageBean;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import exceptions.ServiceDacException;
import services.BookService;


@ViewScoped
@Named
public class BookDelete extends AbstractBean {
	

	private static final long serialVersionUID = 4804260264032468336L;

	private Book book;

	private BookService bookService = new BookService();

	public String delete() {
		try {
			//System.out.println("Entrou na função de deletar com isbn = " + book.getIsbn());
			bookService.delete(book);
		} catch (ServiceDacException e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		
		reportarMensagemDeSucesso("Livro '" + book.getName() + "' excluido com sucesso");
		
		return "index?faces-redirect=true";
	}

	public String cancel() {
		return "search.xhtml";
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	
}
