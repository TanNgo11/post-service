package org.shadcn.postsvc.repository.httpClient;

import org.shadcn.postsvc.dto.response.*;
import org.shadcn.postsvc.exception.RetreiveMessageErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "identity",
        url = "${app.services.identity}",
        configuration = {
            org.shadcn.postsvc.config.AuthenticationRequestInterceptor.class,
            RetreiveMessageErrorDecoder.class
        })
public interface IdentityClient {
    @GetMapping(value = "/api/v1/users/admins/profile/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<UserProfileResponse> getProfileByUserId(@PathVariable Long userId);
}
