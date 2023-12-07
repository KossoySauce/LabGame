public class Door extends Entity{

	public Door(String sprite){
		super(sprite, false);
		super.setRefNum(6);
	}

	public void useKey(Player p){
		if(p.hasKey()){
			super.setPassable(true);
	//		p.removeItem(ITEM.key);
		}
	}

}
