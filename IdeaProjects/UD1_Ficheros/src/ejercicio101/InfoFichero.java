package ejercicio101;

import java.io.File;
import java.util.Scanner;

public class InfoFichero {
 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     System.out.println("Introduce la ruta de un fichero/directorio");

     File directorio = new File(sc.nextLine());


    if(directorio.exists()==true) {
        System.out.println("Nombre: "+directorio.getName());
        System.out.println("Ruta relativa: "+directorio.getPath());
        System.out.println("Ruta absoluta: "+directorio.getAbsolutePath());
        System.out.println("Permiso de lectura: "+directorio.canRead());
        System.out.println("Permiso de escritura: "+directorio.canWrite());
        System.out.println("Tamaño: "+directorio.length()+" bytes.");
        if (directorio.isFile()) {
            System.out.println("Es un fichero");
        } else {
            System.out.println("Es un directorio");
        }
    } else{
        System.err.println("La ruta indicada no existe");
    }



 }
}
