package ExamenFinal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Libro implements OperacionesLibro{
    private int idCliente;
    private String nombre;
    private String genero;
    private Date fecha_publicacion;
    private String estado_solicitud;

    
    public Libro(int idCliente, String nombre, String genero, String fecha_publicacion, String estado_solicitud) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.genero = genero;
        this.estado_solicitud = estado_solicitud;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        try {
            this.fecha_publicacion = formato.parse(fecha_publicacion);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }
    public void setFecha_publicacion(String fecha_publicacion) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        try {
            this.fecha_publicacion = formato.parse(fecha_publicacion);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String getEstado_solicitud() {
        return estado_solicitud;
    }
    public void setEstado_solicitud(String estado_solicitud) {
        this.estado_solicitud = estado_solicitud;
    }
    @Override
    public long diferenciaDevolucion() {
        // TODO Auto-generated method stub
        Date date = new Date();
        long diff = date.getTime() - fecha_publicacion.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        return diffrence;
    }
    @Override
    public String estadoSolicitud() {
        // TODO Auto-generated method stub
        if(this.estado_solicitud.equalsIgnoreCase("ENTREGADO")){
            return "Cliente al dia";
        }
        else if(this.estado_solicitud.equalsIgnoreCase("PASO FECHA DE ENTREGA")){
            return "El Cliente no esta al dia";
        }
        return "Error en el estado de solicitud";
    }

    
}
