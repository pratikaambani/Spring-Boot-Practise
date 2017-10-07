package com.practise.cors.annotation;

import com.wordnik.swagger.annotations.ApiOperation;
import UserProfileDetail;
import UserProfileResource;
import spring.AuthorisationRequestContext;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static AccessControllerResource.API_V1_CONNECTION_ACCESS_DATA;
import static AccessControllerResource.API_V1_CONNECTION_USER_PROFILE;
import static TokenResource.API_V1_APPLICATION_HEADER;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;


@RestController
public class UserProfileController {

    @Autowired
    UserProfileResource userProfileResource;

    @Autowired
    private AuthorisationRequestContext authorisationRequestContext;


    private String getUsername() {
        return authorisationRequestContext.getPrincipalUsername();
    }

    @ApiOperation(value = "Returns a user profile for the given username", notes = "The username will take from token")
    @RequestMapping(method = GET, value = API_V1_CONNECTION_USER_PROFILE, produces = APPLICATION_JSON_VALUE)
    public UserProfileDetail getUserProfile(@Valid @NotEmpty @RequestHeader(API_V1_APPLICATION_HEADER) String application) {
        return userProfileResource.getUserProfile(getUsername());
    }


    @ApiOperation(value = "Create user profiles cache", notes = "Unauthenticated user call")
    @RequestMapping(method = PUT, value = API_V1_CONNECTION_ACCESS_DATA, produces = APPLICATION_JSON_VALUE)
    public void createUserProfileCache() {
        userProfileResource.createUserProfileCache();
    }


}
