package s.kumar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

public class MainActivity extends Activity  {

	ListView l; 
	String[] menu;
	String[] price;
	int[] images={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,R.drawable.p18};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Resources res=getResources();
		menu=res.getStringArray(R.array.titles);
		price=res.getStringArray(R.array.PRICE);
		l=(ListView) findViewById(R.id.listView1);
		SkAdapter adapter=new SkAdapter(this ,menu,images,price);
		l.setAdapter(adapter);		
	/*	l.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		TextView temp= (TextView) arg1;
		Toast.makeText( this,temp.getText()+""+arg2,Toast.LENGTH_SHORT).show();
	
	  }
	 */
	}
	
}

class SkAdapter extends ArrayAdapter<String>
{  
	 Context context;
	 int[] images;
	 String[] menuArray;
	 String[] priceArray;
	 SkAdapter(Context c,String[] menu ,int imgs[],String[] desc)
	 {
		super(c,R.layout.skc,R.id.textView1,menu );
	   this.context=c;
	   this.images=imgs;
	   this.menuArray=menu;
	   this.priceArray=desc ;
	 }
	 @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
	 	View row=inflater.inflate(R.layout.skc,parent,false);
		
	 	//CheckBox c=(CheckBox) row.findViewById(R.id.checkBox1);
		ImageView myImage=(ImageView) row.findViewById(R.id.imageView1);
	 	TextView pmenu=(TextView) row.findViewById(R.id.textView1);
		TextView pprice=(TextView) row.findViewById(R.id.textView2);
		
		myImage.setImageResource(images[position]);
		pmenu.setText(menuArray[position]);
		pprice.setText(priceArray[position]);
		return row;
	 	 
	 	 
	 	 
	}
}
