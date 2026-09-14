// Punto 1: declarativa vs expresada
function cuadrado(numero) {
    return numero * numero;
}

const cubo = function (numero) {
    return numero ** 3;
};

console.log(cuadrado(4));
console.log(cubo(3));

// Diferencia: la declarativa se define con "function" y un nombre propio,
// la expresada se guarda dentro de una variable.


// Punto 2: arrow function con parámetro por defecto
const saludar = (nombre, edad = 18) => `Hola ${nombre}, tienes ${edad} años`;

console.log(saludar("Ana"));
console.log(saludar("Juan", 25));


// Punto 3: objeto con propiedad y método
const persona = {
    nombre: "Ana",
    edad: 30,
    presentarse() {
        return `Hola, soy ${this.nombre} y tengo ${this.edad} años`;
    }
};

console.log(persona.presentarse());

// Diferencia: las propiedades son datos, los métodos son funciones del objeto.


// Punto 4: desestructuración
const { nombre, edad } = persona;
console.log(nombre);
console.log(edad);

// Ventaja: menos código que acceder a persona.nombre y persona.edad por separado.


// Punto 5: spread y rest
const numeros = [1, 2, 3];
const masNumeros = [...numeros, 4, 5]; // spread: desarma el array
console.log(masNumeros);

function sumar(...nums) { // rest: junta los argumentos en un array
    let total = 0;
    for (let i = 0; i < nums.length; i++) {
        total += nums[i];
    }
    return total;
}
console.log(sumar(1, 2, 3, 4));


// Punto 6: manipulación del DOM
const titulo = document.getElementById("titulo");
titulo.textContent = "Título modificado con JavaScript";

const lista = document.getElementById("lista");

const nuevoElemento1 = document.createElement("li");
nuevoElemento1.textContent = "Elemento agregado 1";
lista.appendChild(nuevoElemento1);

const nuevoElemento2 = document.createElement("li");
nuevoElemento2.textContent = "Elemento agregado 2";
lista.appendChild(nuevoElemento2);

titulo.classList.add("resaltado");


// Punto 7: evento click
const inputTexto = document.getElementById("inputTexto");
const botonAgregar = document.getElementById("botonAgregar");

botonAgregar.addEventListener("click", () => {
    if (inputTexto.value.trim() !== "") {
        const item = document.createElement("li");
        item.textContent = inputTexto.value;
        lista.appendChild(item);
        inputTexto.value = "";
    }
});


// Punto 8: evento submit y preventDefault
const formulario = document.getElementById("formulario");
const inputFormulario = document.getElementById("inputFormulario");

formulario.addEventListener("submit", (evento) => {
    evento.preventDefault(); // evita que la página se recargue
    alert("Valor ingresado: " + inputFormulario.value);
    inputFormulario.value = "";
});


// Punto 9: keydown y change
inputTexto.addEventListener("keydown", (evento) => {
    if (evento.key === "Enter" && inputTexto.value.trim() !== "") {
        const item = document.createElement("li");
        item.textContent = inputTexto.value;
        lista.appendChild(item);
        inputTexto.value = "";
    }
});

const selectOpciones = document.getElementById("selectOpciones");
const parrafoSeleccion = document.getElementById("parrafoSeleccion");

selectOpciones.addEventListener("change", () => {
    parrafoSeleccion.textContent = "Opción seleccionada: " + selectOpciones.value;
});

// input: cambia con cada tecla. change: cambia al confirmar el valor final.
// keydown: se dispara al presionar cualquier tecla.
