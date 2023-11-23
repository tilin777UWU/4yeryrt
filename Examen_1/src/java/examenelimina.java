/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Win
 */
@WebServlet(urlPatterns = {"/examenelimina"})
public class examenelimina extends HttpServlet {
Connection conexion;
    
    @Override 
    public void init()
    {
     try 
     {
        Class.forName("com.mysql.jdbc.Driver");
        conexion=DriverManager.getConnection("jdbc:mysql://localhost/escuelaa","root","");
    }
     catch(ClassNotFoundException man)
      {
          System.out.println("No hay manejador");
      }
      catch(SQLException base)
      {
          System.out.println("No hay conexion");
      }
    }
      public String borrar (String eliminarexamen)
      {
          String html="";
          try
          {
              Statement a=conexion.createStatement();
              int fila=a.executeUpdate(eliminarexamen);
              return html+=fila+"Examen(s) Eliminado(s)";
                     
          }
          catch(SQLException base)
          {
              return base.getMessage();
          }
      }
  
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String clave_examen= request.getParameter("clave_examen");
            String eliminarexamen= "delete from datos where clave= " + clave_examen;
          
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet examenelimina</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><form method='post' action='Profesor'></h1>");
            out.println("<td><input type='submit' value='REGRESAR'  button style=background-color:#f2ddd2;></td>");
            
            out.println("<H2>" + borrar(eliminarexamen) + "</h2><br>");
           
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
