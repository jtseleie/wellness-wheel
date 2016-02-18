package com.example.hsport.catalog;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WheelDisplay extends AppCompatActivity {

    public static final String wheelPrefs = "MyPrefs";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_display);

        drawWheel();
    }

    private Bitmap truncateBitmap(int iAmount, Bitmap bmpTruncate) {
        float bitamount = (float) (bmpTruncate.getWidth() * iAmount/100);
        int bitamountfinal = (int) bitamount;

        return Bitmap.createBitmap(bmpTruncate,0,0,bitamountfinal,bmpTruncate.getHeight());
    }

    public static Bitmap loadBitmap(Context context, String filename){
        AssetManager assets = context.getResources().getAssets();
        InputStream buf = null;
        try {
            buf = new BufferedInputStream(assets.open(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(buf);
        return bitmap;
    }

    private float getPieCoordinates (int position){
        final Integer WHEEL_OFFSET = 280;

         return (WHEEL_OFFSET + (10*position));
    }

    private void drawWheel(){
        sharedpreferences = getSharedPreferences(wheelPrefs, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();

        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.emptywheel) ;
        Bitmap bmpYellowWedge = BitmapFactory.decodeResource(getResources(),R.drawable.yellowwedge);
        Bitmap bmpGreenWedge = BitmapFactory.decodeResource(getResources(),R.drawable.greenwedge);
        Bitmap bmpPurpleWedge = BitmapFactory.decodeResource(getResources(),R.drawable.purplewedge);
        Bitmap bmpRedWedge = BitmapFactory.decodeResource(getResources(),R.drawable.redwedge);
        Bitmap bmpBlueWedge = BitmapFactory.decodeResource(getResources(),R.drawable.bluewedge);
        Bitmap bmpOrangeWedge = BitmapFactory.decodeResource(getResources(),R.drawable.orangewedge);

        ImageView myImageView = (ImageView) findViewById(R.id.FinishedWheel);
        Bitmap tempBitmap = Bitmap.createBitmap(myBitmap.getWidth(),myBitmap.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas tempCanvas = new Canvas(tempBitmap);

//        matrix.postRotate(getPieCoordinates(3), 0, bmpYellowWedge.getHeight());
//        matrix.postTranslate(tempCanvas.getWidth() / 2, tempCanvas.getHeight() / 2 - bmpYellowWedge.getHeight());

//        Bitmap testBitmap = truncateBitmap(75,bmpYellowWedge);

        for(int i=0; i<36; i++){
            Matrix matrix = new Matrix();
            matrix.postRotate(getPieCoordinates(i),0, bmpYellowWedge.getHeight());
            matrix.postTranslate(tempCanvas.getWidth() / 2, tempCanvas.getHeight() / 2 - bmpYellowWedge.getHeight());
            if(isBetween(i, 0, 5)){
                Bitmap bmpWorking = truncateBitmap(sharedpreferences.getInt("strWedge"+i, 0),bmpOrangeWedge.copy(bmpOrangeWedge.getConfig(),true));
                tempCanvas.drawBitmap(bmpWorking, matrix, null);
            }
            else if (isBetween(i, 6,11)){
                Bitmap bmpWorking = truncateBitmap(sharedpreferences.getInt("strWedge"+i, 0),bmpYellowWedge.copy(bmpYellowWedge.getConfig(),true));
                tempCanvas.drawBitmap(bmpWorking, matrix, null);
            }
            else if (isBetween(i, 12, 17)){
                Bitmap bmpWorking = truncateBitmap(sharedpreferences.getInt("strWedge"+i, 0),bmpBlueWedge.copy(bmpBlueWedge.getConfig(),true));
                tempCanvas.drawBitmap(bmpWorking, matrix, null);
            }
            else if (isBetween(i, 18, 23)){
                Bitmap bmpWorking = truncateBitmap(sharedpreferences.getInt("strWedge"+i, 0),bmpRedWedge.copy(bmpRedWedge.getConfig(),true));
                tempCanvas.drawBitmap(bmpWorking, matrix, null);
            }
            else if (isBetween(i, 24, 29)){
                Bitmap bmpWorking = truncateBitmap(sharedpreferences.getInt("strWedge"+i, 0),bmpGreenWedge.copy(bmpGreenWedge.getConfig(),true));
                tempCanvas.drawBitmap(bmpWorking, matrix, null);
            }
            else if (isBetween(i, 30, 35)){
                Bitmap bmpWorking = truncateBitmap(sharedpreferences.getInt("strWedge"+i, 0),bmpPurpleWedge.copy(bmpPurpleWedge.getConfig(),true));
                tempCanvas.drawBitmap(bmpWorking, matrix, null);
            }

        }

        tempCanvas.drawBitmap(myBitmap, 0,0,null);
        myImageView.setImageDrawable(new BitmapDrawable(getResources(), tempBitmap));
    }

    public static boolean isBetween(int x, int lower, int upper){
        return lower <= x && x <= upper;
    }
}
