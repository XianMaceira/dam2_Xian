# Repaso

## Unidad 1. Ficheros

### Ejercicio 101

#### Define una clase llamada InfoFichero, que le pida al usuario/a que introduzca una ruta (que puede ser un directorio o un fichero).

#### Si el fichero/directorio existe, se debe mostrar la siguiente información:

#### Nombre.
#### Ruta relativa.
#### Ruta absoluta.
#### Permiso de escritura.
#### Tamaño.
#### Indicar si es un directorio.
#### Indicar si es un fichero.
#### Si no existe, debe mostrar el mensaje La ruta indicada no existe..

#### Usa la clase File para realizar el ejercicio.
````java
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

````
### Ejercicio 102

#### Define una clase ManejoFicheros, que implemente los siguientes métodos:

#### Método	Descripción
#### void crearFichero(String fichero)	Crea el fichero indicado.
#### void borrarFichero(String fichero)	Borra el fichero indicado.
#### void crearDirectorio(String ruta)	Crea el directorio indicado.
#### void borrarDirectorio(String ruta)	Borra el directorio indicado.
#### void listarDirectorio(String ruta)	Lista el contenido del directorio indicado, indicando si los elementos de la lista son ficheros o subdirectorios.
#### Usa la clase File para realizar el ejercicio.

#### Crea una clase Main en la cual hagas uso de todos los métodos de la clase ManejoFicheros.

#### Main
```` java
package ejercicio102;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File F = new File("");
        String rutaFinal = F.getAbsolutePath();

        ManejoFichero.crearFichero("E:\\sample.txt");
        ManejoFichero.borrarFichero("E:\\sample.txt");
        ManejoFichero.crearDirectorio("E:\\arquivos");
        ManejoFichero.borrarDirectorio("E:\\arquivos");
        ManejoFichero.listarDirectorio("C:\\Users\\dam2_alu11\\dam2\\Interfaces");
    }
}
````
#### ManejoFichero
```` java
package ejercicio102;

import java.io.File;
import java.io.IOException;

public class ManejoFichero {

    public static void crearFichero(String fichero) {
        File file = new File(fichero);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Se ha creado el fichero en: " + fichero);
    }

    public static void borrarFichero(String fichero) {
        File file = new File(fichero);
        file.delete();
        System.out.println("Se ha borrado el fichero en: " + fichero);
    }

    public static void crearDirectorio(String ruta) {
        File file = new File(ruta);
        file.mkdir();
        System.out.println("Se ha creado el Directorio: " + ruta);
    }

    public static void borrarDirectorio(String ruta) {
        File file = new File(ruta);
        file.delete();
        System.out.println("Se ha borrado el Directorio: "+ruta);
    }

    public static void listarDirectorio(String ruta) {
        File file = new File(ruta);
        String[] listadoFicheros = file.list();
        System.out.println();
        System.out.println("Listado de: "+ruta);

        for (String item: listadoFicheros) {
            System.out.print(item + " ");
            File ficheroLista = new File(ruta, item);
            if (ficheroLista.isDirectory()) {
                System.out.println("(Subdirectorio)");
            } else {
                System.out.println("(Fichero)");
            }
        }
    }

}

````
### Ejercicio 103
#### En este ejercicio se busca ver dos posibles formas de filtrar un listado de ficheros.

#### Define una clase Filtrar que incluya el siguiente método:

#### void filtrar(String ruta, String extension);

#### El método debe listar solo aquellos archivos de la ruta que tienen una determinada extensión.

#### Crea una clase Main que llame al método Filtrar.filtrar().

#### Define una clase FiltrarNombre que implemente la interfaz FilenameFilter.

#### Desde la misma clase Main, utiliza la clase FiltrarNombre con el método Files.list() para mostrar aquellos archivos con una extensión determinada.
````java
package ejercicio103;

import java.io.File;
import java.io.FilenameFilter;

public class FiltrarNombre implements FilenameFilter {

    private String extension;

    public FiltrarNombre(String extension) {
        this.extension = extension;
    }

    public void filtrar(String ruta, String extension) {
        File directorio = new File(ruta);

            File[] archivos = directorio.listFiles(this);
            if (archivos != null) {
                for (File archivo : archivos) {
                    System.out.println(archivo.getName());
                }
            } else {
                System.out.println("No se encontraron archivos con la extensión " + extension);
            }
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith("." + extension);
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\dam2_alu11\\dam2\\Interfaces";
        String extension = "txt";

        FiltrarNombre filtro = new FiltrarNombre(extension);
        filtro.filtrar(ruta, extension);
    }
}


