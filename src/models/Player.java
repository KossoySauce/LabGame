import java.util.*;
public class Player extends Character{

	private ArrayList<ITEM> invintory = new ArrayList<>();

	public Player(String sprite, ITEM i){
		super(sprite);
		addItem(i);
	}

	public Player(String sprite){
		super(sprite);
	}

	public ArrayList<ITEM> getInvintory(){
		return invintory;
	}	

	public void setInvintory(ArrayList<ITEM> invintory){
		this.invintory=invintory;
	}

	public void addItem(ITEM i){
		invintory.add(i);
	}

	public void removeItem(ITEM i){
		invintory.remove(i);
	}

	public boolean hasStick(){
		return invintory.contains(ITEM.stick);
	}
	public boolean hasSword(){
		return invintory.contains(ITEM.sword);
	}
	public boolean hasPotion(){
		return invintory.contains(ITEM.potion);
	}
	public boolean hasKey(){
		return invintory.contains(ITEM.key);
	}
}
