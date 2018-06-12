package openplatform.openplatform_finalproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.android.volley.RequestQueue;
//import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.Auth;
//import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
//import com.google.android.gms.common.api.ApiException;
//import com.google.android.gms.common.logging.Logger;
//import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.ConnectionResult;
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.JsonHttpResponseHandler;
//import com.loopj.android.http.RequestParams;

//import org.json.JSONArray;
//import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener{

    static final int NUM_ITEMS = 2; //在這更改page的數量
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private FirebaseAuth mFirebaseAuth=FirebaseAuth.getInstance();;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.tt);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.logsign);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setupWithViewPager(mViewPager);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode
            , Intent data) {

        if (requestCode ==
                555) {

            GoogleSignInResult result = Auth.GoogleSignInApi
                    .getSignInResultFromIntent(data);

            if (result.isSuccess()){
                GoogleSignInAccount account
                        = result.getSignInAccount();

                Log.d("","getDisplayName"+account.getDisplayName());
                Log.d("","getId"+account.getId());
                Log.d("","getEmail"+account.getEmail());
            }else{
                Log.d("","Google sign in fail");
            }
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d("Login_layout", "onConnectionFailed:" + connectionResult);
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
    public static class loginFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.login_fragment, container, false);
            final TextView mailText = (TextView) rootView.findViewById(R.id.loginMailText);
            mailText.setText("email : ");
            mailText.setTextColor(Color.parseColor("#000000"));
            final EditText inputMail = (EditText) rootView.findViewById(R.id.loginMail);
            inputMail.setHint("Hao123@gmail.com");

            final TextView passwordText = (TextView) rootView.findViewById(R.id.loginPasswordText);
            passwordText.setText("password : ");
            passwordText.setTextColor(Color.parseColor("#000000"));
            final EditText inputPassword = (EditText) rootView.findViewById(R.id.loginPassword);

            Button othrerLogInButton = (Button) rootView.findViewById(R.id.loginButton2);
            othrerLogInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    final String[] thirdLogin = {"Google"};
//                    AlertDialog.Builder dialog_list = new AlertDialog.Builder(getActivity());
//                    dialog_list.setTitle("利用List呈現");
//                    dialog_list.setItems(thirdLogin, new DialogInterface.OnClickListener(){
//                        @Override
//
//                        //只要你在onClick處理事件內，使用which參數，就可以知道按下陣列裡的哪一個了
//                        public void onClick(DialogInterface dialog, int which) {
//                            // TODO Auto-generated method stub
//                            Toast.makeText(getActivity(), "你選的是" + thirdLogin[which], Toast.LENGTH_SHORT).show();
//                            switch (which){
//                                case 0:
//                                {
//
//                                }
//                            }
//                        }
//                    });
//                    dialog_list.show();
                }
            });

            Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            return rootView;
        }
    }

    public static class signupFragment extends Fragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.signup_fragment, container, false);
            final TextView userText = (TextView) rootView.findViewById(R.id.signupUserText);
            userText.setText("username : ");
            userText.setTextColor(Color.parseColor("#000000"));
            final EditText inputUser = (EditText) rootView.findViewById(R.id.signupUser);
            inputUser.setHint("bob666");

            final TextView mailText = (TextView) rootView.findViewById(R.id.signupMailText);
            mailText.setText("email : ");
            mailText.setTextColor(Color.parseColor("#000000"));
            final EditText inputMail = (EditText) rootView.findViewById(R.id.signupMail);
            inputMail.setHint("Hao123@gmail.com");

            final TextView passwordText = (TextView) rootView.findViewById(R.id.signupPasswordText);
            passwordText.setText("password : ");
            passwordText.setTextColor(Color.parseColor("#000000"));
            final EditText inputPassword = (EditText) rootView.findViewById(R.id.signupPassword);

            Button signupButton = (Button) rootView.findViewById(R.id.signupButton);
            signupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        Fragment fragment;

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            switch (position) {
                case 0:
                    fragment = new loginFragment();
                    return fragment;
                case 1:
                    fragment = new signupFragment();
                    return fragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return NUM_ITEMS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Log In";
                case 1:
                    return "Sign Up";
            }
            return null;
        }
    }

}
