package com.besmartkinopoiskservice.util;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private List<String> errMesaeges = new ArrayList<>();
    private boolean isSuccess;

    public List<String> getErrMesaeges() {
        return errMesaeges;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void addErrMesaeges(String errMessage) {
        errMesaeges.add(errMessage);
    }


}
