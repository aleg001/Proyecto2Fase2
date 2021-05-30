/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Proyecto Final.java
* Autor: Alejandro Gomez
* Autor: Paola de León
* Autor: Marco Jurado
* Fecha de creacion: 27-05-21
* Ultima edicion: 28-05-21
********************************************************/

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;

import static org.neo4j.driver.Values.parameters;

import java.util.LinkedList;
import java.util.List;
/**
 * @author Administrator
 *
 */
public class EmbeddedNeo4j implements AutoCloseable{

    private final Driver driver;
    

    public EmbeddedNeo4j( String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public void printGreeting( final String message )
    {
        try ( Session session = driver.session() )
        {
            String greeting = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "CREATE (a:Greeting) " +
                                                     "SET a.message = $message " +
                                                     "RETURN a.message + ', from node ' + id(a)",
                            parameters( "message", message ) );
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println( greeting );
        }
    }
    
    public LinkedList<String> getGlutenFree()
    {
    	 try ( Session session = driver.session() )
         {
    		 
    		 
    		 LinkedList<String> ResGlutenFree = session.readTransaction( new TransactionWork<LinkedList<String>>()
             {
                 @Override
                 public LinkedList<String> execute( Transaction tx )
                 {
                     Result result = tx.run( "MATCH (n) RETURN n.nombre");
                     LinkedList<String> misRestaurantes = new LinkedList<String>();
                     List<Record> registros = result.list();
                     for (int i = 0; i < registros.size(); i++) {
                         String temp = registros.get(i).get("Resturantes.glutenfree").asString(); // boolean
                         String temp2 = registros.get(i).get("Restaurantes.nombre").asString();
                         if (temp.equals("true")){
                             misRestaurantes.add(temp2);
                         }

                    	 /*myactors.add(registros.get(i).toString());
                    	 myactors.add(registros.get(i).get("people.name").asString());*/
                     }
                     
                     return misRestaurantes;
                 }
             } );
             
             return ResGlutenFree;
         }
    }

    public LinkedList<String> getVegan()
    {
    	 try ( Session session = driver.session() )
         {
    		 
    		 
    		 LinkedList<String> ResVegan = session.readTransaction( new TransactionWork<LinkedList<String>>()
             {
                 @Override
                 public LinkedList<String> execute( Transaction tx )
                 {
                     Result result = tx.run( "MATCH (n) RETURN n.nombre");
                     LinkedList<String> misRestaurantes = new LinkedList<String>();
                     List<Record> registros = result.list();
                     for (int i = 0; i < registros.size(); i++) 
                     {
                         String temp = registros.get(i).get("Resturantes.vegan").asString();
                         String temp2 = registros.get(i).get("Restaurantes.nombre").asString();
                         if (temp.equals("true")){
                             misRestaurantes.add(temp2);
                         }

                    	 /*myactors.add(registros.get(i).toString());
                    	 myactors.add(registros.get(i).get("people.name").asString());*/
                     }
                     
                     return misRestaurantes;
                 }
             } );
             
             return ResVegan;
         }
    }

    public LinkedList<String> getKids()
    {
    	 try ( Session session = driver.session() )
         {
    		 
    		 
    		 LinkedList<String> ResKids= session.readTransaction( new TransactionWork<LinkedList<String>>()
             {
                 @Override
                 public LinkedList<String> execute( Transaction tx )
                 {
                     Result result = tx.run( "MATCH (n) RETURN n.nombre");
                     LinkedList<String> misRestaurantes = new LinkedList<String>();
                     List<Record> registros = result.list();
                     for (int i = 0; i < registros.size(); i++) {
                         String temp = registros.get(i).get("Resturantes.kids").asString();
                         String temp2 = registros.get(i).get("Restaurantes.nombre").asString();
                         if (temp.equals("true")){
                             misRestaurantes.add(temp2);
                         }

                    	 /*myactors.add(registros.get(i).toString());
                    	 myactors.add(registros.get(i).get("people.name").asString());*/
                     }
                     
                     return misRestaurantes;
                 }
             } );
             
             return ResKids;
         }
    }

    public LinkedList<String> getLowCalorie()
    {
    	 try ( Session session = driver.session() )
         {
    		 
    		 
    		 LinkedList<String> ResLowCalorie = session.readTransaction( new TransactionWork<LinkedList<String>>()
             {
                 @Override
                 public LinkedList<String> execute( Transaction tx )
                 {
                     Result result = tx.run( "MATCH (n) RETURN n.nombre");
                     LinkedList<String> misRestaurantes = new LinkedList<String>();
                     List<Record> registros = result.list();
                     for (int i = 0; i < registros.size(); i++) {
                         String temp = registros.get(i).get("n.lowcalorie").asString();
                         String temp2 = registros.get(i).get("n.nombre").asString();
                         if (temp.equals("true")){
                             misRestaurantes.add(temp2);
                         }

                    	 /*myactors.add(registros.get(i).toString());
                    	 myactors.add(registros.get(i).get("people.name").asString());*/
                     }
                     
                     return misRestaurantes;
                 }
             } );
             
             return ResLowCalorie;
         }
    }

    public LinkedList<String> getDelivery()
    {
    	 try ( Session session = driver.session() )
         {
    		 
    		 
    		 LinkedList<String> ResDelivery = session.readTransaction( new TransactionWork<LinkedList<String>>()
             {
                 @Override
                 public LinkedList<String> execute( Transaction tx )
                 {
                     Result result = tx.run( "MATCH (n) RETURN n.nombre");
                     LinkedList<String> misRestaurantes = new LinkedList<String>();
                     List<Record> registros = result.list();
                     for (int i = 0; i < registros.size(); i++) {
                         String temp = registros.get(i).get("Resturantes.delivery").asString();
                         String temp2 = registros.get(i).get("Restaurantes.nombre").asString();
                         if (temp.equals("true")){
                             misRestaurantes.add(temp2);
                         }

                    	 /*myactors.add(registros.get(i).toString());
                    	 myactors.add(registros.get(i).get("people.name").asString());*/
                     }
                     
                     return misRestaurantes;
                 }
             } );
             
             return ResDelivery;
         }
    }
}
