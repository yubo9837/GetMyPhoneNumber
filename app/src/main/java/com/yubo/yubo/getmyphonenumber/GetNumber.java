package com.yubo.yubo.getmyphonenumber;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yubo on 2016/7/15.
 */
public class GetNumber {
    public static List<PhoneInfo> lists=new ArrayList<PhoneInfo>();

    public static String getNumber(Context context){
        Cursor cursor=context.getContentResolver().query(Phone.CONTENT_URI,null,null,null,null);
        java.lang.String phoneNumber;
        String phoneName;
        while(cursor.moveToNext()){
            phoneName=cursor.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME));
            phoneNumber=cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
            PhoneInfo phoneInfo=new PhoneInfo(phoneName,phoneNumber);
            System.out.println(phoneName+":"+phoneNumber);
            lists.add(phoneInfo);
        }
        return null;
    }
}
