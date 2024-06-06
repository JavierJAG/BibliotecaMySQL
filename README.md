<h1>Esta aplicación gestiona los alquileres de libros de una biblioteca.</h1>
<p>La aplicación permite:</p>
<ul>
  <li>Ver la información de los socios de la biblioteca.</li>
  <li>Ver los libros que hay disponibles (sin alquilar) en un momento dado.</li>
  <li>Ver los libros que están alquilados (queremos saber, también, desde qué fecha están alquilados).</li>
  <li>Ver un histórico de los libros alquilados en el pasado, mostrando quién alquiló cada libro y en qué fechas.</li>
</ul>
<p>Se ha diseñado una base de datos en MySQL que permite realizar estas funciones, y se han insertado datos de ejemplo. Se puede encontrar el script que genera esta base de datos dentro del proyecto, además del JAR necesario para realizar la conexión a MySQL.</p>
<p>La aplicación implementa el patrón MVC (Modelo-Vista-Controlador) y la interfaz gráfica es creada con Java Swing.</p>
<p>Para poder utilizar esta aplicación, deberemos ejecutar el script que genera la base de datos, añadir el JAR incluido en el proyecto, y sustituir en la clase `src/model/Modelo` los siguientes datos para poder realizar la conexión.</p>
<img src="https://github.com/JavierJAG/BibliotecaMySQL/assets/74993072/c2d00319-7fc1-4946-9f93-06c167378af4">
</br>
<h2>Ventanas principales</h2>
<ul>
  <li>
    <p>Ventana Principal</p>
    <img src="https://github.com/JavierJAG/BibliotecaMySQL/assets/74993072/8889d1e1-d407-41fe-9687-7bc146ae0e92">
  </li>
  <li>
    <p>Ventana ver listado de socios</p>
    <img src="https://github.com/JavierJAG/BibliotecaMySQL/assets/74993072/8eed3b64-bb33-4ba9-950d-93a65c7b3e1e">
  </li>
  <li>
    <p>Ventana ver libros disponibles para alquilar</p>
    <img src="https://github.com/JavierJAG/BibliotecaMySQL/assets/74993072/dbcbb941-9550-48e9-8f83-c688dd79ea33">
    <p>Se muestran los libros disponibles en la biblioteca que no han sido alquilados.</p>
  </li>
  <li>
    <p>Ventana ver libros alquilados</p>
    <img src="https://github.com/JavierJAG/BibliotecaMySQL/assets/74993072/1dc811ed-e8af-4bbc-be41-bd5eb466a08b">
  </li>
  <li>
    <p>Ventana alquilar libro</p>
    <img src="https://github.com/JavierJAG/BibliotecaMySQL/assets/74993072/19d6e59d-718b-4908-876d-cb083958b1aa">
    <p>Deberá introducirse el código de un libro disponible para alquilar y el DNI del socio que lo alquila.</p>
  </li>
  <li>
    <p>Ventana devolver libro</p>
    <img src="https://github.com/JavierJAG/BibliotecaMySQL/assets/74993072/bf673938-268d-4fdf-9dd0-8b3fd8566bc3">
    <p>Introduciendo el código de un libro alquilado, este pasa a estar disponible de nuevo.</p>
  </li>
  <li>
    <p>Ventana ver historial de alquileres</p>
    <img src="https://github.com/JavierJAG/BibliotecaMySQL/assets/74993072/26675688-5aff-4ca0-bbaa-9d319b61a436">
  </li>
</ul>
<p>Si el libro no ha sido devuelto aún, la fecha de devolución aparece en blanco.</p>

