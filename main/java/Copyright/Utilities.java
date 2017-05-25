package Copyright;

public class Utilities {


/*
 <ListView
 android:id="@+id/lista"
 android:layout_width="match_parent"
 android:layout_height="wrap_content" >
 </ListView>
 */


/*
    Bundle bundle = new Bundle();
    bundle.putString("string", valor);
    bundle.putInt("int", numero);

     Intent intent = new Intent(getBaseContext(), MinhaActivity.class);
     intent.putExtras(bundle);
     startActivity(intent);


     Na classe onde você deseja passar os parâmetros

     @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Bundle bundle = getIntent().getExtras();
    String texto = bundle.getString("string");
    int numero = bundle.getInt("int");
    }
 */

/*
    DateFormat df = android.text.format.DateFormat
    .getDateFormat(getApplicationContext());

    DateFormat hf = android.text.format.DateFormat
    .getTimeFormat(getApplicationContext());

    Date agora = new Date();

    df.format(agora);
    hf.format(agora);
 */

/*
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.GET_ACCOUNTS" />

    //TelephonyManager tMgr = (TelephonyManager)mAppContext.getSystemService(Context.TELEPHONY_SERVICE);
    //TelephonyManager tMgr = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
    //String mPhoneNumber = tMgr.getLine1Number();

    AccountManager accManager = AccountManager.get(context);
    Account acc[] = accManager.getAccounts();
    int accCount = acc.length;
    AppConstants.accOnDevice = new Vector<String>();
    for(int i = 0; i < accCount; i++){
    //preenche o(s) edittext com as conta(s) configura(s)
}


//TelephonyManager Mngr = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        //String PhoneNumber = Mngr.getLine1Number();
        //((EditText) findViewById(R.id.txtPhone)).setText(PhoneNumber);

 */


/*
//Location location = null;
        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 12.0f));

//mMap.moveCamera(CameraUpdateFactory.zoomTo(15f));
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(Cry.newLatLng(sydney));


        //mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));


 */
}
