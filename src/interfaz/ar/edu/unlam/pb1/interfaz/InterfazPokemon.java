package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.Carta;
import ar.edu.unlam.pb1.dominio.Coleccion;
import ar.edu.unlam.pb1.dominio.Menu;
import ar.edu.unlam.pb1.dominio.Pokedex;
import ar.edu.unlam.pb1.dominio.Sobre;

// Album 							 5%	=>	Coleccion / Pokedex							LISTO
// inicializarCodigosDeFiguritas 	 5%	=>	Pokedex.inicializarListaPokemon()			LISTO
// actualizarDatosFigurita 			 5%	=>	Pokedex.actualizarDatosDelPokemon()			LISTO
// getFigurita 						 5%	=>	Carta.getCarta()							LISTO
// comprarSobre 					20%	=>	Sobre.comprarSobre()						LISTO
// agregarFigurita 					 5% =>	Coleccion.agregarCarta()					LISTO
// ordenarFiguritasActuales 		 5%	=>	Coleccion.ordenarColeccion()				LISTO
// elAlbumEstaCompleto 				20%	=>	Coleccion.laColeccionEstaCompleta()			LISTO			
// calcularPorcentajeCompletado 	20%	=>	Coleccion.calcularPorcentajeCompletado()	LISTO
// comprarSobre 					 5%	=>	Interfaz.comprarSobre()						LISTO
// visualizarFiguritasActuales		 5% =>	Interfaz.visualizarCartasActuales()			LISTO

public class InterfazPokemon {
	public static void main(String[] args) {
		Pokedex.inicializarListaPokemon();

		Coleccion miColeccion = new Coleccion();
		Scanner teclado = new Scanner(System.in);
		
		int opcionIngresada;
		Menu opciones[] = Menu.values();
		Menu opcionSeleccionada = null;
		
		do {
			do {
			mostrarTituloMenu("Bienvenido al Sistema Pokémon");
			mostrarMenu(opciones);
			System.out.print("Ingrese la opción elegida: ");
			opcionIngresada = teclado.nextInt();
			teclado.nextLine();
			if (opcionIngresada < 1 || opcionIngresada > opciones.length) {
		        System.out.println("La opción no es válida. Inténtelo nuevamente.");
		    }

			} while (opcionIngresada < 1 || opcionIngresada > opciones.length);

			opcionSeleccionada = opciones[opcionIngresada - 1];
			
			
			switch (opcionSeleccionada) {
				case ACTUALIZAR_DATOS_CARTA:
					actualizarDatosDeCarta(miColeccion, teclado, opcionSeleccionada);
					break;
				case COMPRAR_SOBRE:
					comprarSobre(miColeccion, teclado, opcionSeleccionada);
					break;
				case VISUALIZAR_CARTAS_ACTUALES:
					visualizarCartasActuales(miColeccion, teclado, opcionSeleccionada);
					break;
				case CALCULAR_PORCENTAJE_DE_COMPLETADO:
					calcularPorcentajeCompletado(miColeccion, teclado, opcionSeleccionada);
					break;
				case INTERCAMBIAR_CARTA:
					intercambiarCarta(miColeccion, teclado, opcionSeleccionada);
					break;
				case SALIR :
						System.out.println("Saliendo del menu...");
						System.out.println("Esperamos verlo pronto.\nHasta luego!");
					break;
			}
		} while( opcionSeleccionada != Menu.SALIR );

		teclado.close();
	}
	
	private static void actualizarDatosDeCarta(Coleccion miColeccion, Scanner teclado, Menu opcionSeleccionada) {
        mostrarTituloMenu(opcionSeleccionada.toString());
        
		String nombre;
		boolean encontrado = false;
		 
	    do {
	        System.out.print("Ingrese el nombre del Pokémon a actualizar: ");
	        nombre = teclado.nextLine();

	        for (int i = 0; i < Pokedex.getListapokemon().length; i++) {
	            if (Pokedex.getListapokemon()[i] != null &&
	                Pokedex.getListapokemon()[i].getNombre().equalsIgnoreCase(nombre)) {
	                encontrado = true;
	                break;
	            }
	        }

	        if (!encontrado) {
	            System.out.println("Ese Pokémon no existe. Intente nuevamente.");
	        }

	    } while (!encontrado);
	    
	    int nuevoPoder = -1;
	    boolean poderValido = false;

	    while (!poderValido) {
	        System.out.print("Ingrese el nuevo poder (entero positivo): ");
	        nuevoPoder = teclado.nextInt();
			teclado.nextLine();
	        if (nuevoPoder<1||nuevoPoder>10) {
	            System.out.println("El poder debe estar entre 1 y 10."); }
	        else {
	    		Pokedex.actualizarDatosDelPokemon(nombre, nuevoPoder);
	            System.out.println("Cambio realizado correctamente.");
	            poderValido=true;
	        }
	    }

		enterParaContinuar(teclado);
	}

