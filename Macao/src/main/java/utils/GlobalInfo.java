package utils;

import game.GameRoom;
import model.Game;

import java.util.ArrayList;
import java.util.UUID;

public class GlobalInfo {
    public static ArrayList<GameRoom> games=new ArrayList<GameRoom>();

    public static GameRoom getGame(UUID id)
    {
        for(GameRoom game : games)
        {
            if (game.getId().equals(id))
            {
                return game;
            }
        }
        return null;
    }
}
