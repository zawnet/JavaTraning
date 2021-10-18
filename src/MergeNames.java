import java.util.Arrays;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {

        String [] uniqeNamesArray = Arrays.copyOf(names1, names1.length + names2.length);
        System.arraycopy(names2,0,uniqeNamesArray,names1.length, names2.length);
        int uniqueArrayIndex = uniqeNamesArray.length;
        //int uniqeArrayStartLenght = 1;
       // System.out.println(Arrays.toString(uniqeNamesArray));

        for (int i = 0 ; i < uniqeNamesArray.length; i++){
          for (int j = i+1; j<uniqueArrayIndex; j++){
              if(uniqeNamesArray[i].equals(uniqeNamesArray[j])){
                  String tmp = uniqeNamesArray[j];
                  uniqeNamesArray[j] = uniqeNamesArray[uniqueArrayIndex-1];
                  uniqeNamesArray[uniqueArrayIndex-1] = tmp;
                  uniqueArrayIndex--;
                  j--;
              }
              else {
                  continue;
              }
          }
        }
        return Arrays.copyOf(uniqeNamesArray,uniqueArrayIndex);
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};

    String[] array = uniqueNames(names1, names2);
    System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}