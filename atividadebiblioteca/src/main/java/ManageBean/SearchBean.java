package ManageBean;


import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import services.BookService;


@ViewScoped
@Named("search")
public class SearchBean extends AbstractBean {

	@Inject
	BookService service;
	
	@PostConstruct
	public void atualizar() {
		IndexBean.setMenuVisibility(true);
	}
	public String deleteBook(Book b) {
		try {
			service.delete(b);;
			
		} catch (Exception e) {
			reportarMensagemDeErro(e.getMessage());
		}
		reportarMensagemDeSucesso("Publicação '" + b.getName() + "' apagada com sucesso!");
		
		return null;
	}
	
	
}
