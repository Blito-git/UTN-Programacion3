# Simpsons API Project

## 1.2 npm init -y

`npm init -y` crea el archivo `package.json` en la raíz del proyecto, con la
configuración básica por defecto (nombre, versión, punto de entrada, etc.),
sin preguntar nada durante el proceso (la `-y` responde "sí" a todo
automáticamente).

## 1.3 ¿Por qué --save-dev?

Se usa `--save-dev` porque TypeScript es una herramienta que solo se necesita
durante el **desarrollo** (para compilar el código a JavaScript), no en
producción. El navegador nunca ejecuta archivos `.ts`, solo el `.js`
resultante. Por eso se guarda como dependencia de desarrollo
(`devDependencies`) y no como dependencia normal (`dependencies`).

## 1.4 Opciones de tsconfig.json

- **strict**: activa todas las verificaciones estrictas de tipos a la vez
  (incluye, entre otras, `noImplicitAny` y `strictNullChecks`), ayudando a
  detectar errores de tipado en tiempo de compilación.
- **target**: define a qué versión de JavaScript se transpila el código
  (en este caso, ES2020).
- **outDir**: define la carpeta donde se van a guardar los archivos `.js`
  generados al compilar (en este caso, `./dist`).

## 1.5 Scripts de package.json

- **build** (`tsc`): compila una sola vez todos los archivos `.ts` del
  proyecto a JavaScript. Se usa cuando se quiere generar la versión final
  para probar o desplegar.
- **watch** (`tsc --watch`): deja el compilador corriendo en segundo plano,
  recompilando automáticamente cada vez que se guarda un cambio en algún
  archivo `.ts`. Se usa durante el desarrollo, para no tener que compilar
  manualmente después de cada cambio.

## 2. Documentación de la API

**URL Base:** `https://thesimpsonsapi.com/api/characters`
**Método:** GET

**Estructura de la respuesta:**

| Campo | Tipo | Descripción |
|---|---|---|
| count | number | Cantidad total de personajes disponibles |
| next | string \| null | URL de la siguiente página de resultados |
| prev | string \| null | URL de la página anterior de resultados |
| pages | number | Cantidad total de páginas |
| results | array | Lista de personajes de la página actual |

**Estructura de cada personaje (`results[i]`):**

| Campo | Tipo | Descripción |
|---|---|---|
| id | number | Identificador del personaje |
| age | number | Edad del personaje |
| birthdate | string | Fecha de nacimiento |
| gender | string | Género del personaje |
| name | string | Nombre del personaje |
| occupation | string | Ocupación del personaje |
| portrait_path | string | Ruta relativa de la imagen del personaje |
| phrases | string[] | Lista de frases célebres del personaje |
| status | string | Estado del personaje (ej. "Alive") |

**Imagen del personaje:** se arma concatenando
`https://cdn.thesimpsonsapi.com/500` + el valor de `portrait_path`.

## Parte 6: Ejecución

1. Instalar dependencias: `npm install`
2. Compilar TypeScript: `npm run build`
3. (Opcional, durante desarrollo) Compilar en modo watch: `npm run watch`
4. Abrir `index.html` en el navegador (o servirlo con un servidor local).
