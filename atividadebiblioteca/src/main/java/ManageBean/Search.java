package ManageBean;

import javax.faces.bean.*;
import exceptions.ServiceDacException;
import services.BookService;



@RequestScoped
@ManagedBean
public class Search extends AbstractBean {

	
	
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
