package my.practice.trees;

/**
 * Created by kmishra on 8/18/2016.
 */
public class PostFromPreIn {

    int[] post;
    int[] pre;
    int[] in;
    Index preIdx;
    Index postIdx;

    public void postFromPreIn() {
        postFromPreIn(0, post.length - 1);
    }

    private void postFromPreIn(int lo, int hi) {
        if (lo > hi || preIdx.idx >= pre.length) return;
        int key = pre[preIdx.idx++];
        int idx;
        for (idx = lo; idx <= hi; idx++) {
            if (key == in[idx]) break;
        }
        postFromPreIn(lo, idx - 1);//left
        postFromPreIn(idx + 1, hi);//right
        post[postIdx.idx++] = key;
    }
}
