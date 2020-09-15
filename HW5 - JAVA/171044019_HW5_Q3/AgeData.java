/**
 * This class holds ages and number of people at that age values.
 * @author Emirhan Uzun
 * @since 04/27/2020
 *
 */
public class AgeData implements Comparable<AgeData> {

		/**
		 * The age of person
		 */
		protected int age;
		/**
		 * The number of people in that age
		 */
		protected int numOfPeople = 0;
		
		
		/**
		 * Construct the age data fields
		 * @param age Given age
		 */
		protected AgeData(int age) {
			this.age = age;
			this.numOfPeople++;
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

		/**
		 * It compares the objects age 
		 * @param o Given comparable object
		 * @return the result of the comparison
		 */
		@Override
		public int compareTo(AgeData o) {
			if(this.getAge() == o.getAge()) return 0;
			else if(this.getAge() > o.getAge()) return 1;
			else return -1;
		}
		
		/**
		 * Returns a string that contains age and people number
		 * Prints the age and number of people of that object
		 */
		@Override
		public String toString() {
			return getAge() + " - " + getNumOfPeople() ;
		}

}
