package under.the.bridge.pollingapp.utils;


import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import under.the.bridge.pollingapp.model.ApiResponseModel;
import under.the.bridge.pollingapp.model.PollLoginResponse;

/**
 * Created by ennur on 6/25/16.
 */
public class EndPointBridgeService {
    private final EndPointService endPointService;

    public EndPointBridgeService(@Nullable EndPointService endPointService) {
        this.endPointService = endPointService;
    }

//   public Subscription postCheckoutVa(final NicePayCallback response, String iMid, String paymethod, String currency
//		   , String amt, String ref, String goodsnm, String customer, String phone, String email, String dbprocess, String token, String bankcd) {
//	  return nicePayService.postCheckoutNonTagihan(iMid, paymethod, currency, amt, ref, goodsnm, customer, phone, email, dbprocess, token, bankcd)
//			  .observeOn(Schedulers.io())
//			  .onErrorResumeNext(new Func1<Throwable, Observable<? extends VaCheckoutResponse>>() {
//				 @Override
//				 public Observable<? extends VaCheckoutResponse> call(Throwable throwable) {
//					return Observable.error(throwable);
//				 }
//			  })
//			  .subscribe(new Subscriber<VaCheckoutResponse>() {
//				 @Override
//				 public void onCompleted() {
//
//				 }
//
//				 @Override
//				 public void onError(Throwable e) {
//					response.onError(new NetworkError(e));
//				 }
//
//				 @Override
//				 public void onNext(VaCheckoutResponse vaCheckoutResponse) {
//					response.onProfileSuccess((NicePayCallback) vaCheckoutResponse);
//				 }
//			  });
//   }

    public Subscription loginPoll(final GetCallbackResponse<PollLoginResponse> callbackApiResponse, String gId, String nm, String eml){
        return endPointService.loginPoll(
                gId,
                nm,
                eml
        )
                .subscribeOn(Schedulers.io())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends PollLoginResponse>>() {
                    @Override
                    public Observable<? extends PollLoginResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<PollLoginResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callbackApiResponse.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(PollLoginResponse pollLoginResponse) {
                        callbackApiResponse.onSuccess(pollLoginResponse);
                    }
                });
    }

    public interface GetCallbackList<T> {
        void onSuccess(List<T> responseList);

        void onError(NetworkError networkError);
    }

    public interface GetCallbackResponse<T> {
        void onSuccess(T response);

        void onError(NetworkError networkError);

    }
}
