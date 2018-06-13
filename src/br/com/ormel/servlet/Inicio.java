package br.com.ormel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inicio
 */
@WebServlet(
		name = "Inicio",
		urlPatterns = "/Inicio", 
		initParams = {
			@WebInitParam(name = "valorA", value = "7"),
			@WebInitParam(name = "valorB", value = "4")
		}
)
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valorA="0", valorB="0", resultado="0";
		resultado = null;

//		valorA = Integer.parseInt( getServletConfig().getInitParameter("valorA") );
//		valorB = Integer.parseInt( getServletConfig().getInitParameter("valorB") );
		valorA = request.getParameter("valorA");
		System.out.println("ValorA: " + valorA);
		System.out.println("ValorB: " + valorB);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	    // escreve o texto
	    out.println("<html>");
	    out.println("<body>");
//  	out.println("Capturar dados"); 
	    out.println("<div>SAIDA: " + valorA + "</div>"); 
    
		try {
			resultado = String.valueOf( Integer.parseInt(valorA) + Integer.parseInt(valorB) );

			out.println("<div>Soma dos 2 params recebidos: " + String.valueOf(resultado) + "</div>");
    	
		}catch (NumberFormatException nfe) {
			System.out.println("Parametros A ou B nulos");
			out.println("<div>Ao menos um dos params nulo!</div>");
			
		}finally {
		    out.println("</body>");
		    out.println("</html>");	    
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}
