package ExamenFinal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ModeloExamen.App;

public class Main {
    static ArrayList<Libro> libros = new ArrayList<Libro>();
    public static void main(String[] args) {
        Libro libro = new Libro(1, "Guia del autoestopista galactico", "Ciencia ficcion/Humor", "21/10/2023", "ENTREGADO");
        Libro libro2 = new Libro(2, "Percy Jackson", "Fantasia/Juvenil", "13/09/2023", "ENTREGADO");
        Libro libro3 = new Libro(3, "El principe", "No ficcion", "03/08/1990", "PASO FECHA DE ENTREGA");
        libros.add(libro);
        libros.add(libro2);
        libros.add(libro3);
        Thread notDaemonHilo = new Thread(new Tarea(libros));
        Thread daemonHilo = new Thread(new TareaDaemon());
        notDaemonHilo.setPriority(Thread.MAX_PRIORITY);
        daemonHilo.setDaemon(true);
        notDaemonHilo.start();
        daemonHilo.start();
        
    }
}
class Tarea implements Runnable{
        private ArrayList<Libro> libros;

        public Tarea(ArrayList<Libro> libros){
            this.libros=libros;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
         try {
            System.out.println("Ejecutandose el hilo normal");
            String directorio = System.getProperty("user.dir");
            String ruta_NombreArchivo = directorio+"\\archivoLibros.txt";
            String texto ="";
            for(Libro libro: libros){
                texto += "\n*********************************";
                texto+="\nId Cliente: "+libro.getIdCliente();
                texto+="\nNombre del libro: "+ libro.getNombre();
                texto+="\nFecha de publicacion: "+ libro.getFecha_publicacion();
                texto+="\nEstado de solicitud: "+ libro.getEstado_solicitud();
                texto+="\nDias desde el pedido: "+ libro.diferenciaDevolucion();
                texto+="\nSegmentacion: "+ libro.estadoSolicitud();
            }
            File archivo = new File(ruta_NombreArchivo);
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
            System.out.println("Hilo normal: Subiendo informacion...");
            System.out.println("Hilo normal: Archivo escrito y creado con exito");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
}
class TareaDaemon implements Runnable{
        @Override
        public void run() {
            // TODO Auto-generated method stub
            for(int i=0;i<5;i++){
                System.out.println("Daemon ejecutandose");
            }
        }
}