package id.dekz.fragmentiak;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEKZ on 8/5/2017.
 */

public class FragmentOne extends Fragment implements SimpleAdapter.OnItemClickListener {

    private RecyclerView rv;
    private SimpleAdapter adapter;
    private boolean isTablet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_one, container, false);

        isTablet = getActivity().getResources().getBoolean(R.bool.isTablet);
        rv = (RecyclerView) rootview.findViewById(R.id.rv);
        setupRV();
        return rootview;
    }

    private void setupRV(){
        adapter = new SimpleAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
        adapter.setData(getData());
        adapter.setClickListener(this);
    }

    private List<String> getData(){
        List<String> result = new ArrayList<>();
        result.add("Nougat");
        result.add("Marshmallow");
        result.add("Lolipop");

        return result;
    }

    @Override
    public void onItemClick(String text) {
        if(isTablet){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container_right, FragmentTwo.newInstance(text))
                    .commit();
        }else{
            getFragmentManager().beginTransaction()
                    .replace(R.id.mycontainer, FragmentTwo.newInstance(text))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
