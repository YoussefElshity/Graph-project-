import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("number of rows in adjacencyMatrix");
        int g = s.nextInt();
        System.out.println("number of colm in adjacencyMatrix");
        int c = s.nextInt();
        int[][] adjacencyMatrix = new int[g][c];
        read(adjacencyMatrix);
        if (isReflexive(adjacencyMatrix)) {
            System.out.println("this is Reflexive");
        }
        if (isSymmetric(adjacencyMatrix)) {
            System.out.println("this is Symmetric");
        }
        if (isTransitive(adjacencyMatrix)) {
            System.out.println("this is Transitive ");
        }
        if (isAcyclic(adjacencyMatrix)){
            System.out.println("this is Acyclic");
        }
        if (isConnected(adjacencyMatrix)){
            System.out.println("this is connected");
        }
        System.out.println("number of rows to check Eulerian path in  incidentMatrix");
        int b = s.nextInt();
        System.out.println("number of colm to check Eulerian path in  incidentMatrix");
        int v = s.nextInt();
        int [][]incidentMatrix = new int[b][v];
        read(incidentMatrix);
        if (isEulerianPath(incidentMatrix)){
            System.out.println("this is Eulerian path");
        }
    }
    public static void read(int[][] v) {
        Scanner A = new Scanner(System.in);
        for (int i = 0; i < v.length; i++) {
            System.out.println("the " + (1 + i) + " row");
            for (int j = 0; j < v[i].length; j++) {
                v[i][j] = A.nextInt();
            }
        }
    }
    public static boolean isReflexive(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i][i] != 1)
                return false;
        }
        return true;
    }
    public static boolean isSymmetric(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] != a[j][i])
                    return false;
            }
        }
        return true;
    }
    public static boolean isTransitive(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    for (int k = 0; k < a.length; k++) {
                        if (a[j][k] == 1 && a[i][k] != 1 )
                            return false;
                    }
                }
            }
        }
        return true;
    }public  static boolean isAcyclic(int[][] a) {
        boolean[] check = new boolean[a.length];
        boolean[] check1 = new boolean[a.length];

        for (int i = 0; i < a.length; i++) {
            if (isCyclicUtil(i, check, check1,a))
                return false;
        }
        return true;
    }
    public static boolean isCyclicUtil(int vertex, boolean[] check, boolean[] check1,int [][]a) {
        if (check1[vertex])
            return true;
        if (check[vertex])
            return false;
        check[vertex] = true;
        check1[vertex] = true;

        for (int i = 0; i < a.length; i++) {
            if (a[vertex][i] == 1 && isCyclicUtil(i, check, check1,a))
                return true;
        }
        check1[vertex] = false;
        return false;
    }  public static boolean isConnected(int[][] a) {
        boolean[] check = new boolean[a.length];
        con(0, check,a);

        for (int i = 0; i < a.length; i++) {
            if (!check[i])
                return false;
        }
        return true;
    }
    public static void con(int vertex, boolean[] vis, int[][] a) {
        vis[vertex] = true;
        for (int i = 0; i < a.length; i++) {
            if (a[vertex][i] == 1 && !vis[i])
                con(i, vis,a);
        }
    }
    public static boolean isEulerianPath(int[][] a) {
        int[] inDegree = new int[a.length];
        int[] outDegree = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    outDegree[i]++;
                    inDegree[j]++;
                }
            }
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < a.length; i++) {
            int diff = outDegree[i] - inDegree[i];
            if (diff > 1 || diff < -1)
                return false;
            else if (diff == 1)
                start++;
            else if (diff == -1)
                end++;
        }
        return (start == 0 && end == 0) || (start == 1 && end == 1);
    }
}

