package com.example.estacionespacial;

import com.example.estacionespacial.enums.TipoNaveEnum;
import com.example.estacionespacial.interfaces.IAterrizaje;
import com.example.estacionespacial.interfaces.INave;
import com.example.estacionespacial.interfaces.IVehiculoLanzadera;
import com.example.estacionespacial.models.CargaModel;
import com.example.estacionespacial.models.EnergiaModel;
import com.example.estacionespacial.models.OrigenModel;
import com.example.estacionespacial.models.TipoNaveModel;
import com.example.estacionespacial.naves.*;
import com.example.estacionespacial.repositories.*;
import com.example.estacionespacial.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
@Transactional
public class EstacionespacialApplication implements CommandLineRunner {


	@Autowired
	NaveService naveService;

	@Autowired
	OrigenService origenService;

	@Autowired
	TipoNaveService tipoNaveService;

	public static void main(String[] args) {
		SpringApplication.run(EstacionespacialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean seguirEnElPrograma = true;
		int opcion = 1;
		int id = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println(">>==ESTACIÓN ESPACIAL SOFKA==<<");
		do{

			System.out.println("Ingrese la opcion que deseas");
			System.out.println("1) Observar todas las naves");
			System.out.println("2) Observar naves de lanzadera");
			System.out.println("3) Observar naves no tripuladas");
			System.out.println("4) Observar naves tripuladas");
			System.out.println("5) Observar nave con id");
			System.out.println("6) Crear nave");
			System.out.println("0) Salir");

			opcion = sc.nextInt();

			switch (opcion){

				case 0 :
					seguirEnElPrograma = false;
					System.out.println("-------------> Haz salido con exito <----------");
					break;

				case 1 :
					TodasLasNaves todasLasNaves = naveService.obtenerTodasLasNaves();
					mostrarTodasLasNaves(todasLasNaves);
					break;

				case 2 :
					List<VehiculoLanzadera> vehiculosLanzadera= naveService.obtenerVehiculosLanzadera();
					pintarVehiculoslanzadera(vehiculosLanzadera);
					break;

				case 3 :
					List<VehiculoNoTripulado> vehiculoNoTripulados = naveService.obtenerVehiculosNoTripulados();
					pintarVehiculoNoTripulado(vehiculoNoTripulados);
					break;

				case 4 :
					List<VehiculoTripulado> vehiculoTripulados = naveService.obtenerVehiculosTripulados();
					pintarVehiculosTripulados(vehiculoTripulados);
					break;

				case 5 :
					System.out.println("Por favor ingrese el id de la nave que quiere inspeccionar: ");
					id = sc.nextInt();
					Nave nave = naveService.obtenerNave(id);
					pintarDetallesNave(nave);
					break;
				case 6:
					crearNave();
					break;

				default:
					System.out.println("La opcion ingresada es incorrecta, si desea ver nuevamente el menú ingresa 1, si desea salir 0");
					break;
			}

		}while (seguirEnElPrograma);

	}

	 void  pintarVehiculoslanzadera(Iterable<VehiculoLanzadera> vehiculosLanzadera) {
		System.out.println(">>==Vehiculos de lanzadera==<<");
		vehiculosLanzadera.forEach(v -> {
			System.out.println( "Id: " + v.getId()
							+ "\nNombre: "+ v.getNombre()
							+ "\nPeso de nave: "+ v.getPesoNave()
							+ "\nPotencia de nave: "+ v.getPotencia()
							+ "\nAltura de nave: "+ v.getAlturaNave()
							+ "\nVelocidad de nave: "+ v.getVelocidad()
							+ "\nActividad de nave: "+ v.getActividad()
							+ "\nCapacidad: "+ v.getCapacidad()
							+ "\nSe encuentra volando: " + (v.getVolando() ? "Si" : "no")
					);
			System.out.println("--------------------------");
		});

	}

	void pintarVehiculoNoTripulado(Iterable<VehiculoNoTripulado> vehiculosNoTripulados){
		System.out.println(">>==Vehiculos No tripulado==<<");
		vehiculosNoTripulados.forEach(v -> {
			System.out.println("Id: " + v.getId()
							+ "\nNombre: "+ v.getNombre()
							+ "\nPeso de nave: "+ v.getPesoNave()
							+ "\nPotencia de nave: "+ v.getPotencia()
							+ "\nAltura de nave: "+ v.getAlturaNave()
							+ "\nVelocidad de nave: "+ v.getVelocidad()
							+ "\nActividad de nave: "+ v.getActividad()
							+ "\nSe encuentra volando: " + (v.getVolando() ? "Si" : "no")
			);
			System.out.println("--------------------------");
		});
	}


	void pintarVehiculosTripulados(Iterable<VehiculoTripulado> vehiculosTripulados){
		System.out.println(">>==Vehiculos tripulado==<<");
		vehiculosTripulados.forEach(v -> {
			System.out.println("Id: " + v.getId()
							+ "\nNombre: "+ v.getNombre()
							+ "\nPeso de nave: "+ v.getPesoNave()
							+ "\nPotencia de nave: "+ v.getPotencia()
							+ "\nAltura de nave: "+ v.getAlturaNave()
							+ "\nVelocidad de nave: "+ v.getVelocidad()
							+ "\nActividad de nave: "+ v.getActividad()
							+ "\nSe encuentra volando: " + (v.getVolando() ? "Si" : "no")
			);
			System.out.println("--------------------------");
		});
	}


	 void mostrarTodasLasNaves(TodasLasNaves todasLasNaves){
		pintarVehiculoslanzadera(todasLasNaves.getVehiculosLanzadera());
		pintarVehiculoNoTripulado(todasLasNaves.getVehiculosNoTripulados());
		pintarVehiculosTripulados(todasLasNaves.getVehiculosTripulados());
	}

	void pintarDetallesNave(Nave nave){
		int opcionNave = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println(">>==Nave "+ nave.getNombre() +" ==<<");

		String cargas = "";
		String energias = "";

		for (CargaModel c:nave.getCargas()) {
			cargas += c.getNombreCarga()+ ",";
		}
		for (EnergiaModel energia: nave.getTiposDeEnergia()) {
			energias += energia.getNombreEnergia() + ",";
		}

		cargas = cargas.substring(0, cargas.length() - 1);
		energias = energias.substring(0, energias.length() - 1);

		System.out.println(
				"\nTipo de nave: "+ nave.getTipoNave().getNombre()
						+ "\nOrigen de nave: "+ nave.getOrigen().getNombrePais()
						+ "\nPeso de nave: "+ nave.getPesoNave()
						+ "\nPotencia de nave: "+ nave.getPotencia()
						+ "\nAltura de nave: "+ nave.getAlturaNave()
						+ "\nVelocidad de nave: "+ nave.getVelocidad()
						+ "\nActividad de nave: "+ nave.getActividad()
						+ "\nSe encuentra volando: " + (nave.getVolando() ? "Si" : "no")
						+ "\nTipo de cargas: "+ cargas
						+ "\nTipo de energia: "+ energias
		);

		System.out.println("--------------------------");
		System.out.println("Ingrese la opcion que desea ejecutar con la nave");
		System.out.println("1) Despegar nave");
		System.out.println("2) Desplazar nave");
		System.out.println("3) Aterrizar nave");
		System.out.println("4) Soltar carga útil");
		System.out.println("0) Regresar al menú anterior");
		opcionNave = sc.nextInt();

		switch (opcionNave){
			case 1 :
				((INave) nave).despegar();
				naveService.guardarNave(nave);
				break;

			case 2 :
				((INave) nave).desplazarse();
				break;

			case 3 :
				if (nave instanceof IAterrizaje){
					((IAterrizaje) nave).aterrizar();
					naveService.guardarNave(nave);
				}else{
					System.out.println("Esta nave no está equipada con la tecnología para soltar carga");
				}

				break;

			case 4 :
				if(nave instanceof IVehiculoLanzadera){
					((IVehiculoLanzadera) nave).soltarCargaUtil();
				}else{
					System.out.println("Esta nave no es un vehículo de lanzadera");
				}
				break;

			default:
				System.out.println("La opcion ingresada es incorrecta");
				break;
		}
	}

	void crearNave() {
		int opcionNave = 0;
		int tipoNaveId = 0;
		int origenId = 0;
		Nave nave = null;
		Scanner sc = new Scanner(System.in);
		Iterable<TipoNaveModel> tiposDeNaves = tipoNaveService.obtenerTiposDeNaves();
		Iterable<OrigenModel> origenes = origenService.obtenerOrigenes();

		System.out.println("Por favor seleccione el tipo de nave");
		tiposDeNaves.forEach(t -> System.out.println(t.getId()  + ") " + t.getNombre()));
		tipoNaveId = sc.nextInt();
		System.out.println("Por favor seleccione el origen de la nave");
		origenes.forEach(t -> System.out.println(t.getId()  + ") " + t.getNombrePais()));
		origenId = sc.nextInt();
		TipoNaveEnum tipoNaveEnum = naveService.obtenerTipoNaveEnum(tipoNaveId);
		switch (tipoNaveEnum) {
			case  VehiculoLanzadera:
				nave = new VehiculoLanzadera();
				System.out.print("Capacidad de carga: ");
				((VehiculoLanzadera)nave).setCapacidad(sc.nextInt());
				break;

			case  VehiculoNoTripulado:
				nave = new VehiculoNoTripulado();
				break;

			case  VehiculoTripulado:
				nave = new VehiculoTripulado();
				break;
		}

		int finalOrigenId = origenId;
		Optional<OrigenModel> origenModel = ((List<OrigenModel>)origenes).stream()
				.filter(origen -> origen.getId() == finalOrigenId)
				.findAny();

		int finalTipoNaveId = tipoNaveId;
		Optional<TipoNaveModel> tipoNaveModel = ((List<TipoNaveModel>)tiposDeNaves).stream()
				.filter(origen -> origen.getId() == finalTipoNaveId)
				.findAny();

		nave.setOrigen(origenModel.get());
		nave.setTipoNave(tipoNaveModel.get());
		nave.setVolando(false);


		System.out.print("Nombre: ");
		nave.setNombre(sc.next());

		System.out.print("Peso: ");
		nave.setPesoNave(sc.nextFloat());

		System.out.print("Potencia: ");
		nave.setPotencia(sc.nextFloat());

		System.out.print("Altura: ");
		nave.setAlturaNave(sc.nextFloat());

		System.out.print("Velocidad: ");
		nave.setVelocidad(sc.nextFloat());

		System.out.print("Actividad: ");
		nave.setActividad(sc.next());

		naveService.guardarNave(nave);
	}
}
