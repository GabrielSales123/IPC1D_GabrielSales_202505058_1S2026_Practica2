# Visualizador de Algoritmos de Ordenamiento - Manual Técnico

- **Curso:** Introducción a la Programación y Computación 1
- **Lenguaje:** Java
- **Autor:** Gabriel Sales

---

## 1. Descripción General

El sistema es una aplicación desarrollada en **Java** que permite visualizar el funcionamiento de distintos algoritmos de ordenamiento en tiempo real.  

Se implementan los siguientes algoritmos:

- Bubble Sort
- Shell Sort
- Quick Sort (recursivo obligatorio)

La aplicación incluye:

- Interfaz gráfica con Swing
- Visualización dinámica mediante gráficas
- Estadísticas en tiempo real
- Registro (log) de operaciones
- Generación de reportes

---

## 2. Arquitectura del Sistema

El proyecto sigue una estructura basada en separación de responsabilidades:

com.mycompany.algoritmosdeordenamiento  
│  
├── principal  
│ └── Main.java  
│  
├── vista  
│ ├── MenuPrincipal.java  
│ ├── TablaHistorial.java  
│  
├── algoritmos  
│ ├── BubbleSort.java  
│ ├── ShellSort.java  
│ └── QuickSort.java  
│  
├── modelo  
   ├── Estadisticas.java    
   └── Reportes.java  

---

## 3. Tecnologías Utilizadas

- **Lenguaje:** Java (JDK 11 o superior)
- **Interfaz gráfica:** Swing / AWT
- **Gráficas:** JFreeChart
- **Concurrencia:** Thread / Runnable
- **Control de UI:** SwingUtilities.invokeLater()

---

## 4. Módulos del Sistema

### 4.1 Menú Principal

Permite acceder a:

- Visualizador de algoritmos
- Reportes

Se implementa con `JFrame` y botones de navegación.

---

### 4.2 Panel de Control

Contiene:

#### Ingreso de datos

- Archivo `.txt` (JFileChooser)
- Entrada manual (JTextArea)
- Generación aleatoria

#### Configuración

- Selección de algoritmo (`JComboBox`)
- Tipo de orden:
  - Ascendente
  - Descendente
- Velocidad:
  - Lento (500 ms)
  - Medio (100 ms)
  - Rápido (20 ms)

---

### 4.3 Estadísticas

Se muestran en tiempo real:

- Comparaciones
- Intercambios
- Iteraciones

#### Clase principal:

```java
public class Estadisticas {
    private int comparaciones;
    private int intercambios;
    private int iteraciones;

    public void reiniciar() {
        comparaciones = 0;
        intercambios = 0;
        iteraciones = 0;
    }
```

### 4.4 Visualización

- Representación con gráfica de barras (JFreeChart)
- Actualización en cada paso del algoritmo

#### Estados de los elementos:

| Estado         | Color    |
| -------------- | -------- |
| Normal         | Azul     |
| Comparando     | Amarillo |
| Intercambiando | Rojo     |
| Ordenado       | Verde    |

---

### 4.5 Log de Operaciones

Se muestra en un `JTextArea`:

Ejemplo:

[Paso 1] Comparando arr[0]=5 con arr[1]=3  
[Paso 2] Intercambio realizado

Incluye:

- Tipo de operación
- Índices
- Valores
- Tiempo final

### 4.6 Reportes

Se generan en formato HTML:

Incluyen:

- Algoritmo utilizado
- Orden seleccionado
- Arreglo original y final
- Estadísticas
- Tiempo de ejecución

También se mantiene un historial en memoria (tabla).

---

## 5. Implementación de Algoritmos

### 5.1 Bubble Sort

- Iterativo
- Dos ciclos anidados

```java
for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
        if (datos[j] > datos[j + 1]) {
            // intercambio
        }
    }
}
```

---

### 5.2 Shell Sort

- Iterativo
- Uso de gaps

```java
for (int sal= n / 2; sal> 0; sal/= 2) {  
 for (int i = sal; i < n; i++) {  
 int temp = datos[i];  
 int j;  
 for (j = i; j >= sal&& datos[j - sal] > temp; j -= sal) {  
 datos[j] = datos[j - sal];  
 }  
 datos[j] = temp;  
 }  
}
```

---

### 5.3 Quick Sort (Recursivo)

Método principal:

```java
void quickSort(int[] datos, int prim, int ult) {  
 if (prim< ult) {  
 int piv = partition(datos, prim, ult);  
 quickSort(datos, prim, piv - 1);  
 quickSort(datos, piv + 1, ult);  
 }  
}
```

Partición:

```java
int partition(int[] datos, int prim, int ult) {  
int pivote = datos[high];  
int i = prim- 1;

for (int j = prim; j < ult; j++) {  
    if (datos[j] < pivote) {  
        i++;   
    }  
}  
return i + 1;  
}
```

---

## 6. Manejo de Hilos

Cada algoritmo se ejecuta en un hilo independiente para evitar bloquear la interfaz:

```java
new Thread(() -> {  
 algoritmo.ordenar(datos, orden, velocidad, vista);  
}).start();
```

Se utiliza:

```java
Thread.sleep(velocidad);
```

Para controlar la animación.

---

## 7. Actualización de la Interfaz

Se usa:

```java
SwingUtilities.invokeLater(() -> {  
 // actualizar gráfica o componentes  
});
```

---

## 8. Restricciones Técnicas

- Solo se permite uso de `int[]`
- Prohibido:
  - ArrayList
  - Collections.sort()
  - Arrays.sort()
- QuickSort debe ser recursivo
- Uso obligatorio de hilos

---

## 9. Flujo General del Sistema

1. Usuario ingresa datos
2. Selecciona algoritmo
3. Configura orden y velocidad
4. Ejecuta el algoritmo
5. Se actualiza:
   - Gráfica
   - Estadísticas
   - Log
6. Se genera reporte
7. Se guarda en historial

---

## 10. Consideraciones Técnicas

- Separación de responsabilidades (vista, lógica, modelo)
- Código modular
- Uso de buenas prácticas
- Manejo de excepciones en carga de datos
- Validación de entrada

---

## 11. Librerías Externas

- JFreeChart (para visualización)

Se debe especificar la versión utilizada en el proyecto.

---

## 12. Conclusión

El sistema permite comprender de manera visual y práctica el comportamiento de los algoritmos de ordenamiento, integrando conceptos de:

- Programación orientada a objetos
- Recursividad
- Concurrencia
- Interfaces gráficas
