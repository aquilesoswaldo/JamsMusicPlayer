/*
 * Copyright (C) 2014 Saravan Pantham
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jams.music.player.Drawers;

import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jams.music.player.R;
import com.jams.music.player.Helpers.TypefaceHelper;
import com.jams.music.player.Helpers.UIElementsHelper;
import com.jams.music.player.MainActivity.MainActivity;
import com.jams.music.player.Utils.Common;

public class NavigationDrawerAdapter extends ArrayAdapter<String> {

	private Context mContext;
	private SharedPreferences sharedPreferences;
	private ArrayList<String> mTitlesList;
   
    public NavigationDrawerAdapter(Context context, ArrayList<String> titlesList) {
    	super(context, R.layout.sliding_menu_browsers_layout, titlesList);
    	mContext = context;
    	mTitlesList = titlesList;
    	sharedPreferences = mContext.getSharedPreferences("com.jams.music.player", Context.MODE_PRIVATE);
    }
    
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
    	
    	SongsListViewHolder holder = null;
		if (convertView == null) {	
			convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_drawer_item, parent, false);
			holder = new SongsListViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.title);
			convertView.setTag(holder);
		} else {
		    holder = (SongsListViewHolder) convertView.getTag();
		}

		holder.title.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
		holder.title.setText(mTitlesList.get(position));
		holder.title.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));

		return convertView;

	}
    
	static class SongsListViewHolder {
	    public TextView title;
	}
   
}
