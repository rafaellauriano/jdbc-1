package db;

public class DbException extends RuntimeException{
	
	//número de versão
	private static final long serialVersionUID = 1L;
	
	//construtor
	public DbException(String msg) {
		super(msg);
	}

}
