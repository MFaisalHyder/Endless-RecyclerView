package com.faisal.test;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

	private Toolbar toolbar;
	private RecyclerView mRecyclerView;
	private DataAdapter mAdapter;
	private List<Student> studentList;
	protected List<Student> tempArray;
	protected Handler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
		studentList = new ArrayList<Student>();
		tempArray = new ArrayList<Student>();
		
		handler = new Handler();
		
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("Android Students");		

		loadData();

		mRecyclerView.setHasFixedSize(true);		
		mRecyclerView.setItemAnimator(null);
		
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
		
		tempArray.addAll(studentList.subList(0, 10));
		mAdapter = new DataAdapter(tempArray, mRecyclerView);
		mRecyclerView.setAdapter(mAdapter);

		mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
			@Override
			public void onLoadMore() {				
				tempArray.add(null);
				mAdapter.notifyItemInserted(tempArray.size()-1);				
				mAdapter.notifyItemChanged(tempArray.size()-1);
				
				handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						tempArray.remove(tempArray.size()-1);
						mAdapter.notifyItemRemoved(tempArray.size()-1);
						
						int start = tempArray.size();
						int end = start + 5;
						int remainingItems = studentList.size() - tempArray.size();
						
						if(end <= studentList.size()){
							tempArray.addAll(studentList.subList(start, end));
							mAdapter.notifyItemInserted(tempArray.size());						
							mAdapter.setLoaded();
						}else{
							if(tempArray.size() != studentList.size()){
								tempArray.addAll(studentList.subList(start, start+remainingItems));
								mAdapter.notifyItemInserted(tempArray.size());
							}
						}
					}
				}, 1000);
			}
	        });
	    }
	    
	// load initial data
	private void loadData() {

		Student std = new Student("Student ", "@gmail.com");
		studentList.add(std);

		std = new Student("Student 1", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 2", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 3", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 4", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 5", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 6", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 7", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 8", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 9", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 10", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 11", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 12", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 13", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 14", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 15", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 16", "@gmail.com");
		studentList.add(std);
		std = new Student("Student 17", "@gmail.com");
		studentList.add(std);
		std = new Student("Last Student 19", "@gmail.com");
		studentList.add(std);
		std = new Student("Last Student 20", "@gmail.com");
		studentList.add(std);
		std = new Student("Last Student 21", "@gmail.com");
		studentList.add(std);
		std = new Student("Last Student 22", "@gmail.com");
		studentList.add(std);
		std = new Student("Last Student 23", "@gmail.com");
		studentList.add(std);
		std = new Student("Last Student 24", "@gmail.com");
		studentList.add(std);
		std = new Student("Last Student 25", "@gmail.com");
		studentList.add(std);
		std = new Student("Last Student 26", "@gmail.com");
		studentList.add(std);
		std = new Student("Last Student 27", "@gmail.com");
		studentList.add(std);
	}
}	    
