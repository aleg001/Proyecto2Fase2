/**
 * Universidad Del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Fecha de entrega: 03 de Junio del 2021
 * Integrantes:
 * Alejandro Gómez
 * Marco Jurado
 * Paola De León
 */


// Properties
var primeraCat = null
var segundaCat = null
var restaurantes = []
var ratings = null

/*------------------------------------------------- C O N E X I O N   D E   N E O 4 J  -------------------------------------------------*/
// Método para conectar base de datos.
var driver = neo4j.driver(
    'neo4j://94.74.64.91:7687',
    neo4j.auth.basic('neo4j', 'Uvgenios2021')
)

/*------------------------------------------- F U N C I O N E S   D E   B O T O N E S ---------------------------------------------*/
function clickLowCalorie1() {
    primeraCat = "lowcalorie"
}

function clickDelivery1() {
    primeraCat = "delivery"
}

function clickGlutenFree1() {
    primeraCat = "glutenfree"
}

function clickVegan1() {
    primeraCat = "vegan"

}

function clickLowCalorie2() {
    segundaCat = "lowcalorie"
    Search()
}

function clickDelivery2() {
    segundaCat = "delivery"
    Search()
}

function clickGlutenFree2() {
    segundaCat = "glutenfree"
    Search()
}

function clickVegan2() {
    segundaCat = "vegan"
    Search()
}

/*------------------------------------ M E T O D O   P A R A   B U S C A R  R E S T A U R A N T E S -------------------------------------*/
function Search() {
    // Verificar que se haya presionado 
    if (primeraCat != null && segundaCat != null) {
        // Crear sesión de Neo4J
        var session = driver.session()
        // Buscar en neo4j los matches
        session.run("MATCH (n) WHERE n." + primeraCat +"= true AND n."+segundaCat + "= true RETURN n.nombre AS nombres")
            // Mostrar restaurantes recomendados
            .then(result => {
                console.log(result.records.length);
                alert("A continuación verá las recomendaciones. Presione Aceptar para avanzar.")
                return result.records.map(record => {
                    alert("GuateFood le recomienda: " + record.get("nombres"));
                });
                alert("Esperamos le guste. Vuelva pronto!")
            })
            // Error
            .catch(error => {
                console.log(error)
            })
            // Cerrar sesión de neo4j
            .then(() => {
                session.close()
                console.log("Session closed")
            })
    } else {
        console.log("No se ha seleccionado ninguna categoría")
    }

}