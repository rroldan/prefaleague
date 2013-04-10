package org.ibertech.client;

import java.util.List;

import org.ibertech.shared.Player;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IPlayerServiceAsync {

	void addPlayer(Player player, AsyncCallback<Void> callback);

	void deletePlayer(Player player, AsyncCallback<Void> callback);

	void getPlayer(String name, AsyncCallback<Player> callback);

	void savePlayer(Player player, AsyncCallback<Void> callback);
	
	void getAllPlayer(AsyncCallback<List<Player>> callback);

}
