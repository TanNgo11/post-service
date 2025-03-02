package org.shadcn.postsvc.repository.httpClient;


import org.shadcn.postsvc.dto.response.ApiResponse;
import org.shadcn.postsvc.dto.response.FileUploadResponse;
import org.shadcn.postsvc.exception.RetreiveMessageErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(
        name = "file-service",
        url = "${app.services.file}",
        configuration = {org.shadcn.postsvc.config.AuthenticationRequestInterceptor.class, RetreiveMessageErrorDecoder.class})
public interface FileServiceClient {
    @PostMapping(
            value = "/upload",
            headers = "Content-Type: multipart/form-data",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ApiResponse<FileUploadResponse> uploadFile(@RequestPart(value = "file") MultipartFile file);
}
