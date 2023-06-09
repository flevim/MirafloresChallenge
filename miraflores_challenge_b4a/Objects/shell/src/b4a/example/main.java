
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.example.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _yoyo = RemoteObject.declareNull("anywheresoftware.b4a.ioio.B4AIOIO");
public static RemoteObject _relojluz = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _relojpot = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _sensorluz = RemoteObject.declareNull("anywheresoftware.b4a.ioio.B4AIOIO.B4AAnalogueInputWrapper");
public static RemoteObject _sensorhum = RemoteObject.declareNull("anywheresoftware.b4a.ioio.B4AIOIO.B4AAnalogueInputWrapper");
public static RemoteObject _pot = RemoteObject.declareNull("anywheresoftware.b4a.ioio.B4AIOIO.B4AAnalogueInputWrapper");
public static RemoteObject _tab_vistas = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabHostWrapper");
public static RemoteObject _listview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _serverip = RemoteObject.createImmutable("");
public static RemoteObject _progresoluz = RemoteObject.createImmutable(0);
public static RemoteObject _progresopot = RemoteObject.createImmutable(0);
public static RemoteObject _barraprogluz = RemoteObject.declareNull("anywheresoftware.b4a.objects.ProgressBarWrapper");
public static RemoteObject _barraprogpot = RemoteObject.declareNull("anywheresoftware.b4a.objects.ProgressBarWrapper");
public static RemoteObject _btadmin = RemoteObject.declareNull("anywheresoftware.b4a.objects.Serial.BluetoothAdmin");
public static RemoteObject _valoranalogoluz = RemoteObject.createImmutable(0f);
public static RemoteObject _valoranalogopot = RemoteObject.createImmutable(0f);
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _savedata = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httpjob");
public static RemoteObject _updatedata = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httpjob");
public static RemoteObject _readdata = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httpjob");
public static RemoteObject _deletedata = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httpjob");
public static RemoteObject _url = RemoteObject.createImmutable("");
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.example.starter _starter = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"barraProgLuz",main.mostCurrent._barraprogluz,"barraProgPot",main.mostCurrent._barraprogpot,"BtAdmin",main.mostCurrent._btadmin,"deleteData",main.mostCurrent._deletedata,"HttpUtils2Service",main.mostCurrent._httputils2service,"Label1",main.mostCurrent._label1,"Label2",main.mostCurrent._label2,"ListView1",main.mostCurrent._listview1,"pot",main._pot,"progresoLuz",main._progresoluz,"progresoPot",main._progresopot,"readData",main.mostCurrent._readdata,"relojLuz",main._relojluz,"relojPot",main._relojpot,"saveData",main.mostCurrent._savedata,"sensorHum",main._sensorhum,"sensorLuz",main._sensorluz,"ServerIP",main.mostCurrent._serverip,"Starter",Debug.moduleToString(b4a.example.starter.class),"tab_vistas",main.mostCurrent._tab_vistas,"updateData",main.mostCurrent._updatedata,"URL",main.mostCurrent._url,"ValorAnalogoLuz",main._valoranalogoluz,"ValorAnalogoPot",main._valoranalogopot,"YOYO",main._yoyo};
}
}