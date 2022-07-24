import java.util.ArrayList;
public class Main{
	public static void driver(){
		Building b1=new Office("Kaan",2,10,15,"law");
		Building b2=new House("Mete",15,20,20,26,"blue");
		Building b3=new Market("Batu",1,4,12,"9.00","19.00");
		Building b4=new House("Yusuf",20,22,12,32,"black");
		Building b5=new Playground(40,2);
		//Playground b6=new Playground(1,10);
		//Playground b5=new Playground(40,5);
		//arr[2].getClosingTime();
		Street s1=new Street(55,20);
		//s1.add(arr[1],0);
		s1.add(b3,0);
		s1.add(b2,1);
		s1.add(b4,0);
		s1.add(b1,1);
		s1.add(b5,1);
		//s1.addPlayground(b6,1);
		//s1.addPlayground(b5,0);
		s1.list_buildings();
		//s1.list_playgrounds();
		//s1.displayRemainingLands();
		s1.drawSkylineSil();
		s1.displayBuildings();
		s1.displayRemainingLands();
		s1.list_playgrounds();
		s1.ratioPlaygrounds();
		s1.calculateLength("House");
		s1.remove(1,0);
		//s1.add(b4,0);
		//s1.removePlayground(0,0);
		System.out.println("-------------");
		s1.list_buildings();
		s1.list_playgrounds();
		s1.drawSkylineSil();
		s1.displayBuildings();
		s1.calculateLength("Market");
	}
	public static void main(String [] args)throws RuntimeException{
		driver();
	}


}