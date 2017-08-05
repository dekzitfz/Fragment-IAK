package id.dekz.fragmentiak;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEKZ on 8/5/2017.
 */

public class FragmentOne extends Fragment {

    private RecyclerView rv;
    private SimpleAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_one, container, false);

        rv = (RecyclerView) rootview.findViewById(R.id.rv);
        setupRV();
        return rootview;
    }

    private void setupRV(){
        adapter = new SimpleAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
        adapter.setData(getData());
    }

    private List<String> getData(){
        List<String> result = new ArrayList<>();
        result.add("Nougat");
        result.add("Marshmallow");
        result.add("Lolipop");

        return result;
    }
}
