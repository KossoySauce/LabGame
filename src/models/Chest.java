public class Chest extends Entity{

	private boolean open = false; 
	private ITEM store; //a chest can hold a singular item

	public Chest(String sprite){
		super(sprite, false);
		super.setRefNum(3);
	}
		

	public boolean isOpen(){
		return open;
	}

	public void openChest(){
		open = true;
	}

	public ITEM getItem(){
		return store;
	}

	public void setItem(ITEM store){
		this.store = store;
	}

}
