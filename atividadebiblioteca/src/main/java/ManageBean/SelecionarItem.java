package ManageBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import services.BookFilter;
import services.BookService;



@RequestScoped
@ManagedBean
public class SelecionarItem extends AbstractBean {

	private List<Book> books;
	private BookService bookService = new BookService();
	private BookFilter bookFilter;
	private static final long serialVersionUID = -5976838804313515033L;	

	
	

	

	
//	public void yDes(String s) {
//		System.out.println(s);
//		ind.limpar();
//		bookFilter.setTitle(s);
//		ind.filtrar();
//	}
	
}
