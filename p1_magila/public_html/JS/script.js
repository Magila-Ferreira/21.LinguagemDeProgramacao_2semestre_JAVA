/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
let q3 = document.getElementById("q3");
let q5 = document.getElementById("q5");

let num = 5;  // 0+1+2+3+4+5 = 15;
let soma = 0;
let palavra = "dois";
let vetorPalavra = palavra;

let somaQ3 = questaoTres(num);
let questao5 = invertePalavra(palavra);


// QUESTÃO 1
alert("Aluna: Mágila Morgana S. Ferreira - QUESTÃO 1");

// QUESTÃO 3
function questaoTres(num) {
    for (let cont = 0; cont <= num; cont++) {
        soma = soma + cont;
    }
    
    q3.innerHTML = soma;
    return soma;
}

// QUESTÃO 5
// dois
function invertePalavra(palavra) {
    
    
    q5.innerHTML = vetorPalavra;
    return vetorPalavra;
}

