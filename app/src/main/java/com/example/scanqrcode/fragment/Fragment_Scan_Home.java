package com.example.scanqrcode.fragment;

import static androidx.viewpager.widget.ViewPager.*;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.scanqrcode.R;
import com.google.android.material.snackbar.Snackbar;

public class Fragment_Scan_Home extends Fragment{
    View view;
    boolean cameraPer = false;

    int requestPer = 10000;

//    private int requestCode = 10000;


    Button taolao;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setting, container, false);
        taolao = view.findViewById(R.id.bb);
        taolao.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.CAMERA)){
                        Snackbar.make(getView(),"Cấp quyền đi",Snackbar.LENGTH_INDEFINITE).setAction("ok", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},1);
                            }
                        }).show();
                    }
                    else {
                        // Quyền truy cập chưa được cấp, hỏi trực tiêp người dùng.
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA},1);
                    }
                    } else {
                        Fragment_Scan fragment2 = new Fragment_Scan();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment1, fragment2);
                        fragmentTransaction.addToBackStack(null);
                        taolao.setVisibility(INVISIBLE);
                        fragmentTransaction.commit();
                    }
                }


        });
        return view;
    }
//    public void onClick2(View view) {
//        Fragment2 fragment2 = new Fragment2();
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment1, fragment2);
//        fragmentTransaction.commit();
//    }

    private void CheckPermission() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CAMERA)) {
                    new AlertDialog.Builder(getActivity()).setCancelable(false).setTitle("Chưa cấp quyền cam")
                            .setMessage("Mày có cấp quyền không thì bảo")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
                                }
                            }).show();
                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CAMERA)) {
                    Toast.makeText(getActivity(), "Giề", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", view.getContext().getPackageName(),  null);
                    intent.setData(uri);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Nè", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getActivity(), "Hẻ", Toast.LENGTH_LONG).show();
            }
        }
    }

//    private void CheckPermission() {
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
//            if (ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ){
//                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},requestPer);
//            }else {
//                mCodeScanner.startPreview();
//                cameraPer = true;
//            }
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if(requestCode == requestPer) {
//
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                mCodeScanner.startPreview();
//                cameraPer = true;
//            } else {
//                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CAMERA)) {
//                    new AlertDialog.Builder(getActivity())
//                            .setTitle("Permission")
//                            .setMessage("Vui lòng cung cấp quyền cho camera.")
//                            .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, requestPer);
//                                }
//                            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dialogInterface.dismiss();
//                        }
//                    }).create().show();
//                } else {
//                    new AlertDialog.Builder(getActivity()).
//                            setTitle("Permission").
//                            setMessage("Chỉ có thể quét khi có quyền truy cập vào camera.").
//                            setPositiveButton("Settings", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    dialogInterface.dismiss();
//                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
//                                            Uri.fromParts("pakage", view.getContext().getPackageName(), null));
//                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                    startActivity(intent);
//                                    getActivity().finish();
//                                }
//                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dialogInterface.dismiss();
//                            getActivity().finish();
//                        }
//                    }).create().show();
//                }
//            }
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
}