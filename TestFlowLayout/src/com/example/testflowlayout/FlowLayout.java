package com.example.testflowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup{

	
	

	public FlowLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public FlowLayout(Context context) {
		super(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
		int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
		int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
		int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
		
		int width = 0;
		int height = 0;
		int lineWidth = 0;
		int lineHeight = 0;
		int cCount = getChildCount();
		for (int i = 0; i < cCount; i++) {
			View child = getChildAt(i);
			measureChild(child, widthMeasureSpec, heightMeasureSpec);
			
			FlowLayoutLayoutParams lp = (FlowLayoutLayoutParams) child.getLayoutParams();
			int childWidth = child.getMeasuredWidth() +lp.leftMargin +lp.rightMargin;
			int childHeight = child.getMeasuredHeight()+lp.bottomMargin+lp.topMargin;
			
			if (i >= 49) {//debug
				System.out.print("");
			}
			if (lineWidth + childWidth > sizeWidth) {//another line
				width = Math.max(lineWidth, childWidth); 
				lineWidth = childWidth;
				height += lineHeight;
				lineHeight = childHeight;
				
				lp.left = 0;
				lp.top = height;
			}else{
				lp.left = lineWidth;
				lp.top = height;
				
				lineHeight = Math.max(childHeight, lineHeight);
				lineWidth += childWidth;
			}
			
			if(i == cCount -1){//最后一个
				width = Math.max(lineWidth, width);
				height += lineHeight;
			}
			
		}
		
		setMeasuredDimension( (modeWidth == MeasureSpec.EXACTLY )? sizeWidth : width, 
				(modeHeight == MeasureSpec.EXACTLY) ? sizeHeight : height);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		for (int i = 0; i < getChildCount(); i++) {
			View child = getChildAt(i);
			FlowLayoutLayoutParams lp = (FlowLayoutLayoutParams) child.getLayoutParams();
			if (i >= 49) {
				System.out.print("");
			}
			child.layout(lp.left, lp.top, lp.left + child.getMeasuredWidth(), lp.top+child.getMeasuredHeight());
		}
		
	}

	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		// TODO Auto-generated method stub
		return new FlowLayoutLayoutParams(getContext(), attrs);
	}
	
	@Override
	protected LayoutParams generateLayoutParams(LayoutParams p) {
		// TODO Auto-generated method stub
		return new FlowLayoutLayoutParams(p);
	}
	
	@Override
	protected LayoutParams generateDefaultLayoutParams() {
		// TODO Auto-generated method stub
		return new FlowLayoutLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	}
	
	public static class FlowLayoutLayoutParams extends MarginLayoutParams{
		public int left, top;
		
		public FlowLayoutLayoutParams(Context arg0, AttributeSet arg1) {
			super(arg0, arg1);
		}

		public FlowLayoutLayoutParams(int arg0, int arg1) {
			super(arg0, arg1);
			// TODO Auto-generated constructor stub
		}

		public FlowLayoutLayoutParams(LayoutParams arg0) {
			super(arg0);
			// TODO Auto-generated constructor stub
		}

		public FlowLayoutLayoutParams(MarginLayoutParams arg0) {
			super(arg0);
			// TODO Auto-generated constructor stub
		}
		
		
		
	}
	
	
	
}
