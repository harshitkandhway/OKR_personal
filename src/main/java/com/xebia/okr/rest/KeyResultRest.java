package com.xebia.okr.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/keyresult")
public class KeyResultRest {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String myMethod() {
        //language=JSON
        String str = "{\n" +
                "  \"Technology\":\"Java REST API\",\n" +
                "  \"batch\" : \"Xebiaa fs101\"\n" +
                "}";
        return str;
    }

}
