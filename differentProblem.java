import java.util.Scanner;

public class differentProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lector=new Scanner(System.in);
		
		while(lector.hasNext()){
			
			long num1=lector.nextLong();
			long num2=lector.nextLong();
			long resultado=num1-num2;
			if(resultado<0){
				resultado*=-1;
				num1*=-1;
			}
			

			System.out.println(resultado);
		}
	}

}
