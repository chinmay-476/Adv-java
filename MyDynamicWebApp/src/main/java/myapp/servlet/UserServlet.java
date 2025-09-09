package myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String clientType = request.getParameter("clientType");
        
        String errorMessage = null;
        if (firstName == null || firstName.trim().isEmpty() ||
            lastName == null || lastName.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            clientType == null || clientType.trim().isEmpty()) {
            errorMessage = "Please fill in all required fields (First Name, Last Name, Email, Client Type). "
                         + "<a href='http://localhost:8080/MyDynamicWebApp/index.html'>Go back</a>";
        }

        out.println("<!DOCTYPE html><html><head><title>Result</title></head><body>");
        
        if (errorMessage != null) {
            out.println("<h2 style='color:red;'>" + errorMessage + "</h2>");
        } else {
            out.println("<h2 style='color:green;'>Client Data Submitted Successfully!</h2>");
            out.println("<p>Name: " + firstName + " " + lastName + "</p>");
            out.println("<p>Email: " + email + "</p>");
            out.println("<p>Client Type: " + clientType + "</p>");
        }
        
        out.println("</body></html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}
