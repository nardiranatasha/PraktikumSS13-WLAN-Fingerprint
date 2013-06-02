package de.rwth.ti.wps;

import java.io.File;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import de.rwth.ti.common.Constants;

/**
 * This is the main activity class
 * 
 */
public class MainActivity extends SuperActivity implements OnClickListener {

	/** Called when the activity is first created. */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_localisation);

		// create app sd directory
		File f = new File(Constants.SD_APP_DIR);
		boolean check = f.mkdirs();
		if (check == false) {
			// XXX handle error
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		/*
		 * if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) { if
		 * (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
		 * getActionBar().setSelectedNavigationItem(
		 * savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM)); } }
		 */
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		/*
		 * if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
		 * outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
		 * .getSelectedNavigationIndex()); }
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	/** Called when the activity is first created or restarted */
	@Override
	public void onStart() {
		super.onStart();
		// storage.onStart();
		// scm.onStart();
		// cmgr.onStart();
		// TODO GUI don't show debug info on startup
	}

	/** Called when the activity is finishing or being destroyed by the system */
	@Override
	public void onStop() {
		super.onStop();
		// storage.onStop();
		// scm.onStop();
		// cmgr.onStop();
	}

	@Override
	public void onClick(View view) {
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Start other Activities, when the related MenuItem is selected
		// TextView textView = (TextView) findViewById(R.id.textStatus);
//		String text;
//		text = item.getTitle() + "\n" + Integer.toString(item.getItemId())
//				+ "\n";
		switch (item.getItemId()) {
		case R.id.action_localisation:
//			text += "Lokalisation";
			break;
		case R.id.menu_show_debug:
			// showDebug();
			return true;
		case R.id.menu_export:
			try {
				storage.exportDatabase(Constants.LOCAL_DB_NAME);
				// TODO GUI extract message
				Toast.makeText(getBaseContext(),
						"Datenbank erfolgreich exportiert", Toast.LENGTH_SHORT)
						.show();
			} catch (IOException e) {
				Toast.makeText(getBaseContext(), e.toString(),
						Toast.LENGTH_LONG).show();
			}
			return true;
		case R.id.menu_import:
			// FIXME GUI get user input for filename
			storage.importDatabase(Environment.getExternalStorageDirectory()
					+ File.separator + Constants.LOCAL_DB_NAME);
			// TODO GUI extract message
			Toast.makeText(getBaseContext(),
					"Datenbank erfolgreich importiert", Toast.LENGTH_SHORT)
					.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

		return true;
	}

	/*
	 * @Override public boolean onNavigationItemSelected(int position, long id)
	 * { // When the given dropdown item is selected, show its contents in the
	 * // container view. // TextView textView = (TextView)
	 * findViewById(R.id.textStatus); showDebug(); // Fragment fragment = new
	 * DummySectionFragment(); // Bundle args = new Bundle(); //
	 * args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1); //
	 * fragment.setArguments(args); //
	 * getSupportFragmentManager().beginTransaction() //
	 * .replace(R.id.container, fragment).commit(); return true; }
	 */

}
