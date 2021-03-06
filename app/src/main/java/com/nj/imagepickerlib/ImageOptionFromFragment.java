package com.nj.imagepickerlib;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nj.imagepicker.ImagePicker;
import com.nj.imagepicker.listener.ImageMultiResultListener;
import com.nj.imagepicker.result.ImageResult;
import com.nj.imagepicker.utils.DialogConfiguration;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageOptionFromFragment extends Fragment {

    private static final String LOG_TAG = "ImageOptionFromFragment";


    private ImageView ivImage;

    public ImageOptionFromFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_option_from, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivImage = (ImageView) view.findViewById(R.id.iv_image);
        view.findViewById(R.id.button_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }

    public void show() {
//        ImagePicker.build(new DialogConfiguration()
//                .setTitle("Choose")
//                .setResultImageDimension(1000,1000)
//                .setOptionOrientation(LinearLayoutCompat.HORIZONTAL), new ImageResultListener() {
//            @Override
//            public void onImageResult(ImageResult imageResult) {
//                Bitmap bitmap = imageResult.getBitmap();
//
//                Log.e(LOG_TAG, "onImageResult: "+bitmap.getWidth());
//
//                ivImage.setImageBitmap(bitmap);
//            }
//        }).show(getChildFragmentManager());


        ImagePicker.build(new DialogConfiguration()
                .setTitle("Choose")
                .setResultImageDimension(1000, 1000)
                .setOptionOrientation(LinearLayoutCompat.HORIZONTAL), new ImageMultiResultListener() {
            @Override
            public void onImageResult(ArrayList<ImageResult> imageResult) {
                Log.e(LOG_TAG, "onImageResult:Number of image picked " + imageResult.size());

                if (imageResult.size() > 0) {
                    ivImage.setImageBitmap(imageResult.get(0).getBitmap());
                }
            }
        }).show(getChildFragmentManager());
    }


}
