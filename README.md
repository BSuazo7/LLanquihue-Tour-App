# LLanquihue-Tour-App
Sistema de gestión desarrollado en Java para la agencia de turismo **Llanquihue Tour** (Región de Los Lagos). Permite registrar y consultar de forma automatizada a las personas vinculadas a la operación de la agencia: **guías turísticos, operadores locales y proveedores de servicios
El archivo contiene 8 registros válidos (3 guías, 2 operadores y 3 proveedores)
distribuidos en distintas localidades de la Región de Los Lagos.

## Cómo ejecutar el programa

1. Abrir el proyecto en **IntelliJ IDEA**.
2. Verificar que la carpeta `src` esté marcada como *Sources Root*.
3. Ejecutar la clase principal: `app.Main`.
4. La consola mostrará:
   - El resultado de la carga de datos desde `data/personas.csv`.
   - El listado completo de los empleados cargados.
   - Una búsqueda de ejemplo por RUT.
   - Filtros de ejemplo por cargo (guías, proveedores) y por ciudad.

> **Nota:** si se ejecuta desde la línea de comandos, compilar con
> `javac -encoding UTF-8 -d out $(find src -name "*.java")` y ejecutar con
> `java -cp out app.Main` desde la raíz del proyecto, para que las tildes se
> muestren correctamente.

## Autor

Benjamín Suazo — Proyecto desarrollado para la asignatura Desarrollo Orientado a Objetos I, Duoc UC.
