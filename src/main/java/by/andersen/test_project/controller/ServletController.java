package by.andersen.test_project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.andersen.test_project.controller.commands.CommandProvider;

@WebServlet(name = "controller", value = "/")
public class ServletController extends HttpServlet {

    private final CommandProvider commandProvider = new CommandProvider();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        commandProvider.getCommand("go_to_main").execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        commandProvider.getCommand(request.getParameter("command")).execute(request, response);
    }

}
