package services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ManageBean.Book;
import br.edu.ifpb.mt.dac.util.TransacionalCdi;

public class Persist {

	@Inject
	protected EntityManager manager;
	@Inject
	protected EntityManagerFactory factory;
//	private String bdName = "biblioteca";
	
	public EntityManager getEntityManager() {
//		if(manager == null) {
//			
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory(bdName);
//			manager = factory.createEntityManager();
//		}
		return manager;
	}
	@TransacionalCdi
	public boolean save(Object o) {
	    try {
	   
		   
		    
//		    manager.getTransaction().begin();        
		    manager.persist(o);
//		    manager.getTransaction().commit();    
//		    manager.close();

		    return true;
	    } catch (Exception e) {
	    	System.out.println("------"+e.getMessage());	    	
	    }
		return false;
	}
	
	@TransacionalCdi
	public boolean delete(Book b) {
	    try {
//			EntityManager em = getEntityManager();
//			try {
//				obj = em.find(User.class, obj.getId());
//				em.remove(obj);
//			} catch (PersistenceException pe) {
//				pe.printStackTrace();
//				throw new PersistenciaDacException("Ocorreu algum erro ao tentar remover o usuário.", pe);
//			}
		    //EntityManager manager = getEntityManager();

		    
//		    manager.getTransaction().begin();
		    //o = manager.merge(o);
	    	//Book b = (Book) o;
	    	b = manager.find(Book.class, b.getIsbn());
		    
		    manager.remove(b);
//		    manager.getTransaction().commit();  
//		    manager.close();

		    return true;
	    } catch (Exception e) {
	    	e.getMessage();	    	
	    }
		return false;
	}
	@TransacionalCdi
	public boolean edit(Book b) {
	    try {
//		    EntityManagerFactory factory = Persistence.createEntityManagerFactory(bdName);
//		    EntityManager manager = factory.createEntityManager();
		    
//		    manager.getTransaction().begin();
		    Book nb = getBook(b.getIsbn());
		    
	    	if(nb == null)
	    		return false;	
	    	
		    nb = manager.merge(nb);
		    
		    nb.setIsbn(b.getIsbn());
		    nb.setName(b.getName());
		    nb.setDate(b.getDate());
		    nb.setType(b.getType());
		    nb.setEdition(b.getEdition());
		    nb.setSubject(b.getSubject());
		    nb.setQtdPages(b.getQtdPages());
		    nb.setDescription(b.getDescription());
		    
		    manager.persist(nb);
//		    manager.getTransaction().commit();    
//		    manager.close();

		    return true;
	    } catch (Exception e) {
	    	e.getMessage();	    	
	    	return false;
	    }
	}
	public Book getBook(String key) {

//		EntityManagerFactory factory = Persistence.createEntityManagerFactory(bdName);
//    	EntityManager manager = factory.createEntityManager();

	    return manager.find(Book.class, key);
	}
	
	public ArrayList<Book> getBooks() {
//    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca");
//    	EntityManager manager = factory.createEntityManager();
//    	
		ArrayList<Book> result = (ArrayList<Book>) manager.createQuery(
    			"SELECT b FROM Book b ")
    	
				.getResultList();
    	return result;

    			


	}	
	
	@SuppressWarnings("unchecked")
	public List<Book> find(String sqlCode){
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory(bdName);
//	    EntityManager manager = factory.createEntityManager();
	    
			   return manager
			        .createQuery(sqlCode)
			        .getResultList();
	}
}
