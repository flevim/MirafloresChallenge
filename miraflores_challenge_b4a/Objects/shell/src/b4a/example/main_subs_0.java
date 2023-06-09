package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static void  _activity_create(RemoteObject _firsttime) throws Exception{
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(null, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.main parent,RemoteObject _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _firsttime;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,71);
if (RapidSub.canDelegate("activity_create")) return ;
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 75;BA.debugLine="Activity.LoadLayout(\"main\")";
Debug.ShouldStop(1024);
parent.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 76;BA.debugLine="URL = \"https://3def-200-2-119-118.sa.ngrok.io/\"";
Debug.ShouldStop(2048);
parent.mostCurrent._url = BA.ObjectToString("https://3def-200-2-119-118.sa.ngrok.io/");
 BA.debugLineNum = 77;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(4096);
if (true) break;

case 1:
//if
this.state = 8;
if (_firsttime.<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 78;BA.debugLine="BtAdmin.Initialize(\"BtAdmin\")";
Debug.ShouldStop(8192);
parent.mostCurrent._btadmin.runVoidMethod ("Initialize",main.processBA,(Object)(RemoteObject.createImmutable("BtAdmin")));
 BA.debugLineNum = 80;BA.debugLine="If YOYO.IsInitialized=False Then";
Debug.ShouldStop(32768);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",parent._yoyo.runMethod(true,"IsInitialized"),parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 81;BA.debugLine="Conectar_IOIO";
Debug.ShouldStop(65536);
_conectar_ioio();
 if (true) break;

case 7:
//C
this.state = 8;
;
 BA.debugLineNum = 83;BA.debugLine="relojLuz.Initialize(\"relojLuz\", 100)";
Debug.ShouldStop(262144);
parent._relojluz.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("relojLuz")),(Object)(BA.numberCast(long.class, 100)));
 BA.debugLineNum = 84;BA.debugLine="relojPot.Initialize(\"relojPot\", 100)";
Debug.ShouldStop(524288);
parent._relojpot.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("relojPot")),(Object)(BA.numberCast(long.class, 100)));
 if (true) break;

case 8:
//C
this.state = 9;
;
 BA.debugLineNum = 90;BA.debugLine="tab_vistas.AddTab(\"General\", \"design_savedata\")";
Debug.ShouldStop(33554432);
parent.mostCurrent._tab_vistas.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("General")),(Object)(RemoteObject.createImmutable("design_savedata")));
 BA.debugLineNum = 91;BA.debugLine="tab_vistas.AddTab(\"Temperatura\", \"tabtemp\")";
Debug.ShouldStop(67108864);
parent.mostCurrent._tab_vistas.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Temperatura")),(Object)(RemoteObject.createImmutable("tabtemp")));
 BA.debugLineNum = 92;BA.debugLine="tab_vistas.AddTab(\"Humedad\", \"tabhum\")";
Debug.ShouldStop(134217728);
parent.mostCurrent._tab_vistas.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Humedad")),(Object)(RemoteObject.createImmutable("tabhum")));
 BA.debugLineNum = 93;BA.debugLine="tab_vistas.AddTab(\"Humedad de Suelo\", \"tabhumsuel";
Debug.ShouldStop(268435456);
parent.mostCurrent._tab_vistas.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Humedad de Suelo")),(Object)(RemoteObject.createImmutable("tabhumsuelo")));
 BA.debugLineNum = 94;BA.debugLine="tab_vistas.CurrentTab = 1";
Debug.ShouldStop(536870912);
parent.mostCurrent._tab_vistas.runMethodAndSync(true,"setCurrentTab",BA.numberCast(int.class, 1));
 BA.debugLineNum = 96;BA.debugLine="Do While True";
Debug.ShouldStop(-2147483648);
if (true) break;

case 9:
//do while
this.state = 12;
while (parent.mostCurrent.__c.getField(true,"True").<Boolean>get().booleanValue()) {
this.state = 11;
if (true) break;
}
if (true) break;

case 11:
//C
this.state = 9;
 BA.debugLineNum = 97;BA.debugLine="saveDataDB";
