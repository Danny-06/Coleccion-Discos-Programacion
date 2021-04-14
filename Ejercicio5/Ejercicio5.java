import java.util.ArrayList;
//import java.util.Collections;


public class Ejercicio5 {
  public static void main(String[] args) {

    Do.clear();

    // ArrayList que contendrá los discos
    var listaDiscos = new ArrayList<Disco>();

    var disco1 = new Disco("1","Iron Man", "Noche de pasión", "Drama", 180);

    var disco2 = new Disco("2", "Google", "Una empresa sin beneficios", "Terror", 67);

    var disco3 = new Disco("3", "Heidi", "El Molino", "Comedia", 180);

    var disco4 = new Disco("4", "Morgan Freeman", "El Desierto Blanco", "Comedia Romántica", 115);

    // Añadir discos a la lista
    listaDiscos.add(disco1);
    listaDiscos.add(disco2);
    listaDiscos.add(disco3);
    listaDiscos.add(disco4);

    //Do.println(listaDiscos);

    // Menu principal
    String[] opcionesInicio = {
			 "1. Listado completo"
			,"2. Nuevo Disco"
			,"3. Borrado"
			,"4. Edición"
      ,"5. Salir"
			,"\nElige una opción (1-5): "
		};

		String menuInicio = Do.color( true, "green", "", menu("Menu", opcionesInicio) );

    int opcionMenu = 0;

    while(opcionMenu != 5) {

    Do.clear();

    Do.println(menuInicio);

    opcionMenu = Do.inputInt();
    Do.println();


    switch(opcionMenu) {
      case 1:
        mostrarListaDiscos(listaDiscos);
        break;

      case 2:
        crearYAnadirDisco(listaDiscos);
        break;

      case 3:
        borrarDisco(listaDiscos);
        break;
      
      case 4:
        editarDisco(listaDiscos);
        break;

      case 5:
        Do.clear();
        Do.println( Do.color(true, "y", "b", "Ha salido del programa con éxito") );
        break;
    }

    Do.println();

  }

  } // main()










  /***************************** FUNCIONES *************************/

  // 1. Mostar listado de discos
  public static void mostrarListaDiscos(ArrayList<Disco> listaDiscos) {
    Do.clear();
    Do.println( Do.color(true, "g", "b", "LISTADO COMPLETO DE LOS DISCOS") );

    for(var disco : listaDiscos) {
      Do.println(disco);
    }
    
    Do.print( Do.color(true, "bl", "b", "Introduzca cualquier texto para continuar\n> ") );
    var continuarPrograma = Do.inputString();
  }


  // 2. Crear y Añadir disco
  public static void crearYAnadirDisco(ArrayList<Disco> listaDiscos) {
    var nuevoDisco = new Disco();

    Do.clear();

    Do.println( Do.color(true, "g", "u", "CREANDO NUEVO DISCO\n") );

    // Código del disco
    Do.print( Do.color(true, "bl", "", "Escriba el código del nuevo disco\n> ") );
    var idDisco = Do.inputString();
    nuevoDisco.setCodigo(idDisco);
    Do.println();


    // Si el Código del nuevo Disco coincide con alguno existente, mostrar un error y salir al menu principal
    if( listaDiscos.contains( new Disco(idDisco) ) ) {
      Do.println( Do.color(true, "g", "b", "Ese identificador de Disco ya existe") );

      Do.print( Do.color(true, "bl", "b", "Introduzca cualquier texto para continuar\n> ") );
      var continuarPrograma = Do.inputString();
      return;
    }

    // Nombre del Autor
    Do.print( Do.color(true, "bl", "", "Escriba el nombre del autor de su nuevo disco\n> ") );
    nuevoDisco.setAutor( Do.inputString() );
    Do.println();

    // Titulo
    Do.print( Do.color(true, "bl", "", "Escriba el titulo de su nuevo disco\n> ") );
    nuevoDisco.setTitulo( Do.inputString() );
    Do.println();

    // Género
    Do.print( Do.color(true, "bl", "", "Escriba el género de su nuevo disco\n> ") );
    nuevoDisco.setGenero( Do.inputString() );
    Do.println();

    // Duración
    Do.print( Do.color(true, "bl", "", "Escriba duración de su nuevo disco\n> ") );
    nuevoDisco.setDuracion( Do.inputInt() );
    Do.println();

    listaDiscos.add(nuevoDisco);

    Do.println( Do.color(true, "g", "b", "Disco añadido correctamente") );

    Do.print( Do.color(true, "bl", "b", "Introduzca cualquier texto para continuar\n> ") );
    var continuarPrograma = Do.inputString();

  }

