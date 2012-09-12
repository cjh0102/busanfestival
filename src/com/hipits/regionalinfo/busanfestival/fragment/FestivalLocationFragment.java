package com.hipits.regionalinfo.busanfestival.fragment;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.FloatMath;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.hipits.regionalinfo.busanfestival.activity.GuideMapActivity;
import com.hipits.regionalinfo.busanfestival.activity.R;

public class FestivalLocationFragment extends Fragment implements OnTouchListener {

	private static final String TAG = "Touch";

	Matrix matrix = new Matrix();
	Matrix savedMatrix = new Matrix();

	private Matrix savedMatrix2 = new Matrix();

	static final int NONE = 0;
	static final int DRAG = 1;
	static final int ZOOM = 2;
	int mode = NONE;

	private static final int WIDTH = 0;
	private static final int HEIGHT = 1;

	PointF start = new PointF();
	PointF mid = new PointF();
	float oldDist = 1f;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_location, null);
		
		ImageView locationImageView = (ImageView)view.findViewById(R.id.locationImageView);
		locationImageView.setOnTouchListener(this);
		
		Button button = (Button)view.findViewById(R.id.mapViewButton);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), GuideMapActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}


	@Override
	public boolean onTouch(View v, MotionEvent event) {

		ImageView view = (ImageView) v;

		// Handle touch events here...
		switch (event.getAction() & MotionEvent.ACTION_MASK) {

		case MotionEvent.ACTION_DOWN:
			savedMatrix.set(matrix);
			start.set(event.getX(), event.getY());
			Log.d(TAG, "mode=DRAG");
			mode = DRAG;
			break;

		case MotionEvent.ACTION_POINTER_DOWN:
			oldDist = spacing(event);
			Log.d(TAG, "oldDist=" + oldDist);
			if (oldDist > 10f) {
				savedMatrix.set(matrix);
				midPoint(mid, event);
				mode = ZOOM;
				Log.d(TAG, "mode=ZOOM");
			}
			break;

		case MotionEvent.ACTION_UP:

		case MotionEvent.ACTION_POINTER_UP:
			mode = NONE;
			Log.d(TAG, "mode=NONE");
			break;

		case MotionEvent.ACTION_MOVE:
			if (mode == DRAG) {
				// ...
				matrix.set(savedMatrix);
				matrix.postTranslate(event.getX() - start.x,
						event.getY() - start.y);
			} else if (mode == ZOOM) {
				float newDist = spacing(event);
				Log.d(TAG, "newDist=" + newDist);

				if (newDist > 10f) {
					matrix.set(savedMatrix);
					float scale = newDist / oldDist;
					matrix.postScale(scale, scale, mid.x, mid.y);
				}
			}
			break;
		}

		matrixTurning(matrix, view);
		view.setImageMatrix(matrix);
		return true; // indicate event was handled

	}

	private float spacing(MotionEvent event) {
		float x = event.getX(0) - event.getX(1);
		float y = event.getY(0) - event.getY(1);
		return FloatMath.sqrt(x * x + y * y);
	}

	/** Calculate the mid point of the first two fingers */
	private void midPoint(PointF point, MotionEvent event) {
		float x = event.getX(0) + event.getX(1);
		float y = event.getY(0) + event.getY(1);
		point.set(x / 2, y / 2);
	}
	
	private void matrixTurning(Matrix matrix, ImageView view){
		// 매트릭스 값
		float[] value = new float[9];
	
		matrix.getValues(value);
		
		float[] savedValue = new float[9];
		
		savedMatrix2.getValues(savedValue);

		// 뷰 크기
		int width = view.getWidth();
		int height = view.getHeight();

		// 이미지 크기
		Drawable d = view.getDrawable();
		if (d == null)  return;
		int imageWidth = d.getIntrinsicWidth();
		int imageHeight = d.getIntrinsicHeight();
		int scaleWidth = (int) (imageWidth * value[0]);
		int scaleHeight = (int) (imageHeight * value[4]);

		// 이미지가 바깥으로 나가지 않도록.
		if (value[2] < width - scaleWidth)   
			value[2] = width - scaleWidth;
		
		if (value[5] < height - scaleHeight)   
			value[5] = height - scaleHeight;
	
		if (value[2] > 0)   
			value[2] = 0;
		
		if (value[5] > 0)   
			value[5] = 0;

		// 10배 이상 확대 하지 않도록
		if (value[0] > 10 || value[4] > 10){
			value[0] = savedValue[0];
			value[4] = savedValue[4];
			value[2] = savedValue[2];
			value[5] = savedValue[5];
		}

		// 화면보다 작게 축소 하지 않도록
		if (imageWidth > width || imageHeight > height){
			if (scaleWidth < width && scaleHeight < height){
				int target = WIDTH;
				if (imageWidth < imageHeight) target = HEIGHT;

				if (target == WIDTH) value[0] = value[4] = (float)width / imageWidth;
				if (target == HEIGHT) value[0] = value[4] = (float)height / imageHeight;

				scaleWidth = (int) (imageWidth * value[0]);
				scaleHeight = (int) (imageHeight * value[4]);

				if (scaleWidth > width) value[0] = value[4] = (float)width / imageWidth;
				if (scaleHeight > height) value[0] = value[4] = (float)height / imageHeight;
			}
		}

		// 원래부터 작은 얘들은 본래 크기보다 작게 하지 않도록
		else{
			if (value[0] < 1)   value[0] = 1;
			if (value[4] < 1)   value[4] = 1;
		}

		matrix.setValues(value);
		savedMatrix2.set(matrix);
	}

}
