package services;


import java.io.Serializable;

import java.util.List;

import ManageBean.Book;
import exceptions.*;




public class BookService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7803325791425670859L;
	
	private BookDAO bookDAO = new BookDAO();
	
	public void save(Book book) throws ServiceDacException {
		try {
			// Verificar se login já existe
			//validarLogin(book);
			bookDAO.save(book);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public void update(Book book) throws ServiceDacException {
		
		try {
			// Verificar se login já existe
			bookDAO.update(book);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public void delete(Book book) throws ServiceDacException {
		try {
			bookDAO.delete(book);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public Book getByID(String isbn) throws ServiceDacException {
		try {
			return bookDAO.getByID(isbn);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public List<Book> getAll() throws ServiceDacException {
		try {
			return bookDAO.getAll();
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}

	public List<Book> findBy(BookFilter filter) throws ServiceDacException {
		try {
			return bookDAO.findBy(filter);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException(e.getMessage(), e);
		}
	}
	
//	public String calcularHashDaSenha(Book book) throws ServiceDacException {
//		book.setPassword(hash(user.getPassword()));
//		return user.getPassword();
//	}

//	public String calcularHash(String password) throws ServiceDacException {
//		return hash(password);
//	}

	/**
	 * Método que calcula o hash de uma dada senha usando o algoritmo SHA-256.
	 * 
	 * @param password
	 *            senha a ser calculada o hash
	 * @return hash da senha
	 * @throws ServiceDacException
	 *             lançada caso ocorra algum erro durante o processo
	 */
//	private static String hash(String password) throws ServiceDacException {
//		MessageDigest md;
//		try {
//			md = MessageDigest.getInstance("SHA-256");
//			md.update(password.getBytes("UTF-8"));
//			byte[] digest = md.digest();
//			BigInteger bigInt = new BigInteger(1, digest);
//			String output = bigInt.toString(16);
//			return output;
//		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
//			throw new ServiceDacException("Could not calculate hash!", e);
//		}
//	}

//	private void validarLogin(User user) throws ServiceDacException {
//		boolean jahExiste = userDAO.existeUsuarioComLogin(user);
//		if (jahExiste) {
//			throw new ServiceDacException("Login already exists: " + user.getLogin()); 
//		}
//	}
	
}
