package Test;

public class BikeStore {

	public static void main(String[] args) {
		MountainBike myFirstBike = new MountainBike("xxx","yyy",40,10);
		System.out.println(myFirstBike.showDetails());
		System.out.println();
		
		
		MountainBike mySecondBike = new MountainBike("aaaa","bbbb",50,12);
		System.out.println(mySecondBike.showDetails());
		System.out.println();
		
		System.out.println(Bike.showTotalBike());
		
	}

}


class Bike {
	private String name , model;
	private int maxSpeed , currentSpeed = 0;
	private static int totalBike = 0;
	
	public Bike (String name , String model , int maxSpeed) {
		this.name = name;
		this.model = model;
		this.maxSpeed = maxSpeed;
		Bike.totalBike++;
	}
	
	public void increaseSpeed() {
		if (this.currentSpeed < this.maxSpeed) {
			this.currentSpeed++;
		}
	}
	
	public void decreaseSpeed() {
		if (this.currentSpeed > 0) {
			this.currentSpeed--;
		}
	}
	
	public int showSpeed() {
		return this.currentSpeed;
	}
	
	public String showDetails() {
		String details;
		details = String.format("name = %s\nmodel = %s\nmax speed = %d",this.name , this.model , this.maxSpeed);
		return details;
	}
	
	
//	static method
//	we call method on Bike class not object
	public static String showTotalBike() {
		String total;
		total = String.format("Total bike currently = %d",Bike.totalBike);
		return total;
	}
}


class MountainBike extends Bike {
	private int mass;
	
	public MountainBike (String name , String model , int maxSpeed , int mass) {
		super(name, model, maxSpeed);
		this.mass = mass;
	}
	
	public String showDetails() {
		String details;
//		we use  "super.showDetails()"  because we want to use parents method not child method
		details = String.format("%s\nmass = %d",super.showDetails(),this.mass);		
		return details;
	}
}



