package com.example.tan.testgallery;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Tan on 2/22/2018.
 */

public class GalleryFragment extends Fragment {
    private ArrayList<Actor> actorArrayList;
    private ActorAdapter actorAdapter;
    private RecyclerView recyclerViewActor;
    public ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actor, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        recyclerViewActor = (RecyclerView) view.findViewById(R.id.re_actor);

        new loadActorUrl(progressDialog).execute();
    }

    public class loadActorUrl extends AsyncTask<Void, Void, ArrayList<Actor>> implements ActorListener {

        ProgressDialog progressDialog;

        public loadActorUrl(ProgressDialog progressDialog) {
            this.progressDialog = progressDialog;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Loading...");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected ArrayList<Actor> doInBackground(Void... voids) {

            actorArrayList = new ArrayList<>();
            actorArrayList.add(new Actor("http://imgnews.naver.com/image/044/2017/05/23/20170523000807_0_20170525182009104.jpg"));
            actorArrayList.add(new Actor("http://blogfiles7.naver.net/data43/2009/4/2/131/kim_tae_hee_050070_yejeemiin.jpg"));
            actorArrayList.add(new Actor("http://blogfiles9.naver.net/20130319_279/hahmss_1363698261587KV7Cr_JPEG/2004082500391_whgdkgo3238.jpg"));
            actorArrayList.add(new Actor("http://blogfiles13.naver.net/20130626_109/gwmfruckwrl_1372250442404yDoNN_JPEG/3.jpg"));
            actorArrayList.add(new Actor("http://blogfiles13.naver.net/20120808_153/vziiojw_1344393198734irODX_JPEG/220px-LG_%BF%C9%C6%BC%B8%D3%BD%BA_3D__LG_%BD%C3%B3%D7%B8%B6_3D_TV_CF_%C3%D4%BF%B5_%BB%E7%C1%F8_%28cropped%29.jpg"));
            actorArrayList.add(new Actor("http://blogfiles7.naver.net/20160909_138/evasc21_1473430474677YIeX7_JPEG/704_2011953_146855.jpg"));
            actorArrayList.add(new Actor("http://imgnews.naver.com/image/416/2014/02/25/30000359395_59_20140225124505.jpg"));
            actorArrayList.add(new Actor("http://blogfiles1.naver.net/data17/2006/12/13/45/tehee01-xpvirus1004.jpg"));


            return actorArrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<Actor> actors) {
            super.onPostExecute(actors);

            if (actors != null) {
                progressDialog.dismiss();
                ActorAdapter actorAdapter = new ActorAdapter(getContext(), actorArrayList, this);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerViewActor.setLayoutManager(layoutManager);

                recyclerViewActor.setAdapter(actorAdapter);
                actorAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onClickDetail(int position) {
            DetailActorFragment fragment = new DetailActorFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constant.TAG_DETAIL, actorArrayList.get(position));
            fragment.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fr_main, fragment).addToBackStack("").commit();
        }
    }
}
