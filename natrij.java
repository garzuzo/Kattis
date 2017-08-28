import java.util.Scanner;

public class natrij {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lector = new Scanner(System.in);

			String[] arreglo1 = lector.nextLine().split(":");
			String[] arreglo2 = lector.nextLine().split(":");

		
			String[] resultado = new String[3];
			for (int i = 3 - 1; i >= 0; i--) {

				int resActual = Integer.parseInt(arreglo2[i]) - Integer.parseInt(arreglo1[i]);
				if (resActual < 0) {
					if(i!=0){
					resultado[i] = resActual +60+"";
					arreglo1[i-1]=Integer.parseInt(arreglo1[i-1])+1+"";
					if(Integer.parseInt(arreglo1[i-1])<10){
						arreglo1[i-1]="0"+arreglo1[i-1];
					}
					if(Integer.parseInt(resultado[i])<10){
						resultado[i]="0"+resultado[i];
					}
					
					}else{
						resultado[i]=resActual+24+"";
						if(Integer.parseInt(resultado[i])<10){
							resultado[i]="0"+resultado[i];
						}
					}
				} else {
					if(resActual<10){
						resultado[i] ="0"+ resActual;
					}else
						resultado[i] = resActual+"";
				}
			}
			if(resultado[0].equals("00") && resultado[1].equals("00")&& resultado[2].equals("00")){
				System.out.println("24:00:00");
			}else
			System.out.println(resultado[0]+":"+resultado[1]+":"+resultado[2]);

		
	}

}
