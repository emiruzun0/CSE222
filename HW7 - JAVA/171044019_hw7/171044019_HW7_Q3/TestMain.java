import java.util.*;
//import java.util.concurrent.ConcurrentSkipListSet;
//import java.util.TreeMap;
//import java.util.concurrent.ConcurrentSkipListSet;
//import com.sun.source.tree.Tree;


public class TestMain
{
	
	
	public static void main(String[] args)
	{
		
		TreeSet<Integer> redBlack = new TreeSet<Integer>();
		/*for(int i = 0 ;i<10000;++i) {
			redBlack.add(5);
		}*/
		
		
		//BTree<Integer> btree = new BTree<Integer>(4);
		//btree.add(25);

		//ConcurrentSkipListSet<Integer> skipListJava = new ConcurrentSkipListSet<Integer>();
		//BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();;
		//long start,end,total = 0;
		//Random rand=new Random();
		//SkipList<Integer> skipList=new SkipList<Integer>();
		//RedBlackTree<Integer> redBlack = new RedBlackTree<Integer>();
		int[] arr = new int[10];
 		Random rand=new Random();
		int i=0,j=0;
		int temp = 0;
		long total = 0 , start = 0 , end = 0 , total2 = 0 ;
		
		System.out.println("----Adding and deleting 10 elements to array with 10k elements----");
		for(j=0;j<10;++j) {
			redBlack=new TreeSet<Integer>();
			start = System.nanoTime();
			for(i=0;i<80000;++i) 
				temp = rand.nextInt(80000);
			redBlack.add(temp);
				if(i<10) arr[i] = temp;
	        end = System.nanoTime();
            total=end-start;
	        System.out.println("Add 10k elements to array  " + total);
			start = System.nanoTime();
			for(i=0;i<10;++i) 
				redBlack.add(rand.nextInt(80000));
			end = System.nanoTime();
			total=end-start;
			
			total2=0;
			for(i=0;i<10;++i) {
				start = System.nanoTime();
				if(redBlack.remove(arr[i]) != true) {
					end=System.nanoTime();
					total2 +=end-start;
				}
				else 
					i--;
			}
			
			System.out.println((j+1)+"-adding 10 elements to arr[40000] : "+ (long)total + "ns");
			System.out.println((j+1)+"-deleting 10 elements from arr[40000] : "+ (long)total2 + "ns\n");
		}
		
		//Tree testRed = new Tree<Integer>();
		
		/*for(int j=0;j<10;++j) {
			testTree = new BinarySearchTree<Integer>();
			start = System.currentTimeMillis();
            for(int i=0;i<10000;++i) {
            	testTree.add(rand.nextInt(20000));
            }
            for(int i=0;i<10;++i) {
            	testTree.add(rand.nextInt(20000));
            }
            end = System.currentTimeMillis();
            total=end-start;
            System.out.println((j+1)+"-adding 10 elements to arr[10000] : "+ total + "ms");
        }
		
		for(int j=0;j<10;++j) {
			testTree = new BinarySearchTree<Integer>();
			start = System.currentTimeMillis();
            for(int i=0;i<20000;++i) {
            	testTree.add(rand.nextInt(40000));
            }
            for(int i=0;i<10;++i) {
            	testTree.add(rand.nextInt(20000));
            }
            end = System.currentTimeMillis();
            total=end-start;
            System.out.println((j+1)+"-adding 10 elements to arr[10000] : "+ total + "ms");
        }
		
		for(int j=0;j<10;++j) {
			testTree = new BinarySearchTree<Integer>();
			start = System.currentTimeMillis();
            for(int i=0;i<40000;++i) {
            	testTree.add(rand.nextInt(80000));
            }
            for(int i=0;i<10;++i) {
            	testTree.add(rand.nextInt(80000));
            }
            end = System.currentTimeMillis();
            total=end-start;
            System.out.println((j+1)+"-adding 10 elements to arr[10000] : "+ total + "ms");
        }
		
		for(int j=0;j<10;++j) {
			testTree = new BinarySearchTree<Integer>();
			start = System.currentTimeMillis();
            for(int i=0;i<80000;++i) {
            	testTree.add(rand.nextInt(160000));
            }
            for(int i=0;i<10;++i) {
            	testTree.add(rand.nextInt(160000));
            }
            end = System.currentTimeMillis();
            total=end-start;
            System.out.println((j+1)+"-adding 10 elements to arr[10000] : "+ total + "ms");
        }*/
		/*BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();
		final int MAX_INT = 160000;
		final int START_SIZE = 80000;
		
		//create a random number generator.
		Random random = new Random();
		 start = System.currentTimeMillis();
			for (int i = 0; i < START_SIZE; i++) {
				testTree.add(random.nextInt(MAX_INT));
			}
		 end = System.currentTimeMillis();
		System.out.println(end-start);
		//Add to beginning and end of list.
		for(int i =0; i < 10 ; ++i) {
			 start = System.nanoTime();
			if(testTree.remove(random.nextInt(MAX_INT))) {
				end = System.nanoTime();
				total += end - start;
			}
			else i--;
		}
		 end = System.nanoTime();
		System.out.println(end-start);*/
		
		/*RedBlackTree<String> testRed = new RedBlackTree<String>();
		final int MAX_INT = 160000;
		final int START_SIZE = 80000;
		
		//create a random number generator.
		Random random = new Random();
		 start = System.currentTimeMillis();
			for (int i = 0; i < START_SIZE; i++) {
				String randomNum = String.valueOf(random.nextInt(MAX_INT));
				testRed.add(randomNum);
			}
		 end = System.currentTimeMillis();
		System.out.println(end-start);
		
		 start = System.nanoTime();

			for(int i =0; i < 10 ; ++i) {
				String randomNum = String.valueOf(random.nextInt(MAX_INT));
				testRed.add(randomNum);
			}
			 end = System.nanoTime();
			System.out.println(end-start);
		*/
	}
}