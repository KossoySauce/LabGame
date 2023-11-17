public enum ITEM{

	stick(5),
	sword(10),
	potion(0),
	key(0);

	//in order to get the damage values of each of the items, you have to call ITEM.item_name.getDamage();
	
	private int damage;

	ITEM(int d){
		damage = d;
	}

	public int getDamage(){
		return damage;
	}

}
