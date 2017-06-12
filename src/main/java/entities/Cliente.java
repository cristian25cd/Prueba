package main.java.entities;

import javax.persistence.Entity;

@Entity
public class Cliente extends BaseEntity {

    private String nombre;

    private int numeroIdentificacion;

    private String direccion;

    public Cliente() {
    	super();
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }

    public int getIdentificacion(){
        return numeroIdentificacion;
    }

    public void setIdentificacion(int identificacion) {
        numeroIdentificacion=identificacion;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion=direccion;
    }
    
}
