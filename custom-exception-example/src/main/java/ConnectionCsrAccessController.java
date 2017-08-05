import com.wordnik.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Pratik Ambani on 5/08/17.
 */
@RestController
public class ConnectionCsrAccessController{

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ConnectionUserAccessResource<ConnectionCsrAccess> csrAccessResource;

    @Autowired
    private AuthorisationRequestContext authorisationRequestContext;

    private String getUuid() {
        return authorisationRequestContext.getPrincipalUuid();
    }

    @ApiOperation("Add onaccount connection level access")
    @RequestMapping(method = POST, value = API_V1_CONNECTION_ACCOUNT_ACCESS, produces = APPLICATION_JSON_VALUE)
    public void addCustomerCustomerAccess(@Valid @NotEmpty @RequestBody ConnectionCsrAccessBean csrAccess,
                              @Valid @NotEmpty @RequestHeader(API_V1_APPLICATION_HEADER) String application
    ) {
//        throw new RuntimeException("Dummy Exception");
        System.out.println("Should throw error: ");
        log.info("adding csr user access for {} access: {}",application, getUuid(), csrAccess);
        csrAccessResource.addAccess(getUuid(), csrAccess);
    }

}