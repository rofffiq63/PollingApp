package under.the.bridge.pollingapp.utils;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;
import under.the.bridge.pollingapp.model.DisablePoll;
import under.the.bridge.pollingapp.model.PollLoginResponse;
import under.the.bridge.pollingapp.model.PollingData;
import under.the.bridge.pollingapp.model.PollingRating;
import under.the.bridge.pollingapp.model.PollingReview;
import under.the.bridge.pollingapp.model.PollingStore;

/**
 * Created by ennur on 6/25/16.
 */
public interface EndPointService {

    @POST("login")
    @FormUrlEncoded
    Observable<PollLoginResponse> loginPoll(@Field("google_id") String gId, @Field("name") String nm, @Field("email") String eml);

    @GET("polls")
    Observable<PollingData> getPolls();

    @POST("polls/rating")
    @FormUrlEncoded
    Observable<PollingRating> postPollingRating(@Field("poll_id") String pollId, @Field("rating") String rating, @Field("user_id") String userId);

    @POST("polls/store")
    @FormUrlEncoded
    Observable<PollingStore> postNewPolling(@Field("title") String title, @Field("description") String desc, @Field("user_id") String userId, @Field("type") String type);

    @POST("polls/review")
    @FormUrlEncoded
    Observable<PollingReview> postPollsReview(@Field("poll_id") String pollId, @Field("user_id") String userId, @Field("review") String review);

    @POST("polls/byuser_id")
    @FormUrlEncoded
    Observable<PollingData> getPollsByUser(@Field("user_id") String userId);

    @POST("polls/destroy")
    @FormUrlEncoded
    Observable<DisablePoll> postDestroyPoll(@Field("poll_id") String pollId);

}
