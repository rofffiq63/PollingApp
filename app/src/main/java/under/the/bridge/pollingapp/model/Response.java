package under.the.bridge.pollingapp.model;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("error")
    public boolean error;

    @SerializedName("message")
    public String message;

    @SerializedName("logmesage")
    private String logMessage;

    @SuppressWarnings({"unused", "used by Retrofit"})
    public Response() {
    }

    public Response(String toLog, String string, boolean b) {
        this.message = string;
        this.logMessage = toLog;
        this.error = b;
    }

    public Response(boolean error) {
        this.error = error;
    }

    public Response(String networkErrorMessage, String logMessage) {
        this.message = networkErrorMessage;
        this.logMessage = logMessage;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
