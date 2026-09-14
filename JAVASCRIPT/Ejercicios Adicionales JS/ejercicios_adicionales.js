// 1. Invertir un array
function invertirArray(array) {
    let resultado = [];
    for (let i = array.length - 1; i >= 0; i--) {
        resultado.push(array[i]);
    }
    return resultado;
}
console.log(invertirArray([1, 2, 3, 4]));

// 2. Palíndromo
function esPalindromo(str) {
    let invertido = "";
    for (let i = str.length - 1; i >= 0; i--) {
        invertido += str[i];
    }
    return str === invertido;
}
console.log(esPalindromo("reconocer"));

// 3. Contar vocales
function contarVocales(str) {
    let vocales = "aeiouAEIOU";
    let contador = 0;
    for (let i = 0; i < str.length; i++) {
        if (vocales.includes(str[i])) {
            contador++;
        }
    }
    return contador;
}
console.log(contarVocales("Javascript ES Genial"));

// 4. Rotación de array
function rotarArray(array) {
    let resultado = [array[array.length - 1]];
    for (let i = 0; i < array.length - 1; i++) {
        resultado.push(array[i]);
    }
    return resultado;
}
console.log(rotarArray([10, 20, 30, 40]));

// 5. Ordenar números sin .sort()
function ordenarArray(array) {
    let resultado = [...array];
    for (let i = 0; i < resultado.length; i++) {
        for (let j = 0; j < resultado.length - 1 - i; j++) {
            if (resultado[j] > resultado[j + 1]) {
                let temp = resultado[j];
                resultado[j] = resultado[j + 1];
                resultado[j + 1] = temp;
            }
        }
    }
    return resultado;
}
console.log(ordenarArray([5, 2, 9, 1]));

// 6. Reemplazo de palabras
function reemplazarPalabra(str, palabraOriginal, palabraNueva) {
    return str.split(palabraOriginal).join(palabraNueva);
}
console.log(reemplazarPalabra("me gusta programar en Java", "Java", "JavaScript"));

// 7. Números únicos
function numerosUnicos(array) {
    let resultado = [];
    for (let i = 0; i < array.length; i++) {
        if (!resultado.includes(array[i])) {
            resultado.push(array[i]);
        }
    }
    return resultado;
}
console.log(numerosUnicos([1, 2, 2, 3, 4, 4, 5]));

// 8. Intersección de arrays
function interseccion(array1, array2) {
    let resultado = [];
    for (let i = 0; i < array1.length; i++) {
        if (array2.includes(array1[i])) {
            resultado.push(array1[i]);
        }
    }
    return resultado;
}
console.log(interseccion([1, 2, 3, 4], [3, 4, 5, 6]));

// 9. Contar palabras
function contarPalabras(str) {
    let palabras = str.split(" ");
    let conteo = {};
    for (let i = 0; i < palabras.length; i++) {
        let palabra = palabras[i];
        if (conteo[palabra]) {
            conteo[palabra]++;
        } else {
            conteo[palabra] = 1;
        }
    }
    return conteo;
}
console.log(contarPalabras("hola mundo hola javascript"));

// 10. Matriz transpuesta
function transponerMatriz(matriz) {
    let resultado = [];
    for (let col = 0; col < matriz[0].length; col++) {
        let fila = [];
        for (let row = 0; row < matriz.length; row++) {
            fila.push(matriz[row][col]);
        }
        resultado.push(fila);
    }
    return resultado;
}
console.log(transponerMatriz([
    [1, 2, 3],
    [4, 5, 6]
]));
