package com.ingoguilherme.ecomuseuguide.barcode.reader.zxing;

import com.ingoguilherme.ecomuseuguide.view.fragments.QRCodeFragment;
import com.journeyapps.barcodescanner.CaptureActivity;

/**
 * Created by IngoGuilherme on 13-May-16.
 */
public class CaptureActivityAnyOrientation extends CaptureActivity {


    //Só para mudar orientação da camera, não é necessário métodos

    @Override
    public void onBackPressed() {
        QRCodeFragment.isBackPressed = true;
        super.onBackPressed();
    }
}
