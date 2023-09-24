package com.mbal.saleportal.spring_template.util;

import java.util.List;

public class CollectionUtils {

    public static <T> boolean isNullOrEmpty(List<T> list){
        return list == null || list.isEmpty();
    }
}
