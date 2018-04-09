package com.fc.hft.zjghjiudian.ui.my;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.fc.hft.zjghjiudian.R;
import com.fc.hft.zjghjiudian.activity.LoginActivity;
import com.fc.hft.zjghjiudian.api.Api;
import com.fc.hft.zjghjiudian.utils.UserInfoUtils;
import com.orhanobut.hawk.Hawk;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2018/3/6/006.
 */

public class MyFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.tv_shopname)
    TextView tvShopname;
    @BindView(R.id.tv_admin)
    TextView tvAdmin;
    @BindView(R.id.tv_myaddress)
    TextView tvMyaddress;
    @BindView(R.id.layout_shop_info)
    LinearLayout layoutShopInfo;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.iv_order)
    ImageView ivOrder;
    @BindView(R.id.layout_my_shop)
    LinearLayout layoutMyShop;
    @BindView(R.id.tv_adress)
    TextView tvAdress;
    @BindView(R.id.iv_adress)
    ImageView ivAdress;
    @BindView(R.id.layout_myhome_advice)
    LinearLayout layoutMyhomeAdvice;
    @BindView(R.id.iv_about)
    ImageView ivAbout;
    @BindView(R.id.layout_myhome_about)
    LinearLayout layoutMyhomeAbout;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.layout_myhome_set)
    LinearLayout layoutMyhomeSet;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.iv_showlogo)
    CircleImageView ivShowlogo;
    private static int RESULT_LOAD_IMAGE = 1;
    private View view;

    private static final int PHOTO_REQUEST_CAREMA = 1;
    private static final int PHOTO_REQUEST_GALLERY = 2;
    private static final int PHOTO_REQUEST_CUT = 3;
    private File tempFile;
    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_myhome, container, false);
        unbinder = ButterKnife.bind(this, view);
        Glide.with(getActivity()).load(Api.IMAGE_URL + Hawk.get(UserInfoUtils.imagePath)).error(R.drawable.logn).into(ivShowlogo);
        Log.i("TAG", "++++++++" + Hawk.get("imagePath"));
        tvShopname.setText(Hawk.get(UserInfoUtils.name) + "");
        tvAdmin.setText(Hawk.get(UserInfoUtils.phone) + "");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @OnClick({R.id.iv_showlogo, R.id.iv_order, R.id.iv_adress, R.id.iv_about, R.id.iv_setting, R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_showlogo:
                //Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // startActivityForResult(intent, RESULT_LOAD_IMAGE);
                changeHeadIcon();
                break;
            case R.id.iv_order:
                break;
            case R.id.iv_adress:
                break;
            case R.id.iv_about:
                break;
            case R.id.iv_setting:
                break;
            case R.id.btn_back:
                Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent2);
                getActivity().finish();
                break;
        }
    }

    private void changeHeadIcon() {
        final CharSequence[] items = {"拍照", "相册"};
        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle("选择图片")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (Environment.getExternalStorageState().equals(
                                    Environment.MEDIA_MOUNTED)) {
                                tempFile = new File(Environment
                                        .getExternalStorageDirectory(),
                                        PHOTO_FILE_NAME);
                                Uri uri = Uri.fromFile(tempFile);
                                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                                startActivityForResult(intent,
                                        PHOTO_REQUEST_CAREMA);
                            } else {
                                Toast.makeText(getContext(), "未找到存储卡，无法存储照片！",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Intent intent = new Intent(Intent.ACTION_PICK);
                            intent.setType("image/*");
                            startActivityForResult(intent,
                                    PHOTO_REQUEST_GALLERY);
                        }
                    }
                }).create();
        dialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       /* if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {

            //获取返回的数据，这里是android自定义的Uri地址
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            //获取选择照片的数据视图
            Cursor cursor =getContext().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            //从数据视图中获取已选择图片的路径
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            //将图片显示到界面上
           //ImageView imageView = (ImageView) findViewById(R.id.imgView);
            ImageView imageView = view.findViewById(R.id.iv_showlogo);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }*/
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            if (data != null) {
                Uri uri = data.getData();
                Log.e("图片路径？？", data.getData() + "");
                crop(uri);
            }

        } else if (requestCode == PHOTO_REQUEST_CAREMA) {
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                crop(Uri.fromFile(tempFile));
            } else {
                Toast.makeText(getContext(), "未找到存储卡，无法存储照片！",
                        Toast.LENGTH_SHORT).show();
            }

        } else if (requestCode == PHOTO_REQUEST_CUT) {
            if (data != null) {
                final Bitmap bitmap = data.getParcelableExtra("data");
                ivShowlogo.setImageBitmap(bitmap);
                // 保存图片到internal storage
                FileOutputStream outputStream;
                try {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                    out.flush();
                    // out.close();
                    // final byte[] buffer = out.toByteArray();
                    // outputStream.write(buffer);
                    outputStream = getContext().openFileOutput("_head_icon.jpg",
                            Context.MODE_PRIVATE);
                    out.writeTo(outputStream);
                    out.close();
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                if (tempFile != null && tempFile.exists())
                    tempFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void crop(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }


}
