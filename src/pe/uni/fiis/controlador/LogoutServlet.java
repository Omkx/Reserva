package pe.uni.fiis.controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String admin = String.valueOf(session.getAttribute("admin"));
        String usuario = String.valueOf(session.getAttribute("usu"));

        if(admin != null){
            session.setAttribute("admin",null);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        if(usuario != null){
            session.setAttribute("usu",null);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
