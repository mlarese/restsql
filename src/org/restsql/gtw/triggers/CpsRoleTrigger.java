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
                System.out.println("------ u="+ userName);
                RequestValue rqv = new RequestValue("cp_name", userName, RequestValue.Operator.Equals);
                request.getParameters().add(rqv);
            }
        }


        System.out.println("---------- trigger "+res);

    }
}
