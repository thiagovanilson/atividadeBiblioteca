package ManageBean;


import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import exceptions.PersistenciaDacException;
import exceptions.ServiceDacException;
import services.BookDAO;
import services.BookService;


@ViewScoped
@ManagedBean
public class BookEdit extends AbstractBean {

	private Book book;
	private BookService bookService = new BookService();
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
		b.setQtdPages(10);
		b.setDate(new Date());
		b.setEdition("Abril");
		
		Book c = new Book();
		c.setIsbn("2222");
		c.setName("Livro02");
		c.setDescription("Descrição 02");
		c.setQtdPages(10);
		c.setDate(new Date());
		c.setEdition("Março");
		
		try {
			bookService.save(b);
			bookService.save(c);
			System.out.println("Povoou");
		} catch (ServiceDacException e) {
			System.out.println("Erro ao povoar " + e.getMessage());			e.printStackTrace();
		}
		
	}
//	public String saveBook() {
//		System.out.println("Salvo. SQN");
//		
//		System.out.println(toString());
//		return "index.xhtml";
//	}
	public String toString() {
		String text = "Name: " + book.getName();
		return text;
	}
	public String saveBook() {
		try {
			bookService.save(book);
		} catch (ServiceDacException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index.xhtml";
	}
/*
		try {
			if (isEdicaoDeUsuario()) {
				userService.update(user);
			} else {
				// Confirmar que senha não foi digitada errada
				if (!senhaDigitadaSemErro()) {
					reportarMensagemDeErro("Password does not match the confirm password!");
					return null; // Permanecer na mesma página
				}
				
				userService.calcularHashDaSenha(user);
			}
		} catch (ServiceDacException e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}

		reportarMensagemDeSucesso("User '" + user.getFirstName() + "' saved");

		return "index.xhtml?faces-redirect=true";
	}
	/*
	private boolean senhaDigitadaSemErro() {
		if (getConfirmacaoPassword() == null && getUser().getPassword() == null) {
			return true;
		}
		if (getConfirmacaoPassword() == null || getUser().getPassword() == null) {
			return false;
		}
		
		return getConfirmacaoPassword().equals(getUser().getPassword());
	}

	public boolean isEdicaoDeUsuario() {
		return user.getId() != null;
	}
	
	public boolean isAdmin() {
		return user != null && user.getGroup() == Group.ADMIN;
	}
	
	public boolean isVisitante() {
		return user != null && user.getGroup() == Group.VISITANTE;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	public String getConfirmacaoPassword() {
		return confirmacaoPassword;
	}
	
	public void setConfirmacaoPassword(String confirmacaoPassword) {
		this.confirmacaoPassword = confirmacaoPassword;
	}
	*/

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
