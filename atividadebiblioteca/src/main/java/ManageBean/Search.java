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
public class Search extends AbstractBean {

	
	
	public String deleteBook(Book b) {
		 try {
			new BookService().delete(b);
		} catch (ServiceDacException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
