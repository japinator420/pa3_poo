# pa3_poo
Tercera evaluación del curso de programación orientada a objetos, temas de las sesiones 8 a 10.
# PA3 - Sistema de Gestión de Calificaciones en Java

## 1. Descripción del proyecto

El presente proyecto corresponde a la tercera evaluación (PA3) del curso de Programación Orientada a Objetos de ISIL.

Se desarrolló una aplicación de consola utilizando Java, cuyo propósito es gestionar estudiantes y sus calificaciones de manera organizada.

El sistema permite registrar notas, consultar información académica, calcular promedios, modificar calificaciones y generar reportes estadísticos.

Además, se utilizaron colecciones de Java para almacenar y administrar la información de los estudiantes.

## 2. Objetivo

Desarrollar una aplicación en Java que permita aplicar los conocimientos adquiridos durante las sesiones 8, 9 y 10 del curso de Programación Orientada a Objetos.

**Objetivos específicos:**

- Aplicar los principios de programación orientada a objetos.
- Utilizar clases, atributos, constructores y métodos.
- Implementar colecciones como ArrayList y TreeSet.
- Registrar y administrar calificaciones.
- Calcular promedios académicos.
- Identificar estudiantes aprobados y desaprobados.
- Generar reportes estadísticos.
- Fomentar el trabajo colaborativo mediante Git y GitHub.

## 3. Tecnologías utilizadas

- Java: lenguaje de programación principal.
- IntelliJ IDEA: entorno de desarrollo.
- Apache Maven: gestión y construcción del proyecto.
- Git: control de versiones.
- GitHub: repositorio y trabajo colaborativo.
- Programación orientada a objetos.
- Colecciones de Java: ArrayList, SortedSet y TreeSet.

## 4. Funcionamiento del sistema

### Entrada de datos

El programa permite ingresar información desde la consola utilizando la clase Scanner.

El usuario puede seleccionar las opciones del menú e ingresar los datos solicitados.

### Procesamiento

El sistema procesa la información mediante las clases Main, Alumno y Calificacion.

Se realizan operaciones como:

- Búsqueda de estudiantes.
- Registro de notas.
- Cálculo de promedios.
- Ordenamiento de calificaciones.
- Modificación de notas.
- Identificación de aprobados y desaprobados.
- Obtención de notas extremas.
- Generación de estadísticas.

### Salida

El sistema presenta los resultados directamente en la consola de IntelliJ IDEA.

## 5. Aplicación de colecciones de Java

Para administrar la información se utilizaron diferentes estructuras de datos.

### ArrayList

Permite almacenar las calificaciones y administrar los registros de notas.

Ejemplo:

```java
ArrayList<Calificacion> registroNotas = new ArrayList<>();
```

### TreeSet

Permite almacenar los estudiantes de manera ordenada y evitar duplicados según el criterio de comparación definido.

Ejemplo:

```java
SortedSet<Alumno> listaAlumnos = new TreeSet<>();
```

Estas colecciones facilitan la búsqueda, organización y procesamiento de los datos.

## 6. Estructura de clases

### Clase Main.java

Es la clase principal del proyecto.

Sus responsabilidades son:

- Ejecutar el programa.
- Mostrar el menú de opciones.
- Recibir información mediante Scanner.
- Administrar las colecciones.
- Llamar a los métodos correspondientes.

### Clase Alumno.java

Permite administrar la información de los estudiantes.

Contiene:

- Código del estudiante.
- Nombre del estudiante.
- Métodos de consulta y búsqueda.
- Método compareTo() para ordenar estudiantes.
- Método toString() para mostrar información.

### Clase Calificacion.java

Permite gestionar las calificaciones de cada estudiante.

Contiene métodos para:

- Agregar notas.
- Mostrar calificaciones.
- Calcular promedios.
- Obtener una nota específica.
- Ordenar calificaciones.
- Modificar notas.
- Buscar registros académicos.
- Listar aprobados.
- Identificar notas extremas.
- Generar reportes estadísticos.

## 7. Funcionalidades del sistema

El proyecto cuenta con un menú de 10 opciones para gestionar la información académica.

Entre sus funcionalidades se encuentran:

1. Consultar información de estudiantes.
2. Registrar calificaciones.
3. Mostrar notas registradas.
4. Calcular promedios.
5. Consultar una calificación.
6. Ordenar notas.
7. Modificar calificaciones.
8. Listar estudiantes aprobados.
9. Mostrar notas más altas y más bajas.
10. Generar reportes estadísticos.

**Nota:** Los nombres y la numeración exacta de las opciones deben verificarse con el menú implementado en Main.java.

## 8. Validaciones implementadas

El sistema contempla los siguientes criterios:

- Las calificaciones deben encontrarse entre 0 y 20.
- Para los reportes académicos se consideran estudiantes con exactamente tres notas válidas.
- Se considera aprobado al estudiante con promedio mayor o igual a 10.5.
- Se considera desaprobado al estudiante con promedio menor a 10.5.
- Se verifican las colecciones antes de procesar los reportes.
- Se contempla la búsqueda de estudiantes por código.
- Se controla la existencia de registros antes de realizar determinadas operaciones.

Estas validaciones permiten obtener resultados más confiables y evitar errores durante el procesamiento.

## 9. Instrucciones de ejecución

