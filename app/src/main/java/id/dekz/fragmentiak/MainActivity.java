package id.dekz.fragmentiak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isTablet = getApplicationContext().getResources().getBoolean(R.bool.isTablet);

        if(!isTablet){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.mycontainer, new FragmentOne())
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}
