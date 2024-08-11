import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 각 행을 생성하여 result 리스트에 추가합니다.
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            // 현재 행의 첫 번째 원소는 1입니다.
            row.add(1);
            
            // 중간 원소를 계산합니다.
            if (i > 0) {
                List<Integer> previousRow = result.get(i - 1);
                for (int j = 1; j < i; j++) {
                    row.add(previousRow.get(j - 1) + previousRow.get(j));
                }
            }
            
            // 현재 행의 마지막 원소는 1입니다.
            if (i > 0) {
                row.add(1);
            }
            
            // 생성된 행을 result 리스트에 추가합니다.
            result.add(row);
        }
        
        return result;
    }
}