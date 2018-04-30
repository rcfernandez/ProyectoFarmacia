package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="Punto")
public class Punto {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="latitud")
	private String latitud;
	
	@Column(name="longitud")
	private String longitud;
	
	
	// RELACIONES
	@OneToOne(mappedBy="geoLocalizacion")
	private Farmacia farmacia;


	public Punto() {
	}


	public Punto(String latitud, String longitud, Farmacia farmacia) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.farmacia = farmacia;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLatitud() {
		return latitud;
	}


	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	public String getLongitud() {
		return longitud;
	}


	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}


	public Farmacia getFarmacia() {
		return farmacia;
	}


	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}

	
	
		
		
		
		
}
