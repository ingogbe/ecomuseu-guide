package com.ingoguilherme.ecomuseuguide.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingoguilherme.ecomuseuguide.R;
import com.ingoguilherme.ecomuseuguide.barcode.reader.zxing.IntentIntegrator;
import com.ingoguilherme.ecomuseuguide.barcode.reader.zxing.IntentResult;
import com.ingoguilherme.ecomuseuguide.bo.Exposition;
import com.ingoguilherme.ecomuseuguide.bo.Language;
import com.ingoguilherme.ecomuseuguide.dao.controller.ExpositionDAO;
import com.ingoguilherme.ecomuseuguide.dao.controller.LanguageDAO;
import com.ingoguilherme.ecomuseuguide.dao.handler.DatabaseHandler;
import com.ingoguilherme.ecomuseuguide.view.activities.MainActivity;


/**
 * Created by IngoGuilherme on 04-May-16.
 */
public class QRCodeFragment extends Fragment {

    View rootView;

    public static boolean isBackPressed = false;

    private OnQRCodeFragmentInteractionListener mListener;

    public QRCodeFragment() {
        // Required empty public constructor
    }

    public static QRCodeFragment newInstance() {
        QRCodeFragment fragment = new QRCodeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntentIntegrator integrator = IntentIntegrator.forFragment(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt(getResources().getString(R.string.qr_code_scan));
        integrator.setOrientationLocked(false);
        integrator.setBeepEnabled(false);
        integrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(resultCode == getActivity().RESULT_OK) {
            IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
            if (scanResult != null) {
                Log.d("QR_CODE", scanResult.getContents());
                Log.d("QR_CODE", scanResult.getFormatName());

                DatabaseHandler dh = new DatabaseHandler(getContext());

                LanguageDAO languageDAO = new LanguageDAO(dh);
                Language language = languageDAO.queryCurrentSysLanguage();

                ExpositionDAO expositionDAO = new ExpositionDAO(dh);
                Exposition expo = expositionDAO.queryExpositionByQrCodeAndLanguage(scanResult.getContents(), language);

                if (expo.getId() != 0){
                    MainActivity.lastOpenedFragmentList.remove(this);
                    Fragment f = ExpositionFragment.newInstance(expo);
                    MainActivity.addLastOpenedFragment(f);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.your_placeholder, f);
                    ft.commit();
                }
                else{
                    IntentIntegrator integrator = IntentIntegrator.forFragment(this);
                    integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                    integrator.setPrompt(getResources().getString(R.string.qr_code_scan));
                    integrator.setOrientationLocked(false);
                    integrator.setBeepEnabled(false);
                    integrator.initiateScan();
                }
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_qrcode, container, false);

        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onQRCodeFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        if (context instanceof OnQRCodeFragmentInteractionListener) {
            mListener = (OnQRCodeFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnQRCodeFragmentInteractionListener {
        void onQRCodeFragmentInteraction(Uri uri);
    }
}
