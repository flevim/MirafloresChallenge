package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        anywheresoftware.b4a.samples.httputils2.httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.ioio.B4AIOIO _yoyo = null;
public static anywheresoftware.b4a.objects.Timer _relojluz = null;
public static anywheresoftware.b4a.objects.Timer _relojpot = null;
public static anywheresoftware.b4a.ioio.B4AIOIO.B4AAnalogueInputWrapper _sensorluz = null;
public static anywheresoftware.b4a.ioio.B4AIOIO.B4AAnalogueInputWrapper _sensorhum = null;
public static anywheresoftware.b4a.ioio.B4AIOIO.B4AAnalogueInputWrapper _pot = null;
public anywheresoftware.b4a.objects.TabHostWrapper _tab_vistas = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listview1 = null;
public static String _serverip = "";
public static int _progresoluz = 0;
public static int _progresopot = 0;
public anywheresoftware.b4a.objects.ProgressBarWrapper _barraprogluz = null;
public anywheresoftware.b4a.objects.ProgressBarWrapper _barraprogpot = null;
public anywheresoftware.b4a.objects.Serial.BluetoothAdmin _btadmin = null;
public static float _valoranalogoluz = 0f;
public static float _valoranalogopot = 0f;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.samples.httputils2.httpjob _savedata = null;
public anywheresoftware.b4a.samples.httputils2.httpjob _updatedata = null;
public anywheresoftware.b4a.samples.httputils2.httpjob _readdata = null;
public anywheresoftware.b4a.samples.httputils2.httpjob _deletedata = null;
public static String _url = "";
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.example.starter _starter = null;
public static void  _activity_create(boolean _firsttime) throws Exception{
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.main parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
b4a.example.main parent;
boolean _firsttime;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";
Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
if (true) return;
    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Activity.LoadLayout(\"main\")";
parent.mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="URL = \"https://3def-200-2-119-118.sa.ngrok.io/\"";
parent.mostCurrent._url = "https://3def-200-2-119-118.sa.ngrok.io/";
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="If FirstTime Then";
if (true) break;

case 1:
//if
this.state = 8;
if (_firsttime) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="BtAdmin.Initialize(\"BtAdmin\")";
parent.mostCurrent._btadmin.Initialize(processBA,"BtAdmin");
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="If YOYO.IsInitialized=False Then";
if (true) break;

case 4:
//if
this.state = 7;
if (parent._yoyo.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Conectar_IOIO";
_conectar_ioio();
 if (true) break;

case 7:
//C
this.state = 8;
;
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="relojLuz.Initialize(\"relojLuz\", 100)";
parent._relojluz.Initialize(processBA,"relojLuz",(long) (100));
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="relojPot.Initialize(\"relojPot\", 100)";
parent._relojpot.Initialize(processBA,"relojPot",(long) (100));
 if (true) break;

case 8:
//C
this.state = 9;
;
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="tab_vistas.AddTab(\"General\", \"design_savedata\")";
parent.mostCurrent._tab_vistas.AddTab(mostCurrent.activityBA,"General","design_savedata");
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="tab_vistas.AddTab(\"Temperatura\", \"tabtemp\")";
parent.mostCurrent._tab_vistas.AddTab(mostCurrent.activityBA,"Temperatura","tabtemp");
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="tab_vistas.AddTab(\"Humedad\", \"tabhum\")";
parent.mostCurrent._tab_vistas.AddTab(mostCurrent.activityBA,"Humedad","tabhum");
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="tab_vistas.AddTab(\"Humedad de Suelo\", \"tabhumsuel";
parent.mostCurrent._tab_vistas.AddTab(mostCurrent.activityBA,"Humedad de Suelo","tabhumsuelo");
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="tab_vistas.CurrentTab = 1";
parent.mostCurrent._tab_vistas.setCurrentTab((int) (1));
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="Do While True";
if (true) break;

case 9:
//do while
this.state = 12;
while (anywheresoftware.b4a.keywords.Common.True) {
this.state = 11;
if (true) break;
}
if (true) break;

case 11:
//C
this.state = 9;
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="saveDataDB";
_savedatadb();
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="Sleep(10000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (10000));
this.state = 13;
return;
case 13:
//C
this.state = 9;
;
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _conectar_ioio() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "conectar_ioio"))
	return (String) Debug.delegate(mostCurrent.activityBA, "conectar_ioio", null);
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Conectar_IOIO";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="YOYO.Initialize";
_yoyo.Initialize();
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="If BtAdmin.IsEnabled Then YOYO.Connect(\"yoyo\",YOY";
if (mostCurrent._btadmin.IsEnabled()) { 
_yoyo.Connect(processBA,"yoyo",_yoyo.CONN_BT,(int) (1),(int) (0));};
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="End Sub";
return "";
}
public static String  _savedatadb() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "savedatadb"))
	return (String) Debug.delegate(mostCurrent.activityBA, "savedatadb", null);
