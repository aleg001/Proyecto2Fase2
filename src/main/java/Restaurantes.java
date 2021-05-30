

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dataAccessLayer.EmbeddedNeo4j;

import org.json.simple.JSONArray;

/**
 * Servlet implementation class MoviesByActor
 */
@WebServlet("/MoviesByActor")
public class Restaurantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Restaurantes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
	 	response.setContentType("application/json");
	 	response.setCharacterEncoding("UTF-8");
	 	JSONObject miRespuesta = new JSONObject();
	 	
	 	JSONArray RestaurantesCategoria = new JSONArray();
	 	
	 	String miRestaurante = request.getParameter("nombre");
	 	 try ( EmbeddedNeo4j greeter = new EmbeddedNeo4j( "bolt://localhost:7687", "neo4j", "Uvgenios2021" ) )
	        {
			 	LinkedList<String> misRestaurantes = greeter.getMoviesByActor(miRestaurante);
			 	
			 	for (int i = 0; i < misRestaurantes.size(); i++) {
			 		 //out.println( "<p>" + misRestaurantes.get(i) + "</p>" );
			 		RestaurantesCategoria.add(misRestaurantes.get(i));
			 	}
	        	
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	
	 	miRespuesta.put("conteo", RestaurantesCategoria.size()); //Guardo la cantidad de actores
	 	miRespuesta.put("peliculas", RestaurantesCategoria);
	 	out.println(miRespuesta);
	 	out.flush();  
	 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
