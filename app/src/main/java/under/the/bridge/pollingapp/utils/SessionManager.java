package under.the.bridge.pollingapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import under.the.bridge.pollingapp.R;

/**
 * Created by User on 12/8/17.
 */

public class SessionManager {

    private static final String KEY_USER = "loggedIn_as";
    private static final String USER_TOKEN = "stringToken_";
    private static final String KEY_LOGIN = "isLogin";
    private static final String KEY_FIRST_RUN = "isFirstRun";
    private static final String INTRO_SHOWN = "isFirstRun";
    static SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context c;
    //0 agar cuma bsa dibaca hp itu sendiri
    String PREF_NAME = "LoginStat";
    String userToken;
    boolean introShown;
    private int PRIVATE_MODE = 0;

    //konstruktor
    public SessionManager(Context context) {
        this.c = context;
        pref = c.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public boolean getState() {
        return pref.getBoolean(KEY_LOGIN, false);
    }

    //membuat session login
    public void createLoginSession(int userid, String token, boolean state) {
        editor.putInt(KEY_USER, userid);
        editor.putString(USER_TOKEN, token);
        editor.putBoolean(KEY_LOGIN, state);
        editor.commit();
        //commit digunakan untuk menyimpan perubahan
    }

    public void updateSession(boolean state) {
        editor.putBoolean(KEY_LOGIN, state);
        editor.commit();
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    //mendapatkan token
    public Integer getKeyUser() {
        return pref.getInt(KEY_USER, 0);
    }

    public String getTokenUser() {
        return pref.getString(USER_TOKEN, "996e8f4eaba48cc98bd0baba50b4e5d0a61cfa4e");
    }

    public boolean getFirstRun() {
        return pref.getBoolean(KEY_FIRST_RUN, true);
    }

    public void setFirstRun(boolean state) {
        editor.putBoolean(KEY_FIRST_RUN, state);
        editor.commit();
    }

    //cek login
    public boolean isLogin() {
        return pref.getBoolean(KEY_LOGIN, false);
    }

    //logout user
    public void logout(boolean restart) {
        setFirstRun(true);
        updateSession(false);
        editor.clear();
//        if (restart)
//            ((BaseActivity) c).restartApp();
    }

    public String getIsAgent() {
        return pref.getString("agent", "");
    }

    public void setIsAgent(String isAgent) {
        editor.putString("agent", isAgent);
        editor.commit();
    }

    public String getIsUpload() {
        return pref.getString("upload", "");
    }

    public void setIsUpload(String isUpload) {
        editor.putString("upload", isUpload);
        editor.commit();
    }

    public void setTotalAffiliasi(String totalAffiliasi) {
        editor.putString("affiliasi", totalAffiliasi);
        editor.commit();
    }

    public String getAffiliasi() {
        return pref.getString("affiliasi", "");
    }

    public String getTotalPendapatan() {
        return pref.getString("pendapatan", "");
    }

    public void setTotalPendapatan(String totalPendapatan) {
        editor.putString("pendapatan", totalPendapatan);
        editor.commit();
    }

    public String getKodeAffiliasi() {
        return pref.getString("kodeAff", "");
    }

    public void setKodeAffiliasi(String kodeAffiliasi) {
        editor.putString("kodeAff", kodeAffiliasi);
        editor.commit();
    }

    public String getNamaAgen() {
        return pref.getString("namaAgen", "");
    }

    public void setNamaAgen(String namaAgen) {
        editor.putString("namaAgen", namaAgen);
        editor.commit();
    }

    public String getGender() {
        return pref.getString("gender", "");
    }

    public void setGender(String gender) {
        editor.putString("gender", gender);
        editor.commit();
    }

    public String getBorn() {
        return pref.getString("born", "");
    }

    public void setBorn(String born) {
        editor.putString("born", born);
        editor.commit();
    }

    public String getPoin() {
        return pref.getString("poin", "");
    }

    public void setPoin(String poin) {
        editor.putString("poin", poin);
        editor.commit();
    }

    public String getWallet() {
        return pref.getString("wallet", "");
    }

    public void setWallet(double wallet) {
        editor.putString("wallet", String.valueOf(wallet));
        editor.commit();
    }

    public String getNama() {
        return pref.getString("nama", "");
    }

    public void setNama(String nama) {
        editor.putString("nama", nama);
        editor.commit();
    }

    public String getUsername() {
        return pref.getString("nama", "");
    }

    public void setUsername(String username) {
        editor.putString("username", username);
        editor.commit();
    }

    public String getId() {
        return pref.getString("id", "");
    }

    public void setId(String id) {
        editor.putString("id", id);
        editor.commit();
    }

    public String getEmail() {
        return pref.getString("email", "");
    }

    public void setEmail(String email) {
        editor.putString("email", email);
        editor.commit();
    }

    public String getFoto() {
        return pref.getString("foto", "");
    }

    public void setFoto(String foto) {
        editor.putString("foto", foto);
        editor.commit();
    }

    public String getPhone() {
        return pref.getString("phone", "");
    }

    public void setPhone(String phone) {
        editor.putString("phone", phone);
        editor.commit();
    }

    public boolean getFacebook() {
        return pref.getBoolean("facebook", false);
    }

    public void setFacebook(boolean status) {
        editor.putBoolean("facebook", status);
        editor.commit();
    }

    public boolean getUpgrade() {
        return pref.getBoolean("upgrade", false);
    }

    public void setUpgrade(boolean status) {
        editor.putBoolean("upgrade", status);
        editor.commit();
    }

//    public String getFirebaseInstanceId() {
////        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        String key = c.getString(R.string.pref_firebase_instance_id_key);
//        String default_value = c.getString(R.string.pref_firebase_instance_id_default_key);
//        return pref.getString(key, default_value);
//    }
//
//    public void setFirebaseInstanceId(String InstanceId) {
////        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
////        SharedPreferences.Editor editor;
////        editor = pref.edit();
//        editor.putString(c.getString(R.string.pref_firebase_instance_id_key), InstanceId);
//        editor.apply();
//    }

    public boolean isIntroShown() {
        return pref.getBoolean(INTRO_SHOWN, false);
//        return introShown;
    }

    public void setIntroShown(boolean introShown) {
        editor.putBoolean(INTRO_SHOWN, introShown);
        editor.commit();
//        this.introShown = introShown;
    }
}
