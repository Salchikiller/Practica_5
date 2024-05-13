# Guía Paso a Paso - la distancia más corta entre dos vértices

El programa tiene como objetivo obtener la distancia más corta entre dos vértices 


## Pasos para Ejecutar

### 1. Clonar el Repositorio

Abre la terminal en tu computadora:

- En Windows: Busca "Command Prompt" (Símbolo del Sistema) en el menú de inicio y haz clic para abrirlo.
- En macOS: Busca "Terminal" en la carpeta "Utilities" (Utilidades) dentro de la carpeta "Applications" (Aplicaciones) y haz doble clic para abrirlo.
- En Linux: Puedes abrir la terminal usando el atajo de teclado Ctrl + Alt + T.

Luego, clona el repositorio usando el siguiente comando:

```bash
git clone 'https://github.com/Salchikiller/Practica_5'
```



### 2. Navegar al Directorio del Repositorio

Una vez clonado el repositorio, navega al directorio donde se encuentra:

```bash
cd Practica_5
```

### 3. Limpiar Archivos Previamente Compilados

Para asegurarnos de que estamos trabajando con un estado limpio, vamos a eliminar cualquier archivo previamente compilado:

```bash
mvn limpiar
```

### 4. Compilar el Código Fuente

Ahora vamos a compilar el código fuente del programa:

```bash
mvn compilar
```

### 5. Hacer los test 
Después de compilar, vamos a crear el archivo JAR que contiene el programa:

```bash
mvn test 
```

### 6. Ejecutar el Programa

Finalmente, vamos a ejecutar y generar el archivo ejecutable ".jar"

```bash
mvn package
```
