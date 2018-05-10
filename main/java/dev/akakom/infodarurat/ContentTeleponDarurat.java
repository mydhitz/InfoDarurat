package dev.akakom.infodarurat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class ContentTeleponDarurat extends ListFragment implements AdapterView.OnItemClickListener {

    String[] listPeserta;
    String[] listTelepon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        listPeserta = new String[] {
            "Ambulan",
            "Pemadam Kebakaran",
            "Polisi",
            "SAR",
            "PMI",
            "Posko Bencana Alam",
            "Sentra Informasi Keracunan",
            "Posko Kewaspadaan Nasional",
            "Info dan Perbaikan Gangguan Listrik",
            "Info dan Perbaikan Gangguan Telepon",
            "PLN",
            "Pencegahan Bunuh Diri"
        };

        listTelepon = new String[] {
            "118",
            "113",
            "110",
            "115",
            "0214207051",
            "129",
            "0214250767",
            "122",
            "123",
            "117",
            "123",
            "0217256526"
        };

        View v = inflater.inflate(R.layout.content_telepondarurat, container,false);
        return v;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Planets, android.R.layout.simple_list_item_1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listPeserta);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {

        if (position > listTelepon.length) {
            Toast.makeText(getActivity(), "Nomor telepon belum tersedia", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + listTelepon[position]));
            startActivity(intent);
        }
    }
}
