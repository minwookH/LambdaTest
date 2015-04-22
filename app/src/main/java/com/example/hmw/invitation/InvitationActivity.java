package com.example.hmw.invitation;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.example.hmw.lambdatest.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by Bill Minwook Heo on 15. 4. 16..
 */
@EActivity(R.layout.activity_invitation)
public class InvitationActivity extends Activity {


    /*public void initTask() {
        FacebookSdk.sdkInitialize(getApplicationContext());

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.facebook.samples.hellofacebook",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }*/

    @Click(R.id.kakaoButton)
    public void clickkakao() {
        //com.kakao.talk
        //jp.naver.line.android
        //com.tencent.mm

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setPackage("com.kakao.talk");
        intent.putExtra(Intent.EXTRA_TEXT, "AAA");
        intent.setType("text/plain");
        startActivity(intent);
    }

    @Click(R.id.LineButton)
    public void clickLine() {
        //com.kakao.talk
        //jp.naver.line.android
        //com.tencent.mm

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setPackage("jp.naver.line.android");
        intent.putExtra(Intent.EXTRA_TEXT, "AAA");
        intent.setType("text/plain");
        startActivity(intent);
    }

    @Click(R.id.WeChatButton)
    public void clickWeChat() {
        //com.kakao.talk
        //jp.naver.line.android
        //com.tencent.mm

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setPackage("com.tencent.mm");
        intent.putExtra(Intent.EXTRA_TEXT, "AAA");
        intent.setType("text/plain");
        startActivity(intent);
    }

    @Click(R.id.phoneButton)
    public void clickPhone() {
        //com.kakao.talk
        //jp.naver.line.android
        //com.tencent.mm

        /*Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        //intent.setType(ContactsContract.CommonDataKinds.Email.CONTENT_TYPE);
        intent.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(intent.createChooser(intent, "select email"), 0);*/

    }

    @Click(R.id.messengerButton)
    public void clickMessenger() {
        //com.facebook.orca
        //808900692521335

        String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
        String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
        int PROTOCOL_VERSION = 20150314;
        String YOUR_APP_ID = "432811923545730";
        int SHARE_TO_MESSENGER_REQUEST_CODE = 1;

        //String mimeType = "text/plain";
        String mimeType = "image/*";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setPackage("com.facebook.orca");
        intent.setType(mimeType);
        //intent.putExtra(Intent.EXTRA_STREAM, contentUri);
        intent.putExtra(Intent.EXTRA_TEXT, "[TEST] ABCEFGHI  www.jandi.com");

        intent.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION);
        intent.putExtra(EXTRA_APP_ID, YOUR_APP_ID);

        startActivityForResult(intent, SHARE_TO_MESSENGER_REQUEST_CODE);


        /*Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setPackage("com.facebook.orca");
        intent.putExtra(Intent.EXTRA_TEXT, "AAA");
        intent.setType("text/plain");
        startActivity(intent);*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("result : ", Integer.toString(resultCode));
        Log.i("result : ", Integer.toString(resultCode));
        Log.i("result : ", Integer.toString(resultCode));
        clickPhone();
        //Cursor cursor = managedQuery(data.getData(), null, null, null, null);
        /*Cursor cursor = getContentResolver().query(data.getData(), null, null, null, null);
        String email = null;
        if (cursor.moveToFirst()) {

            Log.i("getColumnCount : ", Integer.toString(cursor.getColumnCount()));
            Log.i("getCount : ", Integer.toString(cursor.getCount()));
            email = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS));
            Log.i("email : ", email);

            while (cursor.moveToNext()) {
                Log.i("moveToNext : ", "moveToNext");
                email = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS));
                Log.i("email : ", email);
            }

        }

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        String[] mailaddr = {email};

        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, mailaddr);

        startActivity(emailIntent);*/

        super.onActivityResult(requestCode, resultCode, data);
    }
}
