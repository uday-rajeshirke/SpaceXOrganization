package com.uday.android.spacexorg.ui.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.network.model.launch.Launch;
import com.uday.android.spacexorg.network.postasynctask.NetworkWidgetAsyncTask;
import com.uday.android.spacexorg.network.postinterface.NetworkWidgetExecute;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NextLaunchAppWidget extends AppWidgetProvider {

    private Context mContext;
    private static final String formatPattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        new NetworkWidgetAsyncTask(new GetData(context,appWidgetManager,appWidgetIds)).execute();
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    private class GetData implements NetworkWidgetExecute {

        AppWidgetManager appWidgetManager;
        int[] appWidgetIds;

        GetData(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
            mContext = context;
            this.appWidgetManager = appWidgetManager;
            this.appWidgetIds = appWidgetIds;
        }

        public void getNextLaunch(Launch nextLaunch, Boolean isExecuted) {

            PendingIntent pendingIntent = getPendingIntent(mContext,appWidgetIds);
            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.widget_next_launch_app);

            if(isExecuted) {
                views.setTextViewText(R.id.txt_widget_mission_name, nextLaunch.getMissionName());
                views.setTextViewText(R.id.txt_widget_mission_countdown, dateDifference(nextLaunch.getLaunchDateUtc()));
            } else {
                views.setTextViewText(R.id.txt_widget_mission_name, mContext.getString(R.string.widget_no_data));
                views.setTextViewText(R.id.txt_widget_mission_countdown, mContext.getString(R.string.widget_no_connection));
            }
            views.setOnClickPendingIntent(R.id.btn_widget_refresh, pendingIntent);
            appWidgetManager.updateAppWidget(new ComponentName(mContext, NextLaunchAppWidget.class), views);

        }

    }

    private PendingIntent getPendingIntent(Context context, int[] ids) {
        Intent intent = new Intent(context, NextLaunchAppWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }


    private String dateDifference(String launchDateString) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatPattern, Locale.getDefault());

        Date currentDate = Calendar.getInstance().getTime();
        Date launchDate = null;
        try {
            launchDate = simpleDateFormat.parse(launchDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long different = (launchDate != null ? launchDate.getTime() : 0) - currentDate.getTime();

        long seconds = different / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        return  days + mContext.getString(R.string.countdown_format_days) +
                hours %24 + mContext.getString(R.string.countdown_format_hours) +
                minutes %60 + mContext.getString(R.string.countdown_format_mintues);

    }
}

