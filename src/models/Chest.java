public class Chest extends Entity{

	private boolean open = false; 
	private Items[] storage;

	public Chest(String sprite){
		super(sprite, false);
	}

	public boolean getOpen(){
		return open;
	}

	public void setOpen(boolean open){
		this.open = open;
	}

	public Items[] getItems(){
		return storage;
	}

	public void setItems(Items[] storage){
		this.storage = storage;
	}

}
