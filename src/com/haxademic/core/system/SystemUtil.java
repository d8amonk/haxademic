package com.haxademic.core.system;

import processing.core.PApplet;

import com.haxademic.core.app.P;

public class SystemUtil {
	
	public static String getJavaVersion() {
		return System.getProperty("java.version");
	}

	public static String getTimestamp( PApplet p ) {
		// use P.nf to pad date components to 2 digits for more consistent ordering across systems
		return  String.valueOf( P.year() ) + "-" + 
				P.nf( P.month(), 2 ) + "-" + 
				P.nf( P.day(), 2 ) + "-" + 
				P.nf( P.hour(), 2 ) + "-" + 
				P.nf( P.minute(), 2 ) + "-" + 
				P.nf( P.second(), 2 );
	}

	public static String getTimestampFine( PApplet p ) {
		return SystemUtil.getTimestamp(p) + "-" + P.nf( p.frameCount, 8 ); 
	}
	
	// Patch TAB capture ability - Processing 2.0 broke this in 3D rendering contexts
	public static void p2TabKeyInputPatch() {
//		if(PJOGL.canvas != null) { PJOGL.canvas.setFocusTraversalKeysEnabled(false); }
	}
}
