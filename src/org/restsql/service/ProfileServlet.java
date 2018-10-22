package org.restsql.service;

import org.json.simple.JSONObject;
import org.restsql.core.impl.serial.JsonResponseSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Principal p = request.getUserPrincipal();

        JSONObject o = new JSONObject();

        if(p==null) {
            o.put("role", null);
            o.put("common_role", null);
            o.put("user", null);
            o.put("logged", false);
        }else {
            if(request.isUserInRole("reporting")) {
                o.put("common_role", "reporting");
            } else {
                o.put("common_role", "");
            }
            o.put("role", findRole(request));
            o.put("user", p.getName());
            o.put("logged", true);
        }


        response.getOutputStream().print( o.toJSONString());

    }

    private String findRole(HttpServletRequest req) {
        String role = "";
        role = "admin";                if(req.isUserInRole(role)) return role;
        role = "reporting_cp";         if(req.isUserInRole(role)) return role;
        role = "reporting_admin";      if(req.isUserInRole(role)) return role;
        return  role;
    }
}
