package model;

import java.util.ArrayList;

public class Game {
    private int maxPlayers;
    private ArrayList<String> players = new ArrayList<String>();
    private ArrayList<String> spectators = new ArrayList<String>();
    private int status;

    public String getStatusString() {
        if(status == 0)
        {
            return "Inactive";
        }
        else if (status == 1)
        {
            return "Active";
        }
        else if (status == 2)
        {
            return "Finished";
        }
        else
        {
            return "Unknown";
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public void addPlayer(String player) {
        this.players.add(player);
    }
    public void removePlayer(String player) {
        this.players.remove(player);
    }
    public boolean playerExists(String player) {
        return this.players.indexOf(player) != -1;
    }

    public ArrayList<String> getSpectators() {
        return spectators;
    }

    public void setSpectators(ArrayList<String> players) {
        this.spectators = players;
    }

    public void addSpectator(String player) {
        this.spectators.add(player);
    }
    public void removeSpectator(String player) {
        this.spectators.remove(player);
    }
    public boolean spectatorExists(String player) {
        return this.spectators.indexOf(player) != -1;
    }

    public Game() {
        maxPlayers = 6;
        status = 0;
    }
}
