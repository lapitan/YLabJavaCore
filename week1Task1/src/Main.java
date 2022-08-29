public class Main {
    static int sizeOfArray=5;

    public static void main(String[] args) {
        int [][] integersArray = new int[sizeOfArray][sizeOfArray];

        long seed=System.currentTimeMillis();

        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = 0; j < sizeOfArray; j++) {
                integersArray[i][j]=randomWithMiddleSquareMethod(seed,0);
                seed*=1.5;
            }
        }

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int sum=0;

        for (int i=0;i<sizeOfArray;i++){
            for (int j = 0; j < sizeOfArray; j++) {
                if (integersArray[i][j]>max){
                    max=integersArray[i][j];
                }
                if (integersArray[i][j]<min){
                    min=integersArray[i][j];
                }
                sum+=integersArray[i][j];
            }
        }
        float average=(float) sum/(float) (sizeOfArray*sizeOfArray);

        System.out.println("min: "+min+" max: "+max+" average: "+average+"\nArray:");
        for (int i = 0; i < sizeOfArray; i++) {
            StringBuilder out= new StringBuilder();
            for (int j = 0; j < sizeOfArray; j++) {
                out.append(integersArray[i][j]).append(" ");
            }
            System.out.println(out);
        }

    }

    public static int randomWithMiddleSquareMethod(long seed,int iteration){

        StringBuilder squaredSeed= new StringBuilder(String.valueOf(seed * seed));
        if(squaredSeed.length()>4){
            squaredSeed = new StringBuilder(squaredSeed.substring(squaredSeed.length() / 2 - 2, squaredSeed.length() / 2 + 2));
        }
        if (squaredSeed.length()<4){
            while (squaredSeed.length()<4){
                squaredSeed.insert(0, "0");
            }
        }
        int result=Integer.parseInt(squaredSeed.substring(1,3));
        if (iteration==4) {
            return result;
        }

        result+=2;
        iteration++;
        return randomWithMiddleSquareMethod(result,iteration);
    }
}