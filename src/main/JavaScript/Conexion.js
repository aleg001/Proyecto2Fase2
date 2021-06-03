
var driver = neo4j.driver{
    'neo4j://http://94.74.64.91:7474',
    neo4j.auth.basic('neo4j','Uvgenios2021')
}

funcion Search(){
    var SeleccionRestaurante = document.querySelector("input(name='SeleccionRestaurante[]'")
    var ResturanteElegido = []

    for(let i=0, i< SeleccionRestaurante.length; i++){
        if(SeleccionRestaurante[i].checked){
            ResturanteElegido.push(SeleccionRestaurante[i].value)}
        }
    var Plataforma
    
    }


