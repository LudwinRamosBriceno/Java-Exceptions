package Ejemplos;

import java.io.*;

public class Excepciones {

    BufferedWriter bw = null;
    FileWriter fw = null;

    // Ejemplo finally
    public void finallyException(String mensaje) throws IOException {
        try {
            File file = new File("src/Ejemplos/registro");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                bw.write(mensaje+"\t");

            }else{
                // adjunta información al archivo.
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                bw.write(mensaje+"\t");

                System.out.println("Se escribió!");
            }

        }finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                System.out.println("La Excepción en el finally es: "+ex.getMessage());
            }
        }
    }

    // Ejemplo de catch
    public void CatchException(){
        int valor=100;
        try {
            for(int x=0; x < 100; x ++){
                valor /= x;
            }
        }
        catch(RuntimeException e ) {
            System.out.println( "Se ha producido un error: usted no puede dividir entre cero" );
            System.out.println(e.getMessage());
        }
    }

    // Ejemplo de throws
    public void throwException() throws IOException {
        // se generará una excepción ya que no se ha creado y no existe este archivo
        File arch = new File("R:\\TEC - II 2021\\Algoritmos y estructura de datos I\\data.txt");

        Reader lector = new FileReader(arch);
        BufferedReader leer = new BufferedReader(lector);
        String info = leer.readLine();

        leer.close();
        lector.close();
    }
    public static void main(String[] args) throws IOException {
        Excepciones clase = new Excepciones();
        clase.throwException(); // ejemplo de throws exception
        clase.CatchException(); // ejemplo de try-catch

        clase.finallyException("hola"); // ejemplo de finally
        clase.finallyException("a");
        clase.finallyException("todos");

    }
}
