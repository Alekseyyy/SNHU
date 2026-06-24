package com.gamingroom;

import java.util.*;

/**
 * A singleton service for the game engine
 * 
 * @author Alexander Ahmann <alexander.ahmann@snhu.edu>
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	public GameService() {
	}
	
	private static GameService INSTANCE;
	public static GameService getInstance() {
		if (INSTANCE == null)
			INSTANCE = new GameService();
		
		return INSTANCE;
	}
	

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Student Function: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		
		Iterator<Game> gameLoop = games.iterator();
		while (gameLoop.hasNext()) {
			Game currentGame = gameLoop.next();
			if (currentGame.name == "name") {
				game = currentGame;
				return game;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// Student Function: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		
		Iterator<Game> gameLoop = games.iterator();
		while (gameLoop.hasNext()) {
			Game currentGame = gameLoop.next();
			if (currentGame.id == id)
				game = currentGame;
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Student Function: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		
		Iterator<Game> gameLoop = games.iterator();
		while (gameLoop.hasNext()) {
			Game currentGame = gameLoop.next();
			if (currentGame.name == "name")
				game = currentGame;
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}

/*
 * References:
 * 1. To complete the iterators, I referenced the following article (Retrieved on May. 
 *     20, 2024): https://www.w3schools.com/java/java_iterator.asp
 * 2. When developing a "singleton" designer pattern, I referenced the following article
 *     (Retrieved on May. 20, 2024): https://www.baeldung.com/java-singleton
 */
