package ujeongri.com.gh.game.view;

import java.util.ArrayList;

public class Player {
	
	private int hp;
	private String itemList;
	
	public Player(int hp, String itemList) {
		super();
		this.hp = hp;
		this.itemList = itemList;
	}

	public int getHp() {
		return hp;
	}


	public String getItemList() {
		return itemList;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}


	public void setItemList(String itemList) {
		this.itemList = itemList;
	}

	
	@Override
	public String toString() {
		return "Player hp : " + hp + ", itemList : " + itemList;
	}
	
	
	
	

}
