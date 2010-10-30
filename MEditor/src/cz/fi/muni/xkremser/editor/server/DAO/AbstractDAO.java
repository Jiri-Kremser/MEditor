package cz.fi.muni.xkremser.editor.server.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.Log;

import com.google.inject.Inject;

import cz.fi.muni.xkremser.editor.server.config.EditorConfiguration;

public class AbstractDAO {

	private Connection conn = null;

	@Inject
	private EditorConfiguration conf;

	@Inject
	public Log logger = null;

	private void initConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException ex) {
			logger.error("Could not find the driver", ex);
		}
		String host = conf.getDBHost();
		String port = conf.getDBPort();
		String login = conf.getDBLogin();
		String password = conf.getDBPassword();
		String name = conf.getDBName();
		if (password == null || password.length() < 3) {
			logger.error("Unable to connect to database at 'jdbc:postgresql://" + host + ":" + port + "/" + name + "' reason: no password set.");
			return;
		}
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + name, login, password);

		} catch (SQLException ex) {
			logger.error("Unable to connect to database at 'jdbc:postgresql://" + host + ":" + port + "/" + name + "'", ex);
		}
	}

	protected Connection getConnection() {
		if (conn == null) {
			initConnection();
		}
		return conn;
	}

	protected void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException ex) {
			logger.error("Connection was not closed", ex);
		}
		conn = null;
	}

}