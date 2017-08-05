package id.dekz.fragmentiak;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by DEKZ on 8/5/2017.
 */

public class FragmentTwo extends Fragment {

    public static FragmentTwo newInstance(String text){
        FragmentTwo frag = new FragmentTwo();
        Bundle b = new Bundle();
        b.putString("text", text);
        frag.setArguments(b);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);

        ((TextView) v.findViewById(R.id.tv_detail))
                .setText(getArguments().getString("text"));

        return v;
    }
}
