package ManageBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import exceptions.ServiceDacException;
import services.BookService;



@RequestScoped
@ManagedBean
public class Search extends AbstractBean {

	@PostConstruct
	public void atualizar() {
		Index.setMenuVisibility(true);
	}
	public String deleteBook(Book b) {
		try {
			new BookService().delete(b);
		} catch (ServiceDacException e) {
			reportarMensagemDeErro(e.getMessage());
		}
		reportarMensagemDeSucesso("Publicação '" + b.getName() + "' apagada com sucesso!");
		
		//return "search.xhtml?faces-redirect=true";
		return null;
	}
}
