package com.sll.showbiggerimage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

public class ShowImageUtil {
   public static void show(@NonNull Activity activity, @NonNull View sharedElement, @NonNull String sharedElementName, @NonNull Bitmap bitmap){
//      Bundle bundle = new Bundle();
//      bundle.putParcelable("bitmap", bitmap);
//      Intent intent = new Intent(activity, TransitionActivity.class);
//      intent.putExtras(bundle);
      ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, sharedElement, sharedElementName);
      ActivityCompat.startActivity(activity,new Intent(activity, TransitionActivity.class) , compat.toBundle());

   }

}
