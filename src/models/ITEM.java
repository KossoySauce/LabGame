public enum ITEM{

	stick(5),
	sword(10),
	potion(0),
	key(0);

<<<<<<< HEAD
	//in order to get the damage values of each of the items, you have to call ITEM.item_name.getDamage();
	
	private int damage;

	ITEM(int d){
		damage = d;
	}

	public int getDamage(){
		return damage;
	}

}
=======
// in order to get the damage values of each of the items, you have to call: ITEM.item_name.getDamge();  	
 	private int damage;
 	ITEM (int d){
 		damage = d;
 	}

	public int getDamage(){
 		return damage;
 	}
}


>>>>>>> 6eb8702bb9126559a527115ae8a29a6920a82c86
