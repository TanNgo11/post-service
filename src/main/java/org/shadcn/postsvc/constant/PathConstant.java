package org.shadcn.postsvc.constant;

public class PathConstant {
    public static final String API_V1 = "/api/v1";

    public static final String POSTS = "/posts";
    public static final String COMMENT = "/comments";
    public static final String TAGS = "/tags";
    public static final String POST_REACTION = "/reactions";

    public static final String API_V1_POSTS = API_V1 + POSTS;
    public static final String API_V1_COMMENT = API_V1 + COMMENT;
    public static final String API_V1_TAGS = API_V1 + TAGS;
    public static final String API_V1_POST_REACTION = API_V1 + POST_REACTION;

    public static final String[] PUBLIC_ENDPOINTS = {
        "/swagger-ui/**", "/v3/api-docs/**",
    };
}
