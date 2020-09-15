/**
 * This class holds ages and number of people at that age values.
 * @author Emirhan Uzun / 171044019
 * @since 04/27/2020
 *
 */
public class AgeData implements Comparator<AgeData> {

		/**
		 * The age of person
		 */
		protected int age;
		/**
		 * The number of people in that age
		 */
		protected int numOfPeople ;
		
		
		/**
		 * Construct the age data fields
		 * @param age Given age
		 */
		protected AgeData(int age) {
			this.age = age;
			this.numOfPeople = 1;
		}
		
		
		/**
		 * Get the age of object
		 * @return age
		 */
		public int getAge() {
			return age;
		}

		/**
		 * Sets the age of object
		 * @param age Setting age
		 */
		public void setAge(int age) {
			this.age = age;
		}

		/**
		 * Get the number of people of object
		 * @return number of people
		 */
		public int getNumOfPeople() {
			return numOfPeople;
		}

		/**
		 * Sets the number of people of object
		 * @param numOfPeople Setting number of people 
		 */
		public void setNumOfPeople(int numOfPeople) {
			this.numOfPeople = numOfPeople;
		}
		
		@Override
		public String toString() {
			return getAge() + " - " + getNumOfPeople() ;
		}

		/**
		 * This method compares the object's age.It belongs to comparator interface
		 */
		public int compare(AgeData o1,AgeData o2) {
			if(o1.getAge() == o2.getAge()) return 0;
			else return 1;
		}
		
		/**
		 * It compares the objects people number
		 * @param o1 Given comparable object
		 * @return true if this object's number of people is bigger than given o1 object's 
		 */
		public boolean compareTo(AgeData o1) {
			if(this.getNumOfPeople() > o1.getNumOfPeople()) return true;
			else return false;
		}


}
