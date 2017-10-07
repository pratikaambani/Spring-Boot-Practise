package com.practise.cors.annotation;


import com.wordnik.swagger.annotations.ApiOperation;
import user.*;
import user.servlet.HttpServletResponseAccessPinTokenBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static user.AccessControllerResource.*;
import static TokenResource.API_V1_APPLICATION_HEADER;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;
/**
 * Created by Pratik Ambani on 01/09/17.
 */
@RestController
public class ConnectionUserAccessControllerMethodLevel {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ConnectionUserAccessResource<ConnectionUserAccess> userAccessResource;

    @Autowired
    private HttpServletResponseAccessPinTokenBinder servletResponseTokenBinder;

    @CrossOrigin
    //<script src="https://gist.github.com/pratikaambani/0a0950371b5915d7e6feff75487934b6.js"></script>
    @ApiOperation(notes = "Add user access", value = "")
    @RequestMapping(method = POST, value = API_V1_ADD_CONNECTION, produces = APPLICATION_JSON_VALUE)
    public void addUserAccess(@Valid @PathVariable(API_V1_ACCESSES_ACC_TYPE_VAR) ConnectionAccessPin.ConnectionAccountType accType,
                              @Valid @RequestBody ConnectionAccessPinBean connectionAccessPin,
                              @Valid @RequestHeader(value = API_V1_ACCESS_PIN_HEADER_NAME) String token,
                              @Valid @RequestHeader(API_V1_APPLICATION_HEADER) String application,
                              HttpServletResponse response) {
        log.info("adding user access for {} access: {}", connectionAccessPin);
        userAccessResource.addAccess(connectionAccessPin, token,accType);
        servletResponseTokenBinder.delete(response);
    }

    @ApiOperation("Remove access associated with AUID")
    @RequestMapping(method = DELETE, value = API_V1_CONNECTION_AUID, produces = APPLICATION_JSON_VALUE)
    public void removeUserAccess( @Valid @NotNull @PathVariable(API_V1_ACCESSES_AUID_VAR)  String authid ,
                                  @Valid @RequestHeader(API_V1_APPLICATION_HEADER) String application) {
        log.info("removing user access for {} access: {}", authid);
        userAccessResource.removeAccesses(authid);
    }

}