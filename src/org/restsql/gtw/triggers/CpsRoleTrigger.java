package org.restsql.gtw.triggers;

import org.restsql.core.*;

public class CpsRoleTrigger extends AbstractTrigger {
    @Override
    public void beforeInsert(Request request) throws InvalidRequestException, SqlResourceException {
        super.beforeInsert(request);

    }

    @Override
    public void beforeSelect(Request request) throws InvalidRequestException, SqlResourceException {
        super.beforeSelect(request);

        String res = request.getSqlResource();

        RequestValue rqv = new RequestValue("cp_name","Encube", RequestValue.Operator.Equals);

        //request.getParameters().add(rqv);

        System.out.println("---------- trigger "+res);

    }
}
