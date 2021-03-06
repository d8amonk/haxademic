package com.haxademic.sketch.three_d;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

import com.haxademic.core.app.P;
import com.haxademic.core.app.PAppletHax;
import com.haxademic.core.draw.util.OpenGLUtil;

@SuppressWarnings("serial")
public class MappingTest
extends PAppletHax{
	
	protected PShape _curShape;
	protected ArrayList<PShape> _shapes;
	protected boolean _isPressed = false;
	protected boolean _debugging = true;
	
	public static void main(String args[]) {
		_isFullScreen = true;
		PApplet.main(new String[] { "--hide-stop", "--bgcolor=000000", "com.haxademic.sketch.three_d.MappingTest" });
	}

	protected void overridePropsFile() {
		_appConfig.setProperty( "width", "1024" );
		_appConfig.setProperty( "height", "768" );
		_appConfig.setProperty( "rendering", "false" );
		_appConfig.setProperty( "fills_screen", "true" );
		_appConfig.setProperty( "fullscreen", "true" );
	}
	
	public void setup() {
		super.setup();
		
		_shapes = new ArrayList<PShape>();
		
		p.strokeWeight( 1 );
		p.smooth(OpenGLUtil.SMOOTH_HIGH);
	}
	
	public void drawApp() {
		p.background(0);
		
		// draw already-drawn shapes
		for (int i=0; i < _shapes.size(); i++) {
			// get shape and set audio-reactive fill --------------
			PShape shape = _shapes.get(i);
			shape.setFill(p.color(255, p._audioInput.getFFT().spectrum[(i * 10 + 10) % 512] * 2000));
			p.shape( shape );

			
			if( _debugging == true ) {
				// draw wireframe and handles -------------------------
				PVector v = null;
				PVector nextV = null;
				int numVertices = shape.getVertexCount();
				for (int j = 0; j < shape.getVertexCount(); j++) {
					v = shape.getVertex(j);
					p.ellipse( v.x, v.y, 6, 6 );
					if( j < numVertices - 1 ) {
						nextV = shape.getVertex(j+1);
						p.line( v.x, v.y, nextV.x, nextV.y );
					}
				}
				p.line( shape.getVertex(0).x, shape.getVertex(0).y, shape.getVertex(numVertices-1).x, shape.getVertex(numVertices-1).y );
			}
		}
		
		// draw mouse point when pressed
		if( _isPressed ) {
			p.fill(255);
			p.noStroke();
			p.ellipse( p.mouseX, p.mouseY, 6, 6 );
		}
		
		// draw currently-drawing shape
		if( _curShape != null ) {
			PVector v = null;
			PVector lastV = null;
			p.noFill();
			p.stroke(255);
			for (int i = 0; i < _curShape.getVertexCount(); i++) {
				v = _curShape.getVertex(i);
				p.ellipse( v.x, v.y, 6, 6 );
				if( i > 0 ) {
					lastV = _curShape.getVertex(i-1);
					p.line( v.x, v.y, lastV.x, lastV.y );
				}
			}
			
			// draw last vertex to mouse if pressed
			if( _isPressed && v != null ) {
				p.line( p.mouseX, p.mouseY, v.x, v.y );
			}
		}
	}
	
	public void mousePressed() {
		super.mousePressed();
		_isPressed = true;
	}
	
	public void mouseReleased() {
		super.mouseReleased();
		_isPressed = false;
		
		if (_curShape == null) {
			_curShape = p.createShape();
			_curShape.noStroke();  
			_curShape.setFill(color(255, 200));
			_curShape.beginShape();
			_curShape.vertex( p.mouseX, p.mouseY );
		} else {
			_curShape.vertex( p.mouseX, p.mouseY );
		}
	}
	
	public void keyPressed() {
		if(p.key == ' ') {
			if( _curShape != null ) {
				_shapes.add(_curShape);
				_curShape.endShape(P.CLOSE);
				_curShape = null;
			}
		} else if(p.key == 'd') {
			_debugging = !_debugging;
		}
	}

}