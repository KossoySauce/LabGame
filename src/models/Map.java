import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Map{

	Entity[][] map = null;
	Entity[][] visible = null;
	Player play = new Player("\u2640");
	Chest ches = new Chest("\u26CA");
	Empty ty = new Empty(" ");
	int curRow = 0;
	int curCol = 0; 
	int x = 0;
	int y = 0; 
	int nR, nC, endRow, endCol, initRow, initCol;
	int level;

	public Map(String fileName,int level){
		this.level = level;
		Scanner input = null; 
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e){
			System.out.println("Invalid file name");
			return;
		} 
		input.useDelimiter(",|\n");
		
		nR = Integer.valueOf(input.next());
		nC = Integer.valueOf(input.next());
		map = new Entity[nR][nC];
		if(level==2){
			play.addHealth(50);
		} 
		if(level==3){
			play.addHealth(100);
		}	
		

		initCol = Integer.valueOf(input.next());
		initRow = Integer.valueOf(input.next());
		y = initRow;
		x = initCol;
		endCol = Integer.valueOf(input.next());
		endRow = Integer.valueOf(input.next());

		while(input.hasNext()){
			int ent = Integer.valueOf(input.next());
			if(ent==1){
				Wall add = new Wall("\u26F0");
				map[curRow][curCol] = add;
			}else if(ent==2){
				Hole add = new Hole("\u2B24");
				map[curRow][curCol] = add;
			}else if(ent==3){
				Chest add = new Chest("\u26CA");
				map[curRow][curCol] = add;
			}else if(ent==4){
				Enemy add = new Enemy("\u2639");
				map[curRow][curCol] = add;
			}else if(ent==5){
				map[curRow][curCol] = play;
			}else if(ent==6){
				Door add = new Door("\u26F3");
				map[curRow][curCol] = add;
			}else{
				Floor add = new Floor("\u2610");
				map[curRow][curCol] = add;
				
			}
			
			//map[curRow][curCol] = add;
			curCol++;
			if(curCol==nC){
				curCol=0;
				curRow++;
			}
			
		}

		makeEmptyMap();

		input.close();
	}

	public void makeEmptyMap(){
		visible = new Entity[nR][nC];
		for(int i=0;i<nR;i++){
			for(int j=0;j<nC;j++){
				if((i==0)||(j==0)||(i==(nR-1))||(j==(nC-1))){
					visible[i][j] = map[i][j];
				} else{
					visible[i][j] = new Empty("\u23F9");
				}
			}
		}
	}

	public void moveRight(){
		int tempX = x;
		int tempY = y;
		x++;
		map[y][x]=play;
		map[tempY][tempX] = ty;
		visible[y][x] = map[y][x];
		visible[tempY][tempX] = map[tempY][tempX];		
	}
	public void moveLeft(){
		int tempX = x;
		int tempY = y;
		x--;
		map[y][x]=play;
		map[tempY][tempX] = ty;		
		visible[y][x] = map[y][x];
		visible[tempY][tempX] = map[tempY][tempX];		
	}
	public void moveUp(){
		int tempX = x;
		int tempY = y;
		y--;
		map[y][x]=play;
		map[tempY][tempX] = ty;		
		visible[y][x] = map[y][x];
		visible[tempY][tempX] = map[tempY][tempX];		
	}
	public void moveDown(){
		int tempX = x;
		int tempY = y;
		y++;
		map[y][x]=play;
		map[tempY][tempX] = ty;		
		visible[y][x] = map[y][x];
		visible[tempY][tempX] = map[tempY][tempX];		
	}
	public Entity nextEntity(char m){
		Entity next;
		if(m=='a'){
			next = map[y][x-1];		
		} else if (m == 's'){
			next = map[y+1][x];
		} else if (m == 'd'){
			next = map[y][x+1];
		} else if (m == 'w'){
			next = map[y-1][x];
		} else {
			System.out.println("not acceptable input");
			return null;
		}
		return next;
	}
	public void makeNextVisible(char m){
		System.out.println(m);
		if(m=='a'){
			visible[y][x-1] = map[y][x-1];		
		} else if (m == 's'){
			visible[y+1][x] = map[y+1][x];
		} else if (m == 'd'){
			visible[y][x+1] = map[y][x+1];
		} else if (m == 'w'){
			visible[y-1][x] = map[y-1][x];
		} else {
			System.out.println("not acceptable input");
		}
	}
	
	public boolean nextPassable(char m){
		Entity next = nextEntity(m);
		if(next == null){
			System.out.println("null");
			return false;
		} else {
			return next.getPassable();
		}
	}

	public int getNextRefNum(char m){
		Entity next = nextEntity(m);
		if(next == null){
			return -1;
		} else{
			return next.getRefNum();
		}
	}


	public void printMap(){
		for(int i=0;i<nR;i++){
			for(int j=0;j<nC;j++){
				System.out.print(visible[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void playerHit(int n){
		play.subHealth(n);	
	}
	public void playerGet(int n){
		play.addHealth(n);
	}
	public int playerHealth(){
		return play.getHealth();
	}
	public void addKey(){
		play.getKey();
	}
	public boolean hasKey(){
		return play.hasKey();
	}
	public void openChest(char m){
		Chest ches = new Chest("\u26CA");
		ches.openChest();
		if(m=='a'){
			map[y][x-1]=ches;		
		} else if (m == 's'){
			map[y+1][x]=ches;
		} else if (m == 'd'){
			map[y][x+1]=ches;
		} else if (m == 'w'){
			map[y-1][x]=ches;
		} else {
			System.out.println("not acceptable input");
		}
	}

	public void playStats(){
		play.printStats();
	}
	
	public int getRow(){
		return nR;
	}
	public int getCol(){
		return nC;
	}

	public int getInitRow(){
		return initRow;
	}
	public int getInitCol(){
		return initCol;
	}
	public int getEndRow(){
		return endRow;
	}
	public int getEndCol(){
		return endCol;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
}
