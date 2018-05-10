package dev.akakom.infodarurat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class ContentPertolongan extends ListFragment implements AdapterView.OnItemClickListener {

    String[] listLearn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        listLearn = new String[] {
            "Gempa Bumi",
            "Kebakaran",
            "Tsunami",
            "Banjir",
            "Longsor"
        };
        View v = inflater.inflate(R.layout.content_telepondarurat, container,false);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Planets, android.R.layout.simple_list_item_1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listLearn);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {

        switch( position )
        {
            case 0:

                Intent newActivity0 = new Intent(getActivity(), ActivityGempabumi.class);
                startActivity(newActivity0);
                break;
            case 1:  Intent newActivity1 = new Intent(getActivity(), ActivityKebakaran.class);
                startActivity(newActivity1);
                break;
            case 2:  Intent newActivity3 = new Intent(getActivity(), ActivityTsunami.class);
                startActivity(newActivity3);
                break;
            case 3:  Intent newActivity4 = new Intent(getActivity(), ActivityBanjir.class);
                startActivity(newActivity4);
                break;
            case 4:  Intent newActivity5 = new Intent(getActivity(), ActivityLongsor.class);
                startActivity(newActivity5);
                break;
            default: Toast.makeText(getActivity(), "belum tersedia", Toast.LENGTH_SHORT).show();
        }
    }
}
