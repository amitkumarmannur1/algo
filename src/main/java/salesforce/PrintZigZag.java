package salesforce;
//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//        P   A   H   N
//        A P L S I I G
//        Y   I   R
//        And then read line by line: "PAHNAPLSIIGYIR"
//
//        Write the code that will take a string and make this conversion given a number of rows:
//
//        string convert(string s, int numRows);
//
//
//        Example 1:
//
//        Input: s = "PAYPALISHIRING", numRows = 3
//        Output: "PAHNAPLSIIGYIR"
//        Example 2:
//
//        Input: s = "PAYPALISHIRING", numRows = 4
//        Output: "PINALSIGYAHRPI"
//        Explanation:
//        P     I    N
//        A   L S  I G
//        Y A   H R
//        P     I
public class PrintZigZag {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
    public static String convert(String s, int numRows) {

        //base case
        if(numRows==1) return s;

        char[][] result = new char[numRows][s.length()];

        //filling the result matrix to distinguish filled spaces from the blank ones
        for(int i=0; i<numRows; i++)
        {
            for(int j=0; j<s.length(); j++)
            {
                result[i][j]='\n';
            }
        }

        //we need to find direction in which the plaintext is being stored in the matrix
        boolean direction_down=false;
        int row=0, col=0;

        for(int i=0; i<s.length(); i++)
        {
            //check the direction of flow
            //reverse the direction if we've just filled the top or bottom rail

            if(row==0 || row==numRows-1)
                direction_down=!direction_down;

            //fill the corresponding alphabet
            result[row][col++]=s.charAt(i);

            //find the next row using direction_down
            if(direction_down)
                row++;
            else
                row--;
        }

        //now construct result using result matrix
        StringBuilder answer= new StringBuilder();
        for(int i=0; i<numRows; i++)
        {
            for(int j=0; j<s.length(); j++)
            {
                if(result[i][j]!='\n')
                {
                    answer.append(result[i][j]);
                }
            }
        }
        return answer.toString();

    }
}
