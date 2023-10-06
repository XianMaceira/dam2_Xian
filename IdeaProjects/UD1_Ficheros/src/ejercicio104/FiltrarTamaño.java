package ejercicio104;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

public class FiltrarTamaño implements FilenameFilter {
    public static void main(String[] args) {
        FiltrarTamaño ft = new FiltrarTamaño();
        ft.filtrar("C:\\Users\\dam2_alu11\\dam2\\Interfaces", 10);

    }

   public void filtrar(String ruta, float minTamano) {
        File dir = new File(ruta);
        List<File> list = new LinkedList<>();
        for (String item: dir.list()) {
            File file = new File(ruta, item);
            if (file.length()>=minTamano) {
                list.add(file);
            }
        }
        for (File item: list) {
            System.out.println(item.getName()+"  "+item.length()/1000.0+" KiloBytes");
        }
    }



    @Override
    public boolean accept(File dir, String name) {
        return false;
    }
}
