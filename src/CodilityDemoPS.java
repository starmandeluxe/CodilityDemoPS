import java.util.ArrayList;
import java.util.List;

//find the smallest covering prefix:
/*

 * A non-empty zero-indexed array A consisting of N integers is given. 
 * The first covering prefix of array A is the smallest integer P 
 * such that and such that every value that occurs in array A also occurs in sequence.
 * 
 * For example, the first covering prefix of 
 * array A with A[0]=2, A[1]=2, A[2]=1, A[3]=0, A[4]=1 is 3, 
 * because sequence A[0], A[1], A[2], A[3] equal to 2, 2, 1, 0 
 * contains all values that occur in array A.

 */

public class CodilityDemoPS {

	public static void main(String[] args) {
		System.out.println("ANSWER: " + solution(new int[]{2, 2, 1, 0, 1}, 5));

	}
	
	
	//N is between 1  and 1000000
	//each element in a is between 0 and N-1
	
	//make 2 passes, 1 to catalog the unique values, then another to stop after each has been visited
	public static int solution(int[] A, int N)
	{
		//zero-indexed, so if there is only one element, then the
		//length of the prefix is zero
		if (A.length == 1)
		{
			return 0;
		}
		//setup a list of unique values to check later on another pass
		List<Integer> uniques = new ArrayList<Integer>();
		
		//counter to count steps of P until prefix coverage is complete
		int counter = 0;
		
		//first pass, assemble list of unique values
		for (int i = 0; i < A.length; i++)
		{
			//if the int hasn't been seen yet, it is new and should be added to the unique list
			if (!uniques.contains(Integer.valueOf(A[i])))
			{
				uniques.add(new Integer(A[i]));
			}
		}
		
		//second pass, mark off values until all are seen, increment P as you go.
		for (int j = 0; j < A.length; j++)
		{
			if (uniques.contains(Integer.valueOf(A[j])))
			{
				//remove one from the uniques list every time
				//another non-duplicate is seen. Once they are all
				//gone, that means prefix coverage is complete
				uniques.remove(Integer.valueOf(A[j]));
				if (uniques.size() == 0)
				{
					break;
				}
				
			}
			counter++;
		}
		
		return counter;
		
	}

}