1. Ingresar al repositorio del proyecto en GitHub.
2. Descargar el repositorio o clonarlo utilizando Git.
3. Abrir IntelliJ IDEA.
4. Seleccionar Open y abrir la carpeta del proyecto.
5. Verificar que el JDK esté correctamente configurado.
6. Esperar a que Maven cargue las dependencias necesarias.
7. Abrir la carpeta src/principal/java/org/japinator, según la estructura del repositorio.
8. Ubicar el archivo Main.java.
9. Ejecutar el método main().
10. Utilizar el menú de consola para probar las funcionalidades.

## 10. Integrantes del equipo - Porcentajes de participación

Integrantes del proyecto:

1. Ariana Tiparra Reyes (ArianaTiparra).
2. Amir Álvarez Álvarez (japinator420).
3. Andreu Antonio Rangel (andreurangel1991-art).
4. Diana Cueva Cerna (diapia).
5. Fátima Gallardo Ramírez (FatimaGR).

**Porcentajes de participación:** Pendientes de confirmar para PA3.

## 11. Distribución de responsabilidades

El proyecto se desarrolló de manera colaborativa, utilizando ramas individuales de GitHub.

Cada integrante participó en el desarrollo, revisión o integración de las funcionalidades asignadas.

**Aporte de Andreu Rangel:** Desarrollo de reportes de estudiantes aprobados, identificación de calificaciones máximas y mínimas, implementación de reportes estadísticos, implementación del archivo readmi.

**Aporte de Amir Alvarez:** Creacion del repositorio, estructuracion del proyecto, creacion de clases y sus metodos fundamentales, creacion de la logica del menu persistente.

**Aporte de Ariana Tiparra:** Calcular promedio, recuperar nota y ordenar notas.

**Aporte de Fátima Gallardo:** Creación de métodos para buscar alumnos y sus calificaciones, Agregar la opción de eliminar un alumno registrado al menú y Implementación y corrección de métodos relacionados con calificaciones.

## 12. Pruebas realizadas

Se deben documentar las siguientes pruebas:

- Ejecución correcta del menú principal.
- Búsqueda de estudiantes por código.
- Registro de tres calificaciones.
- Cálculo del promedio académico.
- Ordenamiento de notas.
- Modificación de una calificación.
- Identificación de estudiantes aprobados.
- Identificación de estudiantes desaprobados.
- Obtención de notas máximas y mínimas.
- Generación del reporte estadístico.
- Verificación del comportamiento ante registros incompletos.

### Ejemplo de evaluación

Estudiante: Juan Pérez

Notas: 15, 16 y 14.

Promedio:

(15 + 16 + 14) / 3 = 15.00

Resultado: APROBADO.

## 13. Evidencias del proyecto

Agregar capturas de pantalla de:

- Estructura del proyecto en IntelliJ IDEA.
- Código de la clase Main.java.
- Código de la clase Alumno.java.
- Código de la clase Calificacion.java.
- Menú principal de la aplicación.
- Registro y consulta de notas.
- Cálculo de promedios.
- Reporte de aprobados.
- Reporte de notas extremas.
- Reporte estadístico.
- Historial de commits en GitHub.
- Solicitudes de extracción realizadas por los integrantes.

## 14. Video de exposición

**Enlace de YouTube:**

En el video se explicará:

- Presentación del proyecto.
- Objetivos principales.
- Tecnologías utilizadas.
- Estructura de clases.
- Funcionamiento del menú.
- Demostración de las funcionalidades.
- Validaciones implementadas.
- Reportes estadísticos.
- Participación de los integrantes.

## 15. Trabajo colaborativo con GitHub

Para desarrollar el proyecto se utilizó GitHub como plataforma de control de versiones.

Cada integrante pudo trabajar en su propia rama y posteriormente enviar sus modificaciones al repositorio principal.

El procedimiento de trabajo incluye:

1. Clonar el repositorio.
2. Seleccionar la rama de trabajo.
3. Modificar los archivos correspondientes.
4. Guardar los cambios.
5. Crear un commit descriptivo.
6. Subir los cambios mediante push.
7. Crear una solicitud de extracción (Pull Request).
8. Revisar e integrar los cambios en la rama principal.

Este procedimiento permitió organizar las aportaciones del equipo y mantener un historial del desarrollo.

## 16. Reportes académicos

### Reporte de aprobados

Muestra los estudiantes con tres notas válidas y promedio mayor o igual a 10.5.

Los resultados se ordenan de mayor a menor promedio.

### Reporte de notas extremas

Identifica la nota más alta y la más baja entre los registros válidos.

También permite mostrar a los estudiantes que obtuvieron esas calificaciones, considerando posibles empates.

### Reporte estadístico

Permite analizar los resultados académicos mediante:

- Cantidad de estudiantes aprobados.
- Cantidad de estudiantes desaprobados.
- Promedios de los estudiantes.
- Información estadística calculada a partir de las calificaciones válidas.

## 17. Conclusiones

El desarrollo del proyecto permitió reforzar los conocimientos adquiridos durante el curso de Programación Orientada a Objetos.

Mediante Java y el uso de colecciones, se logró organizar la información académica y desarrollar operaciones relacionadas con el registro, consulta y procesamiento de calificaciones.

La implementación de reportes permitió aplicar métodos de búsqueda, ordenamiento y cálculo de promedios.

Asimismo, el uso de Git y GitHub facilitó el trabajo colaborativo, permitiendo que los integrantes compartieran sus avances y mantuvieran un control de los cambios realizados.

Finalmente, el proyecto permitió comprender la importancia de desarrollar aplicaciones organizadas, reutilizables y fáciles de mantener.
