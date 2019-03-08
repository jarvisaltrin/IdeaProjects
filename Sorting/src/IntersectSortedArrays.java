import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectSortedArrays {

    // Given two strings, return the intersection of two sorted strings
    public static List<Integer> intersectTwoSortedArrays(List<Integer> A, List<Integer> B){
        List<Integer> intersectedAB = new ArrayList<Integer>();
        int i=0,j=0;
        while(i<A.size() && j<B.size()){
            if(A.get(i) == B.get(j) && (i==0 || A.get(i) != A.get(i-1))){
                intersectedAB.add(A.get(i));
                i++;
                j++;
            }else if(A.get(i) < B.get(j)){
                i++;
            }else{ // A.get(i) > B.get(i)
                j++;
            }
        }
        return intersectedAB;
    }

    public static void main(String[] args){
        List<Integer> A = Arrays.asList(1,1,2,3,4,7,8,9);
        List<Integer> B = Arrays.asList(1,4,5,6);
        System.out.println(intersectTwoSortedArrays(A,B).toString());
    }

}
