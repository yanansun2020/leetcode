package algorithm;

/**
 * Hello world!
 * Thi is a  test I'm chaging here1
 *
 */
public class App_copy
{
    public String convert(String s, int numRows) {
        // 如果行数为1，直接返回s
        if(numRows == 1) return s;
        // 数组，sb[i]代表第i行上的所有字符
        StringBuilder[] sb = new StringBuilder[numRows];
        // 当前行数
        int row = 0;
        // 行数变化规则，1为加一行，-1为减一行
        int diff = 1;
        // 循环字符串每个字符
        for(int i = 0; i < s.length(); i++){
            // 如果数组中当前行的对象为空，初始化StringBuilder
            if(sb[row] == null) sb[row] = new StringBuilder();
            // 将当前字符加入到当前行中
            sb[row].append(s.charAt(i));
            // 如果行数到达最大行或者是最小行时，改变行数变化规则。
            if(row == numRows - 1 || row == 0 && i != 0){
                diff *= -1;
            }
            // 行数加一（或减一）
            row += diff;
        }
        // 返回结果
        StringBuilder res = new StringBuilder();
        // 将数组中每一行的字符串连接起来即是结果
        for(int i = 0; i < numRows; i++){
            if(sb[i] == null) continue;
            res.append(sb[i]);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        App_copy app = new App_copy();
        String result = app.convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }
}
