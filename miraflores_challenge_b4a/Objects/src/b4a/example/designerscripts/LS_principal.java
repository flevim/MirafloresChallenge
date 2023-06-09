package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_principal{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[principal/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="LabelTitulo.SetTopAndBottom(10%y,20%y)"[principal/General script]
views.get("labeltitulo").vw.setTop((int)((10d / 100 * height)));
views.get("labeltitulo").vw.setHeight((int)((20d / 100 * height) - ((10d / 100 * height))));
//BA.debugLineNum = 4;BA.debugLine="Label1.SetLeftAndRight(0%x,22%x)"[principal/General script]
views.get("label1").vw.setLeft((int)((0d / 100 * width)));
views.get("label1").vw.setWidth((int)((22d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 5;BA.debugLine="Label1.SetTopAndBottom(40%y,50%y)"[principal/General script]
views.get("label1").vw.setTop((int)((40d / 100 * height)));
views.get("label1").vw.setHeight((int)((50d / 100 * height) - ((40d / 100 * height))));
//BA.debugLineNum = 7;BA.debugLine="Label2.SetLeftAndRight(0%x,22%x)"[principal/General script]
views.get("label2").vw.setLeft((int)((0d / 100 * width)));
views.get("label2").vw.setWidth((int)((22d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 8;BA.debugLine="Label2.SetTopAndBottom(50%y,60%y)"[principal/General script]
views.get("label2").vw.setTop((int)((50d / 100 * height)));
views.get("label2").vw.setHeight((int)((60d / 100 * height) - ((50d / 100 * height))));
//BA.debugLineNum = 10;BA.debugLine="Label3.SetLeftAndRight(0%x,22%x)"[principal/General script]
views.get("label3").vw.setLeft((int)((0d / 100 * width)));
views.get("label3").vw.setWidth((int)((22d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 11;BA.debugLine="Label3.SetTopAndBottom(60%y,70%y)"[principal/General script]
views.get("label3").vw.setTop((int)((60d / 100 * height)));
views.get("label3").vw.setHeight((int)((70d / 100 * height) - ((60d / 100 * height))));
//BA.debugLineNum = 13;BA.debugLine="SeekBarAzul.Top = 42%y"[principal/General script]
views.get("seekbarazul").vw.setTop((int)((42d / 100 * height)));
//BA.debugLineNum = 14;BA.debugLine="SeekBarVerde.Top = 52%y"[principal/General script]
views.get("seekbarverde").vw.setTop((int)((52d / 100 * height)));
//BA.debugLineNum = 15;BA.debugLine="SeekBarRojo.Top = 62%y"[principal/General script]
views.get("seekbarrojo").vw.setTop((int)((62d / 100 * height)));

}
}