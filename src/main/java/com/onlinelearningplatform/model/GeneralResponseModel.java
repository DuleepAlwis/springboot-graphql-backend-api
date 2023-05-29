package com.onlinelearningplatform.model;

public class GeneralResponseModel {

    public final static String USER_SAVED_SUCCESS = "User successfully created";
    public final static String ERROR_SAVING_USER = "User creation unsuccess";

    public final static String DATA_SAVED_SUCCESS = "Data saved successfully";

    public final static String ERROR_SAVING_DATA = "Data saved unsuccess";
    private String responseMessage;
    private boolean responseStatus;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public boolean getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        this.responseStatus = responseStatus;
    }
}
