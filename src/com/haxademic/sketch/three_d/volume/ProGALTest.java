package com.haxademic.sketch.three_d.volume;



import java.util.Arrays;
import java.util.List;

import processing.core.PImage;
import ProGAL.geom3d.Point;
import ProGAL.geom3d.complex.CTriangle;
import ProGAL.geom3d.complex.alphaComplex.AlphaComplex;
import ProGAL.geom3d.complex.alphaComplex.AlphaFiltration;

import com.haxademic.core.app.P;
import com.haxademic.core.app.PAppletHax;
import com.haxademic.core.draw.util.DrawUtil;
import com.haxademic.core.system.FileUtil;

@SuppressWarnings("serial")
public class ProGALTest 
extends PAppletHax {

	List<Point> points;
	float[] intervals; //init Point3d array
	PImage img;

	protected void overridePropsFile() {
		_appConfig.setProperty( "rendering", "false" );
		_appConfig.setProperty( "width", "1280" );
		_appConfig.setProperty( "height", "1024" );
	}

	public void setup() {
		super.setup();
		smooth();

		img = loadImage(FileUtil.getHaxademicDataPath() + "images/sphere-map-test.jpg");

		//point array
		float max = 800;
		float maxHalf = max/2f;
		points = Arrays.asList( 
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf),
				new Point(Math.random()*max-maxHalf, Math.random()*max-maxHalf, Math.random()*max-maxHalf)
				);

		float intRange = 10;
		float minInt = 4;
		intervals = new float[] {
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt,
				(float) Math.random()*intRange+minInt
		};


	}  

	public void drawApp() {
		DrawUtil.setBasicLights(p);
		background(0);
		fill(255);
		noStroke();
//				noFill();
//				stroke(255);
		smooth();
				translate(width/2f, height/2f, -500);

		int numPoints = points.size();

		for( int i=0; i < numPoints; i++ ) {
			points.get(i).setX( points.get(i).x() + 8* Math.sin(frameCount/intervals[i]) );
			points.get(i).setY( points.get(i).y() + 8* Math.cos(frameCount/intervals[i]) );
			points.get(i).setZ( points.get(i).z() + 8* Math.sin(frameCount/intervals[i]) );
		}


		drawAlphaComplex();
//		drawAlphaShape();
	}
	
	protected void drawAlphaShape() {
		AlphaFiltration af = new AlphaFiltration(points);
		List<CTriangle> triangles = af.getAlphaShape(200.8);
		for(CTriangle tri: triangles) {
			beginShape(TRIANGLE_STRIP);
			texture(img);
	
			vertex( (float) tri.getP1().x(), (float) tri.getP1().y(), (float) tri.getP1().z(),    P.abs( (float) tri.getP1().x()*2f+1 ), P.abs( (float) tri.getP1().y()*2f+1 ) );
			vertex( (float) tri.getP2().x(), (float) tri.getP2().y(), (float) tri.getP2().z(),    P.abs( (float) tri.getP2().x()*2f+1 ), P.abs( (float) tri.getP2().y()*2f+1 ) );
			vertex( (float) tri.getP3().x(), (float) tri.getP3().y(), (float) tri.getP3().z(),    P.abs( (float) tri.getP3().x()*2f+1 ), P.abs( (float) tri.getP3().y()*2f+1 ) );
	
			endShape(CLOSE);
		}
	}
	
	protected void drawAlphaComplex() {
		// draw alpha complex
		AlphaComplex ac = new AlphaComplex(points, 200.8);
		for(CTriangle tri: ac.getTriangles()){		
			beginShape(TRIANGLE_STRIP);
			texture(img);

			vertex( (float) tri.getP1().x(), (float) tri.getP1().y(), (float) tri.getP1().z(),    P.abs( (float) tri.getP1().x()*2f+1 ), P.abs( (float) tri.getP1().y()*2f+1 ) );
			vertex( (float) tri.getP2().x(), (float) tri.getP2().y(), (float) tri.getP2().z(),    P.abs( (float) tri.getP2().x()*2f+1 ), P.abs( (float) tri.getP2().y()*2f+1 ) );
			vertex( (float) tri.getP3().x(), (float) tri.getP3().y(), (float) tri.getP3().z(),    P.abs( (float) tri.getP3().x()*2f+1 ), P.abs( (float) tri.getP3().y()*2f+1 ) );

			endShape(CLOSE);
		}
	}

}
