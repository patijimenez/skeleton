import mx.gob.inadem.*

include "proposerTypes"

fixture {
  microempresario(CallProposer) {
    name = "Microempresario"
    proposerType = fisica
  }
  emprendedor(CallProposer) {
    name = "Emprendedor"
    proposerType = fisica
  }
  estudiante(CallProposer) {
    name = "Estudiante"
    proposerType = fisica
  }
  micro(CallProposer) {
    name = "Microempresa"
    proposerType = moral
  }
  peque(CallProposer) {
    name = "Pequeña empresa"
    proposerType = moral
  }
  media(CallProposer) {
    name = "Empresa mediana"
    proposerType = moral
  }
  grande(CallProposer) {
    name = "Empresa grande"
    proposerType = moral
  }
  estatal(CallProposer) {
    name = "Gobierno estatal"
    proposerType = gobierno
  }
  municipal(CallProposer) {
    name = "Gobierno municipal"
    proposerType = gobierno
  }
  bancaDesarrolloEstatal(CallProposer) {
    name = "Banca de desarrollo estatal"
    proposerType = gobierno
  }
  bancaDesarrolloMunicipal(CallProposer) {
    name = "Banca de desarrollo municipal"
    proposerType = gobierno
  }
}

