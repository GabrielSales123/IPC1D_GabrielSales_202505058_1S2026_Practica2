# Manual de Usuario - Visualizador de Algoritmos de Ordenamiento

 

### Descripción General

Esta aplicación permite visualizar el funcionamiento de distintos algoritmos de ordenamiento mediante una interfaz gráfica desarrollada en Java Swing. El usuario puede ingresar datos, seleccionar un algoritmo y observar en tiempo real el proceso de ordenamiento junto con estadísticas, gráficos y un registro de operaciones.

---

## Requisitos para usar el sistema

- Tener instalado Java JDK 11 o superior
- Ejecutar la aplicación desde el archivo principal (`Main` o `MenuPrincipal`)
- Contar con interfaz gráfica (JFrame)

---

## Inicio del sistema

Al ejecutar el programa, se mostrará la ventana principal:

**Componentes principales:**

- Panel de control (lado izquierdo)
- Gráfica de visualización (centro)
- Consola de eventos (parte inferior)
- Estadísticas (comparaciones, intercambios, iteraciones)

---

## Ingreso de datos

El sistema permite ingresar los datos de dos formas:

### 1. Entrada manual

1. Escribir los números en el campo de texto separados por comas  
   Ejemplo:
   
   5, 2, 9, 1, 7

2. Presionar el botón **Iniciar** para ejecutar el algoritmo seleccionado

---

### 2. Carga desde archivo

1. Presionar el botón **Cargar**
2. Seleccionar un archivo `.txt`
3. El archivo debe contener números separados por comas o en líneas
4. Los datos se cargarán automáticamente en el campo de entrada

---

### 3. Generación aleatoria

1. Presionar el botón **Aleatorio**
2. El sistema generará automáticamente 10 números aleatorios
3. Los datos aparecerán en el campo de entrada

---

## Selección de algoritmo

El usuario puede elegir uno de los siguientes algoritmos desde el menú desplegable:

- **Bubble Sort**
- **Quick Sort**
- **Shell Sort**

Cada algoritmo muestra su ejecución de forma visual y paso a paso.

---

## Selección del orden

El usuario puede seleccionar el orden:

- **Ascendente** → Ordena de menor a mayor
- **Descendente** → Ordena de mayor a menor

---

## Control de velocidad

El sistema permite controlar la velocidad de ejecución:

| Opción | Tiempo de espera |
| ------ | ---------------- |
| Rápido | 20 ms            |
| Medio  | 100 ms           |
| Lento  | 500 ms           |

Este control afecta la visualización del algoritmo en tiempo real.

---

## Ejecución del algoritmo

Para iniciar el proceso:

1. Ingresar o cargar los datos
2. Seleccionar el algoritmo
3. Elegir el orden
4. Elegir la velocidad
5. Presionar el botón **Iniciar**

---

## Visualización gráfica

- La gráfica muestra el estado del arreglo en tiempo real
- Cada barra representa un elemento
- Los colores indican el estado del elemento:

| Color    | Significado       |
| -------- | ----------------- |
| Azul     | Estado normal     |
| Amarillo | Comparación       |
| Rojo     | Intercambio       |
| Verde    | Elemento ordenado |

---

## Estadísticas en tiempo real

Durante la ejecución se muestran:

- **Comparaciones:** número de comparaciones realizadas
- **Intercambios:** número de cambios de posición
- **Iteraciones:** número de iteraciones o pasos

Estos valores se reinician en cada ejecución.

---

## Consola de operaciones

En la parte inferior se muestra un registro de acciones:

Ejemplos de mensajes:

- Inicio del algoritmo
- Comparaciones realizadas
- Intercambios
- Finalización del proceso con tiempo total

Ejemplo:

Iniciando Bubble Sort (Ascendente)  
Comparando arr[2] con arr[3]  
Ordenamiento completado en 1200 ms

---

## Historial de ejecuciones

1. Presionar el botón **Historial**
2. Se abrirá una ventana con el registro de ejecuciones

El historial incluye:

- Número de ejecución
- Algoritmo utilizado
- Tipo de orden
- Cantidad de elementos
- Estadísticas (comparaciones, intercambios, iteraciones)
- Tiempo de ejecución

---

## Reportes

Cada ejecución genera automáticamente un reporte con:

- Algoritmo utilizado
- Orden seleccionado
- Arreglo original
- Arreglo ordenado
- Estadísticas completas
- Tiempo de ejecución

Los reportes se generan en formato HTML.

---

## Recomendaciones de uso

- Ingresar datos válidos (solo números separados por comas)
- No cerrar la aplicación durante la ejecución
- Evitar ingresar textos o caracteres no numéricos
- Usar pocos elementos (5–30) para mejor visualización

---

## Posibles errores

- **Error al ingresar datos:**  
  Verifique que los números estén correctamente separados por comas
- **Error al cargar archivo:**  
  Asegúrese de seleccionar un archivo válido `.txt`
- **La gráfica no se actualiza:**  
  Puede deberse a ejecución sin hilos activos

---

## Conclusión

Esta aplicación permite comprender visualmente el comportamiento de los algoritmos de ordenamiento, facilitando el aprendizaje mediante interacción, estadísticas y animaciones en tiempo real.
