public class Main {

    //set to true to run tests
    static boolean doTests=true;

    static String[][] tests={{"5,6,3,2,5,1,4,9","1,2,3,4,5,5,6,9"},{"6,8,1,6,2,11,1,5","1,1,2,5,6,6,8,11"},{"1,1,1,1,1","1,1,1,1,1"},{"",""},{"1","1"}};

    public static void sort(int[] array,int l,int r){
        if (l>=r){
            return;
        }
        int mid=(r+l)/2;
        sort(array,l,mid);
        sort(array,1+mid,r);
        merge(array,l,mid,r);
    }
    public static void merge(int[] array,int l,int m,int r){
        int sizeLeft=m-l+1;
        int sizeRight=r-m;

        int [] leftArray= new int[sizeLeft];
        int [] rightArray= new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            leftArray[i]=array[l+i];
        }
        for (int i = 0; i < sizeRight; i++) {
            rightArray[i]=array[m+1+i];
        }

        int i=0;
        int j=0;

        int curr=l;

        while (i<sizeLeft&&j<sizeRight){
            if (leftArray[i]<rightArray[j]) {
                array[curr] = leftArray[i];
                i++;
            }
            else{
                array[curr]=rightArray[j];
                j++;
            }
            curr++;
        }

        while (i<sizeLeft){
            array[curr]=leftArray[i];
            i++;
            curr++;
        }
        while (j<sizeRight){
            array[curr]=rightArray[j];
            j++;
            curr++;
        }
    }

    public static void main(String[] args) {

        if (doTests){
            doTests();
            return;
        }

        int [] array={1};
        sort(array,0, array.length-1);

        for (int j : array) {
            System.out.printf("%d ", j);
        }


    }

    public static void doTests(){

        for (int i = 0; i < tests.length; i++) {
            String inputString=tests[i][0];
            String [] inputStringArray=inputString.split(",");
            int[] input = new int[inputStringArray.length];
            if (!inputStringArray[0].equals("")) {

                for (int j = 0; j < inputStringArray.length; j++) {
                    input[j] = Integer.parseInt(inputStringArray[j]);
                }
            }else{
                input= new int[]{};
            }

            sort(input,0,input.length-1);
            showTestInfo(i,input);

        }
    }

    public static void showTestInfo(int testNumb,int[] trueAnswer){

        StringBuilder trueAnswerString= new StringBuilder();
        for (int j : trueAnswer) {
            trueAnswerString.append(",").append(j);
        }
        if (trueAnswerString.length()>0) {
            trueAnswerString = new StringBuilder(trueAnswerString.substring(1));
        }
        if (trueAnswerString.toString().equals(tests[testNumb][1])){
            System.out.println("Test numb "+testNumb+" passed");
            return;
        }
        System.out.println("Test numb "+ testNumb+ " did NOT passed\n"+"Input: "+tests[testNumb][0]+"\nRight Answer: "+tests[testNumb][1]+
                "\nReal Answer: "+trueAnswerString);

    }

}
