package io.github.invigoratedcat.dragui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;



public final class DRAGui extends JavaPlugin {
	private final String ue = "mcph699707", psk= "4dcc0b1ce9", url="jdbc:mysql://66.85.144.162:3306/mcph699707";
	private static Connection connection;
	
	@Override
	public void onEnable() {
		CommandExecutor cmdh = new CommandHandler(this);
		this.getCommand("drag").setExecutor(cmdh);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			this.getLogger().log(Level.SEVERE, "JDBC driver not found!");
			this.getServer().getPluginManager().disablePlugin(this);
		}
		try {
			connection = DriverManager.getConnection(url, ue, psk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onDisable() {
		try {
			if(connection!=null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
