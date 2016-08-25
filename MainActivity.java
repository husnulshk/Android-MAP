package com.unpam.map; 
 
import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 
 
import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.Menu; 
import android.view.View; 
import android.widget.AdapterView; 
import android.widget.AdapterView.OnItemClickListener; 
import android.widget.ListView; 
import android.widget.SimpleAdapter; 
import android.widget.TextView; 
 
import com.google.android.maps.MapController; 
import com.google.android.maps.MapView; 
 
public class MainActivity extends Activity implements 
OnItemClickListener { 
  List<Map<String, String>> items = new ArrayList<Map<String, 
String>>(); 
  ListView listView; 
  MapView mapView; 
  MapController mapController; 
   
  final static String PROPINSI = "propinsi"; 
  final static String IBUKOTA = "ibukota"; 
  final static String LONGITUDE = "longitude"; 
  final static String LATITUDE = "latitude"; 
 
  @Override 
  protected void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.activity_main); 
     
    TextView textView2 = (TextView) 
findViewById(R.id.textView2); 
    textView2.setText(""); 
     
    ListView listView = (ListView) 
findViewById(R.id.listView1); 
    listView.setOnItemClickListener(this); 
    registerForContextMenu(listView); 
    Map<String, String> map; 
     
    map = new HashMap<String, String>(); 
    map.put(PROPINSI, "Jawa Barat"); 
    map.put(IBUKOTA, "Bandung"); 
    map.put(LATITUDE, "-6.912063"); 
    map.put(LONGITUDE, "107.606084"); 
    items.add(map); 
     
    map = new HashMap<String, String>(); 
    map.put(PROPINSI, "Jawa Tengah"); 
    map.put(IBUKOTA, "Semarang"); 
    map.put(LATITUDE, "-6.970239"); 
    map.put(LONGITUDE, "110.424404"); 
    items.add(map); 
     
    map = new HashMap<String, String>(); 
    map.put(PROPINSI, "Jawa Timur"); 
    map.put(IBUKOTA, "Surabaya"); 
    map.put(LATITUDE, "-7.28866"); 
    map.put(LONGITUDE, "112.734311"); 
    items.add(map); 
     
    String[] from = new String[] { PROPINSI, IBUKOTA, 
LATITUDE, LONGITUDE }; 
    int[] to = new int[] { R.id.textView1, R.id.textView2 
}; 
    SimpleAdapter adapter = new SimpleAdapter(this, items, 
R.layout.activity_main, from, to); 
    listView.setAdapter(adapter); 
  } 
 
  @Override 
  public boolean onCreateOptionsMenu(Menu menu) { 
    // Inflate the menu; this adds items to the action bar if it is present. 
    getMenuInflater().inflate(R.menu.activity_main, menu); 
    return true; 
  } 
 
  @Override 
  public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
    // TODO Auto-generated method stub 
    Intent intent = new Intent(this, Peta.class); 
    intent.putExtra(PROPINSI, 
items.get(arg2).get(PROPINSI)); 
    intent.putExtra(IBUKOTA, items.get(arg2).get(IBUKOTA)); 
    intent.putExtra(LONGITUDE, 
items.get(arg2).get(LONGITUDE)); 
    intent.putExtra(LATITUDE, 
items.get(arg2).get(LATITUDE)); 
    startActivity(intent); 
  } 
 
}