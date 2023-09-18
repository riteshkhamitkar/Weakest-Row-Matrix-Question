class RowInfo implements Comparable<RowInfo> {
    int index;
    int count;

    public RowInfo(int index, int count) {
        this.index = index;
        this.count = count;
    }

    @Override
    public int compareTo(RowInfo other) {
        if (this.count != other.count) {
            return Integer.compare(this.count, other.count);
        }
        return Integer.compare(this.index, other.index);
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int matSize = mat.length;
        int matColSize = mat[0].length;
        
        RowInfo[] rows = new RowInfo[matSize];
        for (int i = 0; i < matSize; i++) {
            int count = 0;
            for (int j = 0; j < matColSize; j++) {
                count += mat[i][j];
            }
            rows[i] = new RowInfo(i, count);
        }

        Arrays.sort(rows);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rows[i].index;
        }

        return result;
    }
}
