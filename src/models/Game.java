import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class Game{

	public static void main(String[] args){

		Scanner kb = new Scanner(System.in);
		boolean cont = true;
		boolean notMatch = true;
		
		while(cont){
			boolean validLevel = false;
			String level = "";
			int ilevel=0;
			while(!validLevel){
				System.out.print("Enter level(1,2,3): ");
				level = kb.next();
				try{
					ilevel = Integer.valueOf(level);
					if ((ilevel<1)||(ilevel>3)){
						throw new InputMismatchException();
					}else{
						validLevel=true;
					}
				} catch (NumberFormatException e){
					System.out.println("Invalid option");
				} catch (InputMismatchException e){
					System.out.println("Not a level numer option");
				}
			}
			Map m = new Map("level"+level+".txt",ilevel);
			boolean doorOpen = false;
			boolean alive = true;
			int i = 0;
			int chestCount = 0;
			while((!doorOpen)&&(alive)){
				m.printMap();
				m.playStats();
				System.out.print("Enter move (a,s,d,w): ");
				char move = kb.next().charAt(0);
			
				if(move=='a'||move=='s'||move=='d'||move=='w'){
					if(isValidMove(move,m)){
						if(m.nextPassable(move)){
							if(move=='a'){
								m.moveLeft();
							} else if(move=='s'){
								m.moveDown();
							} else if(move=='d'){
								m.moveRight();
							} else{
								m.moveUp();
							}
						} else {
							int nextRefNum = m.getNextRefNum(move);
							m.makeNextVisible(move);
							if (nextRefNum == 1){
								System.out.println("You hit a Wall. -5 health");
								m.playerHit(5);
							} else if(nextRefNum == 2){
								System.out.println("You fell in a hole. You died");
								alive = false;
							} else if (nextRefNum == 3){
								Entity e = m.nextEntity(move);
								Chest ches = new Chest("");	
								if (e instanceof Chest){
									ches = (Chest)e;
								}
								if(ches.isOpen()){
									System.out.println("You already opened that chest");
								} else {	
									chestCount++;
									System.out.println("You found your " + chestCount + " chest");
									if(chestCount == ilevel){
										m.addKey();
										System.out.println("You found the Key");
									} else{
										System.out.println("You still have "+ ((ilevel)-chestCount) + " chest(s) to find");
										System.out.println(" + 10 health ");
										m.playerGet(10);
									}
									m.openChest(move);
								}
							} else if (nextRefNum == 4){
								System.out.println("You ran into a monster. -10 health");
								m.playerHit(10);
							} else if (nextRefNum == 6){	
								System.out.println("Found the door");
								if(m.hasKey()){
									doorOpen = true;
								} else { 
									System.out.println("You do not have the key. Must open more chests");
								}
							} else{
								System.out.println("something went wrong");
							}
							if(m.playerHealth()<=0){
								alive = false;
							}	
						}
					}else{
						System.out.println("not a valid move");	
					}
				}else{
					System.out.println("not a valid input");
				}
				
			}
			m.printMap();
			if(!alive){
				System.out.print("You died :( ");
			}
			if(doorOpen){
				System.out.print("You won! ");
			}
	
			while(notMatch){
				System.out.print("Play again? y/n: ");
				char stop = kb.next().charAt(0);
				if(stop=='n'){
					cont = false;
					notMatch = false;
				} else if (stop != 'y'){
					System.out.println("Invalid option");
				} else {
					notMatch = false;
				}
			}
			notMatch=true;
		}	
	}	

	public static boolean isValidMove(char mv, Map m){
		int x = m.getX();
		int y = m.getY();
		int r = m.getRow();
		int c = m.getCol();
		if(mv == 'a'){
			if((x-1)<0){
				return false;
			} return true;
		} else if(mv == 's'){			
			if((y+1)>r){
				return false;
			} return true;
		} else if(mv == 'd'){
			if((x+1)>c){
				return false;
			} return true;
		} else if(mv == 'w'){
			if((y-1)<0){
				return false;
			} return true;
		} else{			
			System.out.println("Not a valid character");
			return false;
		}
	}


}
