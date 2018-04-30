/*
1- Montar el entorno java y subir un proyecto en común en github. Enviar el link para mirar los commits en
github, se validará que existan “push” de ambos miembros del equipo.
Se muestra ejemplo de cómo debería verse (no pasar screenshots, con la entrega del TP debe incluir la URL del
proyecto en github)

2- Hacer con junit un test que busque todas las farmacias de turno los días martes.

3- Hacer con junit un test que busque todas las farmacias de una calle.

4- Hacer con junit un test que busque todas las farmacias de un barrio.

5- Usando path variables, hacer un action que reciba una operación y sus dos operandos y que lleve a una vista
que muestra la siguiente frase “El resultado de s umar 3 y 6 da 9 ”. En caso que no pueda realizarse la operación
se debe llevar a otra vista diferente donde se muestra un mensaje descriptivo.
*/


package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class FarmaciaTest extends SpringTest {

	@Test
	@Transactional
	@Rollback
	public void testBuscarFarmaciasTurnoMartes() {


		Farmacia farmacia1 = new Farmacia();
		farmacia1.setNombre("Farmacity");
		farmacia1.setTelefono("4338-5800");
		farmacia1.setDiaDeTurno("Lunes");
		getSession().save(farmacia1);
		
		Farmacia farmacia2 = new Farmacia();
		farmacia2.setNombre("Dr Ahorro");
		farmacia2.setTelefono("4773-4567");
		farmacia2.setDiaDeTurno("Martes");
		getSession().save(farmacia2);
		
		Farmacia farmacia3 = new Farmacia();
		farmacia3.setNombre("Farmacity 2");
		farmacia3.setTelefono("4338-1234");
		farmacia3.setDiaDeTurno("Miercoles");
		getSession().save(farmacia3);
		
		Farmacia farmacia4 = new Farmacia();
		farmacia4.setNombre("Vilela");
		farmacia4.setTelefono("4952-7894");
		farmacia4.setDiaDeTurno("Martes");
		getSession().save(farmacia4);
		
		
		//2- Hacer con junit un test que busque todas las farmacias de turno los días martes.
		@SuppressWarnings("unchecked")
		List<Farmacia> resultado = 	getSession().createCriteria(Farmacia.class)
									.add(Restrictions.eq("diaDeTurno", "Martes"))
									.list();	
		
		assertThat(resultado).hasSize(2);
		
	}
	
	
	
	@Test
	@Transactional
	@Rollback
	public void testBuscarFarmaciasDeUnaCalle() {

		Direccion direccion1 = new Direccion("Riobamba", "1234");
		getSession().save(direccion1);
		
		Direccion direccion2 = new Direccion("Callao", "4567");
		getSession().save(direccion2);
		
		Direccion direccion3 = new Direccion("Callao", "9876");
		getSession().save(direccion3);
		
		Direccion direccion4 = new Direccion("Av de Mayo", "6666");
		getSession().save(direccion3);
		
		
		
		Farmacia farmacia1 = new Farmacia();
		farmacia1.setNombre("Farmacity");
		farmacia1.setTelefono("4338-5800");
		farmacia1.setDiaDeTurno("Lunes");
		farmacia1.setDireccion(direccion1);
		getSession().save(farmacia1);
		
		Farmacia farmacia2 = new Farmacia();
		farmacia2.setNombre("Dr Ahorro");
		farmacia2.setTelefono("4773-4567");
		farmacia2.setDiaDeTurno("Martes");
		farmacia2.setDireccion(direccion2);
		getSession().save(farmacia2);
		
		Farmacia farmacia3 = new Farmacia();
		farmacia3.setNombre("Farmacity 2");
		farmacia3.setTelefono("4338-1234");
		farmacia3.setDiaDeTurno("Miercoles");
		farmacia3.setDireccion(direccion3);
		getSession().save(farmacia3);
		
		Farmacia farmacia4 = new Farmacia();
		farmacia4.setNombre("Vilela");
		farmacia4.setTelefono("4952-7894");
		farmacia4.setDiaDeTurno("Martes");
		farmacia4.setDireccion(direccion4);
		getSession().save(farmacia4);
		
		
		//3- Hacer con junit un test que busque todas las farmacias de una calle.
		@SuppressWarnings("unchecked")
		List<Farmacia> resultado = 	getSession().createCriteria(Farmacia.class)
									.createAlias("direccion", "d")
									.add(Restrictions.eq("d.calle", "Callao"))
									.list();
		
		assertThat(resultado).hasSize(2);
		
		
//		List<?> resultado = getSession().createCriteria(Farmacia.class).createAlias("direccion", "d").add(Restrictions.eq("d.calle", "Riobamba")).list();
//		assertThat(resultado).hasSize(1);
		
		
	}
	
	
	@Test
	@Transactional
	@Rollback
	public void testBuscarFarmaciasDeUnBarrio() {

		Barrio barrioBarracas = new Barrio("Barracas");
		getSession().save(barrioBarracas);
		
		Barrio barrioFlores = new Barrio("Flores");
		getSession().save(barrioFlores);	
		
		Barrio barrioAlmagro = new Barrio("Almagro");
		getSession().save(barrioAlmagro);
		
		Barrio barrioRecoleta = new Barrio("Recoleta");
		getSession().save(barrioRecoleta);
	
		
		Direccion direccion1 = new Direccion("Riobamba", "1234");
		direccion1.setBarrio(barrioFlores);
		getSession().save(direccion1);
		
		Direccion direccion2 = new Direccion("Callao", "4567");
		direccion2.setBarrio(barrioAlmagro);
		getSession().save(direccion2);
		
		Direccion direccion3 = new Direccion("Callao", "9876");
		direccion3.setBarrio(barrioBarracas);
		getSession().save(direccion3);
		
		Direccion direccion4 = new Direccion("Av de Mayo", "6666");
		direccion4.setBarrio(barrioAlmagro);
		getSession().save(direccion4);
		
		
		Farmacia farmacia1 = new Farmacia();
		farmacia1.setNombre("Farmacity");
		farmacia1.setTelefono("4338-5800");
		farmacia1.setDiaDeTurno("Lunes");
		farmacia1.setDireccion(direccion1);
		getSession().save(farmacia1);
		
		Farmacia farmacia2 = new Farmacia();
		farmacia2.setNombre("Dr Ahorro");
		farmacia2.setTelefono("4773-4567");
		farmacia2.setDiaDeTurno("Martes");
		farmacia2.setDireccion(direccion2);
		getSession().save(farmacia2);
		
		Farmacia farmacia3 = new Farmacia();
		farmacia3.setNombre("Farmacity 2");
		farmacia3.setTelefono("4338-1234");
		farmacia3.setDiaDeTurno("Miercoles");
		farmacia3.setDireccion(direccion3);
		getSession().save(farmacia3);
		
		Farmacia farmacia4 = new Farmacia();
		farmacia4.setNombre("Vilela");
		farmacia4.setTelefono("4952-7894");
		farmacia4.setDiaDeTurno("Martes");
		farmacia4.setDireccion(direccion4);
		getSession().save(farmacia4);
		
		
		//4- Hacer con junit un test que busque todas las farmacias de un barrio.
		//@SuppressWarnings("unchecked")
		List<?> resultado = 	getSession().createCriteria(Farmacia.class)
									.createAlias("direccion", "d")
									.createAlias("d.barrio", "b")
									.add(Restrictions.eq("b.nombre", "Almagro"))
									.list();
		
		assertThat(resultado).hasSize(2);
		
		
	}

	
	
	
	
	

} // FIN TEST
