package server;

import models.User;

import java.util.ArrayList;
import java.util.List;


public class ServerUtil
{
	private static List<User> listaUtilizatori = null;

	public ServerUtil()
	{
		// hardcodare a unui utilizator intr-o lista
		listaUtilizatori = new ArrayList<>();
		listaUtilizatori.add(new User("ana","ana"));

	}
//
	public User checkLogin(String username, String password) {
		for (User utilizator : listaUtilizatori) {
			if (username.equals(utilizator.getUsername())) {
				if (password.equals(utilizator.getPassword()))
				{
						System.out.println("Numele logatului este "+utilizator.getUsername());
						System.out.println(utilizator);
						return utilizator;
				}
			}
		}
		return null;
	}
	
	
	
}
