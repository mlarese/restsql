package org.restsql.gtw.triggers;

import org.restsql.core.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

public class CpsRoleTrigger extends AbstractTrigger {
    @Override
    public void beforeInsert(Request request) throws InvalidRequestException, SqlResourceException {
        super.beforeInsert(request);

    }

    @Override
    public void beforeSelect(Request request) throws InvalidRequestException, SqlResourceException {
        super.beforeSelect(request);

        String res = request.getSqlResource();


        HttpServletRequest httpServletRequest = request.getHttpRequest();
        if(httpServletRequest.isUserInRole("reporting_cp")) {
            if(httpServletRequest.getUserPrincipal()!=null) {
                String userName = httpServletRequest.getUserPrincipal().getName();
                // cpuser_1
                System.out.println("------ u="+ userName);

                String[] as = userName.split("_");
                Integer is = new Integer(as[1]);

                // RequestValue rqv = new RequestValue("cp_name", userName, RequestValue.Operator.Equals);
                RequestValue rqv = new RequestValue("cp_id", userName, RequestValue.Operator.Equals);
                request.getParameters().add(rqv);
            }
        }


        System.out.println("---------- trigger "+res);

    }

    public static void main(String[] args) {
        String s = "cpuser_2";
        String[] as = s.split("_");
        Integer is = new Integer(as[1]);
        System.out.println(is +100);
    }
}
