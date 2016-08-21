package my.practice.nestedinteger;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static my.practice.numbers.Numbers.isDigit;

/**
 * Created by kmishra on 8/17/2016.
 */
public abstract class NestedInteger {
      // Constructor initializes an empty nested list.
     public NestedInteger(){}

    // Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public abstract boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public abstract Integer getInteger();

      // Set this NestedInteger to hold a single integer.
      public abstract void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public abstract void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public abstract List<NestedInteger> getList();

    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger child = null;
        NestedInteger ni = null;
        boolean foundNum = false;
        List<Integer> intList = new ArrayList<>();
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '[':
                    if (ni != null) {
                        if (intList != null) {
                            for (int integer : intList) ni.setInteger(integer);
                        }
                        intList.clear();
                    }
                    ni = new NestedInteger() {
                        @Override
                        public boolean isInteger() {
                            return false;
                        }

                        @Override
                        public Integer getInteger() {
                            return null;
                        }

                        @Override
                        public void setInteger(int value) {

                        }

                        @Override
                        public void add(NestedInteger ni) {

                        }

                        @Override
                        public List<NestedInteger> getList() {
                            return null;
                        }
                    };

                    stack.push(ni);
                    break;
                case ',':
                    if (foundNum) intList.add(num * sign);
                    foundNum = false;
                    num = 0;
                    sign = 1;
                    break;
                case ']':
                    if (foundNum) intList.add(num * sign);
                    foundNum = false;
                    num = 0;
                    sign = 1;
                    ni = stack.pop();
                    if (intList != null) {
                        for (int integer : intList) ni.setInteger(integer);
                    }
                    if (child != null) ni.add(child);
                    if (i == s.length()) return ni;
                    child = ni;
                    intList.clear();
                    break;
                case '-':
                    sign = -1;
                    break;
                default:
                    num = num * 10 + c - '0';
                    foundNum = true;
            }
        }
        if (s.indexOf('[') == -1) {
            ni = new NestedInteger() {
                @Override
                public boolean isInteger() {
                    return false;
                }

                @Override
                public Integer getInteger() {
                    return null;
                }

                @Override
                public void setInteger(int value) {

                }

                @Override
                public void add(NestedInteger ni) {

                }

                @Override
                public List<NestedInteger> getList() {
                    return null;
                }
            };
            ni.setInteger(sign * num);
        }
        return ni;
    }

    public static void main(String[] args) {
        String s = "[1,[22,33]]";
    }

}
