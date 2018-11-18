package hackerrank;

import java.util.Scanner;

public class NewYearChaos {

	static int pos[], arr[];
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] a) {
        
        int op = 0;
            boolean yes = true;
            int n = a.length;
            pos = new int[n];
            arr = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]-=1;
        }
            for(int i = 0; i < n; i++)
                arr[i] = pos[i] = i;
            
            for(int i = 0; i < n; i++){
                if(pos[a[i]] - i > 2){
                    yes = false;
                    break;
                }
                while(pos[a[i]] > i){
                    swap(pos[a[i]], pos[a[i]] - 1);
                    op++;
                }
            }
    System.out.println(yes ? op : "Too chaotic");
        }
        
    static void swap(int i,int j){
        //swap ith and jth position
        pos[arr[i]] = j;
        pos[arr[j]] = i;
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
