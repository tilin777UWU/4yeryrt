/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Win
 */
@WebServlet(urlPatterns = {"/MODIFICAEXAMEN"})
public class MODIFICAEXAMEN extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MODIFICAEXAMEN</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> INGRESA LOS DATOS REQUERIDOS </h1>");
            
            out.println("<form action='examenmodifica' method='post'>");
            
            out.println("CLAVE: <input name='clave_examen' size=10 maxlength=10");
            out.println("<br> NOMBRE: <input name='nombre' size=20 maxlength=30 <br><hr>");
            out.println("<br> Pregunta 1: <input name='p1' size=20 maxlength=30 <br>");
            out.println("<br> Pregunta 2: <input name='p2' size=20 maxlength=30 <br>");
            out.println("<br> Pregunta 3: <input name='p3' size=20 maxlength=30 <br>");
            out.println("Pregunta 4: <input name='p4' size=20 maxlength=20 <br>");
            out.println("Pregunta 4: <input name='p5' size=20 maxlength=20 <br>");
            out.println("<center><input type='submit' value='MODIFICAR EXAMEN' button style=background-color:#f2ddd2;> </center>");
           
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
