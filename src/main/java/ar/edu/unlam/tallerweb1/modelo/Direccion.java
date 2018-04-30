package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Direccion")
public class Direccion {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="calle")
	private String calle;
	
	@Column(name="numero")
	private String numero;

	// RELACIONES
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="barrio_id")
	private Barrio barrio;
	

	@OneToOne(mappedBy="direccion")
	private Farmacia farmacia;


	
	
	
	public Direccion() {
	}
	
	public Direccion(String calle, String numero) {
		this.calle = calle;
		this.numero = numero;
	}
	
	public Direccion(String calle, String numero, Barrio barrio) {
		this.calle = calle;
		this.numero = numero;
		this.barrio = barrio;
	}


	public Direccion(String calle, String numero, Barrio barrio, Farmacia farmacia) {
		this.calle = calle;
		this.numero = numero;
		this.barrio = barrio;
		this.farmacia = farmacia;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Barrio getBarrio() {
		return barrio;
	}


	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}


	public Farmacia getFarmacia() {
		return farmacia;
	}


	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}
	
	
	
	
	
}
