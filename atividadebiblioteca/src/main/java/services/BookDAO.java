package services;

import java.util.Date;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ManageBean.Book;
import exceptions.PersistenciaDacException;

public class BookDAO extends Persist{


	private List<Book> books;
	
	public void update(Book book) throws PersistenciaDacException {
		edit(book);
	}
	
	public Book getByID(String isbn) throws PersistenciaDacException {
		return getBook(isbn);
	}

	public List<Book> getAll() throws PersistenciaDacException {
		books = getBooks();
		return books;//new ArrayList<Book>(REPOSITORY.values());
	}

	public List<Book> findBy(BookFilter filter) throws PersistenciaDacException {

		if (filter == null || filter.isEmpty()) {
			getAll();
			return books;
		}

		String sql = "SELECT b FROM Book b Where 1 = 1 ";

		if (notEmpty(filter.getName())) {
			sql += " AND b.title Like :Title";
		}
		
		if (notEmpty(filter.getType())) {
			sql += " AND b.type LIKE :Type ";
		}

		
		if (notEmpty(filter.getDownPages()) && filter.getDownPages() > 0) {
			sql += " AND b.qtdPages <= :RangeBegin ";
		}

		if (notEmpty(filter.getUpPages()) && filter.getUpPages() > 0) {
			sql += " AND b.qtdPages >= :RangeEnd ";
		}
		
		if (notEmpty(filter.getRangeBegin()) ) {
			sql += " AND b.date >= :DateBegin ";
		}
		
		if (notEmpty(filter.getRangeEnd()) ) {
			sql += " AND b.date <= :DateEnd ";
		}
		
		if (notEmpty(filter.getEdition()) ) {
			sql += " AND b.edition like :Edition ";
		}

		EntityManager em = getEntityManager();
		TypedQuery<Book> query = em.createQuery(sql, Book.class);
		
		if (notEmpty(filter.getName())) {
			query.setParameter("Title", "%" + filter.getName() + "%");
		}

		if (notEmpty(filter.getType())) {
			query.setParameter("Type", "" + filter.getType());
		}

	 
		if (notEmpty(filter.getDownPages()) && filter.getDownPages() > 0) {

			query.setParameter("RangeBegin", filter.getDownPages());
		}

		if (notEmpty(filter.getUpPages()) && filter.getUpPages() > 0) {
			query.setParameter("RangeEnd", filter.getUpPages());
		}

		if (notEmpty(filter.getRangeBegin()) ) {
			query.setParameter("DateBegin", filter.getRangeBegin());
		}	
		
		if (notEmpty(filter.getRangeEnd()) ) {
			query.setParameter("DateEnd", filter.getRangeEnd());
		}	
		
		if (notEmpty(filter.getEdition()) ) {
			query.setParameter("Edition", filter.getEdition());
		}
		return query.getResultList();

	}

	private boolean equals(Object obj1, Object obj2) {
		return obj1.equals(obj2);
	}

	private boolean assertDate(Date date, Date dateLimit, boolean atLeast) {
		if (date == null) {
			return true;
		}
		if (atLeast) {
			return date.compareTo(dateLimit) >= 0;
		} else {
			// atMost
			return date.compareTo(dateLimit) <= 0;
		}
	}

	private boolean contains(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1 == null || s2 == null) {
			return false;
		}

		return s1.toUpperCase().contains(s2.toUpperCase());
	}
	
	private boolean notEmpty(Object obj) {
		return obj != null;
	}
	
	private boolean notEmpty(String obj) {
		return obj != null && !obj.trim().isEmpty();
	}	
}
