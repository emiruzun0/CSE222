import java.util.Random;

/**
 * 
 */

/**
 * @author Emir
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyHashTableOpen<Integer,Integer> tableMyOpen = new MyHashTableOpen<Integer,Integer>();
		MyHashTableChain<Integer,Integer> tableMyChain = new MyHashTableChain<Integer,Integer>();
		HashTableOpen<Integer,Integer> tableOpen = new HashTableOpen<Integer,Integer>();
		HashTableChain<Integer,Integer> tableChain = new HashTableChain<Integer,Integer>();
		
		Random rand = new Random();
		
		long start = System.currentTimeMillis();
		for(int i =0;i<1000;++i) {
			tableMyChain.put(rand.nextInt(), i+15);
			tableMyChain.remove(rand.nextInt());
		}
		long end = System.currentTimeMillis();
		long difTime = end -start;
		System.out.println("Table My Chaining : " + difTime + " ms ");
		
		
		 start = System.currentTimeMillis();
		for(int i =0;i<1000;++i) {
			tableMyOpen.put(rand.nextInt(), i+15);
		}
		 end = System.currentTimeMillis();
		 difTime = end -start;
		System.out.println("Table My Open Addressing : " + difTime + " ms ");
		
		
		 start = System.currentTimeMillis();
		for(int i =0;i<1000;++i) {
			tableOpen.put(rand.nextInt(), i+15);
		}
		 end = System.currentTimeMillis();
		 difTime = end -start;
		System.out.println("Table Open Addressing : " + difTime + " ms ");
		
		
		start = System.currentTimeMillis();
		for(int i =0;i<1000;++i) {
			tableChain.put(rand.nextInt(), i+15);
		}
		end = System.currentTimeMillis();
		difTime = end -start;
		System.out.println("Table Chaining : " + difTime + " ms");
		
		
		
		/* start = System.currentTimeMillis();
		for(int i =0;i<10000;++i) {
			tableMyChain.remove(rand.nextInt(1000));
		}
		 end = System.currentTimeMillis();
		 difTime = end -start;
		System.out.println("\n\nREMOVE\nTable My Chaining : " + difTime + " ms ");
		
		
		start = System.currentTimeMillis();
		for(int i =0;i<10000;++i) {
			tableMyOpen.remove(rand.nextInt(1000));
		}
		end = System.currentTimeMillis();
		difTime = end -start;
		System.out.println("Table My Open Addressing : " + difTime + " ms ");
		
		
		start = System.currentTimeMillis();
		for(int i =0;i<10000;++i) {
			tableOpen.remove(rand.nextInt(1000));
		}
		end = System.currentTimeMillis();
		difTime = end -start;
		System.out.println("Table Open Addressing : " + difTime + " ms ");
		
		
		start = System.currentTimeMillis();
		for(int i =0;i<10000;++i) {
			tableChain.remove(rand.nextInt(1000));
		}
		end = System.currentTimeMillis();
		difTime = end -start;
		System.out.println("Table Chaining : " + difTime + " ms");*/
		
		
		//System.out.println(tableMyOpen.toString());
	}

}
