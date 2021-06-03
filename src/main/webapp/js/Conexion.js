
var primeraCat = null
var segundaCat = null
var restaurantes = []
var ratings = []


/**
 * Método para conectar base de datos.
 * Driver.
 */
var driver = neo4j.driver(
    'neo4j://http://94.74.64.91:7474',
    neo4j.auth.basic('neo4j','Uvgenios2021')
)

// Si no se pueden usar parametros 
// function clickLowCalorie () {
//     primeraCat(1);
// }

// function clickDelivery () {
//     primeraCat(2);
// }

// function clickGlutenFree () {
//     primeraCat(3);
// }

// function clickVegan () {
//     primeraCat(4);
// }

/**
 * Metodos de asignar valor a primera categoria
 */
function primeraCat (x) {
    var temp = ""; //Temporal que va a ser asignada a general
    switch (x) {
        case 1: // Low Calorie
            primeraCat = "lowcalorie";
            break;
        case 2: // Delivery
            primeraCat = "delivery"
            
                break;
        case 3: // Gluten Free
            primeraCat = "glutenfree"  

                break;
        case 4: // vegan
            primeraCat = "vegan"
                break;
        
        default:
            break;
    }
}

function segundaCat (x) {
    var temp = ""; //Temporal que va a ser asignada a general
    switch (x) {
        case 1: // Low Calorie
            segundaCat = "lowcalorie";
            break;
        case 2: // Delivery
            segundaCat = "delivery"
            
                break;
        case 3: // Gluten Free
            segundaCat = "glutenfree"  

                break;
        case 4: // vegan
            segundaCat = "vegan"
                break;
        
        default:
            break;
    }
    
    // Llamar a función Search
    Search()

}


/**
 * Método de búsqueda
 */
function Search() {

    var nombresRestaurantes = [] // Lista en donde se almacenan las opciones elegidas
    var ratingsResttaurantes = [] //Lista que almacena ratings
     
    if ( primeraCat != null && segundaCat != null ) {
        var session = driver.session() // Crear sesión de Neo4J
        session
        // Obtener nombre de restaurante
        .run('MATCH (n) WHERE n.$primera = true AND n.$segunda = true RETURN n.nombre AS nombres', {
            primera = primeraCat,
            segunda = segundaCat
        })
        .then( result => {
            restaurantes = nombres;
        })
        .catch(error => {
            console.log(error)
        })
        // Obtener rating de restaurante
        .run('MATCH (n) WHERE n.$primeraCat = true AND n.$segundaCat = true RETURN n.rating AS notas', { // Verificar opc
            nombreParam: nombre
        })
        .then( result => {
            ratings = notas;
        })
        .catch(error => {
            console.log(error)
        })
        .then(() => {
            session.close()
            console.log("Session closed")
        })
    } else {
        console.log(error) // Posible error
    }
    
}

function mostrar(){
    if (restaurantes != null && ratings != null) {
        if (restaurantes.length > 1 && ratings.length > 1) {
            if(restaurantes.length >= 3 && ratings.length >= 3){
                recoNOM1 = restaurantes[0]
                recoRAT1 = ratings[0]
                recoNOM2 = restaurantes[1]
                recoRAT2 = ratings[1]
                recoNOM3 = restaurantes[2]
                recoRAT3 = ratings[2]
    
                alert("Le recomendamos: \n  >" + recoNOM1 + " con un rating de " + recoRAT1 + "\n  >" + recoNOM2 + " con un rating de " + recoRAT2 + "\n  >" + recoNOM3 + " con un rating de " + recoRAT3 + "\n  >")
    
            }
            else {
                recoNOM1 = restaurantes[0]
                recoRAT1 = ratings[0]
                recoNOM2 = restaurantes[1]
                recoRAT2 = ratings[1]

                alert("Le recomendamos: \n  >" + recoNOM1 + " con un rating de " + recoRAT1 + "\n  >" + recoNOM2 + " con un rating de " + recoRAT2)
            }
        }
        
        else if (restaurantes.length == 1 && ratings.length == 1) {
            recoNOM1 = restaurantes[0]
            recoRAT1 = ratings[0]

            alert("Le recomendamos: \n  >" + recoNOM1 + " con un rating de " + recoRAT1)
        }
    }
    
    
    

   
}

// for (let i=0; i< opcRestaurante.length; i++) {
//     if (opcRestaurante[i].clicked) {
//         opcElegida.push(opcRestaurante[i].value)
//     }
// }

/**
 * 
 */
function borrar() {
    // var nombre = document.getElementById("nombreBorrarTxt").value
    // Conexión con base de datos
    var session = driver.session()

    session
    .run('MATCH (n) WHERE n.name = $nombreParam DELETE n', { // Verificar opc
        nombreParam: nombre
    })
    .then(result => {
        alert("Error ") // Error
    })
    .catch(error => {
        console.log(error)
    })
    .then(() => {
        session.close()
        console.log("Session closed")
    })
}
