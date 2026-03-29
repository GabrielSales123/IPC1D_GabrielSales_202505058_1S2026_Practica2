# Diagrama de flujo - Visualizador de Algoritmos de Ordenamiento

## Menu principal

```mermaid
flowchart TD

A[Inicio] --> B[Crear MenuPrincipal]
B --> C[Inicializar componentes]
C --> D[Inicializar grafica]
D --> E[Configurar opciones]

E --> F{Entrada de datos}

F -->|Manual| G[Leer texto]
F -->|Archivo| H[Cargar archivo]
F -->|Aleatorio| I[Generar numeros]

G --> J[Convertir a arreglo]
H --> J
I --> J

J --> K[Seleccionar algoritmo]
K --> L{Algoritmo}

L -->|Bubble| M[Ejecutar Bubble Sort]
L -->|Quick| N[Ejecutar Quick Sort]
L -->|Shell| O[Ejecutar Shell Sort]

M --> P[Actualizar grafica]
N --> P
O --> P

P --> Q[Actualizar estadisticas]
Q --> R[Mostrar log]

R --> S{Termino}

S -->|No| P
S -->|Si| T[Generar reporte]
T --> U[Guardar historial]
U --> V[Fin]
```

## Main

```mermaid

flowchart TD

A[Inicio] --> B[Crear objetos]
B --> C[Crear BubbleSort]
C --> D[Crear QuickSort]
D --> E[Crear ShellSort]
E --> F[Crear Estadisticas]
F --> G[Crear Reportes]

G --> H[Evento de interfaz grafica]
H --> I[Invocar MenuPrincipal]
I --> J[Mostrar ventana]

J --> K[Aplicacion en ejecucion]
K --> L[Esperar acciones del usuario]

L --> M[Seleccion de opciones]
M --> N[Ejecutar algoritmos]
N --> O[Actualizar visualizacion]
O --> P[Actualizar estadisticas]
P --> Q[Generar reportes]

Q --> L
```
