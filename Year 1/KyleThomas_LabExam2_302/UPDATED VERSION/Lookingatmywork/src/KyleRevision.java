
public class KyleRevision {

	/* Assessment: LabExam01
	 * Student Name: Kyle Thomas
	 * Due Date: Feb 17th 2021 
	 * Professor Name: David Haley
	 * Description: Sandwiches class file holding the sandwich information including the bread type, filling and calories. 
	 */	 
			
		private String Breadtype;
		private String Filling;
		private double Calories;	
		
		public KyleRevision() {
			this("","",0.0);
		}			
		KyleRevision(String BT, String Fill, double Cal)
		{
			// For my overloaded Constructor
			this.Breadtype = BT;
			this.Filling = Fill;
			this.Calories = Cal;
		}
		
		// my getter and setter methods
		public String getBT()		
		{
			return Breadtype;
		}
		public void setBT(String BT)		
		{
			this.Breadtype = BT;
		}
		public String getFill()		
		{
			return Filling;
		}
		public void setFill(String Fill)		
		{
			this.Filling = Fill;
		}
		public double getCal()		
		{
			return Calories;			
		}
		public void setCal(double Cal)		{
			this.Calories = Cal;
		}
		// With my setter calls i've been getting that my Sets are not being used locally. 
		// i'm not exactly sure how to remove this. Does this mean it's not being used at all in this class, but can/is being used in the driver
	
		//even if i delete the sets, everything compiles properly. 
	}



