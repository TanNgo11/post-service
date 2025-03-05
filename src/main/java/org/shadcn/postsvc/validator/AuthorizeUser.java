package org.shadcn.postsvc.validator;

import org.shadcn.postsvc.exception.AppException;
import org.shadcn.postsvc.exception.ErrorCode;
import org.shadcn.postsvc.service.IAuthenticationFacade;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class AuthorizeUser {
    IAuthenticationFacade authenticationFacade;
    // GetUsername by Authentication
    public void checkAuthorizeUser() {
        Authentication myAuthentication = authenticationFacade.getAuthentication();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = null;

        // Extract username from JWT token if present
        if (authentication != null && authentication.isAuthenticated()) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            username = jwt.getClaimAsString("sub");
        }

        // Authorization check
        if (username == null || !username.equals(myAuthentication.getName())) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }
    }
}
