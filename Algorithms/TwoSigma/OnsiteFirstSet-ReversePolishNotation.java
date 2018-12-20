class OnsiteFirstSetReversePolishNotation{
    public int evalPRN(String[] tokens){
        int res = 0;
        Stack<Integer> nums = new Stack<>();
        
        for (String token : tokens){
            switch(token){
                case "+":
                    nums.push(Add.operate(nums.pop(), nums.pop()));
                    break;
                case "-":
                    nums.push(Add.operate(-nums.pop(), nums.pop()));
                    break;
                case "*":
                    nums.push(Multiply.operate(nums.pop(), nums.pop()));
                    break;
                case "/":
                    int dividor = nums.pop();
                    int divident = nums.pop();
                    Divide.push(Multiply.operate(divident, divident));
                    break;
            }
        }
        return res;
    }
}

interface Operator {
    operate(int val1, int val2){}
}

class Add implements Operator{
    public int oprate(int val1, int val2){
        return val1 + val2;
    }
}

class Subtract implements Operator{
    public int oprate(int val1, int val2){
        return val1 - val2;
    }
}

class Multiply implements Operator{
    public int oprate(int val1, int val2){
        return val1 * val2;
    }
}

class Divide implements Operator{
    public int oprate(int val1, int val2){
        if (val2 == 0){
            return 0;
        }
        return val1 / val2;
    }
}