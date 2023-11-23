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
@WebServlet(urlPatterns = {"/examenmodifica"})
public class examenmodifica extends HttpServlet {
  
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
     
      public String modificaexamen (String MODIFICAEXAMEN)
      {
          String html="";
          try
          {
              Statement a=conexion.createStatement();
              int fila=a.executeUpdate(MODIFICAEXAMEN);
              return html+=fila+"Alumno(s) Modicado(s)";
                     
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
            
             String clave_examen=request.getParameter("clave_examen");    
            String nombre=request.getParameter("nombre");
                 String p1=request.getParameter("p1");
                 String p2=request.getParameter("p2");
                 String p3=request.getParameter("p3");
                 String p4=request.getParameter("p4");
                 String p5=request.getParameter("p5");
                 
              String MODIFICAEXAMEN="UPDATE examenes SET nombre='"+nombre+"',p1='"+p1+"',p2='"+p2+"'"
                      + "p3='"+p3+"',p4='"+p4+"',p5='"+p5+"' "
                      + "where examenes="+clave_examen;
 
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet examenmodifica</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4><form method='post' action='Profesor'></h4>");
            
            out.println("<td><input type='submit' value='REGRESAR' button style=background-color:#f2ddd2;></td>");
            out.println("<h2>" + modificaexamen(MODIFICAEXAMEN) + "</h2><br>");
        
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
