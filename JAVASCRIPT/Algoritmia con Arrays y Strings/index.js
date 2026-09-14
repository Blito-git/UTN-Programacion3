// 1) Crear un array de palabras
let palabras = [];
for (let i = 0; i < 5; i++) {
    let palabra = prompt(`Ingrese la palabra ${i + 1}:`);
    palabras.push(palabra);
}
console.log("Array de palabras:", palabras);

// 2) Manipular el array
palabras.unshift(prompt("Ingrese una palabra para agregar al inicio:"));
palabras.push(prompt("Ingrese una palabra para agregar al final:"));
palabras.splice(1, 1); // elimina la segunda palabra (índice 1)
console.log("Array actualizado:", palabras);

// 3) Analizar las palabras
let masLarga = palabras[0];
for (let i = 0; i < palabras.length; i++) {
    console.log(`"${palabras[i]}" tiene ${palabras[i].length} caracteres`);

    if (palabras[i].length > masLarga.length) {
        masLarga = palabras[i];
    }

    if (palabras[i].includes("a")) {
        console.log(`"${palabras[i]}" contiene la letra "a"`);
    }
}
console.log("La palabra más larga es:", masLarga);

// 4) Juego de inversión de palabras
let palabrasInvertidas = [];
for (let i = 0; i < palabras.length; i++) {
    let invertida = palabras[i].split("").reverse().join("");
    palabrasInvertidas.push(invertida);
}
console.log("Array invertido:", palabrasInvertidas);
alert("Array invertido: " + palabrasInvertidas.join(", "));

// 5) Palíndromo
let quierePalindromo = prompt("¿Quiere comprobar palíndromos? (sí/no)");
if (quierePalindromo.toLowerCase() === "sí" || quierePalindromo.toLowerCase() === "si") {
    for (let i = 0; i < palabras.length; i++) {
        let original = palabras[i];
        let invertida = original.split("").reverse().join("");

        if (original.toLowerCase() === invertida.toLowerCase()) {
            console.log(`"${original}" es un palíndromo`);
        } else {
            console.log(`"${original}" no es un palíndromo`);
        }
    }
}

// 6) Bonus (opcional)
let contador = 0;
for (let i = 0; i < palabras.length; i++) {
    if (palabras[i].length > 4) {
        contador++;
    }
}
console.log("Cantidad de palabras con más de 4 caracteres:", contador);

let palabrasUnidas = palabras.join("-");
console.log("Palabras unidas por guion:", palabrasUnidas);
