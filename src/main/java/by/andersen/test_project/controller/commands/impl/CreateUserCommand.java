package by.andersen.test_project.controller.commands.impl;

import by.andersen.test_project.controller.commands.Command;
import by.andersen.test_project.dao.UserDAO;
import by.andersen.test_project.dao.impl.UserDAOImpl;
import by.andersen.test_project.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserCommand implements Command {
    private final UserDAO userDAO = UserDAOImpl.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        
        if ((name==null||"".equals(name))||(surname==null||"".equals(surname))){
            response.sendRedirect(request.getContextPath() + "/error");
        }

        User user = new User();
        user.setName(name);
        user.setSurname(surname);

        userDAO.saveUser(user);

        response.sendRedirect(request.getContextPath() + "/");
    }
}
