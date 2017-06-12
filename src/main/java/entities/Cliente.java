package main.java.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Cliente extends BaseEntity {

    private String nombre;

    private int numeroIdentificacion;

    private String direccion;
    
    private List<Tarjeta> tarjetas;

    public Cliente() {
    	super();
    	tarjetas= new ArrayList<Tarjeta>();

    }
    public Cliente(String nombre, int numeroId, String direccion)
    {
    	this.nombre= nombre;
    	this.numeroIdentificacion= numeroId;
    	this.direccion= direccion;
    	tarjetas= new ArrayList<Tarjeta>();
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

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void addTarjeta(Tarjeta tarjeta) {
		this.tarjetas.add(tarjeta);
	}
    
}
