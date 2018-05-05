package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ManageBean.Book;
import exceptions.PersistenciaDacException;

public class BookDAO {

	private static Map<String, Book> REPOSITORY = new ConcurrentHashMap<String, Book>(new HashMap<String, Book>());

	public void save(Book book) throws PersistenciaDacException {
		
		REPOSITORY.put(book.getIsbn(),book);
	}

	public void update(Book book) throws PersistenciaDacException {
		REPOSITORY.put(book.getIsbn(), book);
	}

	public void delete(Book book) throws PersistenciaDacException {
		REPOSITORY.remove(book.getIsbn());
	}

	public Book getByID(String isbn) throws PersistenciaDacException {
		return REPOSITORY.get(isbn);
	}

	public List<Book> getAll() throws PersistenciaDacException {
		return new ArrayList<Book>(REPOSITORY.values());
	}

	public List<Book> findBy(BookFilter filter) throws PersistenciaDacException {

		if (filter == null || filter.isEmpty()) {
			return new ArrayList<Book>(REPOSITORY.values());
		}

		List<Book> resultado = new ArrayList<Book>();

		for (Book book : REPOSITORY.values()) {
			if (notEmpty(filter.getIsbn())) {
				if (equals(book.getIsbn(), filter.getIsbn())) {
					resultado.add(book);
					return resultado;
				}
				else
					continue;
			}
			
			// Name
			if (notEmpty(filter.getName())) {
				if (!contains(book.getName(), filter.getName())) {
					continue;
				}
			}

			if (notEmpty(filter.getEdition())) {
				if (!contains(book.getEdition(),filter.getEdition() )) {
					continue;
				}
			}
			if (notEmpty(filter.getType())) {
				if (!equals(book.getType(),filter.getType() )) {
					continue;
				}
			}
			if (notEmpty(filter.getUpPages() )&& (filter.getUpPages() > 0)) {
				if (!(filter.getUpPages() <= book.getQtdPages() ) ) {
					//System.out.println("N�o encontrou a editora");
					continue;
				}
			}
			if (notEmpty(filter.getDownPages())&& (filter.getDownPages() > 0)) {
				if (!(filter.getDownPages() >= book.getQtdPages() ) ) {
					//System.out.println("N�o encontrou a editora");
					continue;
				}
			}
			// Date begin
			if (notEmpty(filter.getRangeBegin())) {
				if (!assertDate(book.getDate(), filter.getRangeBegin(), true)) {
					continue;
				}
			}

			// Date end
			if (notEmpty(filter.getRangeEnd())) {
				if (!assertDate(book.getDate(), filter.getRangeEnd(), false)) {
					continue;
				}
			}

			resultado.add(book);
		}

		return resultado;

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