Debug.ShouldStop(1);
_savedatadb();
 BA.debugLineNum = 98;BA.debugLine="Sleep(10000)";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this),BA.numberCast(int.class, 10000));
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
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,203);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 203;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 205;BA.debugLine="If UserClosed Then";
Debug.ShouldStop(4096);
if (_userclosed.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 206;BA.debugLine="Desconectar_IOIO";
Debug.ShouldStop(8192);
_desconectar_ioio();
 };
 BA.debugLineNum = 208;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,199);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 199;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 201;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _conectar_ioio() throws Exception{
try {
		Debug.PushSubsStack("Conectar_IOIO (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,104);
if (RapidSub.canDelegate("conectar_ioio")) return b4a.example.main.remoteMe.runUserSub(false, "main","conectar_ioio");
 BA.debugLineNum = 104;BA.debugLine="Sub Conectar_IOIO";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="YOYO.Initialize";
Debug.ShouldStop(256);
main._yoyo.runVoidMethod ("Initialize");
 BA.debugLineNum = 106;BA.debugLine="If BtAdmin.IsEnabled Then YOYO.Connect(\"yoyo\",YOY";
Debug.ShouldStop(512);
if (main.mostCurrent._btadmin.runMethod(true,"IsEnabled").<Boolean>get().booleanValue()) { 
main._yoyo.runVoidMethod ("Connect",main.processBA,(Object)(BA.ObjectToString("yoyo")),(Object)(main._yoyo.getField(true,"CONN_BT")),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 0)));};
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _conexion_pines() throws Exception{
try {
		Debug.PushSubsStack("Conexion_pines (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,162);
if (RapidSub.canDelegate("conexion_pines")) return b4a.example.main.remoteMe.runUserSub(false, "main","conexion_pines");
 BA.debugLineNum = 162;BA.debugLine="Sub Conexion_pines";
Debug.ShouldStop(2);
 BA.debugLineNum = 163;BA.debugLine="YOYO.OpenAnalogInput(\"sensorluz\",39)";
Debug.ShouldStop(4);
main._yoyo.runVoidMethod ("OpenAnalogInput",main.processBA,(Object)(BA.ObjectToString("sensorluz")),(Object)(BA.numberCast(int.class, 39)));
 BA.debugLineNum = 164;BA.debugLine="YOYO.OpenAnalogInput(\"potenciometro\",40)";
Debug.ShouldStop(8);
main._yoyo.runVoidMethod ("OpenAnalogInput",main.processBA,(Object)(BA.ObjectToString("potenciometro")),(Object)(BA.numberCast(int.class, 40)));
 BA.debugLineNum = 165;BA.debugLine="YOYO.OpenAnalogInput(\"humedad\",41)";
Debug.ShouldStop(16);
main._yoyo.runVoidMethod ("OpenAnalogInput",main.processBA,(Object)(BA.ObjectToString("humedad")),(Object)(BA.numberCast(int.class, 41)));
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _desconectar_ioio() throws Exception{
try {
		Debug.PushSubsStack("Desconectar_IOIO (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,145);
if (RapidSub.canDelegate("desconectar_ioio")) return b4a.example.main.remoteMe.runUserSub(false, "main","desconectar_ioio");
 BA.debugLineNum = 145;BA.debugLine="Sub Desconectar_IOIO";
Debug.ShouldStop(65536);
 BA.debugLineNum = 146;BA.debugLine="sensorLuz.Close";
Debug.ShouldStop(131072);
main._sensorluz.runVoidMethod ("Close");
 BA.debugLineNum = 147;BA.debugLine="sensorHum.Close";
Debug.ShouldStop(262144);
main._sensorhum.runVoidMethod ("Close");
 BA.debugLineNum = 148;BA.debugLine="pot.Close";
Debug.ShouldStop(524288);
main._pot.runVoidMethod ("Close");
 BA.debugLineNum = 149;BA.debugLine="YOYO.Disconnect";
Debug.ShouldStop(1048576);
main._yoyo.runVoidMethod ("Disconnect",main.processBA);
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 42;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 45;BA.debugLine="Private tab_vistas As TabHost";
main.mostCurrent._tab_vistas = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private ListView1 As ListView";
main.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private ServerIP As String";
main.mostCurrent._serverip = RemoteObject.createImmutable("");
 //BA.debugLineNum = 53;BA.debugLine="Private progresoLuz, progresoPot As Int";
main._progresoluz = RemoteObject.createImmutable(0);
main._progresopot = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 54;BA.debugLine="Private barraProgLuz, barraProgPot As ProgressBar";
main.mostCurrent._barraprogluz = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
main.mostCurrent._barraprogpot = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Dim BtAdmin As BluetoothAdmin";
main.mostCurrent._btadmin = RemoteObject.createNew ("anywheresoftware.b4a.objects.Serial.BluetoothAdmin");
 //BA.debugLineNum = 58;BA.debugLine="Dim ValorAnalogoLuz, ValorAnalogoPot As Float";
main._valoranalogoluz = RemoteObject.createImmutable(0f);
main._valoranalogopot = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 59;BA.debugLine="Dim Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Dim Label2 As Label";
main.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Dim saveData As HttpJob";
main.mostCurrent._savedata = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 63;BA.debugLine="Dim updateData As HttpJob";
main.mostCurrent._updatedata = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 64;BA.debugLine="Dim readData As HttpJob";
main.mostCurrent._readdata = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 65;BA.debugLine="Dim deleteData As HttpJob";
main.mostCurrent._deletedata = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 66;BA.debugLine="Dim URL As String";
main.mostCurrent._url = RemoteObject.createImmutable("");
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,127);
if (RapidSub.canDelegate("jobdone")) return b4a.example.main.remoteMe.runUserSub(false, "main","jobdone", _job);
Debug.locals.put("job", _job);
 BA.debugLineNum = 127;BA.debugLine="Sub JobDone (job As HttpJob)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 129;BA.debugLine="Select job";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(_job,main.mostCurrent._savedata)) {
case 0: {
 BA.debugLineNum = 131;BA.debugLine="If job.Success Then";
Debug.ShouldStop(4);
if (_job.getField(true,"_success").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 133;BA.debugLine="Log(job.GetString)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 134;BA.debugLine="ToastMessageShow(\"Saved\",False)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Saved")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 137;BA.debugLine="ToastMessageShow(\"Error: \"&job.ErrorMessage, T";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 140;BA.debugLine="saveData.Release";
Debug.ShouldStop(2048);
main.mostCurrent._savedata.runVoidMethod ("_release");
 break; }
}
;
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _potenciometro_open(RemoteObject _noerror,RemoteObject _result) throws Exception{
try {
		Debug.PushSubsStack("potenciometro_open (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,219);
if (RapidSub.canDelegate("potenciometro_open")) return b4a.example.main.remoteMe.runUserSub(false, "main","potenciometro_open", _noerror, _result);
Debug.locals.put("noerror", _noerror);
Debug.locals.put("result", _result);
 BA.debugLineNum = 219;BA.debugLine="Sub potenciometro_open(noerror As Boolean, result";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 220;BA.debugLine="If noerror Then";
Debug.ShouldStop(134217728);
if (_noerror.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 221;BA.debugLine="pot = result";
Debug.ShouldStop(268435456);
main._pot.setObject(_result);
 BA.debugLineNum = 222;BA.debugLine="relojPot.Enabled = True";
Debug.ShouldStop(536870912);
main._relojpot.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 224;BA.debugLine="Log(\"Error: \"&LastException.Message)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"))));
 };
 BA.debugLineNum = 226;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 30;BA.debugLine="Dim YOYO As IOIO";
main._yoyo = RemoteObject.createNew ("anywheresoftware.b4a.ioio.B4AIOIO");
 //BA.debugLineNum = 32;BA.debugLine="Dim relojLuz, relojPot As Timer";
main._relojluz = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
main._relojpot = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 34;BA.debugLine="Dim sensorLuz As AnalogInput";
main._sensorluz = RemoteObject.createNew ("anywheresoftware.b4a.ioio.B4AIOIO.B4AAnalogueInputWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Dim sensorHum As AnalogInput";
main._sensorhum = RemoteObject.createNew ("anywheresoftware.b4a.ioio.B4AIOIO.B4AAnalogueInputWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Dim pot As AnalogInput";
main._pot = RemoteObject.createNew ("anywheresoftware.b4a.ioio.B4AIOIO.B4AAnalogueInputWrapper");
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _relojluz_tick() throws Exception{
try {
		Debug.PushSubsStack("relojLuz_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,169);
if (RapidSub.canDelegate("relojluz_tick")) return b4a.example.main.remoteMe.runUserSub(false, "main","relojluz_tick");
 BA.debugLineNum = 169;BA.debugLine="Sub relojLuz_Tick";
Debug.ShouldStop(256);
 BA.debugLineNum = 170;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 171;BA.debugLine="ValorAnalogoLuz = sensorLuz.Read";
Debug.ShouldStop(1024);
main._valoranalogoluz = main._sensorluz.runMethod(true,"getRead");
 BA.debugLineNum = 172;BA.debugLine="progresoLuz = sensorLuz.Read * 100";
Debug.ShouldStop(2048);
main._progresoluz = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._sensorluz.runMethod(true,"getRead"),RemoteObject.createImmutable(100)}, "*",0, 0));
 BA.debugLineNum = 173;BA.debugLine="barraProgLuz.Progress = progresoLuz";
Debug.ShouldStop(4096);
main.mostCurrent._barraprogluz.runMethod(true,"setProgress",main._progresoluz);
 BA.debugLineNum = 174;BA.debugLine="Label1.Text= ValorAnalogoLuz";
Debug.ShouldStop(8192);
main.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(main._valoranalogoluz));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e7.toString()); BA.debugLineNum = 177;BA.debugLine="Log(\"Error: \"&LastException.Message)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"))));
 BA.debugLineNum = 178;BA.debugLine="Desconectar_IOIO";
Debug.ShouldStop(131072);
_desconectar_ioio();
 BA.debugLineNum = 179;BA.debugLine="Conectar_IOIO";
Debug.ShouldStop(262144);
_conectar_ioio();
 };
 BA.debugLineNum = 182;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _relojpot_tick() throws Exception{
try {
		Debug.PushSubsStack("relojPot_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,184);
if (RapidSub.canDelegate("relojpot_tick")) return b4a.example.main.remoteMe.runUserSub(false, "main","relojpot_tick");
 BA.debugLineNum = 184;BA.debugLine="Sub relojPot_Tick";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 185;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 186;BA.debugLine="ValorAnalogoPot = pot.Read";
Debug.ShouldStop(33554432);
main._valoranalogopot = main._pot.runMethod(true,"getRead");
 BA.debugLineNum = 187;BA.debugLine="progresoPot = pot.Read * 100";
Debug.ShouldStop(67108864);
main._progresopot = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._pot.runMethod(true,"getRead"),RemoteObject.createImmutable(100)}, "*",0, 0));
 BA.debugLineNum = 188;BA.debugLine="barraProgPot.Progress = progresoPot";
