package com.haxademic.core.draw.color;

import com.haxademic.core.app.P;

public class ColorHax {
	public float r;
	public float g;
	public float b;
	public float a;
	
	public ColorHax( float r, float g, float b, float a ) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	} 
	
	public ColorHax( String hex ) {
		int color = ColorUtil.colorFromHex(hex);
		this.r = redFromColorInt(color);
		this.g = greenFromColorInt(color);
		this.b = blueFromColorInt(color);
		this.a = 255;
	} 
	
	public final static int alphaFromColorInt( int c ) { return (c >> 24) & 0xFF; }
	public final static int redFromColorInt( int c ) { return (c >> 16) & 0xFF;	}
	public final static int greenFromColorInt( int c ) { return (c >> 8)  & 0xFF; }
	public final static int blueFromColorInt( int c ) { return c & 0xFF; }

	public int colorInt() {
		return P.p.color(r, g, b, a);
	}
	
	public int colorIntWithAlpha( float alpha, float offset ) {
		return P.p.color(r + offset, g + offset, b + offset, alpha);
	}
	
}