  // 3. Borrar disco
  public static void borrarDisco(ArrayList<Disco> listaDiscos) {
    Do.clear();

    // Obtener la ID del Disco por parte del usuario
    Do.print( Do.color(true, "bl", "b", "Seleccione la ID del disco que va a borrar\n> ") );
    var idDisco = Do.inputString();
    Do.println();


    if( !listaDiscos.contains( new Disco(idDisco) ) ) {
      Do.println( Do.color(true, "g", "b", "Ese identificador de Disco no existe") );

      Do.print( Do.color(true, "bl", "b", "Introduzca cualquier texto para continuar\n> ") );
      var continuarPrograma = Do.inputString();
      return;
    } else {
      listaDiscos.remove(new Disco(idDisco,"","","",0));

      Do.println( Do.color(true, "g", "b", "Disco borrado correctamente") );

      Do.print( Do.color(true, "bl", "b", "Introduzca cualquier texto para continuar\n> ") );
      var continuarPrograma = Do.inputString();
      return;
    }

  }


  // 4. Editar disco
  public static void editarDisco(ArrayList<Disco> listaDiscos) {
    Do.clear();

    Do.println( Do.color(true, "g", "u", "MODIFICANDO DISCO\n") );


    // Obtener la ID del Disco por parte del usuario
    Do.print( Do.color(true, "bl", "b", "Seleccione la ID del disco que va a modificar\n> ") );
    var idDisco = Do.inputString();
    var indiceDisco = listaDiscos.indexOf( new Disco(idDisco) );
    Do.println();
    

    // Si el Código introducido no existe, mostrar un error y continuar
    if( !listaDiscos.contains( new Disco(idDisco) ) ) {
      Do.println( Do.color(true, "g", "b", "Ese identificador de Disco no existe") );

      Do.print( Do.color(true, "bl", "b", "Introduzca cualquier texto para continuar\n> ") );
      var continuarPrograma = Do.inputString();
      return;
    }

    // Código del disco
    Do.print( Do.color(true, "bl", "", "Escriba el nuevo código del disco\n> ") );
    var nuevoIndice = Do.inputString();

    // Si el nuevo Código introducido coincide con alguno, mostrar un error y continuar
    if( listaDiscos.contains( new Disco(nuevoIndice) ) && !listaDiscos.contains( new Disco(idDisco) ) ) {
      Do.println( Do.color(true, "g", "b", "Ese identificador de Disco ya existe") );

      Do.print( Do.color(true, "bl", "b", "Introduzca cualquier texto para continuar\n> ") );
      var continuarPrograma = Do.inputString();
      return;
    }

    listaDiscos.get(indiceDisco).setCodigo( nuevoIndice );
    Do.println();


    /* Introducir los nuevos datos del Disco a modificar */

    // Nombre del Autor
    Do.print( Do.color(true, "bl", "", "Escriba el nuevo nombre del autor del disco\n> ") );
    listaDiscos.get(indiceDisco).setAutor( Do.inputString() );
    Do.println();

    // Titulo
    Do.print( Do.color(true, "bl", "", "Escriba el titulo\n> ") );
    listaDiscos.get(indiceDisco).setTitulo( Do.inputString() );
    Do.println();

    // Género
    Do.print( Do.color(true, "bl", "", "Escriba el género\n> ") );
    listaDiscos.get(indiceDisco).setGenero( Do.inputString() );
    Do.println();

    // Duración
    Do.print( Do.color(true, "bl", "", "Escriba duración\n> ") );
    listaDiscos.get(indiceDisco).setDuracion( Do.inputInt() );
    Do.println();

    // Fin de modificación

    Do.println( Do.color(true, "g", "b", "Disco modificado correctamente") );

    Do.print( Do.color(true, "bl", "b", "Introduzca cualquier texto para continuar\n> ") );
    var continuarPrograma = Do.inputString();

    return;
  }



  // Función que toma como argumento un 'titulo' y un 'array de opciones'
	// de tipo String y devuelve el 'menu' que se puede almacenar en una variable
	public static String menu(String titulo, String[] opciones) {

		String menu;

		menu = titulo.toUpperCase() + "\n";

		// Subrayado del titulo
		for(int i = 1; i <= titulo.length(); i++) {
			menu = menu + "=";
		}
		menu = menu + "\n";

		menu = menu + "\n";

		// Dibujar las opciones contenidas en el array
		for(int i = 0; i < opciones.length; i++) {
			menu = menu + opciones[i] +
                    (i != opciones.length - 1 ? "\n" : ""); // La última opción no recibe salto de linea
		}

		return menu;

	}




}