String _hoy = "";
String _hora = "";
String _datasend = "";
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub saveDataDB";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Dim hoy, hora As String";
_hoy = "";
_hora = "";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Dim datasend As String";
_datasend = "";
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\" 'fecha";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy-MM-dd");
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="DateTime.TimeFormat = \"hh-mm-ss\"  'hora";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("hh-mm-ss");
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="hoy = DateTime.Date(DateTime.Now)";
_hoy = anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="hora = DateTime.Time(DateTime.Now)";
_hora = anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="Log(hoy)";
anywheresoftware.b4a.keywords.Common.Log(_hoy);
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="Log(hora)";
anywheresoftware.b4a.keywords.Common.Log(_hora);
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="datasend = \"fecha=\"&hoy&\"&hora=\"&hora&\"&humedad=\"";
_datasend = "fecha="+_hoy+"&hora="+_hora+"&humedad="+BA.NumberToString(_valoranalogopot)+"&luz="+BA.NumberToString(_valoranalogoluz);
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="saveData.Initialize(\"savedata\", Me)";
mostCurrent._savedata._initialize(processBA,"savedata",main.getObject());
RDebugUtils.currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="saveData.PostString(URL&\"guardar_dato\", datasend)";
mostCurrent._savedata._poststring(mostCurrent._url+"guardar_dato",_datasend);
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="Log(saveData)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(mostCurrent._savedata));
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="If UserClosed Then";
if (_userclosed) { 
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Desconectar_IOIO";
_desconectar_ioio();
 };
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="End Sub";
return "";
}
public static String  _desconectar_ioio() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "desconectar_ioio"))
	return (String) Debug.delegate(mostCurrent.activityBA, "desconectar_ioio", null);
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub Desconectar_IOIO";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="sensorLuz.Close";
_sensorluz.Close();
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="sensorHum.Close";
_sensorhum.Close();
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="pot.Close";
_pot.Close();
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="YOYO.Disconnect";
_yoyo.Disconnect(processBA);
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _conexion_pines() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "conexion_pines"))
	return (String) Debug.delegate(mostCurrent.activityBA, "conexion_pines", null);
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Conexion_pines";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="YOYO.OpenAnalogInput(\"sensorluz\",39)";
_yoyo.OpenAnalogInput(processBA,"sensorluz",(int) (39));
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="YOYO.OpenAnalogInput(\"potenciometro\",40)";
_yoyo.OpenAnalogInput(processBA,"potenciometro",(int) (40));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="YOYO.OpenAnalogInput(\"humedad\",41)";
_yoyo.OpenAnalogInput(processBA,"humedad",(int) (41));
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone"))
	return (String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job});
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub JobDone (job As HttpJob)";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Select job";
switch (BA.switchObjectToInt(_job,mostCurrent._savedata)) {
case 0: {
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="If job.Success Then";
if (_job._success) { 
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="Log(job.GetString)";
anywheresoftware.b4a.keywords.Common.Log(_job._getstring());
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="ToastMessageShow(\"Saved\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Saved"),anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="ToastMessageShow(\"Error: \"&job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="saveData.Release";
mostCurrent._savedata._release();
 break; }
}
;
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="End Sub";
return "";
}
public static String  _potenciometro_open(boolean _noerror,Object _result) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "potenciometro_open"))
	return (String) Debug.delegate(mostCurrent.activityBA, "potenciometro_open", new Object[] {_noerror,_result});
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub potenciometro_open(noerror As Boolean, result";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="If noerror Then";
if (_noerror) { 
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="pot = result";
_pot.setObject((ioio.lib.api.AnalogInput)(_result));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="relojPot.Enabled = True";
_relojpot.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="Log(\"Error: \"&LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="End Sub";
return "";
}
public static String  _relojluz_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "relojluz_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "relojluz_tick", null);
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub relojLuz_Tick";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Try";
try {RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="ValorAnalogoLuz = sensorLuz.Read";
_valoranalogoluz = _sensorluz.getRead();
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="progresoLuz = sensorLuz.Read * 100";
_progresoluz = (int) (_sensorluz.getRead()*100);
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="barraProgLuz.Progress = progresoLuz";
mostCurrent._barraprogluz.setProgress(_progresoluz);
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="Label1.Text= ValorAnalogoLuz";
mostCurrent._label1.setText(BA.ObjectToCharSequence(_valoranalogoluz));
 } 
       catch (Exception e7) {
			processBA.setLastException(e7);RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="Log(\"Error: \"&LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="Desconectar_IOIO";
_desconectar_ioio();
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="Conectar_IOIO";
_conectar_ioio();
 };
RDebugUtils.currentLine=1114125;
 //BA.debugLineNum = 1114125;BA.debugLine="End Sub";
return "";
}
public static String  _relojpot_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "relojpot_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "relojpot_tick", null);
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub relojPot_Tick";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Try";
try {RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="ValorAnalogoPot = pot.Read";
_valoranalogopot = _pot.getRead();
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="progresoPot = pot.Read * 100";
_progresopot = (int) (_pot.getRead()*100);
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="barraProgPot.Progress = progresoPot";
mostCurrent._barraprogpot.setProgress(_progresopot);
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="Label2.Text= ValorAnalogoPot";
mostCurrent._label2.setText(BA.ObjectToCharSequence(_valoranalogopot));
 } 
       catch (Exception e7) {
			processBA.setLastException(e7);RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="Log(\"Error: \"&LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="Desconectar_IOIO";
_desconectar_ioio();
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="Conectar_IOIO";
_conectar_ioio();
 };
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="End Sub";
return "";
}
public static String  _sensorluz_open(boolean _noerror,Object _result) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sensorluz_open"))
	return (String) Debug.delegate(mostCurrent.activityBA, "sensorluz_open", new Object[] {_noerror,_result});
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub sensorluz_open(noerror As Boolean, result As O";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="If noerror Then";
if (_noerror) { 
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="sensorLuz=result";
_sensorluz.setObject((ioio.lib.api.AnalogInput)(_result));
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="relojLuz.Enabled=True";
_relojluz.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="Log(\"Error: \"&LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="End Sub";
return "";
}
public static String  _yoyo_connected(boolean _noerror) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "yoyo_connected"))
	return (String) Debug.delegate(mostCurrent.activityBA, "yoyo_connected", new Object[] {_noerror});
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub yoyo_connected(noerror As Boolean)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="If noerror Then";
if (_noerror) { 
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="ToastMessageShow(\"IOIO Conectado\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("IOIO Conectado"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="Conexion_pines";
_conexion_pines();
 }else {
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="End Sub";
return "";
}
}