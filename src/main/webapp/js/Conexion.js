
/**
 * Método para conectar base de datos.
 * Driver.
 */
var driver = neo4j.driver(
    'neo4j://http://94.74.64.91:7474',
    neo4j.auth.basic('neo4j','Uvgenios2021')
)

/**
 * Método de búsqueda
 */
function Search() {
    var opcElegida = [] // Lista en donde se almacenan las opciones elegidas
    document.querySelectorAll('button')

    for (let i=0; i< opcRestaurante.length; i++) {
        if (opcRestaurante[i].clicked) {
            opcElegida.push(opcRestaurante[i].value)
        }
    } 
    
}

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
