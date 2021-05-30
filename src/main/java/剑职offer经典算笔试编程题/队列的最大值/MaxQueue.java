package 剑职offer经典算笔试编程题.队列的最大值;
class MaxQueue {
    int[] q = new int[20000];
    int begin = 0, end = 0;

    //栈的压入弹出序列
    public MaxQueue() {

    }

    public int max_value() {
        int ans = -1;
        for (int i = begin; i != end; ++i) {
            ans = Math.max(ans, q[i]);
        }
        return ans;
    }

    public void push_back(int value) {
        q[end++] = value;
    }

    public int pop_front() {
        if (begin == end) {
            return -1;
        }
        return q[begin++];
    }
}