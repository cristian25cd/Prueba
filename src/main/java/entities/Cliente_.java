package main.java.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-12T11:16:49.626-0500")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends BaseEntity_ {
	public static volatile SingularAttribute<Cliente, String> nombre;
	public static volatile SingularAttribute<Cliente, Integer> numeroIdentificacion;
	public static volatile SingularAttribute<Cliente, String> direccion;
	public static volatile ListAttribute<Cliente, Tarjeta> tarjetas;
}
