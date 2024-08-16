//metodos auxiliares para obter e fechar uma conexão
//com o banco de dados

package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	//objeto do tipo connection
		private static Connection conn = null;
		
		//método para conectar com o banco de dados
		public static Connection getConnection() {
			if (conn == null) {
				try {
					Properties props = loadProperties();
					String url = props.getProperty("dburl");
					conn = DriverManager.getConnection(url, props);
				}
				catch(SQLException e) {
					throw new DbException(e.getMessage());
				}
			}
			return conn;
		}
		
		public static void closeConnection() {
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					throw new DbException(e.getMessage());
				}
			}
		}
		
		//metodo responsável para carregar as propriedades do arquivo db.properties
		private static Properties loadProperties() {
			try(FileInputStream fs = new FileInputStream("db.properties")){
				Properties props = new Properties();
				props.load(fs);
				return props;
			}
			catch(IOException e) {
				throw new DbException(e.getMessage());
			}
		}

}
