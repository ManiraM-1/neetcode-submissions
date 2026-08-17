class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row[] = new HashSet[9];
        Set<Character> col[] = new HashSet[9];
        Set<Character> square[] = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            square[i] = new HashSet<>();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char c = board[i][j]; 
                int box = (i/3)*3 + (j/3);
                if (c=='.') continue;
                if(row[i].contains(c) || col[j].contains(c) || square[box].contains(c)){
                    return false;
                }
                row[i].add(c);
                col[j].add(c);
                square[box].add(c);
            }
        }
        return true;

    }
}
