package org.SRV;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "testServlet", urlPatterns = {"/testServlet"})
public class testServlet extends HttpServlet {    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet testServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double value1 = Double.parseDouble(request.getParameter("val1"));
        double value2 = Double.parseDouble(request.getParameter("val2"));
        double result=0;
        switch(request.getParameter("operation"))
        {
            case "+":  result = value1+value2;
                break;
            case "-":  result = value1-value2;
                break;
            case "*":  result = value1*value2;
                break;
            case "/":  result = value1/value2;
                break;
            default: 
                break;
        }
        response.getOutputStream().print(result);
    }   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
