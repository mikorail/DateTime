package com.example.datetime;

import android.app.DatePickerDialog;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;
import java.text.DateFormat;

/**
 * Implementation of App Widget functionality.
 */
public class JamTanggal extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        String timeClock= DateFormat.getTimeInstance(DateFormat.SHORT).format(new Date());
        SimpleDateFormat parseFormat = new SimpleDateFormat("E MMMM dd");
        Date date =new Date();
        String dateDay =parseFormat.format(date); ;
        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.jam_tanggal);
        views.setTextViewText(R.id.jam,timeClock);
        views.setTextViewText(R.id.tanggal,dateDay);

        //getting somewhere
        Intent intentUpdate = new Intent(context,JamTanggal.class);
        intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);



        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

