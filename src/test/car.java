package test;

public class car {
	long license;
	int mileage;
	public double rate=1;
	car(){
		
	}
	car(long license, int mileage, double rate){
		this.license=license;
		this.mileage = mileage;
		this.rate = rate;
	}

}
class Luxurycar extends car{
	//double rate=10;
	Luxurycar(){
	//	super.rate=10;
	}
	
	Luxurycar(long license, int mileage, double rate){
		this.license=license;
		this.mileage = mileage;
		this.rate = rate;
	}

	public static void main(String[] args){
		Luxurycar yourcar = new Luxurycar(123, 123, 4.0);
	}
	
}
