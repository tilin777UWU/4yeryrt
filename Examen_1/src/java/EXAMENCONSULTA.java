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
@WebServlet(urlPatterns = {"/EXAMENCONSULTA"})
public class EXAMENCONSULTA extends HttpServlet {
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
   
    public String buscarRegistro(String consultaexamen){
           
                  String html="";
                  try
                  {
            Statement consultar= conexion.createStatement();
                    ResultSet res = consultar.executeQuery(consultaexamen);
                    while (res.next())
                    {
    html +="<hr><br> Clave:<input name='clave_examen' value='" + res.getInt(1) + "'><br>";
    html +="  Nombre:<input name='nombre' value='" + res.getString(2) + "'><hr><br>";
    html +=" Pregunta 1:<input name='p1' value='" + res.getString(3) + "'><hr>";
    html +=" Pregunta 2:<input name='p2' value='" + res.getString(4) + "'><hr>";
    html +=" Pregunta 3:<input name='p3' value='" + res.getString(5) + "'><hr>";
    html +="Pregunta 4:<input name='p4' value='" + res.getString(6) + "'><hr>";
    html +="Pregunta 4:<input name='p5' value='" + res.getString(7) + "'><hr>";
    
   
        
    html += "</form>";
                    }
            res.close();
                    consultar.close();
                    return html;
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
            
            String clave_examen = request.getParameter("clave_examen");
              
            String consultaexamen = "select * from examenes where clave_examen=" + clave_examen;
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EXAMENCONSULTA</title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<h4><form method='post' action='menu'</h4>");
            
            out.println("<h1><center> DATOS REQUERIDOS </h1></center>");
            out.println("<h2>" + buscarRegistro(consultaexamen) + "</h2><br>");
            out.println("<h4><form method='post' action='Profesor'></h4>");
            
            out.println("<td><center><input type='submit' value='REGRESAR' "
                    + "button style=background-color:#d0b7be;></td></center>");
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
