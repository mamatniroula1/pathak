package pathak;


import com.mysql.cj.Session;
import database.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet ("/bhaskar")
public class login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        user user = new user();
        try {
            if (user.check(username, password)) {
                HttpSession session= request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("welcome.jsp");

            } else {
                response.sendRedirect("index.jsp");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

