public class Player extends Character{

	private ArrayList<Items> invintory = new ArrayList<>();

	public Player(String sprite, Items[] i){
		super(sprite);
		invintory.addItems(i);
	}

	public Player(Stirng sprite){
		super(sprite);
	}

	public void setInvintory(ArrayList<Items> invintory){
		this.invintory = invintory;
	}

	public ArrayList<Items> getInvintory(){
		return invintory;
	}	

	public void addItems(Items[] it){
		for(int i=0;i<it.length;i++){
			invintory.add(it[i]);
		}
	}

	public void addItem(Items i){
		invintory.add(i);
	}

	public void removeItem(int i){
		invintory.remove(i);
	}

	public void removeItem(Items i){
		invintory.remove(i);
	}

}
