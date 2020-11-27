import java.util.Arrays;
import java.io.*;
public class QuickFindUF {
    private int[] id;    
    private int count;
    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }
public int count() {
        return count;
    }
public int find(int p) {
        validate(p);
        return id[p];
    }
public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }
public void union(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p];   
        int qID = id[q]; 

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
    }   