	private static void comprarSobre(Coleccion miColeccion, Scanner teclado, Menu opcionSeleccionada) {
        mostrarTituloMenu(opcionSeleccionada.toString());
        System.out.println();
        Carta[] cartasObtenidas =Sobre.comprarSobre();
        System.out.println("Cartas obtenidas en el sobre:");
        System.out.println();

        for (int i = 0; i < cartasObtenidas.length; i++) {
            System.out.println("Carta N°" + (i + 1) + ":");
            System.out.println(cartasObtenidas[i].toString());

            if (miColeccion.esRepetida(cartasObtenidas[i])) {
                System.out.println("[Repetida]");
            } else {
                System.out.println("[¡Nueva!]");
            }
            System.out.println();

            miColeccion.agregarCarta(cartasObtenidas[i]);
        }
		enterParaContinuar(teclado);
	}

    private static void visualizarCartasActuales(Coleccion miColeccion, Scanner teclado, Menu opcionSeleccionada){
        mostrarTituloMenu(opcionSeleccionada.toString());
        System.out.println();
        miColeccion.ordenarColeccion();
		System.out.println(miColeccion.visualizarDatosDeColeccion());
		System.out.println(miColeccion);
		enterParaContinuar(teclado);
    }

	private static void calcularPorcentajeCompletado(Coleccion miColeccion, Scanner teclado, Menu opcionSeleccionada){
        mostrarTituloMenu(opcionSeleccionada.toString());
        System.out.println();
		System.out.println("Completaste el "+miColeccion.calcularPorcentajeCompletado()+"% de tu colección.\nFelicitaciones! Sigue así.");
		enterParaContinuar(teclado);
	}

	private static void intercambiarCarta(Coleccion miColeccion, Scanner teclado, Menu opcionSeleccionada){
		mostrarTituloMenu(opcionSeleccionada.toString());
        System.out.println();
		Carta[] cartasRepetidas = miColeccion.coleccionDeRepetidas();

		int cantidadRepetidas = 0;

		for (int i = 0; i < cartasRepetidas.length; i++) {
		    if (cartasRepetidas[i] != null) {
		        System.out.println("Carta repetida N°" + (i + 1) + ":");
		        System.out.println(cartasRepetidas[i].toString());
		        cantidadRepetidas++;
		    } else {
		        break; // Detenemos cuando ya no hay más cartas
		    }
		}

		if (cantidadRepetidas == 0) {
		    System.out.println("No tenés cartas repetidas para intercambiar.");
		    enterParaContinuar(teclado);
		    return;
		}

		int eleccionCartaRepetida = -1;
	    do {
	        System.out.print("Ingrese el número de la carta repetida que desea intercambiar: ");
	        eleccionCartaRepetida = teclado.nextInt();
	        teclado.nextLine();

	        if (eleccionCartaRepetida < 1 || eleccionCartaRepetida > cantidadRepetidas) {
	            System.out.println("Número inválido. Intente nuevamente.");
	        }
	    } while (eleccionCartaRepetida < 1 || eleccionCartaRepetida > cantidadRepetidas);

		miColeccion.eliminarCartaRepetida(eleccionCartaRepetida - 1);

		Carta[] sobreIntercambio = Sobre.obtenerSobreDe3();

		for(int i = 0 ; i < sobreIntercambio.length ; i++ ){
			System.out.println("Carta N°" + (i+1) +":");
			System.out.println(sobreIntercambio[i]);
			if(miColeccion.esRepetida(sobreIntercambio[i])){
				System.out.println('\t' + "[Repetida]");
			} else {
				System.out.println('\t' + "[¡Nueva!]");
			}
		}
		
		int eleccionCartaParaObtener = -1;
	    do {
	        System.out.print("Ingrese el número de la carta que desea obtener: ");
	        eleccionCartaParaObtener = teclado.nextInt();
	        teclado.nextLine();

	        if (eleccionCartaParaObtener < 1 || eleccionCartaParaObtener > sobreIntercambio.length) {
	            System.out.println("Número inválido. Intente nuevamente.");
	        }
	    } while (eleccionCartaParaObtener < 1 || eleccionCartaParaObtener > sobreIntercambio.length);


		miColeccion.agregarCarta(sobreIntercambio[eleccionCartaParaObtener-1]);

		System.out.println("[Carta agregada exitosamente]");
		enterParaContinuar(teclado);
	}

	private static void mostrarMenu(Menu[] opciones) {
		System.out.println("Menu de opciones: ");
		for (int i = 0; i < opciones.length; i++) {
			System.out.println(opciones[i]);
		}
	}

	private static void mostrarTituloMenu(String titulo){
        System.out.println("╔"+ "═".repeat(titulo.toString().length() + 2) + "╗");
        System.out.println("║ "+ titulo + " ║");
        System.out.println("╚" + "═".repeat(titulo.toString().length() + 2) + "╝");
    }

	private static void enterParaContinuar(Scanner teclado) {
		System.out.println("[Ingrese ENTER para continuar]");
		teclado.nextLine();
	}
}
