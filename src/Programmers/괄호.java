package Programmers;

public class 괄호 {
        boolean solution(String s) {
            /*
                처음에 괄호만 보고 스택으로 풀려다가 효율성 검사에서 막혔다.
                질문 포럼을 보니 나와같은 사람의 글에 이런 답변이 ..
                1. 한글자씩 체크하기 때문에 str.split("")로 String배열화 하여 사용하는 것보다 str.toCharArray()로 char배열을 사용하는것이 유리
                2. Stack에 '(' 하나의 문자만 누적된다면 자료구조를 사용하지 않고 int변수에 갯수만 +/- 시키는 것이 유리

             */
            boolean answer = true;
            char[] chr = s.toCharArray();

            int cnt = 0;

            for(int i=0; i<chr.length; i++) {
                if (chr[i] == '(') {
                    cnt++;
                } else if (chr[i] == ')'){
                    cnt--;
                }
                if (cnt < 0) {
                    answer = false;
                    break;
                }
            }

            if (cnt != 0) answer = false;

            return answer;
        }

    }