````
### Ejercicio 104

#### En este ejercicio se busca ver dos posibles formas de filtrar un listado de ficheros.

#### Define una clase Filtrar que incluya el siguiente método:

#### void filtrar(String ruta, float minTamano);

#### El método debe listar solo aquellos archivos de la ruta que tienen un tamaño (en bytes) mayor que el especificado.

#### Crea una clase Main que llame al método Filtrar.filtrar().

#### Define una clase FiltrarTamano que implemente la interfaz FilenameFilter.

#### Desde la misma clase Main, utiliza la clase FiltrarTamano con el método Files.list() para mostrar aquellos archivos que superen un determinado tamaño.
```` java
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

````

### Ejercicio 105

#### Define una clase ClasificaDirectorio que implemente el siguiente método:

#### void segunExtension(String dir);

#### Este método recibirá un único parámetro, el cual debe ser forzosamente un directorio. El método debe agrupar todos los ficheros de ese directorio en subdirectorios según su extensión. El nombre de cada subdirectorio debe ser el de la extensión de los ficheros que contiene en mayúsculas.

#### Por ejemplo, si hay varios ficheros .jpg, se creará un subdirectorio llamado JPG que los contenga.
```` java
package ejercicio105;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ClasificaDirectorio implements FilenameFilter {

    public static void moveFile(File src, File dest) throws IOException {
        Files.move(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    public static void main(String[] args) {
        ClasificaDirectorio cd = new ClasificaDirectorio();
        cd.segunExtension("C:\\Test");
    }

    void segunExtension(String dir) {
        File ruta = new File(dir);

        if(!ruta.isDirectory()) {
            System.err.println("La ruta introducida no es un directorio.");
            return;
        }

        File[] listaArchivos = ruta.listFiles();
        Set<String> extensiones = new HashSet<>();
        for (int i=0; i<listaArchivos.length; i++) {
            String nombreArchivo = listaArchivos[i].getName();
            extensiones.add(listaArchivos[i].getName().substring(nombreArchivo.lastIndexOf(".")+1).toUpperCase());
        }
        // Creamos las carpetas
        for (String ext : extensiones) {
            File f = new File(dir, ext);
            f.mkdir();
        }
        // Movemos los archivos
        for (File archivo : listaArchivos) {
                String nombreArchivo = archivo.getName();
                String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1).toUpperCase();
                File destino = new File(dir, extension + File.separator + nombreArchivo);

                try {
                    Files.move(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Movido " + nombreArchivo + " a " + extension + File.separator + nombreArchivo);
                } catch (IOException e) {
                    System.err.println("Error al mover el archivo " + nombreArchivo + ": " + e.getMessage());
                }
        }

    }


    @Override
    public boolean accept(File dir, String name) {
        return false;
    }
}


````

### Ejercicio 106

#### Crea una clase FicheroBinario que represente a un fichero binario.

#### La clase tendrá un atributo de tipo File que almacenará el fichero correspondiente. Además, tendrá los siguientes métodos:

#### Constructor.
#### Getter.
#### public void escribir(String texto): escribe en el propio fichero el texto pasado por parámetro.
#### public void leer(): muestra por consola el contenido del fichero.
#### public void copiar(FicheroBinario ficheroDestino): copia el contenido del fichero en el fichero de destino.
#### Utiliza las clases FileInputStream y FileOutputStream.

#### Luego, crea una clase ManejoFicherosBinarios, que implemente el método main(). En esta clase debes crear dos ficheros binarios origen.bin y destino.bin y hacer lo siguiente:

#### Escribe en el fichero de origen el siguiente texto: ESTE ES EL TEXTO DE ORIGEN.
#### Muestra el contenido del fichero por consola.
#### Copia el contenido al fichero de destino.

#### ManejoFicherosBinarios
```` java
package ejercicio106;

public class ManejoFicherosBinarios {
    public static void main(String[] args) {
        FicheroBinario ficheroOrigen = new FicheroBinario("origen.bin");
        FicheroBinario ficheroDestino = new FicheroBinario("destino.bin");

        String textoFicheroOrigen = "ESTE ES EL TEXTO DE ORIGEN";
        ficheroOrigen.escribir(textoFicheroOrigen);

        System.out.println("Contenido del fichero de origen");
        ficheroOrigen.leer();

        ficheroOrigen.copiar(ficheroDestino);


        System.out.println("\nContenido del fichero de destino");
        ficheroDestino.leer();
    }
}

````
#### FicheroBinario
```` java
package ejercicio106;

import java.io.*;

public class FicheroBinario {
    private File archivo;

    public File getFichero() {
        return archivo;
    }

    public FicheroBinario(String nombreArchivo) {

        archivo = new File(nombreArchivo);
    }

    public void escribir(String texto) {
        try (FileOutputStream fos = new FileOutputStream(archivo)){
            fos.write(texto.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leer() {
        try (FileInputStream fis = new FileInputStream(archivo)){
            int data;
            while ((data = fis.read()) != -1 ) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copiar(FicheroBinario ficheroDestino) {
        try(FileInputStream fis = new FileInputStream(archivo);
            FileOutputStream fos = new FileOutputStream(ficheroDestino.getFichero())) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}


````
### Ejercicio 107

#### Crea una clase FicheroTexto que represente a un fichero de texto.

#### La clase tendrá un atributo de tipo File que almacenará el fichero correspondiente. Además, tendrá los siguientes métodos:

#### Constructor.
#### Getter.
#### public void escribir(String texto): escribe en el propio fichero el texto pasado por parámetro.
#### public void leer(): muestra por consola el contenido del fichero.
#### Debes usar las clases FileReader y FileWriter.

#### Luego, crea una clase ManejoFicheroTexto que implemente el método main(). En esta clase debes crear un fichero de texto destino.txt. Además, debes implementar un menú que le muestre las siguientes opciones al usuario:

#### Escribir en el fichero.
#### Leer fichero.
#### Salir.
#### En caso de seleccionar la opción 1, el usuario introducirá por consola el texto que quiere escribir en el fichero.

#### El menú debe mostrarse hasta que el usuario seleccione la opción de salir. Si se escribe varias veces en el fichero, el texto se debe ir añadiendo a continuación del último añadido.

#### ManejoFicherosTexto
```` java
package ejercicio107;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ManejoFicheroTexto {
    public static void main(String[] args) {
        FicheroTexto fichero = new FicheroTexto("destino.txt");
        boolean salir = false;
        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Escribir en el fichero.");
            System.out.println("2. Leer fichero.");
            System.out.println("3. Salir.");
            System.out.print("Seleccione una opción: ");

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Introduzca el texto a escribir en el fichero: ");
                        String texto = br.readLine();
                        fichero.escribir(texto + "\n");
                        break;
                    case 2:
                        System.out.println("Contenido del fichero:");
                        fichero.leer();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException | IOException e) {
                System.err.println("Error en la entrada. Intente de nuevo.");
            }
        }
    }
}


````
#### FicheroTexto
```` java
package ejercicio107;

import java.io.*;

class FicheroTexto {
    private File archivo;

    public FicheroTexto(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }

    public File getArchivo() {
        return archivo;
    }

    public void escribir(String texto) {
        try (FileWriter escritor = new FileWriter(archivo, true); // true para abrir en modo de añadir al final del archivo
             BufferedWriter bufferEscritura = new BufferedWriter(escritor)) {
            bufferEscritura.write(texto);
            bufferEscritura.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void leer() {
        try (FileReader lector = new FileReader(archivo);
             BufferedReader bufferLectura = new BufferedReader(lector)) {
            String linea;
            while ((linea = bufferLectura.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}


````

### Ejercicio 108

#### Crea una clase Persona que:

#### Tenga los atributos nombre y edad.
#### Sea serializable.
#### Luego, crea una clase SerializarPersona que tenga los siguientes métodos:

#### public void escribirPersonaEnFichero(Persona persona, File fichero): escribe la información de la persona en el fichero.
#### #### public Persona leerPersonaDeFichero(File fichero): devuelve un objeto Persona con los datos leídos del fichero.
#### Debes usar las clases ObjectInputStream y ObjectOutputStream.

#### Además, debes implementar un método main() que haga lo siguiente:

#### Crear una persona.
#### Crear un fichero persona.txt.
#### Escribir los datos de la persona en el fichero.
#### Leer los datos y almacenarlos en un objeto diferente.
#### Mostrar por consola los datos recuperados.

#### Main
````java
package ejercicio108;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Crear una persona
        Persona persona = new Persona("Paco", 23);

        // Crear un fichero persona.ser
        File fichero = new File("persona.ser");

        // Crear una instancia de SerializarPersona
        SerializarPersona serializador = new SerializarPersona();

        // Escribir los datos de la persona en el fichero
        serializador.escribirPersonaEnFichero(persona, fichero);

        // Leer los datos y almacenarlos en un objeto diferente
        Persona personaLeida = serializador.leerPersonaDeFichero(fichero);

        // Mostrar por consola los datos recuperados
        if (personaLeida != null) {
            System.out.println("Persona recuperada: " + personaLeida);
        }
    }

}

````
#### Persona
````
package ejercicio108;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }



    public int getEdad() {
        return edad;
    }



    // Método toString para representar la información de la persona
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
    }
}
````
#### SerializarPersona
````
package ejercicio108;

import java.io.*;

public class SerializarPersona {

    public void escribirPersonaEnFichero(Persona persona, File fichero) {
        try (FileOutputStream fos = new FileOutputStream(fichero)){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(persona);
            System.out.println("Persona escrita en el fichero exitosamente.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Persona leerPersonaDeFichero(File fichero) {
        Persona persona = null;
        try (FileInputStream fis = new FileInputStream(fichero)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            persona = (Persona) ois.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return persona;
    }

}

````

### Ejercicio 109

#### Crea un directorio llamado dir que tenga dos archivos: origen.txt y destino.txt.

####  una clase CopiaFichero que implemente método main().

#### Utiliza las clases Paths y Files, y el método copy() para copiar el contenido de origen.txt en el fichero destino.txt.

````java
package ejercicio109;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopiaFichero {
    public static void main(String[] args) {
        Path org = Paths.get("C:\\Users\\dam2_alu11\\dam2\\Acceso a bases\\UD1\\TEST\\TEST 109\\origen.txt");
        Path dest = Paths.get("C:\\Users\\dam2_alu11\\dam2\\Acceso a bases\\UD1\\TEST\\TEST 109\\destino.txt");


        try {
            Files.copy(org, dest, StandardCopyOption.REPLACE_EXISTING);

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

````

### Ejercicio 110

#### Crea un directorio llamado dir que tenga dos archivos: origen.txt. Además, crea un subdirectorio llamado subdirectorio que esté vacío.

#### Crea una clase MoverFichero que implemente método main().

#### Utiliza las clases Paths y Files, y el método move() para mover el fichero origen.txt al subdirectorio, cambiándole el nombre al archivo: destino-sub.txt.
````java
package ejercicio110;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoverFichero {
    public static void main(String[] args) {
        Path org = Paths.get("C:\\Users\\dam2_alu11\\dam2\\Acceso a bases\\UD1\\TEST\\TEST 110\\dir\\origen.txt");
        Path dest = Paths.get("C:\\Users\\dam2_alu11\\dam2\\Acceso a bases\\UD1\\TEST\\TEST 110\\dir\\subdirectorio\\destino-sub.txt");


        try {
            Files.move(org, dest, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Se ha movido el fichero");
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
````

### Ejercicio 112
#### Crea una clase llamada LeerPeliculasXML que tenga un método main().

#### Dentro del main() utiliza la clase DocumentBuilder para leer el siguiente fichero XML: (se mmuestra un fichero XML)

#### En base a ese documento, se debe mostrar su información por consola con el siguiente formato:
````java
package ejercicio112;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class LeerPeliculasXML {
    public static void main(String[] args) {
        try {
            File inputFile = new File("C:\\Users\\dam2_alu11\\IdeaProjects\\UD1_Ficheros\\src\\ejercicio112\\peliculas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("pelicula");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nPELÍCULA #"+(temp+1)+": "+ nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Título: "+ eElement.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Año:  "+ eElement.getElementsByTagName("ano").item(0).getTextContent());
                    System.out.println("Precio: "+eElement.getElementsByTagName("precio").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

````
### Ejercicio 113

#### Crea una clase llamada EscribirPeliculasXML que tenga un método main(). Dentro del main() utiliza la clase Transformer para generar un nuevo fichero XML llamado copiaPeliculas.xml que sea una copia del siguiente fichero:
````java
package ejercicio113;

import org.w3c.dom.Node;

import org.w3c.dom.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EscribirPeliculasXML {
    public static void main(String[] args) {

        try {
            File xmlOriginal = new File("C:\\Users\\dam2_alu11\\IdeaProjects\\UD1_Ficheros\\src\\ejercicio113\\peliculas.xml");

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlOriginal);



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource((Node) doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\dam2_alu11\\IdeaProjects\\UD1_Ficheros\\src\\ejercicio113\\copia_peliculas.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
````

### Ejercicio 114

#### Tenemos un fichero usuarios.xml que almacena los usuarios y contraseñas de una aplicación.

#### Debes crear una aplicación Java que solicite un usuario y contraseña para inciar sesión.

#### Si el usuario existe en el fichero XML y la contraseña es correcta, se mostrará el mensaje SE HA INICIADO SESIÓN CON ÉXITO. Si no, se mostrará el mensaje USUARIO O CONTRASEÑA INCORRECTOS.

#### Además, en el fichero login.txt se irá guardando la información de inicio de sesión. Cuando un usuario inicia sesión con éxito, se guardará el siguiente mensaje en el fichero (uno por línea):
````java
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class iniciarSesion {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("usuarios.xml"));

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese el nombre de usuario: ");
            String usuario = br.readLine();
            System.out.print("Ingrese la contraseña: ");
            String contraseña = br.readLine();

            NodeList usuariosList = doc.getElementsByTagName("usuario");
            boolean inicioSesionExitoso = false;
            for (int i = 0; i < usuariosList.getLength(); i++) {
                Element usuarioElement = (Element) usuariosList.item(i);
                String nombre = usuarioElement.getElementsByTagName("nombre").item(0).getTextContent();
                String clave = usuarioElement.getElementsByTagName("contraseña").item(0).getTextContent();

                if (usuario.equals(nombre) && contraseña.equals(clave)) {
                    inicioSesionExitoso = true;
                    break;
                }
            }

            if (inicioSesionExitoso) {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String fechaActual = formatter.format(date);
                String mensaje = "El usuario " + usuario + " ha iniciado sesión en la fecha " + fechaActual + ".";
                guardarEnArchivo("login.txt", mensaje);

                System.out.println("SE HA INICIADO SESIÓN CON ÉXITO.");
            } else {
                System.out.println("USUARIO O CONTRASEÑA INCORRECTOS.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void guardarEnArchivo(String archivo, String mensaje) {
        try {
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(mensaje);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
````

### Ejercicio 115

#### Crea una clase serializable llamada Producto con los siguientes atributos:

#### idProducto: int
#### descripcion: String
#### precio: float
#### Crea una clase llamada ManejoProductos con los siguientes métodos:

#### Método crearProductos: devuelve un ArrayList de objetos de la clase Producto. El método crea 5 objetos de la clase Producto, usando la información de los siguientes arrays:
````java
int[] identificadores = {123, 456, 789, 235, 567};
String[] descripciones = {"cafe", "leche", "arroz", "sal", "coco"};
double[] precios = {1.22, 1.05, 1, 1.25, 3.2};
````
#### Método almacenarProductos: recibe un ArrayList de productos y almacena cada producto en un fichero binario llamado productos.bin.

#### Método leerProductos: lee los contenidos de productos.bin y muestra su contenido por consola.

#### Main
````java
package ejercicio115;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ManejoProductos manejador = new ManejoProductos();

        ArrayList<Producto> productos = manejador.crearProductos();
        manejador.almacenarProductos(productos);
        manejador.leerProdcutos();
    }
}

````

#### Producto
````java
package ejercicio115;
import java.io.Serializable;
public class Producto implements Serializable{
    private int idProducto;
    private String descripcon;
    private double precios;

    public Producto(int idProducto, String descripcon, double precio) {
        this.idProducto = idProducto;
        this.descripcon = descripcon;
        this.precios = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getDescripcon() {
        return descripcon;
    }

    public double getPrecios() {
        return precios;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", descripcon='" + descripcon + '\'' +
                ", precio=" + precios +
                '}';
    }
}


````

#### ManejoProductos
````java
package ejercicio115;

import java.io.*;
import java.util.ArrayList;

class ManejoProductos {
    public ArrayList<Producto> crearProductos() {
        int[] identificadores = {123, 456, 789, 235, 567};
        String[] descripciones = {"cafe", "leche", "arroz", "sal", "coco"};
        double[] precios = {1.22, 1.05, 1, 1.25, 3.2};

        ArrayList<Producto> productos = new ArrayList<>();

        for (int i = 0; i < identificadores.length; i++) {
            Producto producto = new Producto(identificadores[i], descripciones[i], precios[i]);
            productos.add(producto);
        }

        return productos;
    }

    public void almacenarProductos(ArrayList<Producto> productos) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productos.bin"));
            oos.writeObject(productos);
            oos.close();
            System.out.println("Productos almacenados en productos.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void leerProdcutos() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productos.bin"));
            ArrayList<Producto> productos = (ArrayList<Producto>) ois.readObject();
            ois.close();

            System.out.println("Contenido de productos.bin:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
````

### Ejercicio 116

#### Escribe un programa que lea el fichero de texto refranes.txt.

#### A continuación, el programa debe solicitar al usuario que introduzca una vocal. Una vez introducida, el programa debe crear una copia del fichero en el mismo directorio, sustituyendo todas las vocales por la vocal introducida por el usuario.

#### El fichero resultante debe tener el nombre refranes_CON_X.txt, siendo X la vocal introducida.
````java
package ejercicio116;

import java.io.*;
import java.util.Scanner;

public class Refranes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una vocal");
        char vocalSolicitada = sc.next().charAt(0);


        if (!esVocal(vocalSolicitada)) {
            System.out.println("No has introducido un vocal");
            sc.close();
            return;
        }

        String nomArcEntrada = "refranes.txt";
        String nomArcSalida = "refranes_CON_"+vocalSolicitada+".txt";

        try {
            FileReader ArcEntrada = new FileReader(nomArcEntrada);
            BufferedReader lector = new BufferedReader(ArcEntrada);

            FileWriter ArcSalida = new FileWriter(nomArcSalida);
            BufferedWriter writer = new BufferedWriter(ArcSalida);

            String linea;
            while ((linea = lector.readLine()) != null) {
                String lineaReemplazada = ReemplazarVocal(linea, vocalSolicitada);
                writer.write(lineaReemplazada);
                writer.newLine();
            }

            lector.close();
            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean esVocal(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static String ReemplazarVocal (String texto, char vocalSolicitada) {
        return texto.replaceAll("[aeiouAEIOU]", String.valueOf(vocalSolicitada));
    }
}
````
### Ejercicio 117

#### Escribe un programa que permita a los usuarios crear y almacenar objetos en un fichero.

#### Crea una clase Estudiante con los siguientes atributos:

#### Nombre (String)
#### Número de identificación (int)
#### Edad (int)
#### Promedio de calificaciones (double)
#### Crea un menú interactivo que permita al usuario realizar las siguientes operaciones:

#### Agregar un nuevo estudiante.
#### Mostrar la información de todos los estudiantes almacenados.
#### Guardar la información de los estudiantes en un archivo mediante la serialización de objetos.
#### Salir del programa.
#### Cuando se seleccione la opción de guardar la información de los estudiantes en un archivo, almacena toda la información de los objetos Estudiante en un archivo llamado estudiantes.dat.

#### Cuando se inicie el programa, verifica si el archivo estudiantes.dat existe. Si existe, carga los datos del archivo y muestra la información de los estudiantes en el menú.

#### Asegúrate de que el programa sea robusto frente a posibles errores, como la falta de archivo o la entrada de datos incorrecta por parte del usuario.

#### Estudiante
````java
package ejercicio117;

import java.io.Serializable;

public class Estudiante implements Serializable{
    private String nombre;
    private int numIdentificacion;
    private int edad;
    private double promCalificaciones;

    public Estudiante(String nombre, int numIdentificacion, int edad, double promCalificaciones) {
        this.nombre = nombre;
        this.numIdentificacion = numIdentificacion;
        this.edad = edad;
        this.promCalificaciones = promCalificaciones;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", numIdentificacion=" + numIdentificacion +
                ", edad=" + edad +
                ", promCalificaciones=" + promCalificaciones +
                '}';
    }
}

````
#### OperacionesEstudiantes
````
package ejercicio117;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperacionesEsudiantes {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        File file = new File("estudiantes.dat");

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
                estudiantes = (List<Estudiante>) ois.readObject();
                System.out.println("Datos de esudiantes.dat cargados");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("..................");
            System.out.println("1. Agregar un nuevo estudiante.");
            System.out.println("2. Mostrar la información de todos los estudiantes almacenados.");
            System.out.println("3. Guardar la información de los estudiantes en un archivo mediante la serialización de objetos.");
            System.out.println("4. Salir del programa.");
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Número de Identificación: ");
                    int id = sc.nextInt();
                    System.out.println("Edad: ");
                    int edad = sc.nextInt();
                    System.out.println("Nota promedio");
                    double media = sc.nextDouble();

                    Estudiante newEstudiante = new Estudiante(nombre, id, edad, media);
                    estudiantes.add(newEstudiante);
                    System.out.println("Estudiante añadido");
                    break;
                case 2:
                    System.out.println("Informacion Estudiantes");
                    for (Estudiante estudiante : estudiantes) {
                        System.out.println(estudiante);
                    }
                    break;
                case 3:
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                        oos.writeObject(estudiantes);
                        System.out.println("Datos guardados en estudiantes.dat");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Saliendo");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("Opción invalida");
            }

        } while (opcion !=4);

        
    }
}
````

### Ejercicio 118

#### Escribe un programa en que permita determinar el tipo de archivo de un fichero dado basándose en los primeros bytes del mismo.

#### El programa deberá realizar las siguientes acciones:

#### El usuario deberá ingresar la ruta completa del fichero que desea analizar.
#### El programa deberá abrir el fichero y leer los primeros bytes para identificar el tipo de archivo.
#### Utiliza los números mágicos para determinar el tipo correcto.
#### El programa debe tener soporte para los siguientes tipos: PDF, ZIP, 7Z, RAR y PNG.
#### Muestra por pantalla el tipo de archivo detectado, o indica si no se pudo determinar el tipo.
#### Implementa manejo de excepciones para manejar posibles errores, como la falta de acceso al fichero o la lectura de bytes insuficientes.
````java
package ejercicio118;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DeterminarTipoFichero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Ingrese la ruta completa del archivo");
            String ruta = sc.nextLine();

            FileInputStream fis = new FileInputStream(ruta);
            byte[] bytes = new byte[8];
            int bytesLeidos = fis.read(bytes);
            fis.close();

            if (bytesLeidos < 8) {
                System.out.println("Bytes insuficientes");
            } else {
                String tipo = tipoArchivo(bytes);
                if (tipo != null) {
                    System.out.println("El archivo es un "+tipo);
                } else {
                    System.out.println("No se pudo detectar el archivo");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String tipoArchivo(byte[] bytes) {
        if (bytes[0] == 0x25 && bytes[1] == 0x50 && bytes[2] == 0x44 && bytes[3] == 0x46) {
            return "PDF";
        } else if (bytes[0] == 0x50 && bytes[1] == 0x4B && bytes[2] == 0x03 && bytes[3] == 0x04) {
            return "ZIP";
        } else if (bytes[0] == 0x37 && bytes[1] == 0x7A && bytes[2] == 0xBC && bytes[3] == 0xAF) {
            return "7Z";
        } else if (bytes[0] == 0x52 && bytes[1] == 0x61 && bytes[2] == 0x72 && bytes[3] == 0x21) {
            return "RAR";
        } else if (bytes[0] == 0x89 && bytes[1] == 0x50 && bytes[2] == 0x4E && bytes[3] == 0x47) {
            return "PNG";
        } else {
            return null;
        }
    }
}


````

### Ejercicio 119

#### Escribe un programa en Java que pida al usuario un directorio y que comprima todo su contenido en un archivo ZIP.

#### Los pasos a realizar son los siguientes:

#### Crea una clase llamada DirectorioAZip que contenga todo el código necesario para llevar a cabo la operación.
#### Verifica si el directorio ingresado por el usuario existe y es un directorio válido. Si no es válido, muestra un mensaje de error y solicita al usuario que ingrese una nueva ruta.
#### Si el directorio es válido, crea un archivo ZIP con el mismo nombre del directorio en el mismo directorio padre. Por ejemplo, si el directorio ingresado es mi_directorio, el archivo ZIP se llamará mi_directorio.zip y se ubicará en el mismo directorio padre.
#### Recorre recursivamente el contenido del directorio y agrega todos los archivos y subdirectorios al archivo ZIP. Asegúrate de mantener la estructura de directorios en el archivo ZIP. Utiliza la biblioteca estándar de Java (java.util.zip).
#### Muestra un mensaje de éxito cuando la compresión se haya completado satisfactoriamente.

````java
package ejercicio119;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DirectorioAZip {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese la ruta del directorio a comprimir:");
            String directorioPath = reader.readLine();


            File directorio = new File(directorioPath);
            if (!directorio.exists() || !directorio.isDirectory()) {
                System.err.println("El directorio ingresado no es válido.");
                return;
            }


            String nombreArchivoZip = directorio.getName() + ".zip";


            File archivoZip = new File(directorio.getParent(), nombreArchivoZip);


            FileOutputStream fos = new FileOutputStream(archivoZip);
            ZipOutputStream zipOut = new ZipOutputStream(fos);


            comprimirAZip(directorio, directorio.getName(), zipOut);


            zipOut.close();
            fos.close();

            System.out.println("Compresión completada con éxito. El archivo ZIP se ha creado en: " + archivoZip.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void comprimirAZip(File ruta, String nombreDirectorio, ZipOutputStream zipOut) throws IOException {
        File[] archivos = ruta.listFiles();
        for (File archivo : archivos) {
            if (archivo.isDirectory()) {

                comprimirAZip(archivo, nombreDirectorio + "/" + archivo.getName(), zipOut);
            } else {

                FileInputStream fis = new FileInputStream(archivo);
                ZipEntry zipEntry = new ZipEntry(nombreDirectorio + "/" + archivo.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zipOut.write(buffer, 0, length);
                }

                fis.close();
            }

        }
    }
}

````

### Ejercicio 120

#### Escribe un programa que convierta en contenido de un archivo XML a formato JSON.
````java
package ejercicio120;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class XmlAJson {
    public static void main(String[] args) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("bookstore.xml"));
            StringBuilder cadena = new StringBuilder();
            String line = null;

            while ((line = lector.readLine()) != null) {
                cadena.append(line);

            }
            lector.close();

            String xmlEntrada = cadena.toString();

            JSONObject json = XML.toJSONObject(xmlEntrada);
            String jsonString = json.toString(4);
            System.out.println(jsonString);

            String nombreArchivo = "newJson.json";

            // Crea un FileWriter para escribir en el archivo
            FileWriter fileWriter = new FileWriter(nombreArchivo);

            // Puedes utilizar BufferedWriter para mejorar la eficiencia
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribe el contenido de la cadena en el archivo
            bufferedWriter.write(jsonString);

            // Cierra el BufferedWriter para asegurarte de que los datos se escriban en el archivo
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


}

````

### Proxecto
#### FHandler

````java
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class FileHandler {
    //private static final String FILE_NAME = "usuarios.bin";
    private static final byte[] HEADER = { (byte) 0xFF, (byte) 0xEE, (byte) 0x20, (byte) 0x23, (byte) 0xEE, (byte) 0xFF };

    private File file;

    public FileHandler(String filename) throws IOException {
        //Users users;
        file = new File(filename);
    }

    public Users load() throws IOException {
        if (!file.exists()) {
            createFile();
        } else if (checkHeader()){
            return charge();
        }
        return null;
    }

    private boolean checkHeader() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){

            byte[] readBytes = bis.readNBytes(HEADER.length);
            int result = Arrays.compare(HEADER, readBytes);

            if (result==0) {
                return true;
            } else {
                return false;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Users charge() {
        try (FileInputStream fis = new FileInputStream(file)){

            fis.readNBytes(HEADER.length);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Users users = (Users) ois.readObject();
            System.out.println(users);
            return users;

        } catch (IOException | ClassNotFoundException e) {
            return null;
        }

    }

    public void createFile() throws IOException {
        file.createNewFile();
        Users userList = new Users();
        User adminUser = new User("admin", "admin", "0", "admin@admin.local");
        userList.addUser(adminUser);
        saveUsers(userList);
    }

    public void saveUsers(Users users) {
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            fos = new FileOutputStream(file);
            fos.write(HEADER);
            oos = new ObjectOutputStream(new FileOutputStream(file, true));
            oos.writeObject(users);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



````