import java.util.ArrayList;

/**
 * This class prints the elements of array spirally 
 * @author Emirhan Uzun / 171044019
 * @since 04/09/2020 
 * 
 */
public class PrintElements {

	/**
	 * This method fills array elements that go to clockwise
	 * @param row Array row number
	 * @param column Array column number 
	 * @param xIndex Current x index
	 * @param yIndex Current y index 
	 * @param index Total step index (How many moves that has been done) 
	 * @param direction That goes to the arrays move direction
	 * @param tourCount Completed tour counter
	 * @param size array size
	 * @param array given array
	 * @param temp filling array
	 */
	private static void SpiralPrint(int row, int column, int xIndex, int yIndex, int index, int direction, int tourCount,
			int size,Integer[][] array,ArrayList<Integer> temp) {
		if(index == size) return ;
		else if(direction == 6) {
			if(yIndex < column) {
				temp.add(array[xIndex][yIndex]);
				SpiralPrint(row,column,xIndex,yIndex+1,index+1,6,tourCount,size,array,temp);
			}
			else SpiralPrint(row,column,xIndex+1,yIndex-1,index,2,tourCount,size,array,temp);
		}
		else if(direction == 2)
        {
            if(xIndex < row)
            {
                temp.add(array[xIndex][yIndex]);
                SpiralPrint(row,column,xIndex+1,yIndex,index+1,2,tourCount,size,array,temp);
            }
            else SpiralPrint(row,column,xIndex-1,yIndex-1,index,4,tourCount,size, array ,temp);
        }
		else if(direction == 4) {
			if(yIndex >= tourCount ) {
				temp.add(array[xIndex][yIndex]);
                SpiralPrint(row,column,xIndex,yIndex-1,index+1,4,tourCount,size,array,temp);
			}
			else SpiralPrint(row,column,xIndex-1,yIndex+1,index,8,tourCount,size, array ,temp);
		}
		else if(direction == 8) {
			if(xIndex > tourCount ) {
				temp.add(array[xIndex][yIndex]);
                SpiralPrint(row,column,xIndex-1,yIndex,index+1,8,tourCount,size,array,temp);
			}
			else SpiralPrint(row-1,column-1,tourCount+1,tourCount+1,index,6,tourCount+1,size, array ,temp);
		}
		
		
	}

	/**
	 * @param args String arguments
	 */
	public static void main(String[] args) {
		Integer[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
		int size = array.length*array[0].length;
		ArrayList<Integer> temp = new ArrayList<Integer>(array.length*array[0].length) ;
		SpiralPrint(array.length,array[0].length,0,0,0,6,0,size,array,temp);
		
		
		for(int i =0 ; i< temp.size() ; ++i) {
			System.out.printf("%d ",temp.get(i));
		}
	}
}
