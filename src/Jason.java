public class Jason {
    int n = 5;
    int[] foo = {0,1,2,3,4};
    int m = 100;
    int[] bar = new int[100];

    public void test() {
        for (int i = 0; i < m; i++) {
            bar[i] = i;
        }
        System.out.println("The total number of even numbers in foo are: " + countEvenNum(foo, n));
        System.out.println("The total number of even numbers in bar are: " + countEvenNum(bar, m));
    }

    public int countEvenNum(int[] arr, int size){
        int count = 0;
        for(int i = 0; i < size; i++){
            if(arr[i] % 2 == 0){
                count++;
            }
            else{
            }
        }
        return count;
    }
}
