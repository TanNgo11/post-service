package org.shadcn.postsvc.repository.httpClient;


import org.shadcn.postsvc.dto.response.AdminProfileResponse;
import org.shadcn.postsvc.dto.response.ApiResponse;
import org.shadcn.postsvc.dto.response.StudentProfileResponse;
import org.shadcn.postsvc.dto.response.TeacherProfileResponse;
import org.shadcn.postsvc.exception.RetreiveMessageErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "profile",
        url = "${app.services.profile}",
        configuration = {org.shadcn.postsvc.config.AuthenticationRequestInterceptor.class, RetreiveMessageErrorDecoder.class})
public interface ProfileClient {
    @GetMapping(value = "/api/v1/users/students/ids", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<List<StudentProfileResponse>> getPublicStudentProfile(@RequestParam long[] studentIds);

    @GetMapping(value = "/api/v1/users/teachers/ids", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<List<TeacherProfileResponse>> getPublicTeacherProfile(@RequestParam long[] teacherIds);

    @GetMapping(value = "/api/v1/users/admins/ids", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<List<AdminProfileResponse>> getPublicAdminProfile(@RequestParam long[] adminIds);

}
