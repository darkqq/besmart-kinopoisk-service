package com.besmartkinopoiskservice.util;

import java.util.UUID;

public class UrlPathUtil {
    public static String getResourceRequestPath(UUID imageId){
        return "/resource/" + imageId.toString();
    }
}
