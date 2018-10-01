package org.restsql.service;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session=request.getSession();
        session.invalidate();


        JSONObject o = new JSONObject();


            o.put("role", null);
            o.put("user", null);
            o.put("logged", false);


        response.getOutputStream().print( o.toJSONString());

    }


}