Debug.ShouldStop(134217728);
main.mostCurrent._barraprogpot.runMethod(true,"setProgress",main._progresopot);
 BA.debugLineNum = 189;BA.debugLine="Label2.Text= ValorAnalogoPot";
Debug.ShouldStop(268435456);
main.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(main._valoranalogopot));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e7.toString()); BA.debugLineNum = 192;BA.debugLine="Log(\"Error: \"&LastException.Message)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"))));
 BA.debugLineNum = 193;BA.debugLine="Desconectar_IOIO";
Debug.ShouldStop(1);
_desconectar_ioio();
 BA.debugLineNum = 194;BA.debugLine="Conectar_IOIO";
Debug.ShouldStop(2);
_conectar_ioio();
 };
 BA.debugLineNum = 197;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savedatadb() throws Exception{
try {
		Debug.PushSubsStack("saveDataDB (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("savedatadb")) return b4a.example.main.remoteMe.runUserSub(false, "main","savedatadb");
RemoteObject _hoy = RemoteObject.createImmutable("");
RemoteObject _hora = RemoteObject.createImmutable("");
RemoteObject _datasend = RemoteObject.createImmutable("");
 BA.debugLineNum = 111;BA.debugLine="Sub saveDataDB";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="Dim hoy, hora As String";
Debug.ShouldStop(32768);
_hoy = RemoteObject.createImmutable("");Debug.locals.put("hoy", _hoy);
_hora = RemoteObject.createImmutable("");Debug.locals.put("hora", _hora);
 BA.debugLineNum = 113;BA.debugLine="Dim datasend As String";
Debug.ShouldStop(65536);
_datasend = RemoteObject.createImmutable("");Debug.locals.put("datasend", _datasend);
 BA.debugLineNum = 114;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\" 'fecha";
Debug.ShouldStop(131072);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyy-MM-dd"));
 BA.debugLineNum = 115;BA.debugLine="DateTime.TimeFormat = \"hh-mm-ss\"  'hora";
Debug.ShouldStop(262144);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("hh-mm-ss"));
 BA.debugLineNum = 116;BA.debugLine="hoy = DateTime.Date(DateTime.Now)";
Debug.ShouldStop(524288);
_hoy = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("hoy", _hoy);
 BA.debugLineNum = 117;BA.debugLine="hora = DateTime.Time(DateTime.Now)";
Debug.ShouldStop(1048576);
_hora = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("hora", _hora);
 BA.debugLineNum = 118;BA.debugLine="Log(hoy)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_hoy));
 BA.debugLineNum = 119;BA.debugLine="Log(hora)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_hora));
 BA.debugLineNum = 121;BA.debugLine="datasend = \"fecha=\"&hoy&\"&hora=\"&hora&\"&humedad=\"";
Debug.ShouldStop(16777216);
_datasend = RemoteObject.concat(RemoteObject.createImmutable("fecha="),_hoy,RemoteObject.createImmutable("&hora="),_hora,RemoteObject.createImmutable("&humedad="),main._valoranalogopot,RemoteObject.createImmutable("&luz="),main._valoranalogoluz);Debug.locals.put("datasend", _datasend);
 BA.debugLineNum = 122;BA.debugLine="saveData.Initialize(\"savedata\", Me)";
Debug.ShouldStop(33554432);
main.mostCurrent._savedata.runVoidMethod ("_initialize",main.processBA,(Object)(BA.ObjectToString("savedata")),(Object)(main.getObject()));
 BA.debugLineNum = 123;BA.debugLine="saveData.PostString(URL&\"guardar_dato\", datasend)";
Debug.ShouldStop(67108864);
main.mostCurrent._savedata.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(main.mostCurrent._url,RemoteObject.createImmutable("guardar_dato"))),(Object)(_datasend));
 BA.debugLineNum = 124;BA.debugLine="Log(saveData)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(main.mostCurrent._savedata)));
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sensorluz_open(RemoteObject _noerror,RemoteObject _result) throws Exception{
try {
		Debug.PushSubsStack("sensorluz_open (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,210);
if (RapidSub.canDelegate("sensorluz_open")) return b4a.example.main.remoteMe.runUserSub(false, "main","sensorluz_open", _noerror, _result);
Debug.locals.put("noerror", _noerror);
Debug.locals.put("result", _result);
 BA.debugLineNum = 210;BA.debugLine="Sub sensorluz_open(noerror As Boolean, result As O";
Debug.ShouldStop(131072);
 BA.debugLineNum = 211;BA.debugLine="If noerror Then";
Debug.ShouldStop(262144);
if (_noerror.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 212;BA.debugLine="sensorLuz=result";
Debug.ShouldStop(524288);
main._sensorluz.setObject(_result);
 BA.debugLineNum = 213;BA.debugLine="relojLuz.Enabled=True";
Debug.ShouldStop(1048576);
main._relojluz.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 215;BA.debugLine="Log(\"Error: \"&LastException.Message)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"))));
 };
 BA.debugLineNum = 217;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _yoyo_connected(RemoteObject _noerror) throws Exception{
try {
		Debug.PushSubsStack("yoyo_connected (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,153);
if (RapidSub.canDelegate("yoyo_connected")) return b4a.example.main.remoteMe.runUserSub(false, "main","yoyo_connected", _noerror);
Debug.locals.put("noerror", _noerror);
 BA.debugLineNum = 153;BA.debugLine="Sub yoyo_connected(noerror As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="If noerror Then";
Debug.ShouldStop(33554432);
if (_noerror.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 155;BA.debugLine="ToastMessageShow(\"IOIO Conectado\",True)";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("IOIO Conectado")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 156;BA.debugLine="Conexion_pines";
Debug.ShouldStop(134217728);
_conexion_pines();
 }else {
 BA.debugLineNum = 158;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")));
 };
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}