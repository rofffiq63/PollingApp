package under.the.bridge.pollingapp.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.HttpException;
import under.the.bridge.pollingapp.model.Response;

import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class NetworkError extends Throwable {
    public static final String HTTP_ERROR_MESSAGE = "HTTP Error";
    private static final String DEFAULT_ERROR_MESSAGE = "Something went wrong. Please try again";
    //    private static final String NULL_ERROR_MESSAGE = "NULL Response";
    private static final String NETWORK_ERROR_MESSAGE = "No Internet Connection";
    private static final String ERROR_MESSAGE_HEADER = "Error-Message";
    private final Throwable error;

    public NetworkError(Throwable e) {
        super(e);
        this.error = e;
        this.error.printStackTrace();
    }

    public String getMessage() {
        return error.getMessage();
    }

    public boolean isAuthFailure() {
        return error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_UNAUTHORIZED;
    }

    public boolean isResponseNull() {
        return error instanceof HttpException && ((HttpException) error).response() == null;
    }

    public Response getResponse() {
        if (this.error instanceof IOException)
            return new Response(NETWORK_ERROR_MESSAGE, NETWORK_ERROR_MESSAGE);
        if (!(this.error instanceof HttpException))
            return new Response(DEFAULT_ERROR_MESSAGE, DEFAULT_ERROR_MESSAGE);
        retrofit2.Response<?> response = ((HttpException) this.error).response();
        if (response != null) {
            Response responseJson = getErrorResponse(response);
            if (responseJson != null)
                return responseJson;
//                if (responseJson.error)
//                    return new Response(DEFAULT_ERROR_MESSAGE, responseJson.getMessage());
//            } else
//                return new Response(DEFAULT_ERROR_MESSAGE, responseJson.getLogMessage());

            Map<String, List<String>> headers = response.headers().toMultimap();
            if (headers.containsKey(ERROR_MESSAGE_HEADER))
                return new Response(DEFAULT_ERROR_MESSAGE, headers.get(ERROR_MESSAGE_HEADER).get(0));
        }
        return new Response(DEFAULT_ERROR_MESSAGE, DEFAULT_ERROR_MESSAGE);
    }

    private Response getErrorResponse(final retrofit2.Response<?> response) {
        String jsonString = "ERROR ERROR";
        try {
            jsonString = response.errorBody().string();
//            Log.e(TAG, "getErrorResponse: "+jsonString, this.error);
            System.out.println(jsonString);
            Response response1 = new Gson().fromJson(jsonString, Response.class);
            response1.setLogMessage(jsonString);
            return response1;
        } catch (Exception e) {
            e.printStackTrace();
//            JSONObject jsonObject = null;
//            try {
//                jsonObject = new JSONObject(response.errorBody().string());
//            } catch (JSONException | IOException et) {
//                et.printStackTrace();
//            }
//            Gson gson = new Gson();
//            jsonString = gson.toJson(jsonObject);
//            Log.e(TAG, "getErrorResponse: "+jsonString, this.error);
            System.out.println(jsonString);
            return new Response(jsonString, DEFAULT_ERROR_MESSAGE, true);
//            return null;
        }
    }

    protected boolean getJsonStringFromResponse(final retrofit2.Response<?> response) {
        try {
            String jsonString = response.errorBody().string();
            Response errorResponse = new Gson().fromJson(jsonString, Response.class);
            return errorResponse.error;
        } catch (Exception e) {
            return false;
        }
    }

    protected String getMessageFromResponse(final retrofit2.Response<?> response) {
        try {
            String jsonString = response.errorBody().string();
            Response errorResponse = new Gson().fromJson(jsonString, Response.class);
            return errorResponse.message;
        } catch (Exception e) {
            return "Error";
        }
    }

    public Throwable getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetworkError that = (NetworkError) o;

        return error != null ? error.equals(that.error) : that.error == null;

    }

    @Override
    public int hashCode() {
        return error != null ? error.hashCode() : 0;
    }
}
